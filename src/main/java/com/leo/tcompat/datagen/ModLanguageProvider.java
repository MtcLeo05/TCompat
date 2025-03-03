package com.leo.tcompat.datagen;

import com.leo.tcompat.TCompat;
import com.leo.tcompat.common.TCompatValues;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, TCompat.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("fluid.tconstruct.molten_manasteel", "Molten Manasteel");
        this.add("item.tcompat.molten_manasteel_bucket", "Molten Manasteel Bucket");
        this.add("fluid.tconstruct.molten_terrasteel", "Molten Terrasteel");
        this.add("item.tcompat.molten_terrasteel_bucket", "Molten Terrasteel Bucket");
        this.add("fluid.tconstruct.molten_elementium", "Molten Elementium");
        this.add("item.tcompat.molten_elementium_bucket", "Molten Elementium Bucket");

        this.add("fluid.tconstruct.molten_hellforged", "Molten Hellforged");
        this.add("item.tcompat.molten_hellforged_bucket", "Molten Hellforged Bucket");

        this.add("fluid.tconstruct.molten_chimerite", "Molten Chimerite");
        this.add("item.tcompat.molten_chimerite_bucket", "Molten Chimerite Bucket");

        this.add(TCompatValues.BLOODLUST_TOOLTIP, "Bonus Damage: %s");
        this.add(TCompatValues.MANA_CRUMBLING_TOOLTIP, "Bonus Speed");
        this.add(TCompatValues.WILL_SPEED_BOOST, "Bonus Speed: %s");
        this.add(TCompatValues.WILL_DAMAGE_BOOST, "Bonus Damage: %s");

        this.add("tooltip.tcompat.incompatible", "Modifier is incompatible!");

        this.add("material." + TCompatValues.LIVINGWOOD.toLanguageKey(), "Livingwood");
        this.add("material." + TCompatValues.LIVINGWOOD.toLanguageKey() + ".encyclopedia", "Tool absorbs mana to repair (200 mana / durability, once every 10 ticks) and prevent (100 mana / durability) damage. Each level decreases mana needed by 10 (cannot be lower than 10) and increases durability restored by 1 each tick");

        this.add("material." + TCompatValues.LIVINGROCK.toLanguageKey(), "Livingrock");
        this.add("material." + TCompatValues.LIVINGROCK.toLanguageKey() + ".encyclopedia", "Tool absorbs mana to repair (200 mana / durability, once every 10 ticks) and prevent (100 mana / durability) damage. Each level decreases mana needed by 10 (cannot be lower than 10) and increases durability restored by 1 each tick");

        this.add("material." + TCompatValues.REDQUARTZ.toLanguageKey(), "Redquartz");
        this.add("material." + TCompatValues.REDQUARTZ.toLanguageKey() + ".encyclopedia", "Tool gains +0.5 * level damage each time an enemy is killed. This boost decreases by 0.1 every second and has a cap of 2.5 * level");

        this.add("material." + TCompatValues.MANASTEEL.toLanguageKey(), "Manasteel");
        this.add("material." + TCompatValues.MANASTEEL.toLanguageKey() + ".encyclopedia", "Tool absorbs 100 mana / block to increase mining speed by 50 + (25 * level)%");

        this.add("material." + TCompatValues.TERRASTEEL.toLanguageKey(), "Terrasteel");
        this.add("material." + TCompatValues.TERRASTEEL.toLanguageKey() + ".encyclopedia", "Tool absorbs mana to repair (200 mana / durability, once every 10 ticks) and prevent (100 mana / durability) damage. Each level decreases mana needed by 10 (cannot be lower than 10) and increases durability restored by 1 each tick");

        this.add("material." + TCompatValues.ELEMENTIUM.toLanguageKey(), "Elementium");
        this.add("material." + TCompatValues.ELEMENTIUM.toLanguageKey() + ".encyclopedia", "Tool sometimes spawns pixies when damaged");

        this.add("material." + TCompatValues.DAWNSTONE.toLanguageKey(), "Dawnstone");
        this.add("material." + TCompatValues.DAWNSTONE.toLanguageKey() + ".encyclopedia", "Grants bonus mining speed at lower depth, +6 per 64 blocks below 64");

        this.add("material." + TCompatValues.WYVERN.toLanguageKey(), "Wyvern");
        this.add("material." + TCompatValues.WYVERN.toLanguageKey() + ".encyclopedia", "Tool absorbs energy to repair (200 rf / durability, once every 10 ticks) and prevent (200 rf / durability) damage. Each level decreases energy needed by 10 (cannot be lower than 100) and increases durability restored by 1 each tick");

        this.add("material." + TCompatValues.DRACONIC.toLanguageKey(), "Draconic");
        this.add("material." + TCompatValues.DRACONIC.toLanguageKey() + ".encyclopedia", "Tool does 10 + (5 * level)% damage more when in the end");

        this.add("material." + TCompatValues.CHAOTIC.toLanguageKey(), "Chaotic");
        this.add("material." + TCompatValues.CHAOTIC.toLanguageKey() + ".encyclopedia", "Tool deals between (0.5 / level) and (3 * level) damage");

        this.add("material." + TCompatValues.HELLFORGED.toLanguageKey(), "Hellforged");
        this.add("material." + TCompatValues.HELLFORGED.toLanguageKey() + ".encyclopedia", "Tool does more damage / mines faster based on the amount of will");

        this.add("material." + TCompatValues.CHIMERITE.toLanguageKey(), "Chimerite");
        this.add("material." + TCompatValues.CHIMERITE.toLanguageKey() + ".encyclopedia", "Tool increases holder / wearer mana, and gives slight boost to drops and damage");

        this.add("modifier." + TCompatValues.MANA_ALIGNED.toLanguageKey(), "Mana Aligned");
        this.add("modifier." + TCompatValues.MANA_ALIGNED.toLanguageKey() + ".flavor", "Mana Power!");
        this.add("modifier." + TCompatValues.MANA_ALIGNED.toLanguageKey() + ".description", "Tool absorbs mana from player to heal and prevent damage");

        this.add("modifier." + TCompatValues.BLOODLUST.toLanguageKey(), "Bloodlust");
        this.add("modifier." + TCompatValues.BLOODLUST.toLanguageKey() + ".flavor", "Blood???");
        this.add("modifier." + TCompatValues.BLOODLUST.toLanguageKey() + ".description", "I'mst goingst to ULTRAKILLs yous");

        this.add("modifier." + TCompatValues.MANA_CRUMBLING.toLanguageKey(), "Mana Crumbling");
        this.add("modifier." + TCompatValues.MANA_CRUMBLING.toLanguageKey() + ".flavor", "Destruction is Blueberry Flavored!");
        this.add("modifier." + TCompatValues.MANA_CRUMBLING.toLanguageKey() + ".description", "Tool absorbs mana from player to speed up mining");

        this.add("modifier." + TCompatValues.MANA_ARROW.toLanguageKey(), "Mana Arrow");
        this.add("modifier." + TCompatValues.MANA_ARROW.toLanguageKey() + ".flavor", "Arrows made of condensed mana");
        this.add("modifier." + TCompatValues.MANA_ARROW.toLanguageKey() + ".description", "Tool uses 60 mana instead of arrows to shoot [Arrows take priority!]");

        this.add("modifier." + TCompatValues.TERRESTRIAL.toLanguageKey(), "Terrestrial");
        this.add("modifier." + TCompatValues.TERRESTRIAL.toLanguageKey() + ".flavor", "Mana Maker");
        this.add("modifier." + TCompatValues.TERRESTRIAL.toLanguageKey() + ".description", "Tool generates mana every tick");

        this.add("modifier." + TCompatValues.PIXIECLE.toLanguageKey(), "Pixiecle");
        this.add("modifier." + TCompatValues.PIXIECLE.toLanguageKey() + ".flavor", "Come forth pixies!");
        this.add("modifier." + TCompatValues.PIXIECLE.toLanguageKey() + ".description", "Armor has a chance to generate pixies when damaged");

        this.add("modifier." + TCompatValues.ENERGIZED.toLanguageKey(), "Energized");
        this.add("modifier." + TCompatValues.ENERGIZED.toLanguageKey() + ".flavor", "Shocking!");
        this.add("modifier." + TCompatValues.ENERGIZED.toLanguageKey() + ".description", "Tool absorbs energy from player to heal and prevent damage");

        this.add("modifier." + TCompatValues.ENERGY_ARROW.toLanguageKey(), "Energy Arrow");
        this.add("modifier." + TCompatValues.ENERGY_ARROW.toLanguageKey() + ".flavor", "Arrow of pure energy!");
        this.add("modifier." + TCompatValues.ENERGY_ARROW.toLanguageKey() + ".description", "Tool uses 60rf instead of arrows to shoot [Arrows take priority!]");

        this.add("modifier." + TCompatValues.DRACONIC_M.toLanguageKey(), "Draconic");
        this.add("modifier." + TCompatValues.DRACONIC_M.toLanguageKey() + ".flavor", "Dragon Born!");
        this.add("modifier." + TCompatValues.DRACONIC_M.toLanguageKey() + ".description", "Tool does more damage in the end");

        this.add("modifier." + TCompatValues.CHAOTIC_M.toLanguageKey(), "Chaotic");
        this.add("modifier." + TCompatValues.CHAOTIC_M.toLanguageKey() + ".flavor", "Chaos! Chaos!");
        this.add("modifier." + TCompatValues.CHAOTIC_M.toLanguageKey() + ".description", "Tool randomly does more or less damage");

        this.add("modifier." + TCompatValues.WILLING.toLanguageKey(), "Willing [Default]");
        this.add("modifier." + TCompatValues.WILLING.toLanguageKey() + ".flavor", "Capable of reasoning?!");
        this.add("modifier." + TCompatValues.WILLING.toLanguageKey() + ".description", "Killing mobs drops default will");

        this.add("modifier." + TCompatValues.CORROSIVE.toLanguageKey(), "Willing [Corrosive]");
        this.add("modifier." + TCompatValues.CORROSIVE.toLanguageKey() + ".flavor", "Capable of reasoning?!");
        this.add("modifier." + TCompatValues.CORROSIVE.toLanguageKey() + ".description", "Killing mobs drops corrosive will");

        this.add("modifier." + TCompatValues.VENGEFUL.toLanguageKey(), "Willing [Vengeful]");
        this.add("modifier." + TCompatValues.VENGEFUL.toLanguageKey() + ".flavor", "Capable of reasoning?!");
        this.add("modifier." + TCompatValues.VENGEFUL.toLanguageKey() + ".description", "Killing mobs drops vengeful will");

        this.add("modifier." + TCompatValues.DESTRUCTIVE.toLanguageKey(), "Willing [Destructive]");
        this.add("modifier." + TCompatValues.DESTRUCTIVE.toLanguageKey() + ".flavor", "Capable of reasoning?!");
        this.add("modifier." + TCompatValues.DESTRUCTIVE.toLanguageKey() + ".description", "Killing mobs drops destructive will");

        this.add("modifier." + TCompatValues.STEADFAST.toLanguageKey(), "Willing [Steadfast]");
        this.add("modifier." + TCompatValues.STEADFAST.toLanguageKey() + ".flavor", "Capable of reasoning?!");
        this.add("modifier." + TCompatValues.STEADFAST.toLanguageKey() + ".description", "Killing mobs drops steadfast will");

        this.add("modifier." + TCompatValues.SENTIENT.toLanguageKey(), "Sentient");
        this.add("modifier." + TCompatValues.SENTIENT.toLanguageKey() + ".flavor", "Smooth Brain");
        this.add("modifier." + TCompatValues.SENTIENT.toLanguageKey() + ".description", "Tool becomes stronger the more will the player has");

        this.add("modifier." + TCompatValues.MANA_STORM.toLanguageKey(), "Mana Storm");
        this.add("modifier." + TCompatValues.MANA_STORM.toLanguageKey() + ".flavor", "Strengthening you vessel");
        this.add("modifier." + TCompatValues.MANA_STORM.toLanguageKey() + ".description", "Tool increases holder / wearer mana capacity");

        this.add("modifier." + TCompatValues.MANA_BOOST.toLanguageKey(), "Mana Boost");
        this.add("modifier." + TCompatValues.MANA_BOOST.toLanguageKey() + ".flavor", "May luck be with ye");
        this.add("modifier." + TCompatValues.MANA_BOOST.toLanguageKey() + ".description", "Doing a tools main action sometimes gives bonuses in exchange of mana");
    }


    /**
     * Capitalizes first letter of a string
     *
     * @param input the string to capitalize e.g. "alpha"
     * @return the string capitalized e.g. "Alpha"
     */
    public static String cFL(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}