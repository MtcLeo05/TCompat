package com.leo.tcompat.compat.botania;

import com.leo.tcompat.common.TCompatValues;
import com.leo.tcompat.common.ToolValueUtils;
import net.minecraft.core.Direction;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import vazkii.botania.api.mana.ManaItemHandler;

import java.util.List;

public class ManaCrumblingModifier extends Modifier implements BreakSpeedModifierHook, TooltipModifierHook, BlockBreakModifierHook {
    private static final int MANA_CONSUME = 100;
    private static final float BOOST = 50 / 100f;
    private static final float INCREASE = 25 / 100f;

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.BREAK_SPEED, ModifierHooks.TOOLTIP, ModifierHooks.BLOCK_BREAK);
    }

    @Override
    public void onBreakSpeed(IToolStackView tool, ModifierEntry modifier, PlayerEvent.BreakSpeed event, Direction sideHit, boolean isEffective, float miningSpeedModifier) {
        Player player = event.getEntity();

        if(!isEffective) return;
        if(ToolValueUtils.hasValue(tool, TCompatValues.GENERIC_BOOLEAN, Tag.TAG_FLOAT) && ToolValueUtils.getFloatValue(tool, TCompatValues.GENERIC_BOOLEAN) == 1) {
            float oldSpeed = event.getNewSpeed();
            float newSpeed = boost(modifier, oldSpeed) * miningSpeedModifier;
            event.setNewSpeed(newSpeed);
            return;
        }

        if (!ManaItemHandler.instance().requestManaExact(new ItemStack(tool.getItem()), player, MANA_CONSUME, false)) {
            return;
        }

        ManaItemHandler.instance().requestManaExact(new ItemStack(tool.getItem()), player, MANA_CONSUME, true);
        ToolValueUtils.uncheckedSetFloatValue(tool, TCompatValues.GENERIC_BOOLEAN, 1);
        float oldSpeed = event.getNewSpeed();
        float newSpeed = boost(modifier, oldSpeed) * miningSpeedModifier;
        event.setNewSpeed(newSpeed);
    }

    protected float boost(ModifierEntry modifier, float original) {
        return original + (original * perchBoost(modifier));
    }

    protected float perchBoost(ModifierEntry modifier) {
        return BOOST + ((modifier.getLevel() - 1) * INCREASE);
    }

    @Override
    public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltips, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
        if(!ToolValueUtils.hasValue(tool, TCompatValues.GENERIC_BOOLEAN, Tag.TAG_FLOAT) || ToolValueUtils.getFloatValue(tool, TCompatValues.GENERIC_BOOLEAN) == 0) return;

        TooltipModifierHook.addPercentBoost(this, Component.translatable(TCompatValues.MANA_CRUMBLING_TOOLTIP), perchBoost(modifier), tooltips);
    }

    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        ToolValueUtils.uncheckedSetFloatValue(tool, TCompatValues.GENERIC_BOOLEAN, 0);
    }
}
