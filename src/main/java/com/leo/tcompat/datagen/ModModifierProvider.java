package com.leo.tcompat.datagen;

import com.leo.tcompat.common.TCompatValues;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;

public class ModModifierProvider extends AbstractModifierProvider implements IConditionBuilder {

    public ModModifierProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addModifiers() {
        common();
        botania();
        draconicEvolution();
        bloodMagic();
        manaAndArtifice();
    }

    private void common() {
        buildModifier(TCompatValues.ENERGIZED);
        buildModifier(TCompatValues.ENERGY_ARROW);
    }

    private void botania() {
        ICondition mod = modLoaded("botania");
        buildModifier(TCompatValues.MANA_ALIGNED, mod);
        buildModifier(TCompatValues.BLOODLUST, mod);
        buildModifier(TCompatValues.MANA_CRUMBLING, mod);
        buildModifier(TCompatValues.MANA_ARROW, mod);
    }

    private void draconicEvolution() {
        ICondition mod = modLoaded("draconicevolution");
        buildModifier(TCompatValues.DRACONIC_M, mod);
        buildModifier(TCompatValues.CHAOTIC_M, mod);
    }

    private void bloodMagic() {
        ICondition mod = modLoaded("bloodmagic");

        buildModifier(TCompatValues.WILLING, mod);
        buildModifier(TCompatValues.CORROSIVE, mod);
        buildModifier(TCompatValues.DESTRUCTIVE, mod);
        buildModifier(TCompatValues.VENGEFUL, mod);
        buildModifier(TCompatValues.STEADFAST, mod);

        buildModifier(TCompatValues.SENTIENT, mod);
    }

    private void manaAndArtifice() {
        ICondition mod = modLoaded("mna");

        buildModifier(TCompatValues.MANA_STORM, mod);
        buildModifier(TCompatValues.MANA_BOOST, mod);
    }

    @Override
    public String getName() {
        return "TCompat - Modifier Provider";
    }
}
