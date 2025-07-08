plugins {
    kotlin("jvm") version "2.0.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-core:2.3.4")
    implementation("io.ktor:ktor-client-cio:2.3.4")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.4")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation(kotlin("stdlib"))
}

application {
    mainClass.set("org.vedenemo.cli.MainKt")
    applicationDefaultJvmArgs = listOf()
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}


kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}