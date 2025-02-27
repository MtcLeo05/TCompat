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
        botania();
        draconicEvolution();
        bloodMagic();
    }

    private void botania() {
        ICondition mod = modLoaded("botania");
        buildModifier(TCompatValues.MANA_ALIGNED, mod);
        buildModifier(TCompatValues.BLOODLUST, mod);
        buildModifier(TCompatValues.MANA_CRUMBLING, mod);
    }

    private void draconicEvolution() {
        ICondition mod = modLoaded("draconicevolution");
        buildModifier(TCompatValues.ENERGIZED, mod);
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

    @Override
    public String getName() {
        return "TCompat - Modifier Provider";
    }
}
