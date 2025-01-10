package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OpacityTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Opacity.opacity_100)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Opacity.opacity_75)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Opacity.opacity_50)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Opacity.opacity_25)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Opacity.opacity_0)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="opacity-100">
                  ...
                </div>
                <div class="opacity-75">
                  ...
                </div>
                <div class="opacity-50">
                  ...
                </div>
                <div class="opacity-25">
                  ...
                </div>
                <div class="opacity-0">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

}
