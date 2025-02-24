package com.leo.tcompat.compat.botania;

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
import vazkii.botania.api.mana.ManaItemHandler;

public class ManaAlignedModifier extends Modifier implements InventoryTickModifierHook, ToolDamageModifierHook {

    private static final int MANA_REPAIR = 200;
    private static final int MANA_PREVENT = 100;
    private static final int MANA_REDUCE = 10;

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.INVENTORY_TICK, ModifierHooks.TOOL_DAMAGE);
    }

    @Override
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int damage, @Nullable LivingEntity holder) {
        if(!(holder instanceof ServerPlayer sPlayer)) return damage;

        int mana = toConsume(false, damage, modifier.intEffectiveLevel());

        if (!ManaItemHandler.instance().requestManaExact(new ItemStack(tool.getItem()), sPlayer, mana, false)) {
            return damage;
        }

        ManaItemHandler.instance().requestManaExact(new ItemStack(tool.getItem()), sPlayer, mana, true);
        return 0;
    }


    @Override
    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level level, LivingEntity holder, int slot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if(!(holder instanceof ServerPlayer sPlayer)) return;
        if(holder.tickCount % 10 != 0) return;

        int toRepair = Math.min(modifier.intEffectiveLevel(), tool.getDamage());
        int mana = toConsume(true, toRepair, toRepair);

        if (!ManaItemHandler.instance().requestManaExact(new ItemStack(tool.getItem()), sPlayer, mana, false)) {
            return;
        }

        ManaItemHandler.instance().requestManaExact(new ItemStack(tool.getItem()), sPlayer, mana, true);
        ToolDamageUtil.repair(tool, toRepair);
    }

    protected int toConsume(boolean isRepair, int damage, int level) {
        return Math.max((isRepair ? MANA_REPAIR: MANA_PREVENT) * damage - (MANA_REDUCE * level), 10);
    }
}
