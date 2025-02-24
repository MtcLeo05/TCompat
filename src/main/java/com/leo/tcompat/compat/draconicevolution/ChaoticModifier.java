package com.leo.tcompat.compat.draconicevolution;

import net.minecraft.util.RandomSource;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class ChaoticModifier extends Modifier implements MeleeDamageModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this,ModifierHooks.MELEE_DAMAGE);
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float base, float damage) {
        RandomSource random = context.getLevel().random;
        int min = 50 / modifier.getLevel();
        int max = 300 * modifier.getLevel();

        float multiplier = random.nextIntBetweenInclusive(min, max) / 100f;

        return damage * multiplier;
    }
}
