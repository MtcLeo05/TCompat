package com.leo.tcompat.compat.draconicevolution;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeDamageModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class DraconicModifier extends Modifier implements MeleeDamageModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_DAMAGE);
    }

    @Override
    public float getMeleeDamage(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float base, float damage) {
        if(!(context.getPlayerAttacker() instanceof ServerPlayer sPlayer)) return damage;
        if(!sPlayer.serverLevel().dimension().equals(Level.END)) return damage;

        return damage + (damage * (0.1f + (0.05f * modifier.getEffectiveLevel())));
    }
}
