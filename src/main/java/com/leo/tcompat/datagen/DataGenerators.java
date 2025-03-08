package com.leo.tcompat.datagen;

import com.leo.tcompat.TCompat;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.fluids.data.FluidBlockstateModelProvider;
import slimeknights.tconstruct.fluids.data.FluidBucketModelProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

@Mod.EventBusSubscriber(modid = TCompat.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeClient(), new ModLanguageProvider(packOutput, "en_us"));

        generator.addProvider(event.includeClient(), new ModModifierProvider(packOutput));

        ModMaterialDataProvider mdp = new ModMaterialDataProvider(packOutput);
        generator.addProvider(event.includeClient(), mdp);
        generator.addProvider(event.includeClient(), new ModMaterialStatsDataProvider(packOutput, mdp));
        generator.addProvider(event.includeClient(), new ModMaterialTraitsDataProvider(packOutput, mdp));

        ModMaterialSpriteProvider materialSprite = new ModMaterialSpriteProvider();
        TinkerPartSpriteProvider tinkerPartProvider = new TinkerPartSpriteProvider();

        generator.addProvider(event.includeClient(), new ModMaterialRenderInfoProvider(packOutput, materialSprite, existingFileHelper));

        generator.addProvider(event.includeClient(), new MaterialPartTextureGenerator(packOutput, existingFileHelper, tinkerPartProvider, materialSprite));

        generator.addProvider(event.includeClient(), new FluidBucketModelProvider(packOutput, TCompat.MODID));
        generator.addProvider(event.includeClient(), new FluidBlockstateModelProvider(packOutput, TCompat.MODID));
        generator.addProvider(event.includeClient(), new ModFluidTextureProvider(packOutput));
    }
}
