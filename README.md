# j2html-extensions

A collection of extensions for the [j2html](https://j2html.com) library, used for building HTML with java code.

![Maven Central Version](https://img.shields.io/maven-central/v/dev.rebelcraft/j2html-extensions)

# What's in the box?

* [j2html-extensions-core](/docs/j2html-extensions-core.md) - Extensions for the core j2html classes and creators
* [j2html-extensions-tools](/docs/j2html-extensions-tools.md) - Standalone module with utilities for generating code
* [rebel-ui-test](/docs/rebel-ui-test.md) - Standalone module for testing UI rendering
* [bootstrap-j2html-extension](/docs/bootstrap-j2html-extension.md) - Bootstrap lib
* [htmx-j2html-extension](/docs/htmx-j2html-extension.md) - HTMX attributes
* [j2html-generator](/docs/j2html-generator.md) - Webapp for generating j2html code from html

# Quick Start

Add the following to your Maven `pom.xml` file.

```xml

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>dev.rebelcraft</groupId>
            <artifactId>j2html-extensions-bom</artifactId>
            <version>0.0.3</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

...

<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>j2html-extensions-spring-boot-starter</artifactId>
</dependency>
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>bootstrap-j2html-extension</artifactId>
</dependency>
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>htmx-j2html-extension</artifactId>
</dependency>

```

Use the provided `J2HtmlView` objects to start building out your webmvc application.

```java

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "homeView";
    }

}

...

@Component
public class HomeView extends J2HtmlView {

    @Override
    protected DomContent renderMergedOutputModelDomContent(
            Map<String, Object> model,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return div().withClasses(Bootstrap.container).with(
                p("Hello World")
        );

    }

}

```


# Build and release

[RELEASE.md](/docs/RELEASE.md)
