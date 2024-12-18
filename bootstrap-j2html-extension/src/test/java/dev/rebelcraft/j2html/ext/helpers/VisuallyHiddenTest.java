package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class VisuallyHiddenTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
              h2()
               .withClasses(VisuallyHidden.visually_hidden)
               .with(
                  text("Title for screen readers")
                ),
              a()
               .withClasses(VisuallyHidden.visually_hidden_focusable)
               .withHref("#content")
               .with(
                  text("Skip to main content")
                ),
              div()
               .withClasses(VisuallyHidden.visually_hidden_focusable)
               .with(
                  text("A container with a"),
                  a()
                   .withHref("#")
                   .with(
                      text("focusable element")
                    ),
                  text(".")
                )
            )
        );

        //language=HTML
        assertEquals("""
            <h2 class="visually-hidden">
              Title for screen readers
            </h2>
            <a class="visually-hidden-focusable" href="#content">
              Skip to main content
            </a>
            <div class="visually-hidden-focusable">
              A container with a
              <a href="#">
                focusable element
              </a>
              .
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

}
