# j2html-extensions

A collection of extensions for the [j2html](https://j2html.com) library, used for building HTML with java code.

![Maven Central Version](https://img.shields.io/maven-central/v/dev.rebelcraft/j2html-extensions)

# What's in the box?

* [j2html-extensions-core](#j2html-extensions-core) - Extensions for the core j2html classes and creators
* [j2html-extensions-tools](#j2html-extensions-tools) - Standalone module with utilities for generating code
* [rebel-ui-test](#rebel-ui-test) - Standalone module for testing UI rendering
* [bootstrap-j2html-extension](#bootstrap-j2html-extension) - Bootstrap lib
* [j2html-generator](#j2html-generator) - Webapp for generating j2html code from html

# j2html-extensions-core

Support for some missing tags: `PathTag`, `SvgTag`, `SymbolTag`, `UseTag`. The `ExtendedTagCreator` makes those available in the same way as the j2html library.

```java
ExtendedTagCreator.svg();
ExtendedTagCreator.path();
ExtendedTagCreator.use();
ExtendedTagCreator.symbok();
```

Support for [Aria Roles, States and Properties](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/ARIA_Techniques)

```java
TagCreator.div()
    .attr(AriaRoles.roleButton) // <div role="button" />
TagCreate.div()
    ,attr(AriaStatesAndProperties.aria_current("page")) // <div aria-current="page" />
```

# rebel-ui-test

A proof of concept UI testing framework based on [Spring MockMvc](https://docs.spring.io/spring-framework/reference/testing/mockmvc/overview.html).

* Useful for validating HTML output
* Integrates with JUnit test framework
* Generates snippets of code for integrating with documentation tools

```java
import dev.rebelcraft.j2html.bootstrap.Bootstrap;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AlertsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                      div()
                       .withClasses(Bootstrap.alert, Bootstrap.alert_primary)
                       .attr(AriaRoles.roleAlert)
                       .with(
                          text("A simple primary alert—check it out!")
                        )
                    )
                );

        //language=HTML
        assertEquals("""
            <div class="alert alert-primary" role="alert">
              A simple primary alert—check it out!
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }
    
}

```

# j2html-extensions-tools

Support for generating Java classes containing the CSS class names from published CSS libraries.

* Quick support for any CSS library
* Auto complete for CSS classes within Java classes

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.1.0</version>
    <configuration>
        <mainClass>dev.rebelcraft.j2html.tools.ExtractCssClassesToJava</mainClass>
        <arguments>
            <argument>${project.basedir}\src\bootstrap\css\bootstrap.css</argument>
            <argument>dev.rebelcraft.j2html.bootstrap</argument>
            <argument>Bootstrap</argument>
            <argument>${project.basedir}\src\main\java</argument>
        </arguments>
        <includePluginDependencies>true</includePluginDependencies>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>dev.rebelcraft</groupId>
            <artifactId>j2html-extensions-tools</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-nop</artifactId>
            <version>2.0.16</version>
        </dependency>
    </dependencies>
</plugin>

```

# bootstrap-j2html-extension

This brings the [Bootstrap](https://getbootstrap.com/) UI kit into the j2html ecosystem.

* `Bootstrap` for CSS classes declared in the UI toolkit
* `BootstrapConfig` for useful URLs for CDN and Webjar locations
* `BootstrapIcons` for CSS classes supporting the Bootstrap Icons
* `BootstrapTagCreator` for common templates for Bootstrap components

```xml
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>bootstrap-j2html-extension</artifactId>
    <version>0.0.2</version>
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

## bootstrap versions support

| Java Version | Boostrap Version |
|--------------|------------------|
| 0.0.2        | 5.3.3 |

# j2html-generator

A webapp that can generate j2html code from HTML fragments to help simplfy the process of writing j2html code.

![](/docs/generator.png)

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