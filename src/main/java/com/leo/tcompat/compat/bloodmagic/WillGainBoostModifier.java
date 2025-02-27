package com.leo.tcompat.compat.bloodmagic;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Slime;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.data.ModifierIds;
import wayoftime.bloodmagic.api.compat.EnumDemonWillType;
import wayoftime.bloodmagic.api.compat.IDemonWill;
import wayoftime.bloodmagic.common.item.BloodMagicItems;
import wayoftime.bloodmagic.will.PlayerDemonWillHandler;

public class WillGainBoostModifier extends Modifier implements MeleeHitModifierHook {
    private final EnumDemonWillType will;

    public WillGainBoostModifier(EnumDemonWillType will) {
        this.will = will;
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (context.getLevel().isClientSide) return;
        if (!(context.getPlayerAttacker() instanceof ServerPlayer player)) return;
        LivingEntity target = context.getLivingTarget();
        if (target == null || !target.isDeadOrDying()) return;

        double toAdd = willToAdd(target, modifier.getLevel() * (1 + tool.getModifierLevel(ModifierIds.fortune) + tool.getModifierLevel(ModifierIds.looting)));

        double leftover = toAdd - PlayerDemonWillHandler.addDemonWill(will, player, toAdd);

        if (leftover <= 0) return;

        IDemonWill soul = switch (will) {
            case CORROSIVE -> (IDemonWill) BloodMagicItems.MONSTER_SOUL_CORROSIVE.get();
            case DEFAULT -> (IDemonWill) BloodMagicItems.MONSTER_SOUL_RAW.get();
            case DESTRUCTIVE -> (IDemonWill) BloodMagicItems.MONSTER_SOUL_DESTRUCTIVE.get();
            case VENGEFUL -> (IDemonWill) BloodMagicItems.MONSTER_SOUL_VENGEFUL.get();
            case STEADFAST -> (IDemonWill) BloodMagicItems.MONSTER_SOUL_STEADFAST.get();
        };

        ItemEntity item = new ItemEntity(player.level(), target.getX(), target.getY(), target.getZ(), soul.createWill(leftover));
        player.level().addFreshEntity(item);
    }

    protected double willToAdd(LivingEntity killed, int looting) {
        double willModifier = killed instanceof Slime ? 0.67 : 1.0;
        return (willModifier * killed.getCommandSenderWorld().random.nextDouble() + killed.getMaxHealth() / 20.0) * looting;
    }
}
