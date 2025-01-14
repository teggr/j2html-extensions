package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.comment;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TextTruncationTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                      div()
                       .withClasses(BootstrapClasses.row)
                       .with(
                          comment("Block level"),
                          div()
                           .withClasses(BootstrapClasses.col_2, BootstrapClasses.text_truncate)
                           .with(
                              text("This text is quite long, and will be truncated once displayed.")
                            )
                        ),
                      comment("Inline level"),
                      span()
                       .withClasses(BootstrapClasses.d_inline_block,BootstrapClasses.text_truncate)
                       .withStyle("max-width: 150px;")
                       .with(
                          text("This text is quite long, and will be truncated once displayed.")
                        )
                    )
        );

        //language=HTML
        assertEquals("""
            <div class="row">
              <!-- Block level -->
              <div class="col-2 text-truncate">
                This text is quite long, and will be truncated once displayed.
              </div>
            </div>
            <!-- Inline level -->
            <span class="d-inline-block text-truncate" style="max-width: 150px;">
              This text is quite long, and will be truncated once displayed.
            </span>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

}
