import org.jetbrains.grammarkit.tasks.GenerateParserTask

plugins {
    id("java")
    id("idea")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.7.1"
    id("org.jetbrains.grammarkit") version "2022.3.2.2"
}

group = "org.openalgebra"
version = "1.0.2"

repositories {
    mavenLocal()
    mavenCentral()

    intellijPlatform {
        snapshots()
        defaultRepositories()
    }
}

// Configure IntelliJ Platform Gradle Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")

    intellijPlatform {
        create("IC", "2025.1.4.1")
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)
    }
}


intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "251"
        }

        changeNotes = """
            Initial version
        """.trimIndent()
    }


}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }

    runIde {
        args = listOf("/home/codin/IdeaProjects/untitled",
            "/home/codin/IdeaProjects/untitled/src/test.palm")
        jvmArgs = listOf("-Dsun.java2d.uiScale=2") // 125% zoom
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

sourceSets {
  main {
    java {
      srcDirs("src/main/gen")
    }
  }
}

grammarKit {
  jflexRelease.set("1.10.16")
  grammarKitRelease.set("2022.3.2")
}

tasks.generateLexer {
    sourceFile.set(file("src/main/grammars/PALM.flex"))
    targetOutputDir.set(file("src/main/gen/org/openalgebra/oasispalmidea/lexer"))
    purgeOldFiles.set(true)
}

tasks.generateParser {
    sourceFile.set(file("src/main/grammars/PALM.bnf"))
    targetRootOutputDir.set(file("src/main/gen"))
    pathToParser.set("org/openalgebra/oasispalmidea/parser/PALMParser.java")
    pathToPsiRoot.set("org/openalgebra/oasispalmidea/psi")
    dependsOn("generateLexer", "generateLexer")
//    purgeOldFiles.set(true)
}

tasks.named("compileKotlin") {
    //dependsOn("generateLexer", "generateParser")
}

