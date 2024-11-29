package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.ext.layout.Grid;
import dev.rebelcraft.j2html.ext.utilities.*;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.*;
import static dev.rebelcraft.j2html.ext.aria.AriaRoles.*;
import static dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

class ScrollspyTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void navbar() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                  nav()
                   .withId("navbar-example2")
                   .withClasses(Navbar.navbar,Background.bg_body_tertiary,Spacing.px_3, Spacing.mb_3)
                   .with(
                      a()
                       .withClasses(Navbar.navbar_brand)
                       .withHref("#")
                       .with(
                          text("Navbar")
                        ),
                      ul()
                       .withClasses(NavsTabs.nav,NavsTabs.nav_pills)
                       .with(
                          li()
                           .withClasses(NavsTabs.nav_item)
                           .with(
                              a()
                               .withClasses(NavsTabs.nav_link)
                               .withHref("#scrollspyHeading1")
                               .with(
                                  text("First")
                                )
                            ),
                          li()
                           .withClasses(NavsTabs.nav_item)
                           .with(
                              a()
                               .withClasses(NavsTabs.nav_link)
                               .withHref("#scrollspyHeading2")
                               .with(
                                  text("Second")
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
                                       .withHref("#scrollspyHeading3")
                                       .with(
                                          text("Third")
                                        )
                                    ),
                                  li()
                                   .with(
                                      a()
                                       .withClasses(Dropdowns.dropdown_item)
                                       .withHref("#scrollspyHeading4")
                                       .with(
                                          text("Fourth")
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
                                       .withHref("#scrollspyHeading5")
                                       .with(
                                          text("Fifth")
                                        )
                                    )
                                )
                            )
                        )
                    ),
                  div()
                   .withData("bs-spy","scroll")
                   .withData("bs-target","#navbar-example2")
                   .withData("bs-root-margin","0px 0px -40%")
                   .withData("bs-smooth-scroll","true")
                   .withClasses("scrollspy-example", Background.bg_body_tertiary,Spacing.p_3, Borders.rounded_2)
                   .withTabindex(0)
                   .with(
                      h4()
                       .withId("scrollspyHeading1")
                       .with(
                          text("First heading")
                        ),
                      p()
                       .with(
                          text("...")
                        ),
                      h4()
                       .withId("scrollspyHeading2")
                       .with(
                          text("Second heading")
                        ),
                      p()
                       .with(
                          text("...")
                        ),
                      h4()
                       .withId("scrollspyHeading3")
                       .with(
                          text("Third heading")
                        ),
                      p()
                       .with(
                          text("...")
                        ),
                      h4()
                       .withId("scrollspyHeading4")
                       .with(
                          text("Fourth heading")
                        ),
                      p()
                       .with(
                          text("...")
                        ),
                      h4()
                       .withId("scrollspyHeading5")
                       .with(
                          text("Fifth heading")
                        ),
                      p()
                       .with(
                          text("...")
                        )
                    )
                )
        );

        //language=HTML
        assertEquals("""
            <nav id="navbar-example2" class="navbar bg-body-tertiary px-3 mb-3">
              <a class="navbar-brand" href="#">
                Navbar
              </a>
              <ul class="nav nav-pills">
                <li class="nav-item">
                  <a class="nav-link" href="#scrollspyHeading1">
                    First
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#scrollspyHeading2">
                    Second
                  </a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
                    Dropdown
                  </a>
                  <ul class="dropdown-menu">
                    <li>
                      <a class="dropdown-item" href="#scrollspyHeading3">
                        Third
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#scrollspyHeading4">
                        Fourth
                      </a>
                    </li>
                    <li>
                      <hr class="dropdown-divider">
                    </li>
                    <li>
                      <a class="dropdown-item" href="#scrollspyHeading5">
                        Fifth
                      </a>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
            <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true" class="scrollspy-example bg-body-tertiary p-3 rounded-2" tabindex="0">
              <h4 id="scrollspyHeading1">
                First heading
              </h4>
              <p>
                ...
              </p>
              <h4 id="scrollspyHeading2">
                Second heading
              </h4>
              <p>
                ...
              </p>
              <h4 id="scrollspyHeading3">
                Third heading
              </h4>
              <p>
                ...
              </p>
              <h4 id="scrollspyHeading4">
                Fourth heading
              </h4>
              <p>
                ...
              </p>
              <h4 id="scrollspyHeading5">
                Fifth heading
              </h4>
              <p>
                ...
              </p>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("navbar", renderedHtml);

        uiDocumentation.documentSource("navbar");

    }

    @Test
    void nestedNav() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row)
                        .with(
                                div()
                                        .withClasses(Grid.col_4)
                                        .with(
                                                nav()
                                                        .withId("navbar-example3")
                                                        .withClasses(Sizing.h_100,Flex.flex_column,Flex.align_items_stretch,Spacing.pe_4,Borders.border_end)
                                                        .with(
                                                                nav()
                                                                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills,Flex.flex_column)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                        .withHref("#item-1")
                                                                                        .with(
                                                                                                text("Item 1")
                                                                                        ),
                                                                                nav()
                                                                                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills, Flex.flex_column)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link,Spacing.ms_3,Spacing.my_1)
                                                                                                        .withHref("#item-1-1")
                                                                                                        .with(
                                                                                                                text("Item 1-1")
                                                                                                        ),
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link,Spacing.ms_3,Spacing.my_1)
                                                                                                        .withHref("#item-1-2")
                                                                                                        .with(
                                                                                                                text("Item 1-2")
                                                                                                        )
                                                                                        ),
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                        .withHref("#item-2")
                                                                                        .with(
                                                                                                text("Item 2")
                                                                                        ),
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                        .withHref("#item-3")
                                                                                        .with(
                                                                                                text("Item 3")
                                                                                        ),
                                                                                nav()
                                                                                        .withClasses(NavsTabs.nav,NavsTabs.nav_pills,Flex.flex_column)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link,Spacing.ms_3,Spacing.my_1)
                                                                                                        .withHref("#item-3-1")
                                                                                                        .with(
                                                                                                                text("Item 3-1")
                                                                                                        ),
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link,Spacing.ms_3,Spacing.my_1)
                                                                                                        .withHref("#item-3-2")
                                                                                                        .with(
                                                                                                                text("Item 3-2")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col_8)
                                        .with(
                                                div()
                                                        .withData("bs-spy","scroll")
                                                        .withData("bs-target","#navbar-example3")
                                                        .withData("bs-smooth-scroll","true")
                                                        .withClasses("scrollspy-example-2")
                                                        .withTabindex(0)
                                                        .with(
                                                                div()
                                                                        .withId("item-1")
                                                                        .with(
                                                                                h4()
                                                                                        .with(
                                                                                                text("Item 1")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-1-1")
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Item 1-1")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-1-2")
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Item 1-2")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-2")
                                                                        .with(
                                                                                h4()
                                                                                        .with(
                                                                                                text("Item 2")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-3")
                                                                        .with(
                                                                                h4()
                                                                                        .with(
                                                                                                text("Item 3")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-3-1")
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Item 3-1")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withId("item-3-2")
                                                                        .with(
                                                                                h5()
                                                                                        .with(
                                                                                                text("Item 3-2")
                                                                                        ),
                                                                                p()
                                                                                        .with(
                                                                                                text("...")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="row">
          <div class="col-4">
            <nav id="navbar-example3" class="h-100 flex-column align-items-stretch pe-4 border-end">
              <nav class="nav nav-pills flex-column">
                <a class="nav-link" href="#item-1">
                  Item 1
                </a>
                <nav class="nav nav-pills flex-column">
                  <a class="nav-link ms-3 my-1" href="#item-1-1">
                    Item 1-1
                  </a>
                  <a class="nav-link ms-3 my-1" href="#item-1-2">
                    Item 1-2
                  </a>
                </nav>
                <a class="nav-link" href="#item-2">
                  Item 2
                </a>
                <a class="nav-link" href="#item-3">
                  Item 3
                </a>
                <nav class="nav nav-pills flex-column">
                  <a class="nav-link ms-3 my-1" href="#item-3-1">
                    Item 3-1
                  </a>
                  <a class="nav-link ms-3 my-1" href="#item-3-2">
                    Item 3-2
                  </a>
                </nav>
              </nav>
            </nav>
          </div>
          <div class="col-8">
            <div data-bs-spy="scroll" data-bs-target="#navbar-example3" data-bs-smooth-scroll="true" class="scrollspy-example-2" tabindex="0">
              <div id="item-1">
                <h4>
                  Item 1
                </h4>
                <p>
                  ...
                </p>
              </div>
              <div id="item-1-1">
                <h5>
                  Item 1-1
                </h5>
                <p>
                  ...
                </p>
              </div>
              <div id="item-1-2">
                <h5>
                  Item 1-2
                </h5>
                <p>
                  ...
                </p>
              </div>
              <div id="item-2">
                <h4>
                  Item 2
                </h4>
                <p>
                  ...
                </p>
              </div>
              <div id="item-3">
                <h4>
                  Item 3
                </h4>
                <p>
                  ...
                </p>
              </div>
              <div id="item-3-1">
                <h5>
                  Item 3-1
                </h5>
                <p>
                  ...
                </p>
              </div>
              <div id="item-3-2">
                <h5>
                  Item 3-2
                </h5>
                <p>
                  ...
                </p>
              </div>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("nested-nav", renderedHtml);

        uiDocumentation.documentSource("nested-nav");

    }

    @Test
    void listGroup() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row)
                        .with(
                                div()
                                        .withClasses(Grid.col_4)
                                        .with(
                                                div()
                                                        .withId("list-example")
                                                        .withClasses(ListGroup.list_group)
                                                        .with(
                                                                a()
                                                                        .withClasses(ListGroup.list_group_item,ListGroup.list_group_item_action)
                                                                        .withHref("#list-item-1")
                                                                        .with(
                                                                                text("Item 1")
                                                                        ),
                                                                a()
                                                                        .withClasses(ListGroup.list_group_item,ListGroup.list_group_item_action)
                                                                        .withHref("#list-item-2")
                                                                        .with(
                                                                                text("Item 2")
                                                                        ),
                                                                a()
                                                                        .withClasses(ListGroup.list_group_item,ListGroup.list_group_item_action)
                                                                        .withHref("#list-item-3")
                                                                        .with(
                                                                                text("Item 3")
                                                                        ),
                                                                a()
                                                                        .withClasses(ListGroup.list_group_item,ListGroup.list_group_item_action)
                                                                        .withHref("#list-item-4")
                                                                        .with(
                                                                                text("Item 4")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col_8)
                                        .with(
                                                div()
                                                        .withData("bs-spy","scroll")
                                                        .withData("bs-target","#list-example")
                                                        .withData("bs-smooth-scroll","true")
                                                        .withClasses("scrollspy-example")
                                                        .withTabindex(0)
                                                        .with(
                                                                h4()
                                                                        .withId("list-item-1")
                                                                        .with(
                                                                                text("Item 1")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("list-item-2")
                                                                        .with(
                                                                                text("Item 2")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("list-item-3")
                                                                        .with(
                                                                                text("Item 3")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("list-item-4")
                                                                        .with(
                                                                                text("Item 4")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row">
                  <div class="col-4">
                    <div id="list-example" class="list-group">
                      <a class="list-group-item list-group-item-action" href="#list-item-1">
                        Item 1
                      </a>
                      <a class="list-group-item list-group-item-action" href="#list-item-2">
                        Item 2
                      </a>
                      <a class="list-group-item list-group-item-action" href="#list-item-3">
                        Item 3
                      </a>
                      <a class="list-group-item list-group-item-action" href="#list-item-4">
                        Item 4
                      </a>
                    </div>
                  </div>
                  <div class="col-8">
                    <div data-bs-spy="scroll" data-bs-target="#list-example" data-bs-smooth-scroll="true" class="scrollspy-example" tabindex="0">
                      <h4 id="list-item-1">
                        Item 1
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="list-item-2">
                        Item 2
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="list-item-3">
                        Item 3
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="list-item-4">
                        Item 4
                      </h4>
                      <p>
                        ...
                      </p>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("list-group", renderedHtml);

        uiDocumentation.documentSource("list-group");

    }

    @Test
    void simpleAnchors() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Grid.row)
                        .with(
                                div()
                                        .withClasses(Grid.col_4)
                                        .with(
                                                div()
                                                        .withId("simple-list-example")
                                                        .withClasses(Flex.d_flex,Flex.flex_column,Spacing.gap_2,"simple-list-example-scrollspy",Text.text_center)
                                                        .with(
                                                                a()
                                                                        .withClasses(Spacing.p_1,Borders.rounded)
                                                                        .withHref("#simple-list-item-1")
                                                                        .with(
                                                                                text("Item 1")
                                                                        ),
                                                                a()
                                                                        .withClasses(Spacing.p_1,Borders.rounded)
                                                                        .withHref("#simple-list-item-2")
                                                                        .with(
                                                                                text("Item 2")
                                                                        ),
                                                                a()
                                                                        .withClasses(Spacing.p_1,Borders.rounded)
                                                                        .withHref("#simple-list-item-3")
                                                                        .with(
                                                                                text("Item 3")
                                                                        ),
                                                                a()
                                                                        .withClasses(Spacing.p_1,Borders.rounded)
                                                                        .withHref("#simple-list-item-4")
                                                                        .with(
                                                                                text("Item 4")
                                                                        ),
                                                                a()
                                                                        .withClasses(Spacing.p_1,Borders.rounded)
                                                                        .withHref("#simple-list-item-5")
                                                                        .with(
                                                                                text("Item 5")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Grid.col_8)
                                        .with(
                                                div()
                                                        .withData("bs-spy","scroll")
                                                        .withData("bs-target","#simple-list-example")
                                                        .withData("bs-offset","0")
                                                        .withData("bs-smooth-scroll","true")
                                                        .withClasses("scrollspy-example")
                                                        .withTabindex(0)
                                                        .with(
                                                                h4()
                                                                        .withId("simple-list-item-1")
                                                                        .with(
                                                                                text("Item 1")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("simple-list-item-2")
                                                                        .with(
                                                                                text("Item 2")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("simple-list-item-3")
                                                                        .with(
                                                                                text("Item 3")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("simple-list-item-4")
                                                                        .with(
                                                                                text("Item 4")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        ),
                                                                h4()
                                                                        .withId("simple-list-item-5")
                                                                        .with(
                                                                                text("Item 5")
                                                                        ),
                                                                p()
                                                                        .with(
                                                                                text("...")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row">
                  <div class="col-4">
                    <div id="simple-list-example" class="d-flex flex-column gap-2 simple-list-example-scrollspy text-center">
                      <a class="p-1 rounded" href="#simple-list-item-1">
                        Item 1
                      </a>
                      <a class="p-1 rounded" href="#simple-list-item-2">
                        Item 2
                      </a>
                      <a class="p-1 rounded" href="#simple-list-item-3">
                        Item 3
                      </a>
                      <a class="p-1 rounded" href="#simple-list-item-4">
                        Item 4
                      </a>
                      <a class="p-1 rounded" href="#simple-list-item-5">
                        Item 5
                      </a>
                    </div>
                  </div>
                  <div class="col-8">
                    <div data-bs-spy="scroll" data-bs-target="#simple-list-example" data-bs-offset="0" data-bs-smooth-scroll="true" class="scrollspy-example" tabindex="0">
                      <h4 id="simple-list-item-1">
                        Item 1
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="simple-list-item-2">
                        Item 2
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="simple-list-item-3">
                        Item 3
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="simple-list-item-4">
                        Item 4
                      </h4>
                      <p>
                        ...
                      </p>
                      <h4 id="simple-list-item-5">
                        Item 5
                      </h4>
                      <p>
                        ...
                      </p>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("simple-anchors", renderedHtml);

        uiDocumentation.documentSource("simple-anchors");

    }


}
