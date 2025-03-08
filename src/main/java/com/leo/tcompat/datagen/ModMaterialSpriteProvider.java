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
                    .addARGB(63, 0xFF380a04)
                    .addARGB(102, 0xFF420e05)
                    .addARGB(140, 0xFF4b190a)
                    .addARGB(178, 0xFF511e0b)
                    .addARGB(216, 0xFF54210d)
                    .addARGB(255, 0xFF5e2409)
                    .build()
            );

        this.buildMaterial(TCompatValues.LIVINGROCK)
            .meleeHarvest()
            .fallbacks("rock")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFa19784)
                    .addARGB(63, 0xFFB1A283)
                    .addARGB(102, 0xFFaea592)
                    .addARGB(140, 0xFFc0b7a5)
                    .addARGB(178, 0xFFc9c2b1)
                    .addARGB(216, 0xFFd1cbba)
                    .addARGB(255, 0xFFdbd5c4)
                    .build()
            );

        this.buildMaterial(TCompatValues.REDQUARTZ)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFFffb9b9) //fc5a5a
                    .addARGB(63, 0xFFffbdbd) //fc8585
                    .addARGB(102, 0xFFffc9c9) //fc8f8f
                    .addARGB(140, 0xFFffcbcb) //fcc3c3
                    .addARGB(178, 0xFFffd5d5) //fcdcdc
                    .addARGB(216, 0xFFffdbdb) //fce8e8
                    .addARGB(255, 0xFFffdddd) //FFFFFF
                    .build()
            );

        this.buildMaterial(TCompatValues.MANASTEEL)
            .meleeHarvest()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF211078)
                    .addARGB(63, 0xFF251288)
                    .addARGB(102, 0xFF1f20b7)
                    .addARGB(140, 0xFF3962d7)
                    .addARGB(178, 0xFF66b7eb)
                    .addARGB(216, 0xFFb3fcf9)
                    .addARGB(255, 0xFFfcfcfc)
                    .build()
            );

        this.buildMaterial(TCompatValues.TERRASTEEL)
            .meleeHarvest()
            .armor()
            .maille()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF033017)
                    .addARGB(63, 0xFF043b1c)
                    .addARGB(102, 0xFF0c7127)
                    .addARGB(140, 0xFF2ab73a)
                    .addARGB(178, 0xFF69e561)
                    .addARGB(216, 0xFFcafcb3)
                    .addARGB(255, 0xFFfcfcfc)
                    .build()
            );

        this.buildMaterial(TCompatValues.ELEMENTIUM)
            .meleeHarvest()
            .armor()
            .maille()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF150135)
                    .addARGB(63, 0xFF3e0765)
                    .addARGB(102, 0xFF791890)
                    .addARGB(140, 0xFFc342a6)
                    .addARGB(178, 0xFFdd82a3)
                    .addARGB(216, 0xFFf2c5c2)
                    .addARGB(255, 0xFFfcf8f6)
                    .build()
            );
    }

    private void embers() {
        this.buildMaterial(TCompatValues.DAWNSTONE)
            .meleeHarvest()
            .armor()
            .maille()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF372710)
                    .addARGB(63, 0xFF483315)
                    .addARGB(120, 0xFF65461d)
                    .addARGB(140, 0xFF785121)
                    .addARGB(178, 0xFFc07a31)
                    .addARGB(216, 0xFFf1983b)
                    .addARGB(255, 0xFFffb648)
                    .build()
            );
    }

    private void draconicEvolution() {
        this.buildMaterial(TCompatValues.WYVERN)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF170523)
                    .addARGB(63, 0xFF27093c)
                    .addARGB(102, 0xFF3b1550)
                    .addARGB(140, 0xFF664b75)
                    .addARGB(178, 0xFF77508d)
                    .addARGB(216, 0xFFab7ac9)
                    .addARGB(255, 0xFFbc90d6)
                    .build()
            );

        this.buildMaterial(TCompatValues.DRACONIC)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF700400)
                    .addARGB(63, 0xFF9d0f00)
                    .addARGB(102, 0xFFc92900)
                    .addARGB(140, 0xFFfc8905)
                    .addARGB(178, 0xFFfc901c)
                    .addARGB(216, 0xFFfccf7d)
                    .addARGB(255, 0xFFfcf09d)
                    .build()
            );
        this.buildMaterial(TCompatValues.CHAOTIC)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF090218)
                    .addARGB(63, 0xFF0a021a)
                    .addARGB(102, 0xFF1a132b)
                    .addARGB(140, 0xFF6e677e)
                    .addARGB(178, 0xFF898297)
                    .addARGB(216, 0xFFe5dff3)
                    .addARGB(255, 0xFFfffdff)
                    .build()
            );

    }

    private void bloodMagic() {
        this.buildMaterial(TCompatValues.HELLFORGED)
            .meleeHarvest()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF2a4a43)
                    .addARGB(63, 0xFF375f57)
                    .addARGB(102, 0xFF78c9b9)
                    .addARGB(140, 0xFF9ad9cd)
                    .addARGB(178, 0xFF9fe4d6)
                    .addARGB(216, 0xFFb7f0e6)
                    .addARGB(255, 0xFFdef6f6)
                    .build()
            );
    }

    private void manaAndArtifice() {
        this.buildMaterial(TCompatValues.CHIMERITE)
            .meleeHarvest()
            .armor()
            .maille()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF97a0b6)
                    .addARGB(63, 0xFFacb4d9)
                    .addARGB(102, 0xFFc8bcbd)
                    .addARGB(140, 0xFFbcc7ca)
                    .addARGB(178, 0xFFc8d4c5)
                    .addARGB(216, 0xFFe6ebc5)
                    .addARGB(255, 0xFFe2dbc2)
                    .build()
            );

        this.buildMaterial(TCompatValues.VINTEUM)
            .meleeHarvest()
            .armor()
            .maille()
            .fallbacks("metal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF4675bd)
                    .addARGB(63, 0xFF5e8ecd)
                    .addARGB(102, 0xFF6a9ed5)
                    .addARGB(140, 0xFF77aedc)
                    .addARGB(178, 0xFF86bee3)
                    .addARGB(216, 0xFFa0d0eb)
                    .addARGB(255, 0xFFafd9ef)
                    .build()
            );
    }

    private void projectE() {
        this.buildMaterial(TCompatValues.DARK_MATTER)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF060606)
                    .addARGB(63, 0xFF090909)
                    .addARGB(102, 0xFF0c0c0c)
                    .addARGB(140, 0xFF0f0f0f)
                    .addARGB(178, 0xFF131313)
                    .addARGB(216, 0xFF151515)
                    .addARGB(255, 0xFF171717)
                    .build()
            );

        this.buildMaterial(TCompatValues.RED_MATTER)
            .meleeHarvest()
            .fallbacks("crystal")
            .colorMapper(
                GreyToColorMapping.builder()
                    .addARGB(0, 0xFF340303)
                    .addARGB(63, 0xFF3a0303)
                    .addARGB(102, 0xFF3a0303)
                    .addARGB(140, 0xFF400303)
                    .addARGB(178, 0xFF430404)
                    .addARGB(216, 0xFF470404)
                    .addARGB(255, 0xFF4d0404)
                    .build()
            );
    }
}
