package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.utilities.Borders;
import dev.rebelcraft.j2html.ext.utilities.Flex;
import dev.rebelcraft.j2html.ext.utilities.Spacing;
import dev.rebelcraft.j2html.ext.utilities.Text;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class FocusRingTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                a()
                 .withHref("#")
                 .withClasses(Flex.d_inline_flex,FocusRing.focus_ring, Spacing.py_1,Spacing.px_2, Text.text_decoration_none, Borders.border,Borders.rounded_2)
                 .with(
                    text("Custom focus ring")
                  )
        );

        //language=HTML
        assertEquals("""
            <a href="#" class="d-inline-flex focus-ring py-1 px-2 text-decoration-none border rounded-2">
              Custom focus ring
            </a>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

}
