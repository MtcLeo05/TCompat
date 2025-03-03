package com.leo.tcompat.compat.mna;

import com.leo.tcompat.TCompat;
import com.leo.tcompat.common.TCompatValues;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FlowingFluidObject;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.fluids.block.BurningLiquidBlock;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class MNAInit {
    public static final ModifierDeferredRegister MNA_M = ModifierDeferredRegister.create(TCompat.MODID);
    public static final FluidDeferredRegister MNA_F = new FluidDeferredRegister(TCompat.MODID);

    public static final StaticModifier<Modifier> MANA_STORM = MNA_M.register(TCompatValues.MANA_STORM.getPath(), ManaStormModifier::new);
    public static final StaticModifier<Modifier> MANA_BOOST = MNA_M.register(TCompatValues.MANA_BOOST.getPath(), ManaBoostModifier::new);
    public static final StaticModifier<Modifier> MANA_MAGNET = MNA_M.register(TCompatValues.MANA_MAGNET.getPath(), ManaMagnetModifier::new);
    public static final StaticModifier<Modifier> MANA_GAMBLE = MNA_M.register(TCompatValues.MANA_GAMBLE.getPath(), ManaGambleModifier::new);

    public static final FlowingFluidObject<ForgeFlowingFluid> MOLTEN_CHIMERITE = MNA_F.register("molten_chimerite")
        .type(
            hot("molten_chimerite")
                .temperature(1100)
                .lightLevel(12)
        )
        .block(BurningLiquidBlock.createBurning(MapColor.COLOR_LIGHT_GRAY, 12, 10, 5.0F))
        .bucket()
        .flowing();

    public static final FlowingFluidObject<ForgeFlowingFluid> MOLTEN_VINTEUM = MNA_F.register("molten_vinteum")
        .type(
            hot("molten_vinteum")
                .temperature(1100)
                .lightLevel(12)
        )
        .block(BurningLiquidBlock.createBurning(MapColor.COLOR_CYAN, 12, 10, 5.0F))
        .bucket()
        .flowing();


    public static void init(IEventBus eventBus) {
        MNA_M.register(eventBus);
        MNA_F.register(eventBus);
    }

    public static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000).descriptionId(TConstruct.makeDescriptionId("fluid", name)).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA).motionScale(0.0023333333333333335).canSwim(false).canDrown(false).pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }
}
