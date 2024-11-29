package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.components.Buttons;
import dev.rebelcraft.j2html.ext.utilities.Background;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


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
                 .withClasses(Clearfix.clearfix)
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
                        .withClasses(Background.bg_info,Clearfix.clearfix)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Buttons.btn,Buttons.btn_secondary,dev.rebelcraft.j2html.ext.utilities.Float.float_start)
                                        .with(
                                                text("Example Button floated left")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Buttons.btn,Buttons.btn_secondary, dev.rebelcraft.j2html.ext.utilities.Float.float_end)
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
