package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.components.Buttons;
import dev.rebelcraft.j2html.ext.components.Card;
import dev.rebelcraft.j2html.ext.layout.Grid;
import dev.rebelcraft.j2html.ext.layout.Gutters;
import dev.rebelcraft.j2html.ext.utilities.*;
import dev.rebelcraft.j2html.ext.utilities.Position;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class StretchedlinkTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
             .withClasses(Card.card)
             .withStyle("width: 18rem;")
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
                        text("Card with stretched link")
                      ),
                    p()
                     .withClasses(Card.card_text)
                     .with(
                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                      ),
                    a()
                     .withHref("#")
                     .withClasses(Buttons.btn, Buttons.btn_primary,StretchedLink.stretched_link)
                     .with(
                        text("Go somewhere")
                      )
                  )
              )
        );

        //language=HTML
        assertEquals("""
            <div class="card" style="width: 18rem;">
              <img src="..." class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title">
                  Card with stretched link
                </h5>
                <p class="card-text">
                  Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                </p>
                <a href="#" class="btn btn-primary stretched-link">
                  Go somewhere
                </a>
              </div>
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
                        .withClasses(Flex.d_flex, Position.position_relative)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Flex.flex_shrink_0,Spacing.me_3)
                                        .withAlt("..."),
                                div()
                                        .with(
                                                h5()
                                                        .withClasses(Spacing.mt_0)
                                                        .with(
                                                                text("Custom component with stretched link")
                                                        ),
                                                p()
                                                        .with(
                                                                text("This is some placeholder content for the custom component. It is intended to mimic what some real-world content would look like, and we're using it here to give the component a bit of body and size.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(StretchedLink.stretched_link)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="d-flex position-relative">
          <img src="..." class="flex-shrink-0 me-3" alt="...">
          <div>
            <h5 class="mt-0">
              Custom component with stretched link
            </h5>
            <p>
              This is some placeholder content for the custom component. It is intended to mimic what some real-world content would look like, and we&#x27;re using it here to give the component a bit of body and size.
            </p>
            <a href="#" class="stretched-link">
              Go somewhere
            </a>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("example2", renderedHtml);

        uiDocumentation.documentSource("example2");

    }

    @Test
    void example3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row, Gutters.g_0, Background.bg_body_secondary,Position.position_relative)
                        .with(
                                div()
                                        .withClasses(Grid.col_md_6,Spacing.mb_md_0,Spacing.p_md_4)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Sizing.w_100)
                                                        .withAlt("...")
                                        ),
                                div()
                                        .withClasses(Grid.col_md_6,Spacing.p_4,Spacing.ps_md_0)
                                        .with(
                                                h5()
                                                        .withClasses(Spacing.mt_0)
                                                        .with(
                                                                text("Columns with stretched link")
                                                        ),
                                                p()
                                                        .with(
                                                                text("Another instance of placeholder content for this other custom component. It is intended to mimic what some real-world content would look like, and we're using it here to give the component a bit of body and size.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(StretchedLink.stretched_link)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="row g-0 bg-body-secondary position-relative">
          <div class="col-md-6 mb-md-0 p-md-4">
            <img src="..." class="w-100" alt="...">
          </div>
          <div class="col-md-6 p-4 ps-md-0">
            <h5 class="mt-0">
              Columns with stretched link
            </h5>
            <p>
              Another instance of placeholder content for this other custom component. It is intended to mimic what some real-world content would look like, and we&#x27;re using it here to give the component a bit of body and size.
            </p>
            <a href="#" class="stretched-link">
              Go somewhere
            </a>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("example3", renderedHtml);

        uiDocumentation.documentSource("example3");

    }

    @Test
    void identifyingTheContainingBlock() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .withStyle("width: 18rem;")
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
                                                                text("Card with stretched links")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                a()
                                                                        .withHref("#")
                                                                        .withClasses(StretchedLink.stretched_link,Colors.text_danger)
                                                                        .withStyle("position: relative;")
                                                                        .with(
                                                                                text("Stretched link will not work here, because"),
                                                                                code()
                                                                                        .with(
                                                                                                text("position: relative")
                                                                                        ),
                                                                                text("is added to the link")
                                                                        )
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text,Background.bg_body_tertiary)
                                                        .withStyle("transform: rotate(0);")
                                                        .with(
                                                                text("This"),
                                                                a()
                                                                        .withHref("#")
                                                                        .withClasses(Colors.text_warning,StretchedLink.stretched_link)
                                                                        .with(
                                                                                text("stretched link")
                                                                        ),
                                                                text("will only be spread over the"),
                                                                code()
                                                                        .with(
                                                                                text("p")
                                                                        ),
                                                                text("-tag, because a transform is applied to it.")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="card" style="width: 18rem;">
          <img src="..." class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">
              Card with stretched links
            </h5>
            <p class="card-text">
              Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
            </p>
            <p class="card-text">
              <a href="#" class="stretched-link text-danger" style="position: relative;">
                Stretched link will not work here, because
                <code>
                  position: relative
                </code>
                is added to the link
              </a>
            </p>
            <p class="card-text bg-body-tertiary" style="transform: rotate(0);">
              This
              <a href="#" class="text-warning stretched-link">
                stretched link
              </a>
              will only be spread over the
              <code>
                p
              </code>
              -tag, because a transform is applied to it.
            </p>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("identifying-the-containing-block", renderedHtml);

        uiDocumentation.documentSource("identifying-the-containing-block");

    }


}
