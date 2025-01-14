# j2html-extensions

A set of extensions for the j2html library for building html with java code

## [bootstrap-j2html-extension](bootstrap-j2html-extension)

This brings the [Bootstrap]() UI kit into the j2html ecosystem. 

```xml
<dependency>
    <groupId>dev.rebelcraft</groupId>
    <artifactId>bootstrap-j2html-extension</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

```
// TODO:
svg Tag
use Tag
render of the source code done at render() method use inline/page/etc. to determine where to get code
```

### bootstrap versions support

| Java Version | Boostrap Version |
|--------------|------------------|
|0.0.1-SNAPSHOT| 5.3.3 |

# Modules

* rebel-ui-test - Standalone module for testing UI rendering
* j2html-extensions-tools - Standalone module with utilities for generating code
* j2html-extensions-core - Extensions for the core j2html classes and creators
* bootstrap-j2html-extension - Bootstrap lib