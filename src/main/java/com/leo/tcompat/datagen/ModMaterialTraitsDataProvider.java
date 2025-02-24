package com.leo.tcompat.datagen;

import com.leo.tcompat.common.TCompatValues;
import com.leo.tcompat.compat.botania.BotaniaInit;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
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
    }

    private void botania() {
        this.addDefaultTraits(TCompatValues.LIVINGWOOD, ModifierIds.cultivated, TCompatValues.MANA_ALIGNED);
        this.addDefaultTraits(TCompatValues.LIVINGROCK, TinkerModifiers.stonebound, BotaniaInit.MANA_ALIGNED);
        this.addDefaultTraits(TCompatValues.REDQUARTZ, BotaniaInit.BLOODLUST);
        this.addDefaultTraits(TCompatValues.MANASTEEL, TCompatValues.MANA_ALIGNED, TCompatValues.MANA_CRUMBLING);
        this.addDefaultTraits(TCompatValues.TERRASTEEL, BotaniaInit.MANA_ALIGNED, TinkerModifiers.lacerating);
    }

    private void embers() {
        this.addDefaultTraits(TCompatValues.DAWNSTONE, TinkerModifiers.dwarven, TinkerModifiers.stonebound);
    }

    private void draconic() {
        this.addDefaultTraits(TCompatValues.WYVERN, TCompatValues.ENERGIZED);
        this.addDefaultTraits(TCompatValues.DRACONIC, TCompatValues.ENERGIZED, TCompatValues.DRACONIC_M);
        this.addDefaultTraits(TCompatValues.CHAOTIC, TCompatValues.ENERGIZED, TCompatValues.CHAOTIC_M);
    }


    @Override
    public String getName() {
        return "TCompat - Material Trait Provider";
    }
}
