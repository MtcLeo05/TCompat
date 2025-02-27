package com.leo.tcompat.datagen;

import com.leo.tcompat.common.TCompatValues;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Tiers;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.HandleMaterialStats;
import slimeknights.tconstruct.tools.stats.HeadMaterialStats;
import slimeknights.tconstruct.tools.stats.PlatingMaterialStats;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

public class ModMaterialStatsDataProvider extends AbstractMaterialStatsDataProvider {
    public ModMaterialStatsDataProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    protected void addMaterialStats() {
        botania();
        embers();
        draconic();
        bloodMagic();
        manaAndArtifice();
    }

    private void botania() {
        addMaterialStats(TCompatValues.LIVINGWOOD, new HeadMaterialStats(80, 2.25f, Tiers.WOOD, 0.25f), HandleMaterialStats.percents().build(), StatlessMaterialStats.BINDING);
        addMaterialStats(TCompatValues.LIVINGROCK, new HeadMaterialStats(150, 4.25f, Tiers.STONE, 1.25f), HandleMaterialStats.multipliers().durability(0.85F).miningSpeed(1.1F).build(), StatlessMaterialStats.BINDING);
        addMaterialStats(TCompatValues.REDQUARTZ, new HeadMaterialStats(90, 3.5f, Tiers.STONE, 1.75f), HandleMaterialStats.multipliers().durability(0.75F).attackDamage(1.25F).build(), StatlessMaterialStats.BINDING);
        addMaterialStats(TCompatValues.MANASTEEL, new HeadMaterialStats(275, 6.75f, Tiers.IRON, 1.25f), HandleMaterialStats.multipliers().durability(1.0f).miningSpeed(1.1f).build(), StatlessMaterialStats.BINDING);
        addMaterialStats(TCompatValues.TERRASTEEL, new HeadMaterialStats(500, 4f, Tiers.DIAMOND, 4.5f), HandleMaterialStats.multipliers().durability(0.90f).attackDamage(1.25f).attackSpeed(1.15f).build(), StatlessMaterialStats.BINDING);
    }

    private void embers() {
        addMaterialStats(TCompatValues.DAWNSTONE, new HeadMaterialStats(1000, 5.75f, Tiers.DIAMOND, 2.5f), HandleMaterialStats.percents().durability(0.1f).attackDamage(-0.1f).attackSpeed(-0.05f).miningSpeed(0.2f).build(), StatlessMaterialStats.BINDING);
        addArmorShieldStats(TCompatValues.DAWNSTONE, PlatingMaterialStats.builder().durabilityFactor(19f).armor(2.0f, 5.0f, 6.0f, 3.0f), StatlessMaterialStats.MAILLE);
    }

    private void draconic() {
        addMaterialStats(TCompatValues.WYVERN, new HeadMaterialStats(1500, 7f, Tiers.NETHERITE, 10f), HandleMaterialStats.percents().durability(0.3f).build(), StatlessMaterialStats.BINDING);
        addMaterialStats(TCompatValues.DRACONIC, new HeadMaterialStats(1750, 8f, Tiers.NETHERITE, 12.5f), HandleMaterialStats.percents().durability(0.4f).build(), StatlessMaterialStats.BINDING);
        addMaterialStats(TCompatValues.CHAOTIC, new HeadMaterialStats(2000, 9f, Tiers.NETHERITE, 15f), HandleMaterialStats.percents().durability(0.5f).build(), StatlessMaterialStats.BINDING);
    }

    private void bloodMagic() {
        addMaterialStats(TCompatValues.HELLFORGED, new HeadMaterialStats(300, 6.25f, Tiers.IRON, 2.25f), HandleMaterialStats.percents().durability(0.125f).build(), StatlessMaterialStats.BINDING);
    }

    private void manaAndArtifice() {
        addMaterialStats(TCompatValues.CHIMERITE, new HeadMaterialStats(750, 7.0f, Tiers.DIAMOND, 5.25f), HandleMaterialStats.multipliers().durability(1.75f).attackDamage(1.25f).build(), StatlessMaterialStats.BINDING);
    }
    
    @Override
    public String getName() {
        return "TCompat - Material Stats Provider";
    }
}
