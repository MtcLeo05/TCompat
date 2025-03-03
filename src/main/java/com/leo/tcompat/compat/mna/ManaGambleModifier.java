package com.leo.tcompat.compat.mna;

import com.mna.api.capabilities.IPlayerMagic;
import com.mna.capabilities.playerdata.magic.PlayerMagicProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.LazyOptional;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.mining.BlockBreakModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.ArrayList;
import java.util.List;

public class ManaGambleModifier extends Modifier implements BlockBreakModifierHook {
    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, ModifierHooks.BLOCK_BREAK);
    }

    @Override
    public void afterBlockBreak(IToolStackView tool, ModifierEntry modifier, ToolHarvestContext context) {
        ServerPlayer player = context.getPlayer();
        if(!context.getState().is(BlockTags.STONE_ORE_REPLACEABLES) && !context.getState().is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)) return;

        if(player.level().random.nextFloat() > 0.01 + (0.005 * modifier.getLevel())) return;
        LazyOptional<IPlayerMagic> lazyCap = player.getCapability(PlayerMagicProvider.MAGIC);
        if(!lazyCap.isPresent() || lazyCap.resolve().isEmpty()) return;
        IPlayerMagic magic = lazyCap.resolve().get();

        float mana = 50 + (50 * (modifier.getLevel() * 0.025f));
        if(!magic.getCastingResource().hasEnough(player, mana)) return;
        magic.getCastingResource().consume(player, mana);

        Iterable<Holder<Item>> itemsIt = BuiltInRegistries.ITEM.getTagOrEmpty(Tags.Items.RAW_MATERIALS);

        List<Item> items = new ArrayList<>();

        for (Holder<Item> holder : itemsIt) {
            items.add(holder.value());
        }

        int random = player.level().random.nextInt(0, items.size());
        Item item = items.get(random);
        ItemEntity entity = new ItemEntity(player.level(), context.getPos().getX(), context.getPos().getY(), context.getPos().getZ(), item.getDefaultInstance());
        player.level().addFreshEntity(entity);
    }
}
