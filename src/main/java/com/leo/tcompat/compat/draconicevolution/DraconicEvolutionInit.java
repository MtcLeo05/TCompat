package com.leo.tcompat.compat.draconicevolution;

import com.leo.tcompat.TCompat;
import com.leo.tcompat.common.TCompatValues;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class DraconicEvolutionInit {
    public static final ModifierDeferredRegister DRACONIC_M = ModifierDeferredRegister.create(TCompat.MODID);

    public static final StaticModifier<Modifier> DRACONIC = DRACONIC_M.register(TCompatValues.DRACONIC_M.getPath(), DraconicModifier::new);
    public static final StaticModifier<Modifier> CHAOTIC = DRACONIC_M.register(TCompatValues.CHAOTIC_M.getPath(), ChaoticModifier::new);

    public static void init(IEventBus eventBus) {
        DRACONIC_M.register(eventBus);
    }
}
