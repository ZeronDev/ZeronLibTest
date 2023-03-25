import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    kotlin("jvm") version "1.8.0"
    id("io.papermc.paperweight.userdev") version "1.3.8"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.3"
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "me.zeron.test"
version = "1.0.0"

val minecraftVersion = "1.19.2"

kotlin.jvmToolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))
    paperDevBundle("${minecraftVersion}-R0.1-SNAPSHOT")
    compileOnly("net.kyori:adventure-api:4.13.0")
    implementation("io.github.monun:kommand-api:3.1.2")
    implementation("com.github.shynixn.mccoroutine:mccoroutine-bukkit-api:2.11.0")
    implementation("com.github.shynixn.mccoroutine:mccoroutine-bukkit-core:2.11.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-Beta")
    //api("io.github.ZeronDev:ZeronLib:2.1.0")
    implementation(kotlin("reflect"))
}

tasks {
    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
        }
    }
    create<Jar>("paperJar") {

        from(sourceSets["main"].output)

        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
        archiveVersion.set(project.version.toString())

        doLast {
            copy {
                from(archiveFile)
                val fileLoc = File("C:\\Users\\USER\\AppData\\Roaming\\.feather\\player-server\\servers\\06fac9ca-dc68-43ea-ad6b-823342159533\\plugins")
                into(if (File(fileLoc, archiveFileName.get()).exists()) fileLoc else fileLoc)
            }
        }
    }
    shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
        archiveVersion.set(project.version.toString())

        doLast {
            copy {
                from(archiveFile)
                val fileLoc = File("C:\\Users\\USER\\AppData\\Roaming\\.feather\\player-server\\servers\\06fac9ca-dc68-43ea-ad6b-823342159533\\plugins")
                into(if (File(fileLoc, archiveFileName.get()).exists()) fileLoc else fileLoc)
            }
        }
    }
}

bukkit {
    name = "ZeronTest"
    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
    this.version = project.version.toString()
    apiVersion = minecraftVersion.substring(0 until minecraftVersion.indexOfLast { it == '.' })
    author = "ZeronDev"
    main = "${group}.MainCore"
    libraries = listOf(
        "io.github.monun:kommand-core:3.1.2",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-Beta",
        "com.github.shynixn.mccoroutine:mccoroutine-bukkit-api:2.11.0",
        "com.github.shynixn.mccoroutine:mccoroutine-bukkit-core:2.11.0",
        "org.jetbrains.kotlin:kotlin-stdlib:1.8.0",
        "org.jetbrains.kotlin:kotlin-reflect:1.8.0",
        //"io.github.ZeronDev:ZeronLib:2.1.0",
    )
}