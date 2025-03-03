package com.leo.tcompat.compat.botania;

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
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class BotaniaInit {
    public static final ModifierDeferredRegister BOTANIA_M = ModifierDeferredRegister.create(TCompat.MODID);
    public static final FluidDeferredRegister BOTANIA_F = new FluidDeferredRegister(TCompat.MODID);

    public static final StaticModifier<Modifier> MANA_ALIGNED = BOTANIA_M.register(TCompatValues.MANA_ALIGNED.getPath(), ManaAlignedModifier::new);
    public static final StaticModifier<Modifier> BLOODLUST = BOTANIA_M.register(TCompatValues.BLOODLUST.getPath(), BloodlustModifier::new);
    public static final StaticModifier<Modifier> MANA_CRUMBLING = BOTANIA_M.register(TCompatValues.MANA_CRUMBLING.getPath(), ManaCrumblingModifier::new);
    public static final StaticModifier<Modifier> MANA_ARROW = BOTANIA_M.register(TCompatValues.MANA_ARROW.getPath(), ManaArrowModifier::new);
    public static final StaticModifier<Modifier> TERRESTRIAL = BOTANIA_M.register(TCompatValues.TERRESTRIAL.getPath(), TerrestrialModifier::new);
    public static final StaticModifier<Modifier> PIXIECLE = BOTANIA_M.register(TCompatValues.PIXIECLE.getPath(), PixiecleModifier::new);

    public static final FloatToolStat BLOODLUST_BOOST = ToolStats.register(new FloatToolStat(TCompatValues.BLOODLUST_BOOST, 0xfff1100, 0.0F, 0.0F, 32767.0F));

    public static final FlowingFluidObject<ForgeFlowingFluid> MOLTEN_MANASTEEL = BOTANIA_F.register("molten_manasteel")
        .type(
            hot("molten_manasteel")
                .temperature(1100)
                .lightLevel(12)
        )
        .block(BurningLiquidBlock.createBurning(MapColor.LAPIS, 12, 10, 5.0F))
        .bucket()
        .flowing();

    public static final FlowingFluidObject<ForgeFlowingFluid> MOLTEN_TERRASTEEL = BOTANIA_F.register("molten_terrasteel")
        .type(
            hot("molten_terrasteel")
                .temperature(1100)
                .lightLevel(12)
        )
        .block(BurningLiquidBlock.createBurning(MapColor.EMERALD, 12, 10, 5.0F))
        .bucket()
        .flowing();

    public static final FlowingFluidObject<ForgeFlowingFluid> MOLTEN_ELEMENTIUM = BOTANIA_F.register("molten_elementium")
        .type(
            hot("molten_elementium")
                .temperature(1100)
                .lightLevel(12)
        )
        .block(BurningLiquidBlock.createBurning(MapColor.COLOR_MAGENTA, 12, 10, 5.0F))
        .bucket()
        .flowing();

    public static void init(IEventBus eventBus) {
        BOTANIA_M.register(eventBus);
        BOTANIA_F.register(eventBus);
    }

    public static FluidType.Properties hot(String name) {
        return FluidType.Properties.create().density(2000).viscosity(10000).temperature(1000).descriptionId(TConstruct.makeDescriptionId("fluid", name)).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA).sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA).motionScale(0.0023333333333333335).canSwim(false).canDrown(false).pathType(BlockPathTypes.LAVA).adjacentPathType(null);
    }
}
