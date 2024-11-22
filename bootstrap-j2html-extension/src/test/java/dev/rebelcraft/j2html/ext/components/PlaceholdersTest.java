package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.ext.layout.Grid;
import dev.rebelcraft.j2html.ext.utilities.Background;
import dev.rebelcraft.j2html.ext.utilities.Sizing;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class PlaceholdersTest {

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
                   .withClasses(Card.card)
                   .with(
                      img()
                       .withSrc("...")
                       .withClasses(Card.card_img_top)
                       .withAlt("..."),
                      div()
                       .withClasses(Card.card_body)
                       .with(
                          h5()
                           .withClasses(Card.card_title)
                           .with(
                              text("Card title")
                            ),
                          p()
                           .withClasses(Card.card_text)
                           .with(
                              text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                            ),
                          a()
                           .withHref("#")
                           .withClasses(Buttons.btn,Buttons.btn_primary)
                           .with(
                              text("Go somewhere")
                            )
                        )
                    ),
                  div()
                   .withClasses(Card.card)
                   .attr(
                      AriaStatesAndProperties.ariaHidden("true")
                    )
                   .with(
                      img()
                       .withSrc("...")
                       .withClasses(Card.card_img_top)
                       .withAlt("..."),
                      div()
                       .withClasses(Card.card_body)
                       .with(
                          h5()
                           .withClasses(Card.card_title,Placeholders.placeholder_glow)
                           .with(
                              span()
                               .withClasses(Placeholders.placeholder,Grid.col_6)
                            ),
                          p()
                           .withClasses(Card.card_text,Placeholders.placeholder_glow)
                           .with(
                              span()
                               .withClasses(Placeholders.placeholder, Grid.col_7),
                              span()
                               .withClasses(Placeholders.placeholder,Grid.col_4),
                              span()
                               .withClasses(Placeholders.placeholder,Grid.col_4),
                              span()
                               .withClasses(Placeholders.placeholder,Grid.col_6),
                              span()
                               .withClasses(Placeholders.placeholder,Grid.col_8)
                            ),
                          a()
                           .withClasses(Buttons.btn,Buttons.btn_primary,Popovers.disabled,Placeholders.placeholder,Grid.col_6)
                           .attr(
                              AriaStatesAndProperties.ariaDisabled("true")
                            )
                        )
                    )
                )
        );

        //language=HTML
        assertEquals("""
            <div class="card">
              <img src="..." class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">
                  Card title
                </h5>
                <p class="card-text">
                  Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                </p>
                <a href="#" class="btn btn-primary">
                  Go somewhere
                </a>
              </div>
            </div>
            <div class="card" aria-hidden="true">
              <img src="..." class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title placeholder-glow">
                  <span class="placeholder col-6">
                  </span>
                </h5>
                <p class="card-text placeholder-glow">
                  <span class="placeholder col-7">
                  </span>
                  <span class="placeholder col-4">
                  </span>
                  <span class="placeholder col-4">
                  </span>
                  <span class="placeholder col-6">
                  </span>
                  <span class="placeholder col-8">
                  </span>
                </p>
                <a class="btn btn-primary disabled placeholder col-6" aria-disabled="true">
                </a>
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void howItWorks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .attr(
                                        AriaStatesAndProperties.ariaHidden("true")
                                )
                                .with(
                                        span()
                                                .withClasses(Placeholders.placeholder,Grid.col_6)
                                ),
                        a()
                                .withClasses(Buttons.btn,Buttons.btn_primary,Popovers.disabled,Placeholders.placeholder,Grid.col_4)
                                .attr(
                                        AriaStatesAndProperties.ariaDisabled("true")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <p aria-hidden="true">
          <span class="placeholder col-6">
          </span>
        </p>
        <a class="btn btn-primary disabled placeholder col-4" aria-disabled="true">
        </a>
        """, renderedHtml);

        // document
        uiDocumentation.document("how-it-works", renderedHtml);

        uiDocumentation.documentSource("how-it-works");

    }

    @Test
    void width() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_6),
                        span()
                                .withClasses(Placeholders.placeholder, Sizing.w_75),
                        span()
                                .withClasses(Placeholders.placeholder)
                                .withStyle("width: 25%;")
                )
        );

        //language=HTML
        assertEquals("""
        <span class="placeholder col-6">
        </span>
        <span class="placeholder w-75">
        </span>
        <span class="placeholder" style="width: 25%;">
        </span>
        """, renderedHtml);

        // document
        uiDocumentation.document("width", renderedHtml);

        uiDocumentation.documentSource("width");

    }

    @Test
    void color() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Background.bg_primary),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Background.bg_secondary),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Background.bg_success),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Background.bg_danger),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Background.bg_warning),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Background.bg_info),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Background.bg_light),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12, Background.bg_dark)
                )
        );

        //language=HTML
        assertEquals("""
        <span class="placeholder col-12">
        </span>
        <span class="placeholder col-12 bg-primary">
        </span>
        <span class="placeholder col-12 bg-secondary">
        </span>
        <span class="placeholder col-12 bg-success">
        </span>
        <span class="placeholder col-12 bg-danger">
        </span>
        <span class="placeholder col-12 bg-warning">
        </span>
        <span class="placeholder col-12 bg-info">
        </span>
        <span class="placeholder col-12 bg-light">
        </span>
        <span class="placeholder col-12 bg-dark">
        </span>
        """, renderedHtml);

        // document
        uiDocumentation.document("color", renderedHtml);

        uiDocumentation.documentSource("color");

    }

    @Test
    void sizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Placeholders.placeholder_lg),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Placeholders.placeholder_sm),
                        span()
                                .withClasses(Placeholders.placeholder,Grid.col_12,Placeholders.placeholder_xs)
                )
        );

        //language=HTML
        assertEquals("""
        <span class="placeholder col-12 placeholder-lg">
        </span>
        <span class="placeholder col-12">
        </span>
        <span class="placeholder col-12 placeholder-sm">
        </span>
        <span class="placeholder col-12 placeholder-xs">
        </span>
        """, renderedHtml);

        // document
        uiDocumentation.document("sizing", renderedHtml);

        uiDocumentation.documentSource("sizing");

    }

    @Test
    void animation() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Placeholders.placeholder_glow)
                                .with(
                                        span()
                                                .withClasses(Placeholders.placeholder,Grid.col_12)
                                ),
                        p()
                                .withClasses(Placeholders.placeholder_wave)
                                .with(
                                        span()
                                                .withClasses(Placeholders.placeholder,Grid.col_12)
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <p class="placeholder-glow">
          <span class="placeholder col-12">
          </span>
        </p>
        <p class="placeholder-wave">
          <span class="placeholder col-12">
          </span>
        </p>
        """, renderedHtml);

        // document
        uiDocumentation.document("animation", renderedHtml);

        uiDocumentation.documentSource("animation");

    }


}
