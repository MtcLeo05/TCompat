package com.leo.tcompat.compat.botania;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import vazkii.botania.api.mana.ManaItemHandler;

public class TerrestrialModifier extends Modifier implements InventoryTickModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.INVENTORY_TICK);
    }

    @Override
    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level level, LivingEntity livingEntity, int slot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if(!isSelected || !isCorrectSlot) return;
        if(!(livingEntity instanceof ServerPlayer sPlayer)) return;
        if(ManaItemHandler.instance().getManaItems(sPlayer).isEmpty() && ManaItemHandler.instance().getManaAccesories(sPlayer).isEmpty()) return;

        ManaItemHandler.instance().dispatchMana(stack, sPlayer, modifier.getLevel(), true);
    }
}
