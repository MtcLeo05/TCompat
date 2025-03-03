package com.leo.tcompat.common;

import com.leo.tcompat.TCompat;
import com.leo.tcompat.common.content.EnergizedModifier;
import com.leo.tcompat.common.content.EnergyArrowModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class CommonInit {
    public static final ModifierDeferredRegister COMMON_M = ModifierDeferredRegister.create(TCompat.MODID);

    public static final StaticModifier<Modifier> ENERGIZED = COMMON_M.register(TCompatValues.ENERGIZED.getPath(), EnergizedModifier::new);
    public static final StaticModifier<Modifier> ENERGY_ARROW = COMMON_M.register(TCompatValues.ENERGY_ARROW.getPath(), EnergyArrowModifier::new);

    public static void init(IEventBus eventBus) {
        COMMON_M.register(eventBus);
    }
}
