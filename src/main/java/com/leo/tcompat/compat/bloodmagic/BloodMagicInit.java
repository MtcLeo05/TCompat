package com.leo.tcompat.compat.bloodmagic;

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
import wayoftime.bloodmagic.api.compat.EnumDemonWillType;

public class BloodMagicInit {
    public static final ModifierDeferredRegister BLOODMAGIC_M = ModifierDeferredRegister.create(TCompat.MODID);
    public static final FluidDeferredRegister BLOODMAGIC_F = new FluidDeferredRegister(TCompat.MODID);

    public static final StaticModifier<Modifier> WILLING = BLOODMAGIC_M.register(TCompatValues.WILLING.getPath(), () -> new WillGainBoostModifier(EnumDemonWillType.DEFAULT));
    public static final StaticModifier<Modifier> CORROSIVE = BLOODMAGIC_M.register(TCompatValues.CORROSIVE.getPath(), () -> new WillGainBoostModifier(EnumDemonWillType.CORROSIVE));
    public static final StaticModifier<Modifier> VENGEFUL = BLOODMAGIC_M.register(TCompatValues.VENGEFUL.getPath(), () -> new WillGainBoostModifier(EnumDemonWillType.VENGEFUL));
    public static final StaticModifier<Modifier> DESTRUCTIVE = BLOODMAGIC_M.register(TCompatValues.DESTRUCTIVE.getPath(), () -> new WillGainBoostModifier(EnumDemonWillType.DESTRUCTIVE));
    public static final StaticModifier<Modifier> STEADFAST = BLOODMAGIC_M.register(TCompatValues.STEADFAST.getPath(), () -> new WillGainBoostModifier(EnumDemonWillType.STEADFAST));

    public static final StaticModifier<Modifier> SENTIENT = BLOODMAGIC_M.register(TCompatValues.SENTIENT.getPath(), WillStatBoostModifier::new);

    public static final FlowingFluidObject<ForgeFlowingFluid> MOLTEN_HELLFORGED = BLOODMAGIC_F.register("molten_hellforged")
        .type(
            hot("molten_hellforged")
                .temperature(1100)
                .lightLevel(12)
        )
        .block(BurningLiquidBlock.createBurning(MapColor.COLOR_LIGHT_BLUE, 12, 10, 5.0F))
        .bucket()
        .flowing();

    public static void init(IEventBus eventBus) {
        BLOODMAGIC_M.register(eventBus);
        BLOODMAGIC_F.register(eventBus);
    }

    public static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000).descriptionId(TConstruct.makeDescriptionId("fluid", name)).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA).motionScale(0.0023333333333333335).canSwim(false).canDrown(false).pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }
}
