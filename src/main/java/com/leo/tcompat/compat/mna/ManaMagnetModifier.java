package com.leo.tcompat.compat.mna;

import com.mna.api.capabilities.IPlayerMagic;
import com.mna.capabilities.playerdata.magic.PlayerMagicProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.special.PlantHarvestModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.special.ShearsModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.tools.modifiers.upgrades.general.MagneticModifier;

import javax.annotation.Nullable;

public class ManaMagnetModifier extends Modifier implements PlantHarvestModifierHook, ShearsModifierHook, BlockBreakModifierHook, MeleeHitModifierHook, ProjectileLaunchModifierHook, InventoryTickModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.PLANT_HARVEST, ModifierHooks.SHEAR_ENTITY, ModifierHooks.BLOCK_BREAK, ModifierHooks.MELEE_HIT, ModifierHooks.PROJECTILE_LAUNCH, ModifierHooks.INVENTORY_TICK);
    }

    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        if (context.isAOE()) {
            return;
        }

        applyMagnet(modifier, context.getLiving());
    }

    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (context.isExtraAttack()) {
            return;
        }

        applyMagnet(modifier, context.getAttacker());
    }

    public void afterHarvest(IToolStackView tool, ModifierEntry modifier, UseOnContext context, ServerLevel world, BlockState state, BlockPos pos) {
        Player player = context.getPlayer();
        if (player == null) {
            return;
        }

        applyMagnet(modifier, player);
    }

    public void afterShearEntity(IToolStackView tool, ModifierEntry modifier, Player player, Entity entity, boolean isTarget) {
        if (!isTarget) {
            return;
        }

        applyMagnet(modifier, player);
    }

    public void onProjectileLaunch(IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, Projectile projectile, @Nullable AbstractArrow arrow, ModDataNBT persistentData, boolean primary) {
        if (!primary) {
            return;
        }

        applyMagnet(modifier, shooter);
    }

    @Override
    public void onInventoryTick(IToolStackView tool, ModifierEntry modifier, Level level, LivingEntity holder, int slot, boolean isEquipped, boolean isCorrectSlot, ItemStack itemStack) {
        if(!isEquipped || !isCorrectSlot) return;
        if(holder.tickCount % 20 != 0) return;

        applyMagnet(modifier, holder);
    }

    private static void applyMagnet(ModifierEntry modifier, LivingEntity holder) {
        if(!(holder instanceof ServerPlayer player)) return;

        LazyOptional<IPlayerMagic> lazyCap = player.getCapability(PlayerMagicProvider.MAGIC);
        if(!lazyCap.isPresent() || lazyCap.resolve().isEmpty()) return;
        IPlayerMagic magic = lazyCap.resolve().get();

        float mana = Math.max(1, 5 - modifier.getLevel());
        if(!magic.getCastingResource().hasEnough(player, mana)) return;

        magic.getCastingResource().consume(player, mana);

        MagneticModifier.applyMagnet(holder, modifier.getLevel() - 1);
        MagneticModifier.applyVelocity(holder, modifier.getLevel() - 1, ExperienceOrb.class, 3, 0.05f, 100);
    }
}
