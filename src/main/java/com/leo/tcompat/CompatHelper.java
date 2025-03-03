package com.leo.tcompat;

import com.leo.tcompat.common.CommonInit;
import com.leo.tcompat.compat.bloodmagic.BloodMagicInit;
import com.leo.tcompat.compat.botania.BotaniaInit;
import com.leo.tcompat.compat.draconicevolution.DraconicEvolutionInit;
import com.leo.tcompat.compat.mna.MNAInit;
import com.leo.tcompat.compat.projecte.ProjectEInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public class CompatHelper {

    public static void init(IEventBus eventBus) {
        CommonInit.init(eventBus);
        ModList modList = ModList.get();

        if(modList.isLoaded("botania")) {
            BotaniaInit.init(eventBus);
        }

        if(modList.isLoaded("draconicevolution")) {
            DraconicEvolutionInit.init(eventBus);
        }

        if(modList.isLoaded("bloodmagic")) {
            BloodMagicInit.init(eventBus);
        }

        if(modList.isLoaded("mna")) {
            MNAInit.init(eventBus);
        }

        if(modList.isLoaded("projecte")) {
            ProjectEInit.init(eventBus);
        }
    }

}
