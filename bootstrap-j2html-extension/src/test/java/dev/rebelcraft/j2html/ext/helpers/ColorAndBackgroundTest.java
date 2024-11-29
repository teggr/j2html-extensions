package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.components.Badge;
import dev.rebelcraft.j2html.ext.components.Card;
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

class ColorAndBackgroundTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void overview() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
              div()
               .withClasses(ColorsAndBackground.text_bg_primary, Spacing.p_3)
               .with(
                  text("Primary with contrasting color")
                ),
              div()
               .withClasses(ColorsAndBackground.text_bg_secondary,Spacing.p_3)
               .with(
                  text("Secondary with contrasting color")
                ),
              div()
               .withClasses(ColorsAndBackground.text_bg_success,Spacing.p_3)
               .with(
                  text("Success with contrasting color")
                ),
              div()
               .withClasses(ColorsAndBackground.text_bg_danger,Spacing.p_3)
               .with(
                  text("Danger with contrasting color")
                ),
              div()
               .withClasses(ColorsAndBackground.text_bg_warning,Spacing.p_3)
               .with(
                  text("Warning with contrasting color")
                ),
              div()
               .withClasses(ColorsAndBackground.text_bg_info,Spacing.p_3)
               .with(
                  text("Info with contrasting color")
                ),
              div()
               .withClasses(ColorsAndBackground.text_bg_light,Spacing.p_3)
               .with(
                  text("Light with contrasting color")
                ),
              div()
               .withClasses(ColorsAndBackground.text_bg_dark,Spacing.p_3)
               .with(
                  text("Dark with contrasting color")
                )
            )
        );

        //language=HTML
        assertEquals("""
            <div class="text-bg-primary p-3">
              Primary with contrasting color
            </div>
            <div class="text-bg-secondary p-3">
              Secondary with contrasting color
            </div>
            <div class="text-bg-success p-3">
              Success with contrasting color
            </div>
            <div class="text-bg-danger p-3">
              Danger with contrasting color
            </div>
            <div class="text-bg-warning p-3">
              Warning with contrasting color
            </div>
            <div class="text-bg-info p-3">
              Info with contrasting color
            </div>
            <div class="text-bg-light p-3">
              Light with contrasting color
            </div>
            <div class="text-bg-dark p-3">
              Dark with contrasting color
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("overview", renderedHtml);

        uiDocumentation.documentSource("overview");

    }

    @Test
    void withComponents() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Badge.badge,ColorsAndBackground.text_bg_primary)
                                .with(
                                        text("Primary")
                                ),
                        span()
                                .withClasses(Badge.badge,ColorsAndBackground.text_bg_info)
                                .with(
                                        text("Info")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <span class="badge text-bg-primary">
              Primary
            </span>
            <span class="badge text-bg-info">
              Info
            </span>
            """, renderedHtml);

        // document
        uiDocumentation.document("with-components", renderedHtml);

        uiDocumentation.documentSource("with-components");

    }

    @Test
    void withComponents2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Card.card,ColorsAndBackground.text_bg_primary,Spacing.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Card.card_body)
                                                .with(
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,ColorsAndBackground.text_bg_info,Spacing.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Card.card_body)
                                                .with(
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="card text-bg-primary mb-3" style="max-width: 18rem;">
          <div class="card-header">
            Header
          </div>
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
            </p>
          </div>
        </div>
        <div class="card text-bg-info mb-3" style="max-width: 18rem;">
          <div class="card-header">
            Header
          </div>
          <div class="card-body">
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
            </p>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("with-components2", renderedHtml);

        uiDocumentation.documentSource("with-components2");

    }

}
