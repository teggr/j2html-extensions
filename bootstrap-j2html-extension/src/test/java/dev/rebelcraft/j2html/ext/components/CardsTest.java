package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.ext.content.Images;
import dev.rebelcraft.j2html.ext.content.Typography;
import dev.rebelcraft.j2html.ext.helpers.ColorsAndBackground;
import dev.rebelcraft.j2html.ext.layout.Grid;
import dev.rebelcraft.j2html.ext.layout.Gutters;
import dev.rebelcraft.j2html.ext.utilities.*;
import dev.rebelcraft.uidocs.UiDocumentation;
import j2html.tags.specialized.NavTag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class CardsTest {

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
                      )
                );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
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
                """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void body() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .with(
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                text("This is some text within a card body.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card">
                  <div class="card-body">
                    This is some text within a card body.
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("body", renderedHtml);

        uiDocumentation.documentSource("body");

    }

    @Test
    void titlesTextAndLinks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .withStyle("width: 18rem;")
                        .with(
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Card title")
                                                        ),
                                                h6()
                                                        .withClasses(Card.card_subtitle, Spacing.mb_2, Colors.text_body_secondary)
                                                        .with(
                                                                text("Card subtitle")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Card.card_link)
                                                        .with(
                                                                text("Card link")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Card.card_link)
                                                        .with(
                                                                text("Another link")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <h6 class="card-subtitle mb-2 text-body-secondary">
                      Card subtitle
                    </h6>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                    <a href="#" class="card-link">
                      Card link
                    </a>
                    <a href="#" class="card-link">
                      Another link
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("titles-text-and-links", renderedHtml);

        uiDocumentation.documentSource("titles-text-and-links");

    }

    @Test
    void images() throws Exception {

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
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <img src="..." class="card-img-top" alt="...">
                  <div class="card-body">
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("images", renderedHtml);

        uiDocumentation.documentSource("images");

    }

    @Test
    void listGroup() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .withStyle("width: 18rem;")
                        .with(
                                ul()
                                        .withClasses(Card.list_group,Card.list_group_flush)
                                        .with(
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("An item")
                                                        ),
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("A second item")
                                                        ),
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("A third item")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      An item
                    </li>
                    <li class="list-group-item">
                      A second item
                    </li>
                    <li class="list-group-item">
                      A third item
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("list-group", renderedHtml);

        uiDocumentation.documentSource("list-group");

    }

    @Test
    void listGroup2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .withStyle("width: 18rem;")
                        .with(
                                div()
                                        .withClasses(Card.card_header)
                                        .with(
                                                text("Featured")
                                        ),
                                ul()
                                        .withClasses(Card.list_group,Card.list_group_flush)
                                        .with(
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("An item")
                                                        ),
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("A second item")
                                                        ),
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("A third item")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <div class="card-header">
                    Featured
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      An item
                    </li>
                    <li class="list-group-item">
                      A second item
                    </li>
                    <li class="list-group-item">
                      A third item
                    </li>
                  </ul>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("list-group2", renderedHtml);

        uiDocumentation.documentSource("list-group2");

    }

    @Test
    void listGroup3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .withStyle("width: 18rem;")
                        .with(
                                ul()
                                        .withClasses(Card.list_group,Card.list_group_flush)
                                        .with(
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("An item")
                                                        ),
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("A second item")
                                                        ),
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("A third item")
                                                        )
                                        ),
                                div()
                                        .withClasses(Card.card_footer)
                                        .with(
                                                text("Card footer")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      An item
                    </li>
                    <li class="list-group-item">
                      A second item
                    </li>
                    <li class="list-group-item">
                      A third item
                    </li>
                  </ul>
                  <div class="card-footer">
                    Card footer
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("list-group3", renderedHtml);

        uiDocumentation.documentSource("list-group3");

    }

    @Test
    void kitchenSink() throws Exception {

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
                                                                text("Card title")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        )
                                        ),
                                ul()
                                        .withClasses(Card.list_group,Card.list_group_flush)
                                        .with(
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("An item")
                                                        ),
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("A second item")
                                                        ),
                                                li()
                                                        .withClasses(Card.list_group_item)
                                                        .with(
                                                                text("A third item")
                                                        )
                                        ),
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Card.card_link)
                                                        .with(
                                                                text("Card link")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Card.card_link)
                                                        .with(
                                                                text("Another link")
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
                      Card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                      An item
                    </li>
                    <li class="list-group-item">
                      A second item
                    </li>
                    <li class="list-group-item">
                      A third item
                    </li>
                  </ul>
                  <div class="card-body">
                    <a href="#" class="card-link">
                      Card link
                    </a>
                    <a href="#" class="card-link">
                      Another link
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("kitchen-sink", renderedHtml);

        uiDocumentation.documentSource("kitchen-sink");

    }

    @Test
    void headerAndFooter() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .with(
                                div()
                                        .withClasses(Card.card_header)
                                        .with(
                                                text("Featured")
                                        ),
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Buttons.btn,Buttons.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card">
                  <div class="card-header">
                    Featured
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("header-and-footer", renderedHtml);

        uiDocumentation.documentSource("header-and-footer");

    }

    @Test
    void headerAndFooter2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .with(
                                h5()
                                        .withClasses(Card.card_header)
                                        .with(
                                                text("Featured")
                                        ),
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Buttons.btn,Buttons.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card">
                  <h5 class="card-header">
                    Featured
                  </h5>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("header-and-footer2", renderedHtml);

        uiDocumentation.documentSource("header-and-footer2");

    }

    @Test
    void headerAndFooter3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .with(
                                div()
                                        .withClasses(Card.card_header)
                                        .with(
                                                text("Quote")
                                        ),
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                blockquote()
                                                        .withClasses(Typography.blockquote,Spacing.mb_0)
                                                        .with(
                                                                p()
                                                                        .with(
                                                                                text("A well-known quote, contained in a blockquote element.")
                                                                        ),
                                                                footer()
                                                                        .withClasses(Typography.blockquote_footer)
                                                                        .with(
                                                                                text("Someone famous in"),
                                                                                cite()
                                                                                        .withTitle("Source Title")
                                                                                        .with(
                                                                                                text("Source Title")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card">
                  <div class="card-header">
                    Quote
                  </div>
                  <div class="card-body">
                    <blockquote class="blockquote mb-0">
                      <p>
                        A well-known quote, contained in a blockquote element.
                      </p>
                      <footer class="blockquote-footer">
                        Someone famous in
                        <cite title="Source Title">
                          Source Title
                        </cite>
                      </footer>
                    </blockquote>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("header-and-footer3", renderedHtml);

        uiDocumentation.documentSource("header-and-footer3");

    }

    @Test
    void headerAndFooter4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card, Text.text_center)
                        .with(
                                div()
                                        .withClasses(Card.card_header)
                                        .with(
                                                text("Featured")
                                        ),
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Buttons.btn,Buttons.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        ),
                                div()
                                        .withClasses(Card.card_footer,Colors.text_body_secondary)
                                        .with(
                                                text("2 days ago")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-center">
                  <div class="card-header">
                    Featured
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                  <div class="card-footer text-body-secondary">
                    2 days ago
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("header-and-footer4", renderedHtml);

        uiDocumentation.documentSource("header-and-footer4");

    }

    @Test
    void usingGridMarkup() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row)
                        .with(
                                div()
                                        .withClasses(Grid.col_sm_6,Spacing.mb_3,Spacing.mb_sm_0)
                                        .with(
                                                div()
                                                        .withClasses(Card.card)
                                                        .with(
                                                                div()
                                                                        .withClasses(Card.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Card.card_title)
                                                                                        .with(
                                                                                                text("Special title treatment")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Card.card_text)
                                                                                        .with(
                                                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                                                        ),
                                                                                a()
                                                                                        .withHref("#")
                                                                                        .withClasses(Buttons.btn,Buttons.btn_primary)
                                                                                        .with(
                                                                                                text("Go somewhere")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col_sm_6)
                                        .with(
                                                div()
                                                        .withClasses(Card.card)
                                                        .with(
                                                                div()
                                                                        .withClasses(Card.card_body)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(Card.card_title)
                                                                                        .with(
                                                                                                text("Special title treatment")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Card.card_text)
                                                                                        .with(
                                                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                                                        ),
                                                                                a()
                                                                                        .withHref("#")
                                                                                        .withClasses(Buttons.btn,Buttons.btn_primary)
                                                                                        .with(
                                                                                                text("Go somewhere")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row">
                  <div class="col-sm-6 mb-3 mb-sm-0">
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          Special title treatment
                        </h5>
                        <p class="card-text">
                          With supporting text below as a natural lead-in to additional content.
                        </p>
                        <a href="#" class="btn btn-primary">
                          Go somewhere
                        </a>
                      </div>
                    </div>
                  </div>
                  <div class="col-sm-6">
                    <div class="card">
                      <div class="card-body">
                        <h5 class="card-title">
                          Special title treatment
                        </h5>
                        <p class="card-text">
                          With supporting text below as a natural lead-in to additional content.
                        </p>
                        <a href="#" class="btn btn-primary">
                          Go somewhere
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("using-grid-markup", renderedHtml);

        uiDocumentation.documentSource("using-grid-markup");

    }

    @Test
    void usingUtilities() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Card.card, Sizing.w_75,Spacing.mb_3)
                                .with(
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
                                                                        text("With supporting text below as a natural lead-in to additional content.")
                                                                ),
                                                        a()
                                                                .withHref("#")
                                                                .withClasses(Buttons.btn,Buttons.btn_primary)
                                                                .with(
                                                                        text("Button")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,Sizing.w_50)
                                .with(
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
                                                                        text("With supporting text below as a natural lead-in to additional content.")
                                                                ),
                                                        a()
                                                                .withHref("#")
                                                                .withClasses(Buttons.btn,Buttons.btn_primary)
                                                                .with(
                                                                        text("Button")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="card w-75 mb-3">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Button
                    </a>
                  </div>
                </div>
                <div class="card w-50">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Button
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("using-utilities", renderedHtml);

        uiDocumentation.documentSource("using-utilities");

    }

    @Test
    void usingCustomCSS() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card)
                        .withStyle("width: 18rem;")
                        .with(
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Buttons.btn,Buttons.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("using-custom-css", renderedHtml);

        uiDocumentation.documentSource("using-custom-css");

    }

    @Test
    void textAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Card.card,Spacing.mb_3)
                                .withStyle("width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Special title treatment")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("With supporting text below as a natural lead-in to additional content.")
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
                                .withClasses(Card.card,Text.text_center,Spacing.mb_3)
                                .withStyle("width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Special title treatment")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("With supporting text below as a natural lead-in to additional content.")
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
                                .withClasses(Card.card,Text.text_end)
                                .withStyle("width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_body)
                                                .with(
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Special title treatment")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("With supporting text below as a natural lead-in to additional content.")
                                                                ),
                                                        a()
                                                                .withHref("#")
                                                                .withClasses(Buttons.btn,Buttons.btn_primary)
                                                                .with(
                                                                        text("Go somewhere")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="card mb-3" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                <div class="card text-center mb-3" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                <div class="card text-end" style="width: 18rem;">
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-alignment", renderedHtml);

        uiDocumentation.documentSource("text-alignment");

    }


    @Test
    void navigation() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card,Text.text_center)
                        .with(
                                div()
                                        .withClasses(Card.card_header)
                                        .with(
                                                ul()
                                                        .withClasses(NavsTabs.nav,NavsTabs.nav_tabs,Card.card_header_tabs)
                                                        .with(
                                                                li()
                                                                        .withClasses(NavsTabs.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link,NavsTabs.active)
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaCurrent("true")
                                                                                        )
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Active")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .withClasses(NavsTabs.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .withClasses(NavsTabs.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link,NavsTabs.disabled)
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                                                        )
                                                                                        .with(
                                                                                                text("Disabled")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Buttons.btn,Buttons.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-center">
                  <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs">
                      <li class="nav-item">
                        <a class="nav-link active" aria-current="true" href="#">
                          Active
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">
                          Link
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link disabled" aria-disabled="true">
                          Disabled
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("navigation", renderedHtml);

        uiDocumentation.documentSource("navigation");

    }

    @Test
    void navigation2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card,Text.text_center)
                        .with(
                                div()
                                        .withClasses(Card.card_header)
                                        .with(
                                                ul()
                                                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills,NavsTabs.card_header_pills)
                                                        .with(
                                                                li()
                                                                        .withClasses(NavsTabs.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link,NavsTabs.active)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Active")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .withClasses(NavsTabs.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Link")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .withClasses(NavsTabs.nav_item)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link,NavsTabs.disabled)
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                                                        )
                                                                                        .with(
                                                                                                text("Disabled")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Card.card_body)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Special title treatment")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("With supporting text below as a natural lead-in to additional content.")
                                                        ),
                                                a()
                                                        .withHref("#")
                                                        .withClasses(Buttons.btn,Buttons.btn_primary)
                                                        .with(
                                                                text("Go somewhere")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-center">
                  <div class="card-header">
                    <ul class="nav nav-pills card-header-pills">
                      <li class="nav-item">
                        <a class="nav-link active" href="#">
                          Active
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">
                          Link
                        </a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link disabled" aria-disabled="true">
                          Disabled
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Special title treatment
                    </h5>
                    <p class="card-text">
                      With supporting text below as a natural lead-in to additional content.
                    </p>
                    <a href="#" class="btn btn-primary">
                      Go somewhere
                    </a>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("navigation2", renderedHtml);

        uiDocumentation.documentSource("navigation2");

    }

    @Test
    void imageCaps() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Card.card,Spacing.mb_3)
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
                                                                        text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        small()
                                                                                .withClasses(Colors.text_body_secondary)
                                                                                .with(
                                                                                        text("Last updated 3 mins ago")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card)
                                .with(
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
                                                                        text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        small()
                                                                                .withClasses("text-body-secondary")
                                                                                .with(
                                                                                        text("Last updated 3 mins ago")
                                                                                )
                                                                )
                                                ),
                                        img()
                                                .withSrc("...")
                                                .withClasses(Card.card_img_bottom)
                                                .withAlt("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="card mb-3">
                  <img src="..." class="card-img-top" alt="...">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    </p>
                    <p class="card-text">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </p>
                  </div>
                </div>
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    </p>
                    <p class="card-text">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </p>
                  </div>
                  <img src="..." class="card-img-bottom" alt="...">
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("image-caps", renderedHtml);

        uiDocumentation.documentSource("image-caps");

    }

    @Test
    void imageOverlays() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card,ColorsAndBackground.text_bg_dark)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Card.card_img)
                                        .withAlt("..."),
                                div()
                                        .withClasses(Card.card_img_overlay)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Card title")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                small()
                                                                        .with(
                                                                                text("Last updated 3 mins ago")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card text-bg-dark">
                  <img src="..." class="card-img" alt="...">
                  <div class="card-img-overlay">
                    <h5 class="card-title">
                      Card title
                    </h5>
                    <p class="card-text">
                      This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                    </p>
                    <p class="card-text">
                      <small>
                        Last updated 3 mins ago
                      </small>
                    </p>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("image-overlays", renderedHtml);

        uiDocumentation.documentSource("image-overlays");

    }

    @Test
    void horizontal() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card,Spacing.mb_3)
                        .withStyle("max-width: 540px;")
                        .with(
                                div()
                                        .withClasses(Grid.row, Gutters.g_0)
                                        .with(
                                                div()
                                                        .withClasses(Grid.col_md_4)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Images.img_fluid, Borders.rounded_start)
                                                                        .withAlt("...")
                                                        ),
                                                div()
                                                        .withClasses(Grid.col_md_8)
                                                        .with(
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
                                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        ),
                                                                                p()
                                                                                        .withClasses(Card.card_text)
                                                                                        .with(
                                                                                                small()
                                                                                                        .withClasses("text-body-secondary")
                                                                                                        .with(
                                                                                                                text("Last updated 3 mins ago")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card mb-3" style="max-width: 540px;">
                  <div class="row g-0">
                    <div class="col-md-4">
                      <img src="..." class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                        <p class="card-text">
                          <small class="text-body-secondary">
                            Last updated 3 mins ago
                          </small>
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal", renderedHtml);

        uiDocumentation.documentSource("horizontal");

    }


    @Test
    void backgroundAndColor() throws Exception {

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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Primary card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,ColorsAndBackground.text_bg_secondary,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Secondary card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,ColorsAndBackground.text_bg_success,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Success card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,ColorsAndBackground.text_bg_danger,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Danger card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,ColorsAndBackground.text_bg_warning,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Warning card title")
                                                                ),
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Info card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,ColorsAndBackground.text_bg_light,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Light card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,ColorsAndBackground.text_bg_dark,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Dark card title")
                                                                ),
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
                    <h5 class="card-title">
                      Primary card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-secondary mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Secondary card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-success mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Success card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-danger mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Danger card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-warning mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Warning card title
                    </h5>
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
                    <h5 class="card-title">
                      Info card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-light mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Light card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card text-bg-dark mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Dark card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("background-and-color", renderedHtml);

        uiDocumentation.documentSource("background-and-color");

    }

    @Test
    void border() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Card.card,Borders.border_primary,Spacing.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Card.card_body,Colors.text_primary)
                                                .with(
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Primary card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,Borders.border_secondary,Spacing.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Card.card_body,Colors.text_secondary)
                                                .with(
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Secondary card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,Borders.border_success,Spacing.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Card.card_body,Colors.text_success)
                                                .with(
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Success card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,Borders.border_danger,Spacing.mb_3)
                                .withStyle("max-width: 18rem;")
                                .with(
                                        div()
                                                .withClasses(Card.card_header)
                                                .with(
                                                        text("Header")
                                                ),
                                        div()
                                                .withClasses(Card.card_body,Colors.text_danger)
                                                .with(
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Danger card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,Borders.border_warning,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Warning card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,Borders.border_info,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Info card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,Borders.border_light,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Light card title")
                                                                ),
                                                        p()
                                                                .withClasses(Card.card_text)
                                                                .with(
                                                                        text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Card.card,Borders.border_dark,Spacing.mb_3)
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
                                                        h5()
                                                                .withClasses(Card.card_title)
                                                                .with(
                                                                        text("Dark card title")
                                                                ),
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
                <div class="card border-primary mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body text-primary">
                    <h5 class="card-title">
                      Primary card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-secondary mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body text-secondary">
                    <h5 class="card-title">
                      Secondary card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-success mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body text-success">
                    <h5 class="card-title">
                      Success card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-danger mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body text-danger">
                    <h5 class="card-title">
                      Danger card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-warning mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Warning card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-info mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Info card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-light mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Light card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                <div class="card border-dark mb-3" style="max-width: 18rem;">
                  <div class="card-header">
                    Header
                  </div>
                  <div class="card-body">
                    <h5 class="card-title">
                      Dark card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("border", renderedHtml);

        uiDocumentation.documentSource("border");

    }

    @Test
    void mixinUtilities() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card,Borders.border_success,Spacing.mb_3)
                        .withStyle("max-width: 18rem;")
                        .with(
                                div()
                                        .withClasses(Card.card_header,Background.bg_transparent,Borders.border_success)
                                        .with(
                                                text("Header")
                                        ),
                                div()
                                        .withClasses(Card.card_body,Colors.text_success)
                                        .with(
                                                h5()
                                                        .withClasses(Card.card_title)
                                                        .with(
                                                                text("Success card title")
                                                        ),
                                                p()
                                                        .withClasses(Card.card_text)
                                                        .with(
                                                                text("Some quick example text to build on the card title and make up the bulk of the card's content.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Card.card_footer,Background.bg_transparent,Borders.border_success)
                                        .with(
                                                text("Footer")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card border-success mb-3" style="max-width: 18rem;">
                  <div class="card-header bg-transparent border-success">
                    Header
                  </div>
                  <div class="card-body text-success">
                    <h5 class="card-title">
                      Success card title
                    </h5>
                    <p class="card-text">
                      Some quick example text to build on the card title and make up the bulk of the card&#x27;s content.
                    </p>
                  </div>
                  <div class="card-footer bg-transparent border-success">
                    Footer
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("mixin-utilities", renderedHtml);

        uiDocumentation.documentSource("mixin-utilities");

    }

    @Test
    void cardLayout() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card_group)
                        .with(
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
                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                        ),
                                                                p()
                                                                        .withClasses(Card.card_text)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Colors.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        ),
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
                                                                                text("This card has supporting text below as a natural lead-in to additional content.")
                                                                        ),
                                                                p()
                                                                        .withClasses(Card.card_text)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Colors.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        ),
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
                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.")
                                                                        ),
                                                                p()
                                                                        .withClasses(Card.card_text)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Colors.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card-group">
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                      </p>
                      <p class="card-text">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </p>
                    </div>
                  </div>
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This card has supporting text below as a natural lead-in to additional content.
                      </p>
                      <p class="card-text">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </p>
                    </div>
                  </div>
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.
                      </p>
                      <p class="card-text">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </p>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("card-layout", renderedHtml);

        uiDocumentation.documentSource("card-layout");

    }

    @Test
    void cardLayout2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Card.card_group)
                        .with(
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
                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Card.card_footer)
                                                        .with(
                                                                small()
                                                                        .withClasses(Colors.text_body_secondary)
                                                                        .with(
                                                                                text("Last updated 3 mins ago")
                                                                        )
                                                        )
                                        ),
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
                                                                                text("This card has supporting text below as a natural lead-in to additional content.")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Card.card_footer)
                                                        .with(
                                                                small()
                                                                        .withClasses(Colors.text_body_secondary)
                                                                        .with(
                                                                                text("Last updated 3 mins ago")
                                                                        )
                                                        )
                                        ),
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
                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Card.card_footer)
                                                        .with(
                                                                small()
                                                                        .withClasses(Colors.text_body_secondary)
                                                                        .with(
                                                                                text("Last updated 3 mins ago")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="card-group">
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                      </p>
                    </div>
                    <div class="card-footer">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </div>
                  </div>
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This card has supporting text below as a natural lead-in to additional content.
                      </p>
                    </div>
                    <div class="card-footer">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </div>
                  </div>
                  <div class="card">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                      <h5 class="card-title">
                        Card title
                      </h5>
                      <p class="card-text">
                        This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.
                      </p>
                    </div>
                    <div class="card-footer">
                      <small class="text-body-secondary">
                        Last updated 3 mins ago
                      </small>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("card-layout2", renderedHtml);

        uiDocumentation.documentSource("card-layout2");

    }

    @Test
    void gridCards() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row,Grid.row_cols_1,Grid.row_cols_md_2,Gutters.g_4)
                        .with(
                                div()
                                        .withClasses(Grid.col)
                                        .with(
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row row-cols-1 row-cols-md-2 g-4">
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-cards", renderedHtml);

        uiDocumentation.documentSource("grid-cards");

    }

    @Test
    void gridCards2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row,Grid.row_cols_1,Grid.row_cols_md_3,Gutters.g_4)
                        .with(
                                div()
                                        .withClasses(Grid.col)
                                        .with(
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row row-cols-1 row-cols-md-3 g-4">
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-cards2", renderedHtml);

        uiDocumentation.documentSource("grid-cards2");

    }

    @Test
    void gridCards3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row,Grid.row_cols_1,Grid.row_cols_md_3,Gutters.g_4)
                        .with(
                                div()
                                        .withClasses(Grid.col)
                                        .with(
                                                div()
                                                        .withClasses(Card.card,Sizing.h_100)
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
                                                div()
                                                        .withClasses(Card.card,Sizing.h_100)
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
                                                                                                text("This is a short card.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
                                                div()
                                                        .withClasses(Card.card,Sizing.h_100)
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content.")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
                                                div()
                                                        .withClasses(Card.card,Sizing.h_100)
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
                                                                                                text("This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row row-cols-1 row-cols-md-3 g-4">
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a short card.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content.
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-cards3", renderedHtml);

        uiDocumentation.documentSource("grid-cards3");

    }

    @Test
    void gridCards4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row,Grid.row_cols_1,Grid.row_cols_md_3,Gutters.g_4)
                        .with(
                                div()
                                        .withClasses(Grid.col)
                                        .with(
                                                div()
                                                        .withClasses(Card.card,Sizing.h_100)
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
                                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Card.card_footer)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Colors.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
                                                div()
                                                        .withClasses(Card.card,Sizing.h_100)
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
                                                                                                text("This card has supporting text below as a natural lead-in to additional content.")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Card.card_footer)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Colors.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col)
                                        .with(
                                                div()
                                                        .withClasses(Card.card,Sizing.h_100)
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
                                                                                                text("This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Card.card_footer)
                                                                        .with(
                                                                                small()
                                                                                        .withClasses(Colors.text_body_secondary)
                                                                                        .with(
                                                                                                text("Last updated 3 mins ago")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row row-cols-1 row-cols-md-3 g-4">
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This card has supporting text below as a natural lead-in to additional content.
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card h-100">
                      <img src="..." class="card-img-top" alt="...">
                      <div class="card-body">
                        <h5 class="card-title">
                          Card title
                        </h5>
                        <p class="card-text">
                          This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.
                        </p>
                      </div>
                      <div class="card-footer">
                        <small class="text-body-secondary">
                          Last updated 3 mins ago
                        </small>
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("grid-cards4", renderedHtml);

        uiDocumentation.documentSource("grid-cards4");

    }


}
