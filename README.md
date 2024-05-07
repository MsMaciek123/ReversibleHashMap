# ReversibleHashMap

![Release](https://jitpack.io/v/MsMaciek123/ReversibleHashMap.svg)

ReversibleHashMap is a special type that allows you to get reversed HashMap without iterating over all keys. It works by
storing a copy of HashMap and changing the reversed HashMap values when the original HashMap values changes.

Example usage can be found in tests.

Replace VERSION with current version. \
Gradle:

```gradle
repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
}
   
dependencies {
    implementation 'com.github.MsMaciek123:ReversibleHashMap:VERSION'
}
```

Maven:

```xml

<project>
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.MsMaciek123</groupId>
            <artifactId>ReversibleHashMap</artifactId>
            <version>VERSION</version>
        </dependency>
    </dependencies>
</project>
```