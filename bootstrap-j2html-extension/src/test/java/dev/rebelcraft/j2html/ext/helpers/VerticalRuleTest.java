package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.utilities.Flex;
import dev.rebelcraft.j2html.ext.utilities.Spacing;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class VerticalRuleTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                    .withClasses(VerticalRule.vr)
        );

        //language=HTML
        assertEquals("""
            <div class="vr">
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void example2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Flex.d_flex)
                        .withStyle("height: 200px;")
                        .with(
                                div()
                                        .withClasses(VerticalRule.vr)
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="d-flex" style="height: 200px;">
          <div class="vr">
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("example2", renderedHtml);

        uiDocumentation.documentSource("example2");

    }

    @Test
    void withStacks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Stacks.hstack,Spacing.gap_3)
                        .with(
                                div()
                                        .withClasses(Spacing.p_2)
                                        .with(
                                                text("First item")
                                        ),
                                div()
                                        .withClasses(Spacing.p_2,Spacing.ms_auto)
                                        .with(
                                                text("Second item")
                                        ),
                                div()
                                        .withClasses(VerticalRule.vr),
                                div()
                                        .withClasses(Spacing.p_2)
                                        .with(
                                                text("Third item")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="hstack gap-3">
          <div class="p-2">
            First item
          </div>
          <div class="p-2 ms-auto">
            Second item
          </div>
          <div class="vr">
          </div>
          <div class="p-2">
            Third item
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("with-stacks", renderedHtml);

        uiDocumentation.documentSource("with-stacks");

    }


}
