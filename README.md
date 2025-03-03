### Mod Integration

This page serves as a (mostly updated) list of all mods integration, and should be the preferred place to see which mods
are supported.

## General List

* Common \[Always Available\]:
    * <span style="color: #843fa1;">Energized</span>, <span style="color: #ff7100;">Energy Arrow</span> Modifier


* Botania:
    * <span style="color: #ba372a;">Livingwood</span>, <span style="color: #ced4d9;">
      Livingrock</span>, <span style="color: #3598db;">Manasteel</span>, <span style="color: #ba372a;">
      Redquartz</span>, <span style="color: #0c7127;">Terrasteel </span> Material
    * <span style="color: #3598db;">Molten Manasteel</span>, <span style="color: #0c7127;">Molten Terrasteel</span> Liquid
    * <span style="color: #00f;">Mana Aligned</span>, <span style="color: #f00;">
      Bloodlust</span>, <span style="color: #3598db;">Mana Crumbling</span>, <span style="color: #21e7ff;">Mana Arrow</span>, <span style="color: #0c7127;">Terrestrial</span> Modifiers


* Embers Rekindled
    * <span style="color: #fa0;">Dawnstone </span> Material
    * Removes <span style="color: #fb9f9a;">Rose Gold</span> materials and alloy crafting, and replaces them
      with <span style="color: #fa0;">Dawnstone</span>. Molten <span style="color: #fb9f9a;">Rose Gold</span> is still craftable as trying to remove it crashes the game with JEI


* Draconic Evolution
    * <span style="color: #843fa1;">Wyvern</span>, <span style="color: #e03e2d;">
      Draconic</span>, <span style="color: #170131;">Chaotic </span> Material
    * <span style="color: #e03e2d;">
      Draconic</span>, <span style="color: #170131;">Chaotic </span> Modifier

    
* Blood Magic
  * <span style="color: #9ad9cd;">Hellforged</span> Material
  * <span style="color: #8cc9ca;">Willing</span>, <span style="color: #8dc288;">Corrosive</span>, <span style="color: #cd807d;">Destructive</span>, <span style="color: #c2b288;">Vengeful</span>, <span style="color: #8988c2;">Steadfast</span>, <span style="color: #9ad9cd;">Sentient</span> Modifier


* Mana and Artifice
    * <span style="color: #dccbc7;">Chimerite</span>, <span style="color: #647cac;">Vinteum</span> Material
    * <span style="color: #FFE2EE;">Mana Storm</span>, <span style="color: #B7FFF7;">Mana Boost</span>, <span style="color: #9593FF;">Mana Magnet</span>, <span style="color: #FFFC5E;">Mana Gamble</span> Modifier


* ProjectE
  * <span style="color: #37173b;">Dark Matter</span>, <span style="color: #980707;">Red Matter</span> Material
  * <span style="color: #B51800;">EMC Generator</span> Modifier
## Modifier / Traits Details

* Common \[Always Available\]:
  * <span style="color: #843fa1;">Energized</span>: Tool absorbs energy to repair (200 rf / durability, once every 10
      ticks) and prevent (200 rf / durability) damage. Each level decreases energy needed by 10 (cannot be lower than 100) and increases durability restored by 1 each tick
  * <span style="color: #ff7100;">Energy Arrow</span>: Tool uses 60 rf (or whatever energy type the storage uses) when out of arrow to shoot


* Botania:
    * <span style="color: #00f;">Mana Aligned</span>: Tool absorbs mana to repair (200 mana / durability, once every 10
      ticks) and prevent (100 mana / durability) damage. Each level decreases mana needed by 10 (cannot be lower than 10) and increases durability restored by 1 each tick
    * <span style="color: #f00;">Bloodlust</span>: Tool gains +0.5 * level damage each time an enemy is killed. This
      boost decreases by 0.1 every second and has a cap of 2.5 * level
    * <span style="color: #3598db;">Mana Crumbling</span>: Tool absorbs 100 mana / block to increase mining speed by
      50 + (25 * level)%
    * <span style="color: #21e7ff;">Mana Arrow</span>: Tool uses 60 mana when out of arrows to shoot <span style="color: #efff00;">Spectral Arrows</span>
    * <span style="color: #0c7127;">Terrestrial</span>: Tool generates mana each tick based on the modifier level


* Draconic Evolution
    * <span style="color: #e03e2d;">Draconic</span>: Tool does 10 + (5 * level)% damage more when in the end
    * <span style="color: #170131;">Chaotic </span>: Tool deals between (0.5 / level) and (3 * level) damage


* Blood Magic
  * <span style="color: #8cc9ca;">Willing</span>, <span style="color: #8dc288;">Corrosive</span>, <span style="color: #cd807d;">Destructive</span>, <span style="color: #c2b288;">Vengeful</span>, <span style="color: #8988c2;">Steadfast</span>: Each of them makes killing mobs drop their respective will type
  * <span style="color: #9ad9cd;">Sentient</span>: Makes tool have damage and mining speed boosts based on the will the player has. Boost changes based on amount and type of will


* Mana and Artifice
    * <span style="color: #FFE2EE;">Mana Storm</span>: Increases the holder / wearer mana by 40 + (20 * level)
    * <span style="color: #B7FFF7;">Mana Boost</span>: Has a 10 + (7.5 * level) % chance of consuming 25 mana (+2.6% * level) to either increase drops (1.5x) or deal magic damage on top of the original. Magic damage is original damage / 4
    * <span style="color: #9593FF;">Mana Magnet</span>: Tool / Armor Consumes 5 - level mana to attract items and exp around the player
    * <span style="color: #FFFC5E;">Mana Gamble</span>: Tool has a 1% (+0.5% per level) chance of consuming 50 mana (+2.5% each level) and dropping a random ore when mining stone / deepslate


* ProjectE
  * <span style="color: #B51800;">EMC Generator</span>: Tool can be toggled between dropping items and converting them directly in EMC, adding the EMC and learning the item