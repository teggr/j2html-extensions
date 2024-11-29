package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.ext.components.Buttons;
import dev.rebelcraft.j2html.ext.forms.FormControl;
import dev.rebelcraft.j2html.ext.layout.Grid;
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

class StacksTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void vertical() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
             .withClasses(Stacks.vstack,Spacing.gap_3)
             .with(
                div()
                 .withClasses(Spacing.p_2)
                 .with(
                    text("First item")
                  ),
                div()
                 .withClasses(Spacing.p_2)
                 .with(
                    text("Second item")
                  ),
                div()
                 .withClasses(Spacing.p_2)
                 .with(
                    text("Third item")
                  )
              )
        );

        //language=HTML
        assertEquals("""
            <div class="vstack gap-3">
              <div class="p-2">
                First item
              </div>
              <div class="p-2">
                Second item
              </div>
              <div class="p-2">
                Third item
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("vertical", renderedHtml);

        uiDocumentation.documentSource("vertical");

    }

    @Test
    void horizontal() throws Exception {

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
                                        .withClasses(Spacing.p_2)
                                        .with(
                                                text("Second item")
                                        ),
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
          <div class="p-2">
            Second item
          </div>
          <div class="p-2">
            Third item
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("horizontal", renderedHtml);

        uiDocumentation.documentSource("horizontal");

    }

    @Test
    void horizontal2() throws Exception {

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
          <div class="p-2">
            Third item
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("horizontal2", renderedHtml);

        uiDocumentation.documentSource("horizontal2");

    }

    @Test
    void horizontal3() throws Exception {

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
        uiDocumentation.document("horizontal3", renderedHtml);

        uiDocumentation.documentSource("horizontal3");

    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Stacks.vstack,Spacing.gap_2, Grid.col_md_5,Spacing.mx_auto)
                        .with(
                                button()
                                        .withType("button")
                                        .withClasses(Buttons.btn,Buttons.btn_secondary)
                                        .with(
                                                text("Save changes")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Buttons.btn,Buttons.btn_outline_secondary)
                                        .with(
                                                text("Cancel")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="vstack gap-2 col-md-5 mx-auto">
          <button type="button" class="btn btn-secondary">
            Save changes
          </button>
          <button type="button" class="btn btn-outline-secondary">
            Cancel
          </button>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

    @Test
    void examples2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Stacks.hstack,Spacing.gap_3)
                        .with(
                                input()
                                        .withClasses(FormControl.form_control,Spacing.me_auto)
                                        .withType("text")
                                        .withPlaceholder("Add your item here...")
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Add your item here...")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Buttons.btn,Buttons.btn_secondary)
                                        .with(
                                                text("Submit")
                                        ),
                                div()
                                        .withClasses(VerticalRule.vr),
                                button()
                                        .withType("button")
                                        .withClasses(Buttons.btn,Buttons.btn_outline_danger)
                                        .with(
                                                text("Reset")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="hstack gap-3">
          <input class="form-control me-auto" type="text" placeholder="Add your item here..." aria-label="Add your item here...">
          <button type="button" class="btn btn-secondary">
            Submit
          </button>
          <div class="vr">
          </div>
          <button type="button" class="btn btn-outline-danger">
            Reset
          </button>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("examples2", renderedHtml);

        uiDocumentation.documentSource("examples2");

    }


}
