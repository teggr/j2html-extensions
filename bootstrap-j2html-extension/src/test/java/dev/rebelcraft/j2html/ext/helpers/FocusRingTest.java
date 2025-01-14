package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.a;
import static j2html.TagCreator.text;
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
                 .withClasses(BootstrapClasses.d_inline_flex, BootstrapClasses.focus_ring, BootstrapClasses.py_1,BootstrapClasses.px_2, BootstrapClasses.text_decoration_none, BootstrapClasses.border,BootstrapClasses.rounded_2)
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
