package io.github.ZeronDev.gui

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class SlotFunc {
    var item: ItemStack? = null
    internal val onslotclick: ((InventoryClickEvent) -> Unit)? = null

    fun onSlotClick(func: (InventoryClickEvent) -> Unit) {

    }
}