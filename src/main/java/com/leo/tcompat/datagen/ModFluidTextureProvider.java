package com.leo.tcompat.datagen;

import com.leo.tcompat.TCompat;
import com.leo.tcompat.common.TCompatValues;
import com.leo.tcompat.compat.bloodmagic.BloodMagicInit;
import com.leo.tcompat.compat.botania.BotaniaInit;
import com.leo.tcompat.compat.mna.ManaAndArtificeInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.fluid.texture.AbstractFluidTextureProvider;
import slimeknights.mantle.fluid.texture.FluidTexture;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.fluids.TinkerFluids;

public class ModFluidTextureProvider extends AbstractFluidTextureProvider {

    public ModFluidTextureProvider(PackOutput packOutput) {
        super(packOutput, TCompat.MODID);
    }

    @Override
    public void addTextures() {
        this.named(BotaniaInit.MOLTEN_MANASTEEL, "molten").color(0xFF000000 | TCompatValues.MANASTEEL_COLOR);
        this.named(BotaniaInit.MOLTEN_TERRASTEEL, "molten").color(0xFF000000 | TCompatValues.TERRASTEEL_COLOR);
        this.named(BloodMagicInit.MOLTEN_HELLFORGED, "molten").color(0xFF000000 | TCompatValues.HELLFORGED_COLOR);
        this.customNamed(ManaAndArtificeInit.MOLTEN_CHIMERITE, "molten/chimerite_").color(0xFFFFFFFF);
    }

    @Override
    public String getName() {
        return "TCompat - Fluid Texture Provider";
    }

    private FluidTexture.Builder root(FluidObject<?> fluid) {
        return this.texture(fluid).wrapId("fluid/", "/", false, false);
    }

    private FluidTexture.Builder folder(FluidObject<?> fluid, String folder) {
        return this.texture(fluid).wrapId("fluid/" + folder + "/", "/", false, false);
    }

    private FluidTexture.Builder named(FluidObject<?> fluid, String name) {
        return this.texture(fluid).textures(TConstruct.getResource("fluid/" + name + "/"), false, false);
    }

    private FluidTexture.Builder customNamed(FluidObject<?> fluid, String name) {
        return this.texture(fluid).textures(new ResourceLocation(TCompat.MODID, "fluid/" + name), false, false);
    }

    private FluidTexture.Builder slime(FluidObject<?> fluid) {
        return this.folder(fluid, "slime");
    }

    private FluidTexture.Builder slime(FluidObject<?> fluid, String name) {
        return this.named(fluid, "slime/" + name);
    }

    private FluidTexture.Builder molten(FluidObject<?> fluid) {
        return this.named(fluid, "molten/" + TinkerFluids.withoutMolten(fluid));
    }

    private FluidTexture.Builder moltenFolder(FluidObject<?> fluid, String folder) {
        return this.named(fluid, "molten/" + folder + "/" + TinkerFluids.withoutMolten(fluid));
    }

    private FluidTexture.Builder stone(FluidObject<?> fluid) {
        return this.moltenFolder(fluid, "stone");
    }

    private FluidTexture.Builder ore(FluidObject<?> fluid) {
        return this.moltenFolder(fluid, "ore");
    }

    private FluidTexture.Builder alloy(FluidObject<?> fluid) {
        return this.moltenFolder(fluid, "alloy");
    }

    private FluidTexture.Builder compatOre(FluidObject<?> fluid) {
        return this.moltenFolder(fluid, "compat_ore");
    }

    private FluidTexture.Builder compatAlloy(FluidObject<?> fluid) {
        return this.moltenFolder(fluid, "compat_alloy");
    }

    private FluidTexture.Builder tintedStew(FluidObject<?> fluid) {
        return this.named(fluid, "food/stew");
    }

    private FluidTexture.Builder tintedStone(FluidObject<?> fluid) {
        return this.named(fluid, "molten/stone");
    }
}
