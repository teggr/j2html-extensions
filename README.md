# j2html-extensions

A set of extensions for the [j2html](https://j2html.com) library for building html with java code.

# What's in the box?

* [rebel-ui-test](#rebel-ui-test) - Standalone module for testing UI rendering
* [j2html-extensions-core](#j2html-extensions-core) - Extensions for the core j2html classes and creators
* [j2html-extensions-tools](#j2html-extensions-tools) - Standalone module with utilities for generating code
* [bootstrap-j2html-extension](#bootstrap-j2html-extension) - Bootstrap lib
* [j2html-generator](#j2html-generator) - Webapp for generating j2html code from html

# j2html-extensions-core

# rebel-ui-test

# j2html-extensions-tools

# bootstrap-j2html-extension

This brings the [Bootstrap]() UI kit into the j2html ecosystem.

```xml
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>bootstrap-j2html-extension</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Usage:
```java
import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import static j2html.TagCreator.*;

div()
    .withClasses(Bootstrap.alert, Bootstrap.alert_primary)
    .attr(AriaRoles.roleAlert)
    .with(
      text("A simple primary alert—check it out!")
    )
```

```
// TODO:
svg Tag
use Tag
render of the source code done at render() method use inline/page/etc. to determine where to get code
```

## bootstrap versions support

| Java Version | Boostrap Version |
|--------------|------------------|
|0.0.1-SNAPSHOT| 5.3.3 |

# j2html-generator

# Build and release

```shell
mvn clean
# set the version for all extensions and then the spring boot app
mvn -Pcentral versions:set -DremoveSnapshot -DprocessAllModules
mvn -Pcentral --projects j2html-generator versions:set -DremoveSnapshot
# check that the poms are correct
mvn -Pcentral org.kordamp.maven:pomchecker-maven-plugin:1.14.0:check-maven-central
# verify it still all works
mvn -Pcentral deploy -DignorePublishedComponents=true

# set the new versions for all extensions and then the spring boot app
mvn -Pcentral versions:set -DnextSnapshot -DprocessAllModules
mvn -Pcentral --projects j2html-generator versions:set -DnextSnapshot

# set the new versions for all extensions and then the spring boot app
mvn -Pcentral versions:commit -DprocessAllModules
mvn -Pcentral --projects j2html-generator versions:commit
```

## Plugins

* https://www.mojohaus.org/versions/versionsmaven-plugin/index.html
* https://maven.apache.org/plugins/maven-gpg-plugin/index.html
* https://kordamp.org/pomchecker/pomchecker-maven-plugin/index.html

## Maintenance

* https://central.sonatype.com/publishing
* https://central.sonatype.com/search?q=dev.rebelcraft