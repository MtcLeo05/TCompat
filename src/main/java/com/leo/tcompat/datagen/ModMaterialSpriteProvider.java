package com.leo.tcompat.datagen;

import com.leo.tcompat.common.TCompatValues;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;

public class ModMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    public String getName() {
        return "TCompat - Material Sprite Provider";
    }

    @Override
    protected void addAllMaterials() {
        botania();
        embers();
        draconicEvolution();
        bloodMagic();
        manaAndArtifice();
        projectE();
    }

    private void botania() {
        this.buildMaterial(TCompatValues.LIVINGWOOD)
            .meleeHarvest()
            .fallbacks("wood")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF330704)
                    .addARGB(63, 0xFF380A04)
                    .addARGB(102, 0xFF4B190A)
                    .addARGB(140, 0xFF511E0B)
                    .addARGB(178, 0xFF54210D)
                    .addARGB(216, 0xFF5E2409)
                    .addARGB(255, 0xFFFFFFFF)
                    .build()
            );

        this.buildMaterial(TCompatValues.LIVINGROCK)
            .meleeHarvest()
            .fallbacks("rock")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF9B7E64)
                    .addARGB(63, 0xFFA89C78)
                    .addARGB(102, 0xFFB1A283)
                    .addARGB(140, 0xFFB9AA97)
                    .addARGB(178, 0xFFCDCBC1)
                    .addARGB(216, 0xFFF4F2EC)
                    .addARGB(255, 0xFFFFFFFF)
                    .build()
            );

        this.buildMaterial(TCompatValues.REDQUARTZ)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFfc5a5a)
                    .addARGB(63, 0xFFfc8585)
                    .addARGB(102, 0xFFfc8f8f)
                    .addARGB(140, 0xFFfcc3c3)
                    .addARGB(178, 0xFFfcdcdc)
                    .addARGB(216, 0xFFfce8e8)
                    .addARGB(255, 0xFFFFFFFF)
                    .build()
            );

        this.buildMaterial(TCompatValues.MANASTEEL)
            .meleeHarvest()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFfcfcfc)
                    .addARGB(63, 0xFFb3fcf9)
                    .addARGB(102, 0xFF66b7eb)
                    .addARGB(140, 0xFF3962d7)
                    .addARGB(178, 0xFF1f20b7)
                    .addARGB(216, 0xFF251288)
                    .addARGB(255, 0xFF211078)
                    .build()
            );

        this.buildMaterial(TCompatValues.TERRASTEEL)
            .meleeHarvest()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFfcfcfc)
                    .addARGB(63, 0xFFcafcb3)
                    .addARGB(102, 0xFF69e561)
                    .addARGB(140, 0xFF2ab73a)
                    .addARGB(178, 0xFF0c7127)
                    .addARGB(216, 0xFF043b1c)
                    .addARGB(255, 0xFF033017)
                    .build()
            );

        this.buildMaterial(TCompatValues.ELEMENTIUM)
            .meleeHarvest()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFfcf8f6)
                    .addARGB(63, 0xFFf2c5c2)
                    .addARGB(102, 0xFFdd82a3)
                    .addARGB(140, 0xFFc342a6)
                    .addARGB(178, 0xFF791890)
                    .addARGB(216, 0xFF3e0765)
                    .addARGB(255, 0xFF150135)
                    .build()
            );
    }

    private void embers() {
        this.buildMaterial(TCompatValues.DAWNSTONE)
            .meleeHarvest()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF986529)
                    .addARGB(63, 0xFFbe7930)
                    .addARGB(120, 0xFFee963a)
                    .addARGB(140, 0xFFfcb447)
                    .addARGB(178, 0xFFfccc77)
                    .addARGB(216, 0xFFfcda9d)
                    .addARGB(255, 0xFFfce9c7)
                    .build()
            );
    }

    private void draconicEvolution() {
        this.buildMaterial(TCompatValues.WYVERN)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFbc90d6)
                    .addARGB(63, 0xFFab7ac9)
                    .addARGB(120, 0xFF77508d)
                    .addARGB(140, 0xFF664b75)
                    .addARGB(178, 0xFF3b1550)
                    .addARGB(216, 0xFF27093c)
                    .addARGB(255, 0xFF170523)
                    .build()
            );

        this.buildMaterial(TCompatValues.DRACONIC)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFfcf09d )
                    .addARGB(63, 0xFFfccf7d)
                    .addARGB(120, 0xFFfc901c)
                    .addARGB(140, 0xFFfc8905)
                    .addARGB(178, 0xFFc92900)
                    .addARGB(216, 0xFF9d0f00)
                    .addARGB(255, 0xFF700400)
                    .build()
            );
        this.buildMaterial(TCompatValues.CHAOTIC)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFfffdff)
                    .addARGB(63, 0xFFe5dff3)
                    .addARGB(120, 0xFF898297)
                    .addARGB(140, 0xFF6e677e)
                    .addARGB(178, 0xFF1a132b)
                    .addARGB(216, 0xFF0a021a)
                    .addARGB(255, 0xFF090218)
                    .build()
            );

    }

    private void bloodMagic() {
        this.buildMaterial(TCompatValues.HELLFORGED)
            .meleeHarvest()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFdef6f6)
                    .addARGB(63, 0xFFb7f0e6)
                    .addARGB(120, 0xFF9fe4d6)
                    .addARGB(140, 0xFF9ad9cd)
                    .addARGB(178, 0xFF78c9b9)
                    .addARGB(216, 0xFF375f57)
                    .addARGB(255, 0xFF2a4a43)
                    .build()
            );
    }

    private void manaAndArtifice() {
        this.buildMaterial(TCompatValues.CHIMERITE)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFdccbc7)
                    .addARGB(63, 0xFFdab9cc)
                    .addARGB(120, 0xFFfce87c)
                    .addARGB(140, 0xFFefbaa9)
                    .addARGB(178, 0xFFa9cfbe)
                    .addARGB(216, 0xFFaabee2)
                    .addARGB(255, 0xFFc791ad)
                    .build()
            );

        this.buildMaterial(TCompatValues.VINTEUM)
            .meleeHarvest()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFf4f8f9)
                    .addARGB(63, 0xFFb4d3de)
                    .addARGB(120, 0xFFc0fafc)
                    .addARGB(140, 0xFF9abcd0)
                    .addARGB(178, 0xFF647cac)
                    .addARGB(216, 0xFF566ba0)
                    .addARGB(255, 0xFF44558c)
                    .build()
            );
    }

    private void projectE() {
        this.buildMaterial(TCompatValues.DARK_MATTER)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF343434)
                    .addARGB(63, 0xFF37173b)
                    .addARGB(120, 0xFF331536)
                    .addARGB(140, 0xFF2d1331)
                    .addARGB(178, 0xFF240f27)
                    .addARGB(216, 0xFF1a091d)
                    .addARGB(255, 0xFF150919)
                    .build()
            );

        this.buildMaterial(TCompatValues.RED_MATTER)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFb50808)
                    .addARGB(63, 0xFF980707)
                    .addARGB(120, 0xFF940707)
                    .addARGB(140, 0xFF8e0707)
                    .addARGB(178, 0xFF850606)
                    .addARGB(216, 0xFF7d0606)
                    .addARGB(255, 0xFF7a0606)
                    .build()
            );
    }
}
