package io.github.ZeronDev

import me.zeron.test.MainCore
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.PluginClassLoader

object LibraryPlugin {
    val plugin: Plugin get() = MainCore.plugin
}