plugins {
    id("java")
    id("checkstyle")
}

group = "ru.mihozhereb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

checkstyle {
    toolVersion = "10.21.3"
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

// recommended libs
dependencies {
    implementation("org.projectlombok:lombok:1.18.36")
}

// add your lib dependencies here
dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("commons-codec:commons-codec:1.18.0")
}

tasks.check {
    dependsOn("checkstyleMain")
    dependsOn("checkstyleTest")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.runtimeClasspath.get().filter { it.exists() }.map { if (it.isDirectory) it else zipTree(it) })

    manifest {
        attributes(
            mapOf(
                "Class-Path" to configurations.runtimeClasspath.get().files.joinToString(" ") { it.name },
                "Main-Class" to "ru.mihozhereb.Main"
            )
        )
    }
}