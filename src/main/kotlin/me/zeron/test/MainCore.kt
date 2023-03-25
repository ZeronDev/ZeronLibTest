package me.zeron.test

import com.mojang.brigadier.builder.RequiredArgumentBuilder.*
import io.github.ZeronDev.gui.GuiManager.openInv
import io.github.ZeronDev.item.ItemStackBuilder
import io.github.ZeronDev.listener.EventListener.listen
import io.github.monun.kommand.kommand
import net.kyori.adventure.text.Component.text
import org.bukkit.Material
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.util.concurrent.ThreadLocalRandom


@Suppress("unused")
class MainCore : JavaPlugin(), Listener {
    companion object {
        lateinit var plugin: Plugin
    }
    override fun onEnable() {
        plugin = this

        kommand {
            register("asdf") {
                requires { isPlayer }

                executes {
                    player.openInv("a", 1) {
                        slot(1) {
                            item = ItemStackBuilder(Material.STICK).displayName("asdf").build()

                            onSlotClick {
                                player.sendMessage(text("Hello?!~"))
                            }

                            player.inventory.addItem(ItemStackBuilder(Material.STICK)
                                .displayName("asdf")
                                .lore(mutableListOf("asdf><?"))
                                .onInteract { e ->
                                    e.player.sendMessage(text("ㅁㄴㅇㄹ!!"))
                                }
                                .build())
                        }
                    }
                }
            }
        }

        listen<PlayerJoinEvent> { event ->
            event.joinMessage(text("ㅎㅇ ${event.player.name}"))
        }
    }
}