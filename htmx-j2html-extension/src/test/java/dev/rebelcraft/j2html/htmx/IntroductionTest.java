package dev.rebelcraft.j2html.htmx;

import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntroductionTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void nutshell() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                    .attr(hxPost("/clicked") )
                    .attr(hxTrigger(click))
                    .attr(hxTarget("#parent-div"))
                    .attr(hxSwap(outerHTML))
                    .with(
                            text("Click Me!")
                    )
        );

        //language=HTML
        assertEquals("""
                <button hx-post="/clicked" hx-trigger="click" hx-target="#parent-div" hx-swap="outerHTML">
                  Click Me!
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("nutshell", renderedHtml);

        uiDocumentation.documentSource("nutshell");

    }

    @Test
    void nutshell2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                        .withData(hx_post,"/click")
                        .with(
                                text("Click Me!")
                        )
        );

        //language=HTML
        assertEquals("""
                <a data-hx-post="/click">
                  Click Me!
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("nutshell2", renderedHtml);

        uiDocumentation.documentSource("nutshell2");

    }


}