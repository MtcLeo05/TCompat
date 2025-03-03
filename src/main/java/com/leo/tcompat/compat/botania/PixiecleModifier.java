package com.leo.tcompat.compat.botania;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.AttributesModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import vazkii.botania.common.handler.PixieHandler;

import java.util.function.BiConsumer;

public class PixiecleModifier extends Modifier implements AttributesModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.ATTRIBUTES);
    }

    @Override
    public void addAttributes(IToolStackView tool, ModifierEntry modifier, EquipmentSlot equipmentSlot, BiConsumer<Attribute, AttributeModifier> biConsumer) {
        String modifierName = "modifier.tcompat.pixiecle" + equipmentSlot.getType().name() + "_" + equipmentSlot.getIndex();

        biConsumer.accept(
            PixieHandler.PIXIE_SPAWN_CHANCE,
            new AttributeModifier(
                modifierName,
                modifier.getLevel() * 0.05,
                AttributeModifier.Operation.ADDITION
            )
        );
    }
}
