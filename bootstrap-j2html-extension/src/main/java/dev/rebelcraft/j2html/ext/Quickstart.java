package dev.rebelcraft.j2html.ext;

import j2html.tags.specialized.HtmlTag;

import static dev.rebelcraft.j2html.ext.BootstrapTagCreator.*;
import static j2html.TagCreator.*;

/**
 * <pre>
 *     https://getbootstrap.com/docs/5.3/getting-started/introduction/
 * </pre>
 */
public class Quickstart {

    public static HtmlTag index() {

        return
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
                        );

    }

}
