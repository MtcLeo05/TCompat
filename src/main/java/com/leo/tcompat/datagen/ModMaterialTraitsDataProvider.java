package com.leo.tcompat.datagen;

import com.leo.tcompat.common.TCompatValues;
import com.leo.tcompat.compat.botania.BotaniaInit;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.data.ModifierIds;

public class ModMaterialTraitsDataProvider extends AbstractMaterialTraitDataProvider {
    public ModMaterialTraitsDataProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialTraits() {
        botania();
        embers();
        draconic();
        bloodMagic();
        manaAndArtifice();
    }

    private void botania() {
        this.addDefaultTraits(TCompatValues.LIVINGWOOD, ModifierIds.cultivated, TCompatValues.MANA_ALIGNED);
        this.addDefaultTraits(TCompatValues.LIVINGROCK, TinkerModifiers.stonebound, BotaniaInit.MANA_ALIGNED);
        this.addDefaultTraits(TCompatValues.REDQUARTZ, BotaniaInit.BLOODLUST);
        this.addDefaultTraits(TCompatValues.MANASTEEL, TCompatValues.MANA_ALIGNED, TCompatValues.MANA_CRUMBLING);
        this.addDefaultTraits(TCompatValues.TERRASTEEL, BotaniaInit.MANA_ALIGNED);
        this.addDefaultTraits(TCompatValues.ELEMENTIUM, BotaniaInit.MANA_ALIGNED);

        this.addTraits(TCompatValues.TERRASTEEL, MaterialRegistry.MELEE_HARVEST, TinkerModifiers.lacerating, BotaniaInit.MANA_ALIGNED);
        this.addTraits(TCompatValues.TERRASTEEL, MaterialRegistry.ARMOR, TCompatValues.TERRESTRIAL, TCompatValues.MANA_ALIGNED);
        this.addTraits(TCompatValues.ELEMENTIUM, MaterialRegistry.ARMOR, TCompatValues.PIXIECLE, TCompatValues.MANA_ALIGNED);
    }

    private void embers() {
        this.addDefaultTraits(TCompatValues.DAWNSTONE, TinkerModifiers.dwarven, TinkerModifiers.stonebound);
    }

    private void draconic() {
        this.addDefaultTraits(TCompatValues.WYVERN, TCompatValues.ENERGIZED);
        this.addDefaultTraits(TCompatValues.DRACONIC, TCompatValues.ENERGIZED, TCompatValues.DRACONIC_M);
        this.addDefaultTraits(TCompatValues.CHAOTIC, TCompatValues.ENERGIZED, TCompatValues.CHAOTIC_M);
    }

    private void bloodMagic() {
        this.addDefaultTraits(TCompatValues.HELLFORGED, TCompatValues.WILLING, TCompatValues.SENTIENT);
    }

    private void manaAndArtifice() {
        this.addDefaultTraits(TCompatValues.CHIMERITE, TCompatValues.MANA_STORM);
        this.addDefaultTraits(TCompatValues.VINTEUM, TCompatValues.MANA_MAGNET);

        this.addTraits(TCompatValues.CHIMERITE, MaterialRegistry.MELEE_HARVEST, TCompatValues.MANA_BOOST, TCompatValues.MANA_STORM);
        this.addTraits(TCompatValues.VINTEUM, MaterialRegistry.MELEE_HARVEST, TCompatValues.MANA_MAGNET);

        this.addTraits(TCompatValues.CHIMERITE, MaterialRegistry.ARMOR, TCompatValues.MANA_STORM);
        this.addTraits(TCompatValues.VINTEUM, MaterialRegistry.ARMOR, TCompatValues.MANA_MAGNET);
    }

    @Override
    public String getName() {
        return "TCompat - Material Trait Provider";
    }
}
