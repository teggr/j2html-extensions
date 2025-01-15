package com.robintegg.j2html.app.generator.code;

import j2html.rendering.IndentedHtml;
import j2html.tags.DomContent;

import java.io.IOException;

import static j2html.TagCreator.*;

public class HtmlTest {

    public static void main(String[] args) throws IOException {

        DomContent output = div()
                .with(
                        each(
                                text("For example, "),
                                code()
                                        .with(
                                                text("<section>")
                                        ),
                                text(" should be wrapped as inline.")
                        )
                );

        System.out.println( output.render(IndentedHtml.inMemory()) );

    }

}
