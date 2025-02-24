package com.leo.tcompat.compat.botania;

import com.leo.tcompat.common.TCompatValues;
import com.leo.tcompat.common.ToolValueUtils;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.DurabilityDisplayModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import java.util.List;

public class BloodlustModifier extends Modifier implements InventoryTickModifierHook, MeleeHitModifierHook, DurabilityDisplayModifierHook, MeleeDamageModifierHook, TooltipModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.INVENTORY_TICK, ModifierHooks.MELEE_HIT, ModifierHooks.DURABILITY_DISPLAY, ModifierHooks.MELEE_DAMAGE, ModifierHooks.TOOLTIP);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if(context.getLevel().isClientSide) return;
        if(context.getLivingTarget() == null || !context.getLivingTarget().isDeadOrDying()) return;

        ToolValueUtils.addCappedFloatValue(tool, TCompatValues.BLOODLUST_BOOST, modifier.getLevel() * 0.5f, modifier.getLevel() * 2.5f);
    }

    @Override
    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level level, LivingEntity holder, int slot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if(holder.level().isClientSide) return;
        if(holder.tickCount % 20 != 0) return;

        ToolValueUtils.decreaseFloatValue(tool, TCompatValues.BLOODLUST_BOOST, 0.1f);
    }


    @Nullable
    @Override
    public Boolean showDurabilityBar(IToolStackView tool, ModifierEntry modifier) {
        return hasBoost(tool) || tool.getDamage() > 0;
    }

    private @Nullable Float boost(IToolStackView tool) {
        if(!hasBoost(tool)) return null;

        return ToolValueUtils.getFloatValue(tool, TCompatValues.BLOODLUST_BOOST);
    }

    private boolean hasBoost(IToolStackView tool) {
        return ToolValueUtils.hasValue(tool, TCompatValues.BLOODLUST_BOOST, Tag.TAG_FLOAT) && ToolValueUtils.getFloatValue(tool, TCompatValues.BLOODLUST_BOOST) > 0;
    }

    @Override
    public int getDurabilityWidth(IToolStackView tool, ModifierEntry modifier) {
        if (!hasBoost(tool) || boost(tool).intValue() < 1) {
            return DurabilityDisplayModifierHook.getWidthFor(tool.getDamage(), tool.getStats().getInt(ToolStats.DURABILITY));
        }

        int value = boost(tool).intValue();
        return value <= 0? 0: (int) ((value / (modifier.getLevel() * 2.5f)) * 13f);
    }

    @Override
    public int getDurabilityRGB(IToolStackView tool, ModifierEntry modifier) {
        if(!hasBoost(tool)) {
            float max = (float) tool.getStats().getInt(ToolStats.DURABILITY);
            return Mth.hsvToRgb(Math.max(0.0F, (max - (float) tool.getDamage()) / max / 3.0F), 1.0F, 1.0F);
        }

        return BotaniaInit.BLOODLUST_BOOST.getColor().getValue();
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float baseDamage, float damage) {
        if(!hasBoost(tool)) return damage;

        return damage + boost(tool);
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltips, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        if(!hasBoost(tool)) return;

        tooltips.add(
            Component.translatable(TCompatValues.BLOODLUST_TOOLTIP, boost(tool))
        );
    }
}
