package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ZIndexTest {

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
                                .withClasses(ZIndex.z_3, Position.position_absolute, Spacing.p_5, Borders.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-3")
                                                )
                                ),
                        div()
                                .withClasses(ZIndex.z_2, Position.position_absolute, Spacing.p_5, Borders.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-2")
                                                )
                                ),
                        div()
                                .withClasses(ZIndex.z_1, Position.position_absolute, Spacing.p_5, Borders.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-1")
                                                )
                                ),
                        div()
                                .withClasses(ZIndex.z_0, Position.position_absolute, Spacing.p_5, Borders.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-0")
                                                )
                                ),
                        div()
                                .withClasses(ZIndex.z_n1, Position.position_absolute, Spacing.p_5, Borders.rounded_3)
                                .with(
                                        span()
                                                .with(
                                                        text("z-n1")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="z-3 position-absolute p-5 rounded-3">
                  <span>
                    z-3
                  </span>
                </div>
                <div class="z-2 position-absolute p-5 rounded-3">
                  <span>
                    z-2
                  </span>
                </div>
                <div class="z-1 position-absolute p-5 rounded-3">
                  <span>
                    z-1
                  </span>
                </div>
                <div class="z-0 position-absolute p-5 rounded-3">
                  <span>
                    z-0
                  </span>
                </div>
                <div class="z-n1 position-absolute p-5 rounded-3">
                  <span>
                    z-n1
                  </span>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

}
