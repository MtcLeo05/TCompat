package com.leo.tcompat.compat.mna;

import com.mna.api.capabilities.IPlayerMagic;
import com.mna.capabilities.playerdata.magic.PlayerMagicProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.LazyOptional;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.EquipmentChangeModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ManaStormModifier extends Modifier implements EquipmentChangeModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.EQUIPMENT_CHANGE);
    }

    @Override
    public void onEquip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        if(!(context.getEntity() instanceof ServerPlayer player)) return;
        LazyOptional<IPlayerMagic> lazyCap = player.getCapability(PlayerMagicProvider.MAGIC);

        if(!lazyCap.isPresent() || lazyCap.resolve().isEmpty()) return;

        IPlayerMagic magic = lazyCap.resolve().get();

        float mod = 40 + (20 * modifier.getLevel());

        magic.getCastingResource().addModifier("modifier.tcompat.tool_boost", mod);
    }

    @Override
    public void onUnequip(IToolStackView tool, ModifierEntry modifier, EquipmentChangeContext context) {
        if(!(context.getEntity() instanceof ServerPlayer player)) return;
        LazyOptional<IPlayerMagic> lazyCap = player.getCapability(PlayerMagicProvider.MAGIC);

        if(!lazyCap.isPresent() || lazyCap.resolve().isEmpty()) return;

        IPlayerMagic magic = lazyCap.resolve().get();

        float mod = 40 + (20 * modifier.getLevel());

        magic.getCastingResource().removeModifier("modifier.tcompat.tool_boost");
    }
}
