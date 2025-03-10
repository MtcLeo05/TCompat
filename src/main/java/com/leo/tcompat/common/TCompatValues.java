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
    public static final MaterialId ELEMENTIUM = matId("elementium");

    public static final MaterialId DAWNSTONE = matId("dawnstone");

    public static final MaterialId WYVERN = matId("wyvern");
    public static final MaterialId DRACONIC = matId("draconic");
    public static final MaterialId CHAOTIC = matId("chaotic");

    public static final MaterialId HELLFORGED = matId("hellforged");

    public static final MaterialId CHIMERITE = matId("chimerite");
    public static final MaterialId VINTEUM = matId("vinteum");

    public static final MaterialId DARK_MATTER = matId("dark_matter");
    public static final MaterialId RED_MATTER = matId("red_matter");

    public static final ModifierId MANA_ALIGNED = modId("mana_aligned");
    public static final ModifierId BLOODLUST = modId("bloodlust");
    public static final ModifierId MANA_CRUMBLING = modId("mana_crumbling");
    public static final ModifierId MANA_ARROW = modId("mana_arrow");
    public static final ModifierId TERRESTRIAL = modId("terrestrial");
    public static final ModifierId PIXIECLE = modId("pixiecle");

    public static final ModifierId ENERGIZED = modId("energized");
    public static final ModifierId ENERGY_ARROW = modId("energy_arrow");

    public static final ModifierId DRACONIC_M = modId("draconic");
    public static final ModifierId CHAOTIC_M = modId("chaotic");

    public static final ModifierId WILLING = modId("willing");
    public static final ModifierId CORROSIVE = modId("corrosive");
    public static final ModifierId VENGEFUL = modId("vengeful");
    public static final ModifierId DESTRUCTIVE = modId("destructive");
    public static final ModifierId STEADFAST = modId("steadfast");
    public static final ModifierId SENTIENT = modId("sentient");

    public static final ModifierId MANA_STORM = modId("mana_storm");
    public static final ModifierId MANA_BOOST = modId("mana_boost");
    public static final ModifierId MANA_MAGNET = modId("mana_magnet");
    public static final ModifierId MANA_GAMBLE = modId("mana_gamble");

    public static final ModifierId EMC_GENERATOR = modId("emc_generator");

    public static final ToolStatId BLOODLUST_BOOST = toolStatId("bloodlust_boost");
    public static final ToolStatId GENERIC_BOOLEAN = toolStatId("generic_boolean");

    public static final String BLOODLUST_TOOLTIP = "tooltip.tcompat.bloodlust.boost";
    public static final String MANA_CRUMBLING_TOOLTIP = "tooltip.tcompat.mana_crumbling.boost";
    public static final String WILL_SPEED_BOOST = "tooltip.tcompat.will_damage.speed_boost";
    public static final String WILL_DAMAGE_BOOST = "tooltip.tcompat.will_damage.damage_boost";

    public static final String EMC_GENERATOR_MODE = "tooltip.tcompat.emc_generator.mode.";
    public static final String EMC_GENERATOR_MODE_WARN = "tooltip.tcompat.emc_generator.mode_switch.";

    public static final int MANASTEEL_COLOR = 0x66b7eb;
    public static final int TERRASTEEL_COLOR = 0x69e561;
    public static final int ELEMENTIUM_COLOR = 0xdd82a3;

    public static final int HELLFORGED_COLOR = 0x9ad9cd;

    public static final int CHIMERITE_COLOR = 0xdccbc7;
    public static final int VINTEUM_COLOR = 0x86bee3;

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
