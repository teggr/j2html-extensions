package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClearfixTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void clearfixTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                 .withClasses(BootstrapClasses.clearfix)
                 .with(
                    text("...")
                  )
        );

        //language=HTML
        assertEquals("""
            <div class="clearfix">
              ...
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("clearfix-test", renderedHtml);

        uiDocumentation.documentSource("clearfix-test");

    }

    @Test
    void clearfixTest2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(BootstrapClasses.bg_info,BootstrapClasses.clearfix)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(BootstrapClasses.btn,BootstrapClasses.btn_secondary,BootstrapClasses.float_start)
                                        .with(
                                                text("Example Button floated left")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(BootstrapClasses.btn,BootstrapClasses.btn_secondary, BootstrapClasses.float_end)
                                        .with(
                                                text("Example Button floated right")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="bg-info clearfix">
          <button type="button" class="btn btn-secondary float-start">
            Example Button floated left
          </button>
          <button type="button" class="btn btn-secondary float-end">
            Example Button floated right
          </button>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("clearfix-test2", renderedHtml);

        uiDocumentation.documentSource("clearfix-test2");

    }


}
