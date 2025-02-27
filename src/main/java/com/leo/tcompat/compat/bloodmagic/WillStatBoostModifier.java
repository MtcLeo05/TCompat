package com.leo.tcompat.compat.bloodmagic;

import com.leo.tcompat.common.TCompatValues;
import com.leo.tcompat.common.ToolValueUtils;
import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import wayoftime.bloodmagic.api.compat.EnumDemonWillType;
import wayoftime.bloodmagic.common.item.soul.ItemSentientPickaxe;
import wayoftime.bloodmagic.common.item.soul.ItemSentientSword;
import wayoftime.bloodmagic.will.PlayerDemonWillHandler;

import java.util.List;

public class WillStatBoostModifier extends Modifier implements MeleeHitModifierHook, MeleeDamageModifierHook, TooltipModifierHook, BreakSpeedModifierHook, BlockBreakModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT, ModifierHooks.MELEE_DAMAGE, ModifierHooks.TOOLTIP, ModifierHooks.BREAK_SPEED, ModifierHooks.BLOCK_BREAK);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (context.getLevel().isClientSide) return;
        if (!(context.getPlayerAttacker() instanceof ServerPlayer player)) return;

        EnumDemonWillType type = PlayerDemonWillHandler.getLargestWillType(player);
        int level = getLevel(PlayerDemonWillHandler.getTotalDemonWill(type, player));

        applyEffectToEntity(type, level, context.getLivingTarget(), context.getPlayerAttacker());

        if (context.getLivingTarget() == null || !context.getLivingTarget().isDeadOrDying()) return;

        double drain = level >= 0 ? ItemSentientSword.soulDrainPerSwing[level] : 0.0;
        PlayerDemonWillHandler.consumeDemonWill(type, player, drain);
    }

    public void applyEffectToEntity(EnumDemonWillType type, int willBracket, LivingEntity target, LivingEntity attacker) {
        switch (type) {
            case CORROSIVE:
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, ItemSentientSword.poisonTime[willBracket], ItemSentientSword.poisonLevel[willBracket]));
            case DEFAULT:
            case DESTRUCTIVE:
            case VENGEFUL:
            default:
                break;
            case STEADFAST:
                if (!target.isAlive()) {
                    float absorption = attacker.getAbsorptionAmount();
                    attacker.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, ItemSentientSword.absorptionTime[willBracket], 127, false, false));
                    attacker.setAbsorptionAmount((float) Math.min(absorption + target.getMaxHealth() * 0.05F, ItemSentientSword.maxAbsorptionHearts));
                }
        }

    }

    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        Player player = event.getEntity();
        if (!isEffective) return;

        EnumDemonWillType type = PlayerDemonWillHandler.getLargestWillType(player);
        int level = getLevel(PlayerDemonWillHandler.getTotalDemonWill(type, player));

        float oldSpeed = event.getNewSpeed();
        double newSpeed = (oldSpeed + getExtraSpeed(level)) * miningSpeedModifier;

        if (ToolValueUtils.hasValue(tool, TCompatValues.GENERIC_BOOLEAN, Tag.TAG_FLOAT) && ToolValueUtils.getFloatValue(tool, TCompatValues.GENERIC_BOOLEAN) == 1) {
            event.setNewSpeed((float) newSpeed);
            return;
        }

        ToolValueUtils.uncheckedSetFloatValue(tool, TCompatValues.GENERIC_BOOLEAN, 1);
        event.setNewSpeed((float) newSpeed);
    }

    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        ServerPlayer player = context.getPlayer();

        ToolValueUtils.uncheckedSetFloatValue(tool, TCompatValues.GENERIC_BOOLEAN, 0);

        EnumDemonWillType type = PlayerDemonWillHandler.getLargestWillType(player);
        int level = getLevel(PlayerDemonWillHandler.getTotalDemonWill(type, player));
        double drain = level >= 0 ? ItemSentientSword.soulDrainPerSwing[level] : 0.0;
        PlayerDemonWillHandler.consumeDemonWill(type, player, drain);
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float base, float damage) {
        if (context.getLevel().isClientSide) return damage;
        if (!(context.getPlayerAttacker() instanceof ServerPlayer player)) return damage;

        EnumDemonWillType type = PlayerDemonWillHandler.getLargestWillType(player);
        int level = getLevel(PlayerDemonWillHandler.getTotalDemonWill(type, player));
        double extra = getExtraDamage(type, level);

        return (float) (damage + extra);
    }


    protected int getLevel(double soulsRemaining) {
        int lvl = -1;

        for (int i = 0; i < ItemSentientSword.soulBracket.length; ++i) {
            if (soulsRemaining >= ItemSentientSword.soulBracket[i]) {
                lvl = i;
            }
        }

        return lvl;
    }

    public double getExtraDamage(EnumDemonWillType type, int willBracket) {
        if (willBracket < 0) {
            return 0.0;
        } else {
            return switch (type) {
                case CORROSIVE, DEFAULT -> ItemSentientSword.defaultDamageAdded[willBracket];
                case DESTRUCTIVE -> ItemSentientSword.destructiveDamageAdded[willBracket];
                case VENGEFUL -> ItemSentientSword.vengefulDamageAdded[willBracket];
                case STEADFAST -> ItemSentientSword.steadfastDamageAdded[willBracket];
            };
        }
    }

    public double getExtraSpeed(int willBracket) {
        if (willBracket < 0) {
            return 0.0;
        } else {
            return ItemSentientPickaxe.defaultDigSpeedAdded[Math.min(willBracket, ItemSentientPickaxe.defaultDigSpeedAdded.length - 1)];
        }
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltips, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        EnumDemonWillType type = PlayerDemonWillHandler.getLargestWillType(player);
        int level = getLevel(PlayerDemonWillHandler.getTotalDemonWill(type, player));

        if (level <= 0) return;

        double extraDamage = getExtraDamage(type, level);
        double extraSpeed = getExtraSpeed(level);

        tooltips.add(
            Component.translatable(TCompatValues.WILL_SPEED_BOOST, extraSpeed)
        );
        tooltips.add(
            Component.translatable(TCompatValues.WILL_DAMAGE_BOOST, extraDamage)
        );
    }
}
