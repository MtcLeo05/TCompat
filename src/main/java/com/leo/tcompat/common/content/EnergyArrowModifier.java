package com.leo.tcompat.common.content;

import com.leo.tcompat.common.EnergyUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.ranged.BowAmmoModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.function.Predicate;

public class EnergyArrowModifier extends Modifier implements BowAmmoModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.BOW_AMMO);
    }

    @Override
    public ItemStack findAmmo(IToolStackView tool, ModifierEntry modifier, LivingEntity holder, ItemStack item, Predicate<ItemStack> predicate) {
        if(!item.isEmpty()) return item;
        if(!(holder instanceof ServerPlayer sPlayer)) return item;

        int energy = 60;

        if (!EnergyUtil.hasEnergy(sPlayer, energy)) {
            return item;
        }

        EnergyUtil.consumeEnergy(sPlayer, energy);
        return Items.ARROW.getDefaultInstance();
    }
}
