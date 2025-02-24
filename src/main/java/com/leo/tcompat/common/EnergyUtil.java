package com.leo.tcompat.common;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.energy.IEnergyStorage;

import java.util.List;

public class EnergyUtil {

    public static boolean hasEnergy(Player player, int energy) {
        List<ItemStack> energyItems = player.getInventory().items.stream().filter(s -> s.getCapability(ForgeCapabilities.ENERGY).isPresent()).toList();

        if(energyItems.isEmpty()) return false;
        int foundEnergy = 0;

        for (ItemStack item : energyItems) {
            if(item.isEmpty()) continue;
            IEnergyStorage energyStorage = item.getCapability(ForgeCapabilities.ENERGY).resolve().get();
            if(energyStorage.getEnergyStored() >= energy) return true;
            foundEnergy += energyStorage.getEnergyStored();
            if(foundEnergy >= energy) return true;
        }

        return false;
    }

    public static void consumeEnergy(Player player, int energy) {
        List<ItemStack> energyItems = player.getInventory().items.stream().filter(s -> s.getCapability(ForgeCapabilities.ENERGY).isPresent()).toList();

        if(energyItems.isEmpty()) return;

        int consumed = 0;

        for (ItemStack item : energyItems) {
            if(consumed >= energy) return;
            IEnergyStorage energyStorage = item.getCapability(ForgeCapabilities.ENERGY).resolve().get();
            if(energyStorage.getEnergyStored() > 0) {
                int toRemove = Math.min(energy - consumed, energyStorage.getEnergyStored());

                energyStorage.receiveEnergy(toRemove, false);
                consumed += toRemove;
            }
        }
    }
}
