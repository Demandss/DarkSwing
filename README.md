<h1 align="center">Dark Swing</h1>

<p align="center">
<h3>That's how many people visited this page</h3>

![Visitor Count](https://profile-counter.glitch.me/DarkSwing/count.svg)
</p>

Changes Swing elements to dark style (as i see it)
<p align="center">
<img src="https://img.shields.io/badge/made%20by-Demands-7289da?style=flat-square" >
<img src="https://img.shields.io/badge/open%20source-❤-7289da?style=flat-square" >
<img src="https://img.shields.io/badge/java%20swing-❤-7289da?style=flat-square" >
</p>
<h1 align="center">Installation</h1>

* [Creating a new Gradle project with IntelliJ](https://www.jetbrains.com/help/idea/getting-started-with-gradle.html) *(recommended)*
* [Creating a new Maven project with IntelliJ](https://www.jetbrains.com/help/idea/maven-support.html)
* [Creating a new Gradle project with Eclipse](https://www.vogella.com/tutorials/EclipseGradle/article.html#creating-gradle-projects)
* [Creating a new Maven project with Eclipse](https://www.vogella.com/tutorials/EclipseMaven/article.html#exercise-create-a-new-maven-enabled-project-via-eclipse)

### Gradle
```groovy
repositories {
  maven { url "https://jitpack.io" }
  mavenCentral()
}

dependencies {
  implementation 'com.github.Demandss:darkswing:master-SNAPSHOT'
}
```

### Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependencies>
  <dependency>
    <groupId>com.github.demandss</groupId>
    <artifactId>darkswing</artifactId>
    <version>master-SNAPSHOT</version>
  </dependency>
</dependencies>
```
