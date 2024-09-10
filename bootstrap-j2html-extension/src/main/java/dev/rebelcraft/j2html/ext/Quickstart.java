package dev.rebelcraft.j2html.ext;

import j2html.attributes.Attr;

import static j2html.TagCreator.*;

public class Quickstart {

    public static String index() {

        return document(
                html(
                        head(
                                meta().attr(Attr.CHARSET, "utf-8"),
                                meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
                                title("Bootstrap demo")
                        ),
                        body(
                                h1("Hello, world!")
                        )
                )
        );

    }

}
