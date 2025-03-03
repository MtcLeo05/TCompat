package com.leo.tcompat.common.content;

import com.leo.tcompat.common.EnergyUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ToolDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class EnergizedModifier extends Modifier implements InventoryTickModifierHook, ToolDamageModifierHook {

    private static final int ENERGY_REPAIR = 200;
    private static final int ENERGY_REDUCE = 10;

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.INVENTORY_TICK, ModifierHooks.TOOL_DAMAGE);
    }

    @Override
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int damage, @Nullable LivingEntity holder) {
        if(!(holder instanceof ServerPlayer sPlayer)) return damage;

        int energy = toConsume(damage, modifier.intEffectiveLevel());

        if (!EnergyUtil.hasEnergy(sPlayer, energy)) {
            return damage;
        }

        EnergyUtil.consumeEnergy(sPlayer, energy);

        return 0;
    }


    @Override
    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level level, LivingEntity holder, int slot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if(!(holder instanceof ServerPlayer sPlayer)) return;
        if(holder.tickCount % 10 != 0) return;

        int toRepair = Math.min(modifier.intEffectiveLevel(), tool.getDamage());
        int energy = toConsume(toRepair, toRepair);

        if (!EnergyUtil.hasEnergy(sPlayer, energy)) {
            return;
        }

        EnergyUtil.consumeEnergy(sPlayer, energy);
        ToolDamageUtil.repair(tool, toRepair);
    }

    protected int toConsume(int damage, int level) {
        return Math.max(ENERGY_REPAIR * damage - (ENERGY_REDUCE * level), 100);
    }
}
