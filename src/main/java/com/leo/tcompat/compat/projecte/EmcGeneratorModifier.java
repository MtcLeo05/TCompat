package com.leo.tcompat.compat.projecte;

import com.leo.tcompat.common.TCompatValues;
import com.leo.tcompat.common.ToolValueUtils;
import moze_intel.projecte.api.capabilities.IKnowledgeProvider;
import moze_intel.projecte.api.capabilities.PECapabilities;
import moze_intel.projecte.utils.EMCHelper;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ProcessLootModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.math.BigInteger;
import java.util.List;

public class EmcGeneratorModifier extends NoLevelsModifier implements ProcessLootModifierHook, GeneralInteractionModifierHook, TooltipModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.PROCESS_LOOT, ModifierHooks.GENERAL_INTERACT, ModifierHooks.TOOLTIP);
    }


    @Override
    public void processLoot(IToolStackView tool, ModifierEntry modifier, List<ItemStack> loot, LootContext context) {
        if(loot.isEmpty()) return;

        if(!ToolValueUtils.hasValue(tool, TCompatValues.GENERIC_BOOLEAN, Tag.TAG_FLOAT) || ToolValueUtils.getFloatValue(tool, TCompatValues.GENERIC_BOOLEAN) == 0) {
            return;
        }

        Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);

        if(!(entity instanceof ServerPlayer player)) return;

        LazyOptional<IKnowledgeProvider> emc = player.getCapability(PECapabilities.KNOWLEDGE_CAPABILITY);
        if(!emc.isPresent() || emc.resolve().isEmpty()) return;

        IKnowledgeProvider storage = emc.resolve().get();

        loot.removeIf(s -> {
            if(!EMCHelper.doesItemHaveEmc(s)) return false;

            storage.setEmc(storage.getEmc().add(BigInteger.valueOf(EMCHelper.getEmcValue(s))));
            if (storage.hasKnowledge(s)) {
                return true;
            }

            storage.addKnowledge(s);
            return true;
        });

        storage.sync(player);
    }

    @Override
    public InteractionResult onToolUse(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand interactionHand, InteractionSource interactionSource) {
        if(!player.isCrouching()) return InteractionResult.PASS;

        if(!ToolValueUtils.hasValue(tool, TCompatValues.GENERIC_BOOLEAN, Tag.TAG_FLOAT)) {
            ToolValueUtils.uncheckedSetFloatValue(tool, TCompatValues.GENERIC_BOOLEAN, 0);
            return InteractionResult.CONSUME;
        }

        float oldFloat = ToolValueUtils.getFloatValue(tool, TCompatValues.GENERIC_BOOLEAN);
        float newFloat = oldFloat == 1? 0: 1;
        ToolValueUtils.uncheckedSetFloatValue(tool, TCompatValues.GENERIC_BOOLEAN, newFloat);

        return InteractionResult.CONSUME;
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> list, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        if(!ToolValueUtils.hasValue(tool, TCompatValues.GENERIC_BOOLEAN, Tag.TAG_FLOAT)) return;

        String mode = TCompatValues.EMC_GENERATOR_MODE + (ToolValueUtils.getFloatValue(tool, TCompatValues.GENERIC_BOOLEAN) == 1? "burning": "dropping");

        list.add(Component.translatable(mode));
    }
}
