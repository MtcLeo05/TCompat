package com.leo.tcompat.datagen;

import com.leo.tcompat.common.TCompatValues;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class ModMaterialDataProvider extends AbstractMaterialDataProvider {
    public ModMaterialDataProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addMaterials() {
        botania();
        embers();
        draconicEvolution();
        bloodMagic();
        manaAndArtifice();
    }

    private void botania() {
        ICondition mod = new ModLoadedCondition("botania");

        addMaterial(TCompatValues.LIVINGWOOD, 1, ORDER_GENERAL, true, false, mod);
        addMaterial(TCompatValues.LIVINGROCK, 1, ORDER_GENERAL, true, false, mod);
        addMaterial(TCompatValues.REDQUARTZ, 1, ORDER_WEAPON, true, false, mod);
        addMaterial(TCompatValues.MANASTEEL, 2, ORDER_HARVEST, false, false, mod);
        addMaterial(TCompatValues.TERRASTEEL, 3, ORDER_WEAPON, false, false, mod);
        addMaterial(TCompatValues.ELEMENTIUM, 2, ORDER_COMPAT, false, false, mod);
    }

    private void embers() {
        ICondition mod = new ModLoadedCondition("embers");

        addMaterial(TCompatValues.DAWNSTONE, 3, ORDER_HARVEST, false, false, mod);
    }

    private void draconicEvolution() {
        ICondition mod = new ModLoadedCondition("draconicevolution");

        addMaterial(TCompatValues.WYVERN, 5, ORDER_GENERAL, true, false, mod);
        addMaterial(TCompatValues.DRACONIC, 5, ORDER_GENERAL, true, false, mod);
        addMaterial(TCompatValues.CHAOTIC, 5, ORDER_GENERAL, true, false, mod);
    }

    private void bloodMagic() {
        ICondition mod = new ModLoadedCondition("bloodmagic");

        addMaterial(TCompatValues.HELLFORGED, 2, ORDER_GENERAL, false, false, mod);
    }

    private void manaAndArtifice() {
        ICondition mod = new ModLoadedCondition("mna");

        addMaterial(TCompatValues.CHIMERITE, 2, ORDER_GENERAL, false, false, mod);
    }


    @Override
    public String getName() {
        return "TCompat - Material Data Provider";
    }
}
