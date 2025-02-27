package com.leo.tcompat;

import com.leo.tcompat.compat.bloodmagic.BloodMagicInit;
import com.leo.tcompat.compat.botania.BotaniaInit;
import com.leo.tcompat.compat.draconicevolution.DraconicEvolutionInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;

public class CompatHelper {

    public static void init(IEventBus eventBus) {
        if(ModList.get().isLoaded("botania")) {
            BotaniaInit.init(eventBus);
        }

        if(ModList.get().isLoaded("draconicevolution")) {
            DraconicEvolutionInit.init(eventBus);
        }

        if(ModList.get().isLoaded("bloodmagic")) {
            BloodMagicInit.init(eventBus);
        }
    }

}
