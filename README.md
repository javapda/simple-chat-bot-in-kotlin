# simple-chat-bot #

* [Simple Chat Bot](https://hyperskill.org/projects/126?track=18)

* Main entry point: [SimpleChatBot.kt](app/src/main/kotlin/bot/SimpleChatBot.kt)


# to run:
```courseignore
.\gradlew.bat clean build
java -jar .\app\build\libs\simple-chat-bot-in-kotlin.jar
```

# Troubleshooting

when you run a java project you are usually relying on the availability
of the JRE (Java Runtime Environment). This is a Kotlin project, so,
in addition to the JRE you may need whatever is needed to run classes associated 
with the Kotlin runtime environment.

One solution is to package the Kotlin runtime with the build jar.
To accomplish this we can use the 



## symptoms
```
Exception in thread "main" java.lang.NoClassDefFoundError: kotlin/jvm/functions/Function0
        at java.base/java.lang.ClassLoader.defineClass1(Native Method)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1027)
        at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:150)
        at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:862)
        at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:760)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:681)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:639)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
        at bot.SimpleChatBotKt.multipleChoice(SimpleChatBot.kt:69)
        at MainKt.main(Main.kt:5)
        at MainKt.main(Main.kt)
Caused by: java.lang.ClassNotFoundException: kotlin.jvm.functions.Function0
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
        ... 12 more
```

### reason
The error you're encountering, java.lang.NoClassDefFoundError: kotlin/jvm/functions/Function0, suggests that the Kotlin runtime and standard library are not included in your JAR file. This typically happens because the JAR file you're building does not include the dependencies necessary to run the application.

To resolve this issue, you need to create a "fat" or "uber" JAR, which includes all the dependencies within the JAR file itself.

### resources
* [Shadow User Guide](https://imperceptiblethoughts.com/shadow/introduction/)
* [Shadow - main site](https://imperceptiblethoughts.com/shadow/)
* [shadowjar on github](https://github.com/johnrengelman/shadow)
* [ShadowJar on mvnrepository](https://mvnrepository.com/artifact/com.github.johnrengelman.shadow/com.github.johnrengelman.shadow.gradle.plugin?repo=gradle-plugins)

### Steps to Including the Kotlin runtime and standard library
1. Add the [Shadow Plugin](https://mvnrepository.com/artifact/com.github.johnrengelman.shadow/com.github.johnrengelman.shadow.gradle.plugin?repo=gradle-plugins)
2. Build the Fat JAR
3. Run the Fat JAR

#### Step 1: Add the [Shadow Plugin](https://mvnrepository.com/artifact/com.github.johnrengelman.shadow/com.github.johnrengelman.shadow.gradle.plugin?repo=gradle-plugins)
* edit .\app\build.gradle.kts:
```
plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("")
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
}
    
```

#### Step 2: Build the Fat JAR
```courseignore
.\gradlew.bat build
```

#### Step 3. Run the Fat JAR
```courseignore
 java -jar .\app\build\libs\simple-chat-bot-in-kotlin.jar
```
### Explanation
* Shadow Plugin: The Shadow plugin helps package the dependencies into the JAR file.
* shadowJar Task: Configures the shadowJar task to set the main class and create a JAR without a classifier.
* Build and Run: The shadowJar task creates a fat JAR containing all dependencies, making it runnable with java -jar.

