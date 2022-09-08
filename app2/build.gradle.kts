plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin. 1.6.21
    id("org.jetbrains.kotlin.jvm") version "1.7.10"
    kotlin("kapt") version "1.7.10"
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}



repositories {
    mavenCentral()
}


dependencies {
    // Kotlin 4.2.4
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Vertx Core
    implementation("io.vertx:vertx-core:4.2.4")
    implementation ("io.vertx:vertx-lang-kotlin:4.2.4")

    // Vertx Web
    implementation ("io.vertx:vertx-web:4.2.4")

    // Vertx Rxjava
    implementation ("io.vertx:vertx-rx-java3:4.2.4")
    implementation ("io.vertx:vertx-rx-java3-gen:4.2.4")
    implementation(project(":lib"))
   // kapt("io.vertx:vertx-codegen:4.2.4")

    implementation("io.vertx:vertx-service-proxy:4.2.4")
    implementation("io.vertx:vertx-codegen:4.2.4")
    implementation("io.vertx:vertx-lang-kotlin:4.2.4")
    implementation("io.vertx:vertx-lang-kotlin-gen:4.2.4")
    implementation("io.vertx:vertx-lang-kotlin-coroutines:4.2.4")
    kapt("io.vertx:vertx-codegen:4.2.4:processor")
    compileOnly("io.vertx:vertx-codegen:4.2.4")

   // kapt( "io.vertx:vertx-codegen:4.2.4:processor")
   // compileOnly("io.vertx:vertx-codegen:4.2.4")
}

val fatJar = task("fatJar", type = org.gradle.jvm.tasks.Jar::class) {
    baseName = "${project.name}-fat"
    manifest {
        attributes["Implementation-Title"] = "Gradle Jar File Example"
        attributes["Main-Class"] = "AppKt"
    }
    from(configurations.runtimeClasspath.get().map({ if (it.isDirectory) it else zipTree(it) }))
    with(tasks.jar.get() as CopySpec)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks {
    "build" {
        dependsOn(fatJar)
    }
}


