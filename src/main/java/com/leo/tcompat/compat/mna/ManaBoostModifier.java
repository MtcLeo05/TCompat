package com.leo.tcompat.compat.mna;

import com.mna.api.capabilities.IPlayerMagic;
import com.mna.capabilities.playerdata.magic.PlayerMagicProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.util.LazyOptional;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ProcessLootModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public class ManaBoostModifier extends Modifier implements MeleeHitModifierHook, ProcessLootModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.MELEE_HIT, ModifierHooks.PROCESS_LOOT);
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        Player player = context.getPlayerAttacker();
        LivingEntity target = context.getLivingTarget();
        if(target == null) return;
        if(target.isDeadOrDying()) return;
        if(player.level().random.nextFloat() > 0.1 + (modifier.getLevel() * 0.075f)) return;

        LazyOptional<IPlayerMagic> lazyCap = player.getCapability(PlayerMagicProvider.MAGIC);
        if(!lazyCap.isPresent() || lazyCap.resolve().isEmpty()) return;
        IPlayerMagic magic = lazyCap.resolve().get();

        float mana = 25 + (25 * (modifier.getLevel() * 0.024f));
        if(!magic.getCastingResource().hasEnough(player, mana)) return;

        magic.getCastingResource().consume(player, mana);
        target.hurt(player.level().damageSources().magic(), damageDealt / 4f);
    }

    @Override
    public void processLoot(IToolStackView tool, ModifierEntry modifier, List<ItemStack> loot, LootContext context) {
        if(loot.isEmpty()) return;
        Entity entity = context.getParamOrNull(LootContextParams.THIS_ENTITY);

        if(!(entity instanceof Player player)) return;
        if(player.level().random.nextFloat() > 0.1 + (modifier.getLevel() * 0.075f)) return;
        LazyOptional<IPlayerMagic> lazyCap = player.getCapability(PlayerMagicProvider.MAGIC);
        if(!lazyCap.isPresent() || lazyCap.resolve().isEmpty()) return;
        IPlayerMagic magic = lazyCap.resolve().get();

        float mana = 25 + (25 * (modifier.getLevel() * 0.024f));
        if(!magic.getCastingResource().hasEnough(player, mana)) return;
        magic.getCastingResource().consume(player, mana);

        for (int i = 0; i < loot.size(); i++) {
            ItemStack stack = loot.get(i);
            stack = stack.copyWithCount(Math.max((int) (stack.getCount() * 1.5), stack.getCount() + 1));
            loot.set(i, stack);
        }
    }
}
