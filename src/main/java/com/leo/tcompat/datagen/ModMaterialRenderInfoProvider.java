package com.leo.tcompat.datagen;

import com.leo.tcompat.common.TCompatValues;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class ModMaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {
    public ModMaterialRenderInfoProvider(PackOutput packOutput, AbstractMaterialSpriteProvider spriteProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, spriteProvider, existingFileHelper);
    }

    @Override
    protected void addMaterialRenderInfo() {
        botania();
        embers();
        draconicEvolution();
        bloodMagic();
        manaAndArtifice();
    }

    private void botania() {
        this.buildRenderInfo(TCompatValues.LIVINGWOOD).color(0x5E2409).fallbacks("wood");
        this.buildRenderInfo(TCompatValues.LIVINGROCK).color(0xDFE2D4).fallbacks("rock");
        this.buildRenderInfo(TCompatValues.REDQUARTZ).color(0xFC5A5A).fallbacks("crystal");
        this.buildRenderInfo(TCompatValues.MANASTEEL).color(TCompatValues.MANASTEEL_COLOR).fallbacks("metal");
        this.buildRenderInfo(TCompatValues.TERRASTEEL).color(TCompatValues.TERRASTEEL_COLOR).fallbacks("metal");
        this.buildRenderInfo(TCompatValues.ELEMENTIUM).color(TCompatValues.ELEMENTIUM_COLOR).fallbacks("metal");
    }

    private void embers() {
        this.buildRenderInfo(TCompatValues.DAWNSTONE).color(0xfcb447).fallbacks("metal");
    }

    private void draconicEvolution() {
        this.buildRenderInfo(TCompatValues.WYVERN).color(0x3b1550).fallbacks("crystal");
        this.buildRenderInfo(TCompatValues.DRACONIC).color(0xc92900).fallbacks("crystal");
        this.buildRenderInfo(TCompatValues.CHAOTIC).color(0x191328).fallbacks("crystal");
    }

    private void bloodMagic() {
        this.buildRenderInfo(TCompatValues.HELLFORGED).color(TCompatValues.HELLFORGED_COLOR).fallbacks("metal");
    }

    private void manaAndArtifice() {
        this.buildRenderInfo(TCompatValues.CHIMERITE).color(TCompatValues.CHIMERITE_COLOR).fallbacks("crystal");
        this.buildRenderInfo(TCompatValues.VINTEUM).color(TCompatValues.VINTEUM_COLOR).fallbacks("metal");
    }


    @Override
    public String getName() {
        return "TCompat - Material Render Info Provider";
    }
}
