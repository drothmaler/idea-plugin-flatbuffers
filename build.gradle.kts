import org.gradle.api.JavaVersion.VERSION_1_8
import org.jetbrains.grammarkit.tasks.GenerateLexer
import org.jetbrains.grammarkit.tasks.GenerateParser

plugins {
  `java-library`
  idea
  id("org.jetbrains.intellij") version "0.4.9"
  id("org.jetbrains.grammarkit") version "2019.2"
}

apply {
  plugin("org.jetbrains.grammarkit")
}

repositories {
  mavenCentral()
}

val genRoot = "$buildDir/generated/grammars/"

configure<JavaPluginConvention> {
  sourceCompatibility = VERSION_1_8
  targetCompatibility = VERSION_1_8
}


sourceSets {
  main {
    java.srcDirs(genRoot)
  }
}

idea {
  module {
    generatedSourceDirs.add(file(genRoot))
  }
}

dependencies {
  testCompile(group = "junit", name = "junit", version = "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
  // Define IntelliJ Platform API version to use for building this plugin
  version = "2019.1"
}

tasks {
  val generateFlatBuffersLexer by creating(GenerateLexer::class) {
    source = "src/main/grammars/flatbuffers.flex"
    // skeleton "src/main/grammars/flatbuffers.skeleton"
    targetDir = "$genRoot/com/pdehaan/flatbuffers/lexer"
    targetClass = "FlatBuffersLexer"
    purgeOldFiles = true
  }

  val generateFlatBuffersParser by creating(GenerateParser::class) {
    source = "src/main/grammars/flatbuffers-grammer.bnf"
    targetRoot = genRoot
    pathToParser = "com/pdehaan/flatbuffers/parser/FlatBuffersParser.java"
    pathToPsiRoot = "com/pdehaan/flatbuffers/psi"
    purgeOldFiles = true
  }

  compileJava {
    dependsOn(
            generateFlatBuffersParser,
            generateFlatBuffersLexer
    )
  }

  patchPluginXml {
    untilBuild("194.*")
  }
}

