package com.leo.tcompat.compat.projecte;

import com.leo.tcompat.TCompat;
import com.leo.tcompat.common.TCompatValues;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class ProjectEInit {

    public static final ModifierDeferredRegister PROJECTE_M = ModifierDeferredRegister.create(TCompat.MODID);

    public static final StaticModifier<Modifier> EMC_GENERATOR = PROJECTE_M.register(TCompatValues.EMC_GENERATOR.getPath(), EmcGeneratorModifier::new);

    public static void init(IEventBus eventBus) {
        PROJECTE_M.register(eventBus);
    }
}
