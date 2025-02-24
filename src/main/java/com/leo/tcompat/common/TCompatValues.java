package com.leo.tcompat.common;

import com.leo.tcompat.TCompat;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.tools.stat.ToolStatId;

public class TCompatValues {

    public static final MaterialId LIVINGWOOD = matId("livingwood");
    public static final MaterialId LIVINGROCK = matId("livingrock");
    public static final MaterialId MANASTEEL = matId("manasteel");
    public static final MaterialId REDQUARTZ = matId("redquartz");
    public static final MaterialId TERRASTEEL = matId("terrasteel");

    public static final MaterialId DAWNSTONE = matId("dawnstone");

    public static final MaterialId WYVERN = matId("wyvern");
    public static final MaterialId DRACONIC = matId("draconic");
    public static final MaterialId CHAOTIC = matId("chaotic");

    public static final ModifierId MANA_ALIGNED = modId("mana_aligned");
    public static final ModifierId BLOODLUST = modId("bloodlust");
    public static final ModifierId MANA_CRUMBLING = modId("mana_crumbling");

    public static final ModifierId ENERGIZED = modId("energized");
    public static final ModifierId DRACONIC_M = modId("draconic");
    public static final ModifierId CHAOTIC_M = modId("chaotic");

    public static final ToolStatId BLOODLUST_BOOST = toolStatId("bloodlust_boost");
    public static final ToolStatId MANA_CRUMBLING_BOOST = toolStatId("mana_crumbling_boost");

    public static final String BLOODLUST_TOOLTIP = "tooltip.tcompat.bloodlust.boost";
    public static final String MANA_CRUMBLING_TOOLTIP = "tooltip.tcompat.mana_crumbling.boost";

    public static final int MANASTEEL_COLOR = 0x3962d7;
    public static final int TERRASTEEL_COLOR = 0x0c7127;

    private static MaterialId matId(String base) {
        return new MaterialId(TCompat.MODID, base);
    }

    private static ModifierId modId(String base) {
        return new ModifierId(TCompat.MODID, base);
    }

    private static ToolStatId toolStatId(String base) {
        return new ToolStatId(TCompat.MODID, base);
    }
}
