import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}
dependencies {
    implementation("org.jetbrains.compose.ui:ui:1.6.0")
    implementation("org.jetbrains.compose.material:material:1.6.0")
    implementation("org.jetbrains.compose.ui:ui-tooling:1.6.0")
    implementation("org.jetbrains.compose.ui:ui-util:1.6.0")
    implementation("org.jetbrains.compose.foundation:foundation:1.6.0")
    implementation("org.jetbrains.compose.runtime:runtime:1.6.0")
    implementation("org.jetbrains.compose.desktop:desktop:1.6.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    // Note, if you develop a library, you should use compose.desktop.common.
    // compose.desktop.currentOs should be used in launcher-sourceSet
    // (in a separate module for demo project and in testMain).
    // With compose.desktop.common you will also lose @Preview functionality
    implementation(compose.desktop.currentOs)
}


compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "Bible"
            packageVersion = "1.0.0"
        }
    }
}
