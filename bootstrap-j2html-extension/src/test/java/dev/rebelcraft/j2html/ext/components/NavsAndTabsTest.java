package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.ext.utilities.Flex;
import dev.rebelcraft.j2html.ext.utilities.Text;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class NavsAndTabsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void baseNav() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                 .withClasses(NavsTabs.nav)
                 .with(
                    li()
                     .withClasses(NavsTabs.nav_item)
                     .with(
                        a()
                         .withClasses(NavsTabs.nav_link,Pagination.active)
                         .attr(
                            AriaStatesAndProperties.ariaCurrent("page")
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
                         .withClasses(NavsTabs.nav_link,Popovers.disabled)
                         .attr(
                            AriaStatesAndProperties.ariaDisabled("true")
                          )
                         .with(
                            text("Disabled")
                          )
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <ul class="nav">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">
                  Active
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  Link
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
            """, renderedHtml);

        // document
        uiDocumentation.document("base-nav", renderedHtml);

        uiDocumentation.documentSource("base-nav");

    }

    @Test
    void baseNav2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(NavsTabs.nav)
                        .with(
                                a()
                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("page")
                                        )
                                        .withHref("#")
                                        .with(
                                                text("Active")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Link")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Link")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                        .attr(
                                                AriaStatesAndProperties.ariaDisabled("true")
                                        )
                                        .with(
                                                text("Disabled")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="nav">
          <a class="nav-link active" aria-current="page" href="#">
            Active
          </a>
          <a class="nav-link" href="#">
            Link
          </a>
          <a class="nav-link" href="#">
            Link
          </a>
          <a class="nav-link disabled" aria-disabled="true">
            Disabled
          </a>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("base-nav2", renderedHtml);

        uiDocumentation.documentSource("base-nav2");

    }

    @Test
    void horizontalAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav, Flex.justify_content_center)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav justify-content-center">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              Link
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
        """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-alignment", renderedHtml);

        uiDocumentation.documentSource("horizontal-alignment");

    }


    @Test
    void horizontalAlignment2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,Flex.justify_content_end)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav justify-content-end">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              Link
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
        """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-alignment2", renderedHtml);

        uiDocumentation.documentSource("horizontal-alignment2");

    }

    @Test
    void vertical() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,Flex.flex_column)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              Link
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
        """, renderedHtml);

        // document
        uiDocumentation.document("vertical", renderedHtml);

        uiDocumentation.documentSource("vertical");

    }

    @Test
    void vertical2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(NavsTabs.nav,Flex.flex_column)
                        .with(
                                a()
                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("page")
                                        )
                                        .withHref("#")
                                        .with(
                                                text("Active")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Link")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Link")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                        .attr(
                                                AriaStatesAndProperties.ariaDisabled("true")
                                        )
                                        .with(
                                                text("Disabled")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="nav flex-column">
          <a class="nav-link active" aria-current="page" href="#">
            Active
          </a>
          <a class="nav-link" href="#">
            Link
          </a>
          <a class="nav-link" href="#">
            Link
          </a>
          <a class="nav-link disabled" aria-disabled="true">
            Disabled
          </a>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("vertical2", renderedHtml);

        uiDocumentation.documentSource("vertical2");

    }

    @Test
    void tabs() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_tabs)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav nav-tabs">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              Link
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
        """, renderedHtml);

        // document
        uiDocumentation.document("tabs", renderedHtml);

        uiDocumentation.documentSource("tabs");

    }

    @Test
    void pills() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav nav-pills">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              Link
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
        """, renderedHtml);

        // document
        uiDocumentation.document("pills", renderedHtml);

        uiDocumentation.documentSource("pills");

    }

    @Test
    void underline() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_underline)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav nav-underline">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              Link
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
        """, renderedHtml);

        // document
        uiDocumentation.document("underline", renderedHtml);

        uiDocumentation.documentSource("underline");

    }

    @Test
    void fillAndJustify() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills,NavsTabs.nav_fill)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
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
                                                                text("Much longer nav link")
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav nav-pills nav-fill">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              Much longer nav link
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
        """, renderedHtml);

        // document
        uiDocumentation.document("fill-and-justify", renderedHtml);

        uiDocumentation.documentSource("fill-and-justify");

    }

    @Test
    void fillAndJustify2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills,NavsTabs.nav_fill)
                        .with(
                                a()
                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("page")
                                        )
                                        .withHref("#")
                                        .with(
                                                text("Active")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Much longer nav link")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Link")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                        .attr(
                                                AriaStatesAndProperties.ariaDisabled("true")
                                        )
                                        .with(
                                                text("Disabled")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="nav nav-pills nav-fill">
          <a class="nav-link active" aria-current="page" href="#">
            Active
          </a>
          <a class="nav-link" href="#">
            Much longer nav link
          </a>
          <a class="nav-link" href="#">
            Link
          </a>
          <a class="nav-link disabled" aria-disabled="true">
            Disabled
          </a>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("fill-and-justify2", renderedHtml);

        uiDocumentation.documentSource("fill-and-justify2");

    }

    @Test
    void fillAndJustify3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills,NavsTabs.nav_justified)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
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
                                                                text("Much longer nav link")
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav nav-pills nav-justified">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              Much longer nav link
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
        """, renderedHtml);

        // document
        uiDocumentation.document("fill-and-justify3", renderedHtml);

        uiDocumentation.documentSource("fill-and-justify3");

    }

    @Test
    void fillAndJustify4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills,NavsTabs.nav_justified)
                        .with(
                                a()
                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("page")
                                        )
                                        .withHref("#")
                                        .with(
                                                text("Active")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Much longer nav link")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Link")
                                        ),
                                a()
                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                        .attr(
                                                AriaStatesAndProperties.ariaDisabled("true")
                                        )
                                        .with(
                                                text("Disabled")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="nav nav-pills nav-justified">
          <a class="nav-link active" aria-current="page" href="#">
            Active
          </a>
          <a class="nav-link" href="#">
            Much longer nav link
          </a>
          <a class="nav-link" href="#">
            Link
          </a>
          <a class="nav-link disabled" aria-disabled="true">
            Disabled
          </a>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("fill-and-justify4", renderedHtml);

        uiDocumentation.documentSource("fill-and-justify4");

    }

    @Test
    void workingWithFlexUtilities() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills,Flex.flex_column,Flex.flex_sm_row)
                        .with(
                                a()
                                        .withClasses(Flex.flex_sm_fill, Text.text_sm_center,NavsTabs.nav_link,Pagination.active)
                                        .attr(
                                                AriaStatesAndProperties.ariaCurrent("page")
                                        )
                                        .withHref("#")
                                        .with(
                                                text("Active")
                                        ),
                                a()
                                        .withClasses(Flex.flex_sm_fill,Text.text_sm_center,NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Longer nav link")
                                        ),
                                a()
                                        .withClasses(Flex.flex_sm_fill,Text.text_sm_center,NavsTabs.nav_link)
                                        .withHref("#")
                                        .with(
                                                text("Link")
                                        ),
                                a()
                                        .withClasses(Flex.flex_sm_fill,Text.text_sm_center,NavsTabs.nav_link,Popovers.disabled)
                                        .attr(
                                                AriaStatesAndProperties.ariaDisabled("true")
                                        )
                                        .with(
                                                text("Disabled")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="nav nav-pills flex-column flex-sm-row">
          <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="#">
            Active
          </a>
          <a class="flex-sm-fill text-sm-center nav-link" href="#">
            Longer nav link
          </a>
          <a class="flex-sm-fill text-sm-center nav-link" href="#">
            Link
          </a>
          <a class="flex-sm-fill text-sm-center nav-link disabled" aria-disabled="true">
            Disabled
          </a>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("working-with-flex-utilities", renderedHtml);

        uiDocumentation.documentSource("working-with-flex-utilities");

    }


    @Test
    void tabsWithDropdowns() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_tabs)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .withHref("#")
                                                        .with(
                                                                text("Active")
                                                        )
                                        ),
                                li()
                                        .withClasses(NavsTabs.nav_item,Dropdowns.dropdown)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Dropdowns.dropdown_toggle)
                                                        .withData("bs-toggle","dropdown")
                                                        .withHref("#")
                                                        .attr(AriaRoles.roleButton)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .with(
                                                                text("Dropdown")
                                                        ),
                                                ul()
                                                        .withClasses(Dropdowns.dropdown_menu)
                                                        .with(
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Action")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Another action")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Something else here")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                hr()
                                                                                        .withClasses(Dropdowns.dropdown_divider)
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Separated link")
                                                                                        )
                                                                        )
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav nav-tabs">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
              Dropdown
            </a>
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" href="#">
                  Action
                </a>
              </li>
              <li>
                <a class="dropdown-item" href="#">
                  Another action
                </a>
              </li>
              <li>
                <a class="dropdown-item" href="#">
                  Something else here
                </a>
              </li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li>
                <a class="dropdown-item" href="#">
                  Separated link
                </a>
              </li>
            </ul>
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
        """, renderedHtml);

        // document
        uiDocumentation.document("tabs-with-dropdowns", renderedHtml);

        uiDocumentation.documentSource("tabs-with-dropdowns");

    }

    @Test
    void pillsWithDropdowns() throws Exception {

        String renderedHtml = uiDocumentation.render(
                ul()
                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills)
                        .with(
                                li()
                                        .withClasses(NavsTabs.nav_item)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .withHref("#")
                                                        .with(
                                                                text("Active")
                                                        )
                                        ),
                                li()
                                        .withClasses(NavsTabs.nav_item,Dropdowns.dropdown)
                                        .with(
                                                a()
                                                        .withClasses(NavsTabs.nav_link,Dropdowns.dropdown_toggle)
                                                        .withData("bs-toggle","dropdown")
                                                        .withHref("#")
                                                        .attr(AriaRoles.roleButton)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .with(
                                                                text("Dropdown")
                                                        ),
                                                ul()
                                                        .withClasses(Dropdowns.dropdown_menu)
                                                        .with(
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Action")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Another action")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Something else here")
                                                                                        )
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                hr()
                                                                                        .withClasses(Dropdowns.dropdown_divider)
                                                                        ),
                                                                li()
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Separated link")
                                                                                        )
                                                                        )
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
                                                        .withClasses(NavsTabs.nav_link,Popovers.disabled)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaDisabled("true")
                                                        )
                                                        .with(
                                                                text("Disabled")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <ul class="nav nav-pills">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              Active
            </a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
              Dropdown
            </a>
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" href="#">
                  Action
                </a>
              </li>
              <li>
                <a class="dropdown-item" href="#">
                  Another action
                </a>
              </li>
              <li>
                <a class="dropdown-item" href="#">
                  Something else here
                </a>
              </li>
              <li>
                <hr class="dropdown-divider">
              </li>
              <li>
                <a class="dropdown-item" href="#">
                  Separated link
                </a>
              </li>
            </ul>
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
        """, renderedHtml);

        // document
        uiDocumentation.document("pills-with-dropdowns", renderedHtml);

        uiDocumentation.documentSource("pills-with-dropdowns");

    }


}
