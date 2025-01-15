package dev.rebelcraft.j2html.bootstrap;

import dev.rebelcraft.j2html.ext.ExtendedTagCreator;

import static dev.rebelcraft.j2html.bootstrap.BootstrapTagCreator.*;
import static j2html.TagCreator.*;

/**
 * <pre>
 *     https://getbootstrap.com/docs/5.3/getting-started/introduction/
 * </pre>
 */
public class Quickstart {

    public static String index() {

        return ExtendedTagCreator.document(
                html().withLang("en")
                        .with(
                                head(
                                        utf8Charset(),
                                        responsiveViewport(),
                                        title("Bootstrap demo"),
                                        cdnCSSLink()
                                ),
                                body(
                                        h1("Hello, world!"),
                                        cdnBundleMinJSLink()
                                )
                        )
        );

    }

}
