package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.ext.content.Typography;
import dev.rebelcraft.j2html.ext.forms.FormControl;
import dev.rebelcraft.j2html.ext.forms.InputGroups;
import dev.rebelcraft.j2html.ext.helpers.ColorsAndBackground;
import dev.rebelcraft.j2html.ext.helpers.Position;
import dev.rebelcraft.j2html.ext.layout.Containers;
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

class NavbarTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void supportedContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                 .withClasses(Navbar.navbar,Navbar.navbar_expand_lg, Background.bg_body_tertiary)
                 .with(
                    div()
                     .withClasses(Containers.container_fluid)
                     .with(
                        a()
                         .withClasses(Navbar.navbar_brand)
                         .withHref("#")
                         .with(
                            text("Navbar")
                          ),
                        button()
                         .withClasses(Navbar.navbar_toggler)
                         .withType("button")
                         .withData("bs-toggle","collapse")
                         .withData("bs-target","#navbarSupportedContent")
                         .attr(
                            AriaStatesAndProperties.ariaControls("navbarSupportedContent")
                          )
                         .attr(
                            AriaStatesAndProperties.ariaExpanded("false")
                          )
                         .attr(
                            AriaStatesAndProperties.ariaLabel("Toggle navigation")
                          )
                         .with(
                            span()
                             .withClasses(Navbar.navbar_toggler_icon)
                          ),
                        div()
                         .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                         .withId("navbarSupportedContent")
                         .with(
                            ul()
                             .withClasses(Navbar.navbar_nav, Spacing.me_auto,Spacing.mb_2,Spacing.mb_lg_0)
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
                                        text("Home")
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
                                 .withClasses(NavsTabs.nav_item,Dropdowns.dropdown)
                                 .with(
                                    a()
                                     .withClasses(NavsTabs.nav_link,Dropdowns.dropdown_toggle)
                                     .withHref("#")
                                     .attr(AriaRoles.roleButton)
                                     .withData("bs-toggle","dropdown")
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
                                            hr()
                                             .withClasses(Dropdowns.dropdown_divider)
                                          ),
                                        li()
                                         .with(
                                            a()
                                             .withClasses(Dropdowns.dropdown_item)
                                             .withHref("#")
                                             .with(
                                                text("Something else here")
                                              )
                                          )
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
                              ),
                            form()
                             .withClasses(Flex.d_flex)
                             .attr(AriaRoles.roleSearch)
                             .with(
                                input()
                                 .withClasses(FormControl.form_control,Spacing.me_2)
                                 .withType("search")
                                 .withPlaceholder("Search")
                                 .attr(
                                    AriaStatesAndProperties.ariaLabel("Search")
                                  ),
                                button()
                                 .withClasses(Buttons.btn,Buttons.btn_outline_success)
                                 .withType("submit")
                                 .with(
                                    text("Search")
                                  )
                              )
                          )
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
              <div class="container-fluid">
                <a class="navbar-brand" href="#">
                  Navbar
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon">
                  </span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                      <a class="nav-link active" aria-current="page" href="#">
                        Home
                      </a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">
                        Link
                      </a>
                    </li>
                    <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
                          <hr class="dropdown-divider">
                        </li>
                        <li>
                          <a class="dropdown-item" href="#">
                            Something else here
                          </a>
                        </li>
                      </ul>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link disabled" aria-disabled="true">
                        Disabled
                      </a>
                    </li>
                  </ul>
                  <form class="d-flex" role="search">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">
                      Search
                    </button>
                  </form>
                </div>
              </div>
            </nav>
            """, renderedHtml);

        // document
        uiDocumentation.document("supported-content", renderedHtml);

        uiDocumentation.documentSource("supported-content");

    }

    @Test
    void textTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        nav()
                                .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                                .with(
                                        div()
                                                .withClasses(Containers.container_fluid)
                                                .with(
                                                        a()
                                                                .withClasses(Navbar.navbar_brand)
                                                                .withHref("#")
                                                                .with(
                                                                        text("Navbar")
                                                                )
                                                )
                                ),
                        comment("As a heading"),
                        nav()
                                .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                                .with(
                                        div()
                                                .withClasses(Containers.container_fluid)
                                                .with(
                                                        span()
                                                                .withClasses(Navbar.navbar_brand,Spacing.mb_0, Typography.h1)
                                                                .with(
                                                                        text("Navbar")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <nav class="navbar bg-body-tertiary">
                  <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                      Navbar
                    </a>
                  </div>
                </nav>
                <!-- As a heading -->
                <nav class="navbar bg-body-tertiary">
                  <div class="container-fluid">
                    <span class="navbar-brand mb-0 h1">
                      Navbar
                    </span>
                  </div>
                </nav>
                """, renderedHtml);

        // document
        uiDocumentation.document("text", renderedHtml);

        uiDocumentation.documentSource("text");

    }

    @Test
    void imageTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                img()
                                                                        .withSrc("/docs/5.3/assets/brand/bootstrap-logo.svg")
                                                                        .withAlt("Bootstrap")
                                                                        .attr("width","30")
                                                                        .attr("height","24")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container">
            <a class="navbar-brand" href="#">
              <img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Bootstrap" width="30" height="24">
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("image-test", renderedHtml);

        uiDocumentation.documentSource("image-test");

    }

    @Test
    void imageAndText() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                img()
                                                                        .withSrc("/docs/5.3/assets/brand/bootstrap-logo.svg")
                                                                        .withAlt("Logo")
                                                                        .attr("width","30")
                                                                        .attr("height","24")
                                                                        .withClasses(Display.d_inline_block, VerticalAlign.align_text_top),
                                                                text("Bootstrap")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              <img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
              Bootstrap
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("image-and-text", renderedHtml);

        uiDocumentation.documentSource("image-and-text");

    }

    @Test
    void navTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarNav")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarNav")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                                                        .withId("navbarNav")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Navbar.navbar_nav)
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
                                                                                                                text("Home")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(NavsTabs.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Features")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(NavsTabs.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Pricing")
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
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Features
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Pricing
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link disabled" aria-disabled="true">
                    Disabled
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("nav-test", renderedHtml);

        uiDocumentation.documentSource("nav-test");

    }

    @Test
    void navTest2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarNavAltMarkup")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarNavAltMarkup")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                                                        .withId("navbarNavAltMarkup")
                                                        .with(
                                                                div()
                                                                        .withClasses(Navbar.navbar_nav)
                                                                        .with(
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link,Pagination.active)
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                                                        )
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Home")
                                                                                        ),
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Features")
                                                                                        ),
                                                                                a()
                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                        .withHref("#")
                                                                                        .with(
                                                                                                text("Pricing")
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
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="#">
                  Home
                </a>
                <a class="nav-link" href="#">
                  Features
                </a>
                <a class="nav-link" href="#">
                  Pricing
                </a>
                <a class="nav-link disabled" aria-disabled="true">
                  Disabled
                </a>
              </div>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("nav-test2", renderedHtml);

        uiDocumentation.documentSource("nav-test2");

    }

    @Test
    void navTest3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarNavDropdown")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarNavDropdown")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                                                        .withId("navbarNavDropdown")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Navbar.navbar_nav)
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
                                                                                                                text("Home")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(NavsTabs.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Features")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(NavsTabs.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Pricing")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(NavsTabs.nav_item,Dropdowns.dropdown)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link,Dropdowns.dropdown_toggle)
                                                                                                        .withHref("#")
                                                                                                        .attr(AriaRoles.roleButton)
                                                                                                        .withData("bs-toggle","dropdown")
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                                                        )
                                                                                                        .with(
                                                                                                                text("Dropdown link")
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
                                                                                                                        )
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Features
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Pricing
                  </a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Dropdown link
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
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("nav-test2", renderedHtml);

        uiDocumentation.documentSource("nav-test2");

    }

    @Test
    void forms() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                form()
                                                        .withClasses(Flex.d_flex)
                                                        .attr(AriaRoles.roleSearch)
                                                        .with(
                                                                input()
                                                                        .withClasses(FormControl.form_control,Spacing.me_2)
                                                                        .withType("search")
                                                                        .withPlaceholder("Search")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                        ),
                                                                button()
                                                                        .withClasses(Buttons.btn,Buttons.btn_outline_success)
                                                                        .withType("submit")
                                                                        .with(
                                                                                text("Search")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("forms", renderedHtml);

        uiDocumentation.documentSource("forms");

    }

    @Test
    void forms2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                form()
                                                        .withClasses(Flex.d_flex)
                                                        .attr(AriaRoles.roleSearch)
                                                        .with(
                                                                input()
                                                                        .withClasses(FormControl.form_control,Spacing.me_2)
                                                                        .withType("search")
                                                                        .withPlaceholder("Search")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                        ),
                                                                button()
                                                                        .withClasses(Buttons.btn,Buttons.btn_outline_success)
                                                                        .withType("submit")
                                                                        .with(
                                                                                text("Search")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand">
              Navbar
            </a>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">
                Search
              </button>
            </form>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("forms2", renderedHtml);

        uiDocumentation.documentSource("forms2");

    }

    @Test
    void forms3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                        .with(
                                form()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                div()
                                                        .withClasses(InputGroups.input_group)
                                                        .with(
                                                                span()
                                                                        .withClasses(InputGroups.input_group_text)
                                                                        .withId("basic-addon1")
                                                                        .with(
                                                                                text("@")
                                                                        ),
                                                                input()
                                                                        .withType("text")
                                                                        .withClasses(FormControl.form_control)
                                                                        .withPlaceholder("Username")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Username")
                                                                        )
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaDescribedby("basic-addon1")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <nav class="navbar bg-body-tertiary">
              <form class="container-fluid">
                <div class="input-group">
                  <span class="input-group-text" id="basic-addon1">
                    @
                  </span>
                  <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
              </form>
            </nav>
            """, renderedHtml);

        // document
        uiDocumentation.document("forms3", renderedHtml);

        uiDocumentation.documentSource("forms3");

    }

    @Test
    void forms4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                        .with(
                                form()
                                        .withClasses(Containers.container_fluid,Flex.justify_content_start)
                                        .with(
                                                button()
                                                        .withClasses(Buttons.btn,Buttons.btn_outline_success,Spacing.me_2)
                                                        .withType("button")
                                                        .with(
                                                                text("Main button")
                                                        ),
                                                button()
                                                        .withClasses(Buttons.btn,Buttons.btn_sm,Buttons.btn_outline_secondary)
                                                        .withType("button")
                                                        .with(
                                                                text("Smaller button")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <form class="container-fluid justify-content-start">
            <button class="btn btn-outline-success me-2" type="button">
              Main button
            </button>
            <button class="btn btn-sm btn-outline-secondary" type="button">
              Smaller button
            </button>
          </form>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("forms4", renderedHtml);

        uiDocumentation.documentSource("forms4");

    }

    @Test
    void text2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                span()
                                                        .withClasses(Navbar.navbar_text)
                                                        .with(
                                                                text("Navbar text with an inline element")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <span class="navbar-text">
              Navbar text with an inline element
            </span>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("text2", renderedHtml);

        uiDocumentation.documentSource("text2");

    }

    @Test
    void text3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar w/ text")
                                                        ),
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarText")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarText")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                                                        .withId("navbarText")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Navbar.navbar_nav,Spacing.me_auto,Spacing.mb_2,Spacing.mb_lg_0)
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
                                                                                                                text("Home")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(NavsTabs.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Features")
                                                                                                        )
                                                                                        ),
                                                                                li()
                                                                                        .withClasses(NavsTabs.nav_item)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link)
                                                                                                        .withHref("#")
                                                                                                        .with(
                                                                                                                text("Pricing")
                                                                                                        )
                                                                                        )
                                                                        ),
                                                                span()
                                                                        .withClasses(Navbar.navbar_text)
                                                                        .with(
                                                                                text("Navbar text with an inline element")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar w/ text
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Features
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Pricing
                  </a>
                </li>
              </ul>
              <span class="navbar-text">
                Navbar text with an inline element
              </span>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("text3", renderedHtml);

        uiDocumentation.documentSource("text3");

    }

    @Test
    void colorSchemes() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        nav()
                                .withClasses(Navbar.navbar,Background.bg_dark,Borders.border_bottom,Borders.border_body)
                                .withData("bs-theme","dark")
                                .with(
                                        comment("Navbar content")
                                ),
                        nav()
                                .withClasses(Navbar.navbar,Background.bg_primary)
                                .withData("bs-theme","dark")
                                .with(
                                        comment("Navbar content")
                                ),
                        nav()
                                .withClasses(Navbar.navbar)
                                .withStyle("background-color: #e3f2fd;")
                                .with(
                                        comment("Navbar content")
                                )
                )
        );

        //language=HTML
        assertEquals("""
            <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
              <!-- Navbar content -->
            </nav>
            <nav class="navbar bg-primary" data-bs-theme="dark">
              <!-- Navbar content -->
            </nav>
            <nav class="navbar" style="background-color: #e3f2fd;">
              <!-- Navbar content -->
            </nav>
            """, renderedHtml);

        // document
        uiDocumentation.document("color-schemes", renderedHtml);

        uiDocumentation.documentSource("color-schemes");

    }

    @Test
    void containersTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        nav()
                                .withClasses(Navbar.navbar,Background.bg_dark,Borders.border_bottom,"border-body")
                                .withData("bs-theme","dark")
                                .with(
                                        comment("Navbar content")
                                ),
                        nav()
                                .withClasses(Navbar.navbar,Background.bg_primary)
                                .withData("bs-theme","dark")
                                .with(
                                        comment("Navbar content")
                                ),
                        nav()
                                .withClasses(Navbar.navbar)
                                .withStyle("background-color: #e3f2fd;")
                                .with(
                                        comment("Navbar content")
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
          <!-- Navbar content -->
        </nav>
        <nav class="navbar bg-primary" data-bs-theme="dark">
          <!-- Navbar content -->
        </nav>
        <nav class="navbar" style="background-color: #e3f2fd;">
          <!-- Navbar content -->
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("containers-test", renderedHtml);

        uiDocumentation.documentSource("containers-test");

    }

    @Test
    void containersTest2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_md)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-md">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("containers-test2", renderedHtml);

        uiDocumentation.documentSource("containers-test2");

    }

    @Test
    void placement1() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Default")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Default
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement1", renderedHtml);

        uiDocumentation.documentSource("placement1");

    }

    @Test
    void placement2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar, Position.fixed_top,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Fixed top")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar fixed-top bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Fixed top
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement2", renderedHtml);

        uiDocumentation.documentSource("placement2");

    }

    @Test
    void placement3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Position.fixed_bottom,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Fixed bottom")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar fixed-bottom bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Fixed bottom
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement3", renderedHtml);

        uiDocumentation.documentSource("placement3");

    }

    @Test
    void placement4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Position.sticky_top,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Sticky top")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar sticky-top bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Sticky top
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement4", renderedHtml);

        uiDocumentation.documentSource("placement4");

    }

    @Test
    void placement5() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Position.sticky_bottom,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Sticky bottom")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar sticky-bottom bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Sticky bottom
            </a>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement5", renderedHtml);

        uiDocumentation.documentSource("placement5");

    }

    @Test
    void scrolling() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar scroll")
                                                        ),
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarScroll")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarScroll")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                                                        .withId("navbarScroll")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Navbar.navbar_nav,Spacing.me_auto,Spacing.my_2,Spacing.my_lg_0,Navbar.navbar_nav_scroll)
                                                                        .withStyle("--bs-scroll-height: 100px;")
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
                                                                                                                text("Home")
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
                                                                                        .withClasses(NavsTabs.nav_item,Dropdowns.dropdown)
                                                                                        .with(
                                                                                                a()
                                                                                                        .withClasses(NavsTabs.nav_link,Dropdowns.dropdown_toggle)
                                                                                                        .withHref("#")
                                                                                                        .attr(AriaRoles.roleButton)
                                                                                                        .withData("bs-toggle","dropdown")
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                                                        )
                                                                                                        .with(
                                                                                                                text("Link")
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
                                                                                                                                hr()
                                                                                                                                        .withClasses(Dropdowns.dropdown_divider)
                                                                                                                        ),
                                                                                                                li()
                                                                                                                        .with(
                                                                                                                                a()
                                                                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                                                                        .withHref("#")
                                                                                                                                        .with(
                                                                                                                                                text("Something else here")
                                                                                                                                        )
                                                                                                                        )
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
                                                                                                                text("Link")
                                                                                                        )
                                                                                        )
                                                                        ),
                                                                form()
                                                                        .withClasses(Flex.d_flex)
                                                                        .attr(AriaRoles.roleSearch)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(FormControl.form_control,Spacing.me_2)
                                                                                        .withType("search")
                                                                                        .withPlaceholder("Search")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                        ),
                                                                                button()
                                                                                        .withClasses(Buttons.btn,Buttons.btn_outline_success)
                                                                                        .withType("submit")
                                                                                        .with(
                                                                                                text("Search")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar scroll
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
              <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Link
                  </a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Link
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
                      <hr class="dropdown-divider">
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        Something else here
                      </a>
                    </li>
                  </ul>
                </li>
                <li class="nav-item">
                  <a class="nav-link disabled" aria-disabled="true">
                    Link
                  </a>
                </li>
              </ul>
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("scrolling", renderedHtml);

        uiDocumentation.documentSource("scrolling");

    }

    @Test
    void toggler() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarTogglerDemo01")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarTogglerDemo01")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                                                        .withId("navbarTogglerDemo01")
                                                        .with(
                                                                a()
                                                                        .withClasses(Navbar.navbar_brand)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Hidden brand")
                                                                        ),
                                                                ul()
                                                                        .withClasses(Navbar.navbar_nav,Spacing.me_auto,Spacing.mb_2,"mb-lg-0")
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
                                                                                                                text("Home")
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
                                                                        ),
                                                                form()
                                                                        .withClasses(Flex.d_flex)
                                                                        .attr(AriaRoles.roleSearch)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(FormControl.form_control,Spacing.me_2)
                                                                                        .withType("search")
                                                                                        .withPlaceholder("Search")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                        ),
                                                                                button()
                                                                                        .withClasses(Buttons.btn,Buttons.btn_outline_success)
                                                                                        .withType("submit")
                                                                                        .with(
                                                                                                text("Search")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
              <a class="navbar-brand" href="#">
                Hidden brand
              </a>
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
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
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("toggler", renderedHtml);

        uiDocumentation.documentSource("toggler");

    }


    @Test
    void toggler2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarTogglerDemo02")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarTogglerDemo02")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                                                        .withId("navbarTogglerDemo02")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Navbar.navbar_nav,Spacing.me_auto,Spacing.mb_2,Spacing.mb_lg_0)
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
                                                                                                                text("Home")
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
                                                                        ),
                                                                form()
                                                                        .withClasses(Flex.d_flex)
                                                                        .attr(AriaRoles.roleSearch)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(FormControl.form_control,Spacing.me_2)
                                                                                        .withType("search")
                                                                                        .withPlaceholder("Search")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                        ),
                                                                                button()
                                                                                        .withClasses(Buttons.btn,Buttons.btn_outline_success)
                                                                                        .withType("submit")
                                                                                        .with(
                                                                                                text("Search")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
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
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("toggler2", renderedHtml);

        uiDocumentation.documentSource("toggler2");

    }

    @Test
    void toggler3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","collapse")
                                                        .withData("bs-target","#navbarTogglerDemo03")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("navbarTogglerDemo03")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Navbar")
                                                        ),
                                                div()
                                                        .withClasses(Collapse.collapse,Navbar.navbar_collapse)
                                                        .withId("navbarTogglerDemo03")
                                                        .with(
                                                                ul()
                                                                        .withClasses(Navbar.navbar_nav,Spacing.me_auto,Spacing.mb_2,"mb-lg-0")
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
                                                                                                                text("Home")
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
                                                                        ),
                                                                form()
                                                                        .withClasses(Flex.d_flex)
                                                                        .attr(AriaRoles.roleSearch)
                                                                        .with(
                                                                                input()
                                                                                        .withClasses(FormControl.form_control,Spacing.me_2)
                                                                                        .withType("search")
                                                                                        .withPlaceholder("Search")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                        ),
                                                                                button()
                                                                                        .withClasses(Buttons.btn,Buttons.btn_outline_success)
                                                                                        .withType("submit")
                                                                                        .with(
                                                                                                text("Search")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
          <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <a class="navbar-brand" href="#">
              Navbar
            </a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Home
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
              <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("toggler3", renderedHtml);

        uiDocumentation.documentSource("toggler3");

    }

    @Test
    void externalContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Collapse.collapse)
                                .withId("navbarToggleExternalContent")
                                .withData("bs-theme","dark")
                                .with(
                                        div()
                                                .withClasses(Background.bg_dark,Spacing.p_4)
                                                .with(
                                                        h5()
                                                                .withClasses(Colors.text_body_emphasis,Typography.h4)
                                                                .with(
                                                                        text("Collapsed content")
                                                                ),
                                                        span()
                                                                .withClasses(Colors.text_body_secondary)
                                                                .with(
                                                                        text("Toggleable via the navbar brand.")
                                                                )
                                                )
                                ),
                        nav()
                                .withClasses(Navbar.navbar,Navbar.navbar_dark,Background.bg_dark)
                                .with(
                                        div()
                                                .withClasses(Containers.container_fluid)
                                                .with(
                                                        button()
                                                                .withClasses(Navbar.navbar_toggler)
                                                                .withType("button")
                                                                .withData("bs-toggle","collapse")
                                                                .withData("bs-target","#navbarToggleExternalContent")
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaControls("navbarToggleExternalContent")
                                                                )
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaExpanded("false")
                                                                )
                                                                .attr(
                                                                        AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                                )
                                                                .with(
                                                                        span()
                                                                                .withClasses(Navbar.navbar_toggler_icon)
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <div class="collapse" id="navbarToggleExternalContent" data-bs-theme="dark">
          <div class="bg-dark p-4">
            <h5 class="text-body-emphasis h4">
              Collapsed content
            </h5>
            <span class="text-body-secondary">
              Toggleable via the navbar brand.
            </span>
          </div>
        </div>
        <nav class="navbar navbar-dark bg-dark">
          <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("external-content", renderedHtml);

        uiDocumentation.documentSource("external-content");

    }

    @Test
    void offcanvasNavbar() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Background.bg_body_tertiary,Position.fixed_top)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Offcanvas navbar")
                                                        ),
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","offcanvas")
                                                        .withData("bs-target","#offcanvasNavbar")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("offcanvasNavbar")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(OffCanvas.offcanvas,OffCanvas.offcanvas_end)
                                                        .withTabindex(-1)
                                                        .withId("offcanvasNavbar")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabelledby("offcanvasNavbarLabel")
                                                        )
                                                        .with(
                                                                div()
                                                                        .withClasses(OffCanvas.offcanvas_header)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(OffCanvas.offcanvas_title)
                                                                                        .withId("offcanvasNavbarLabel")
                                                                                        .with(
                                                                                                text("Offcanvas")
                                                                                        ),
                                                                                button()
                                                                                        .withType("button")
                                                                                        .withClasses(CloseButton.btn_close)
                                                                                        .withData("bs-dismiss","offcanvas")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(OffCanvas.offcanvas_body)
                                                                        .with(
                                                                                ul()
                                                                                        .withClasses(Navbar.navbar_nav,Flex.justify_content_end,Flex.flex_grow_1,Spacing.pe_3)
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
                                                                                                                                text("Home")
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
                                                                                                        .withClasses(NavsTabs.nav_item,Dropdowns.dropdown)
                                                                                                        .with(
                                                                                                                a()
                                                                                                                        .withClasses(NavsTabs.nav_link,Dropdowns.dropdown_toggle)
                                                                                                                        .withHref("#")
                                                                                                                        .attr(AriaRoles.roleButton)
                                                                                                                        .withData("bs-toggle","dropdown")
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
                                                                                                                                                hr()
                                                                                                                                                        .withClasses(Dropdowns.dropdown_divider)
                                                                                                                                        ),
                                                                                                                                li()
                                                                                                                                        .with(
                                                                                                                                                a()
                                                                                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                                                                                        .withHref("#")
                                                                                                                                                        .with(
                                                                                                                                                                text("Something else here")
                                                                                                                                                        )
                                                                                                                                        )
                                                                                                                        )
                                                                                                        )
                                                                                        ),
                                                                                form()
                                                                                        .withClasses(Flex.d_flex,Spacing.mt_3)
                                                                                        .attr(AriaRoles.roleSearch)
                                                                                        .with(
                                                                                                input()
                                                                                                        .withClasses(FormControl.form_control,Spacing.me_2)
                                                                                                        .withType("search")
                                                                                                        .withPlaceholder("Search")
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                                        ),
                                                                                                button()
                                                                                                        .withClasses(Buttons.btn,Buttons.btn_outline_success)
                                                                                                        .withType("submit")
                                                                                                        .with(
                                                                                                                text("Search")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar bg-body-tertiary fixed-top">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Offcanvas navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
              <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">
                  Offcanvas
                </h5>
                <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close">
                </button>
              </div>
              <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">
                      Home
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">
                      Link
                    </a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
                        <hr class="dropdown-divider">
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Something else here
                        </a>
                      </li>
                    </ul>
                  </li>
                </ul>
                <form class="d-flex mt-3" role="search">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success" type="submit">
                    Search
                  </button>
                </form>
              </div>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("offcanvas-navbar", renderedHtml);

        uiDocumentation.documentSource("offcanvas-navbar");

    }

    @Test
    void offcanvasNavbar2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,Navbar.navbar_expand_lg,Background.bg_body_tertiary,Position.fixed_top)
                        .with(
                                a()
                                        .withClasses(Navbar.navbar_brand)
                                        .withHref("#")
                                        .with(
                                                text("Offcanvas navbar")
                                        ),
                                button()
                                        .withClasses(Navbar.navbar_toggler)
                                        .withType("button")
                                        .withData("bs-toggle","offcanvas")
                                        .withData("bs-target","#navbarOffcanvasLg")
                                        .attr(
                                                AriaStatesAndProperties.ariaControls("navbarOffcanvasLg")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                        )
                                        .with(
                                                span()
                                                        .withClasses(Navbar.navbar_toggler_icon)
                                        ),
                                div()
                                        .withClasses(OffCanvas.offcanvas,OffCanvas.offcanvas_end)
                                        .withTabindex(-1)
                                        .withId("navbarOffcanvasLg")
                                        .attr(
                                                AriaStatesAndProperties.ariaLabelledby("navbarOffcanvasLgLabel")
                                        )
                                        .with(
                                                text("...")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-expand-lg bg-body-tertiary fixed-top">
          <a class="navbar-brand" href="#">
            Offcanvas navbar
          </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#navbarOffcanvasLg" aria-controls="navbarOffcanvasLg" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon">
            </span>
          </button>
          <div class="offcanvas offcanvas-end" tabindex="-1" id="navbarOffcanvasLg" aria-labelledby="navbarOffcanvasLgLabel">
            ...
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("offcanvas-navbar2", renderedHtml);

        uiDocumentation.documentSource("offcanvas-navbar2");

    }

    @Test
    void offcanvasNavbar3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .withClasses(Navbar.navbar,"navbar-dark",Background.bg_dark,Position.fixed_top)
                        .with(
                                div()
                                        .withClasses(Containers.container_fluid)
                                        .with(
                                                a()
                                                        .withClasses(Navbar.navbar_brand)
                                                        .withHref("#")
                                                        .with(
                                                                text("Offcanvas dark navbar")
                                                        ),
                                                button()
                                                        .withClasses(Navbar.navbar_toggler)
                                                        .withType("button")
                                                        .withData("bs-toggle","offcanvas")
                                                        .withData("bs-target","#offcanvasDarkNavbar")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaControls("offcanvasDarkNavbar")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Toggle navigation")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(Navbar.navbar_toggler_icon)
                                                        ),
                                                div()
                                                        .withClasses(OffCanvas.offcanvas,OffCanvas.offcanvas_end, ColorsAndBackground.text_bg_dark)
                                                        .withTabindex(-1)
                                                        .withId("offcanvasDarkNavbar")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabelledby("offcanvasDarkNavbarLabel")
                                                        )
                                                        .with(
                                                                div()
                                                                        .withClasses(OffCanvas.offcanvas_header)
                                                                        .with(
                                                                                h5()
                                                                                        .withClasses(OffCanvas.offcanvas_title)
                                                                                        .withId("offcanvasDarkNavbarLabel")
                                                                                        .with(
                                                                                                text("Dark offcanvas")
                                                                                        ),
                                                                                button()
                                                                                        .withType("button")
                                                                                        .withClasses(CloseButton.btn_close,CloseButton.btn_close_white)
                                                                                        .withData("bs-dismiss","offcanvas")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(OffCanvas.offcanvas_body)
                                                                        .with(
                                                                                ul()
                                                                                        .withClasses(Navbar.navbar_nav,Flex.justify_content_end,Flex.flex_grow_1,Spacing.pe_3)
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
                                                                                                                                text("Home")
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
                                                                                                        .withClasses(NavsTabs.nav_item,Dropdowns.dropdown)
                                                                                                        .with(
                                                                                                                a()
                                                                                                                        .withClasses(NavsTabs.nav_link,Dropdowns.dropdown_toggle)
                                                                                                                        .withHref("#")
                                                                                                                        .attr(AriaRoles.roleButton)
                                                                                                                        .withData("bs-toggle","dropdown")
                                                                                                                        .attr(
                                                                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                                                                        )
                                                                                                                        .with(
                                                                                                                                text("Dropdown")
                                                                                                                        ),
                                                                                                                ul()
                                                                                                                        .withClasses(Dropdowns.dropdown_menu,Dropdowns.dropdown_menu_dark)
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
                                                                                                                                                hr()
                                                                                                                                                        .withClasses(Dropdowns.dropdown_divider)
                                                                                                                                        ),
                                                                                                                                li()
                                                                                                                                        .with(
                                                                                                                                                a()
                                                                                                                                                        .withClasses(Dropdowns.dropdown_item)
                                                                                                                                                        .withHref("#")
                                                                                                                                                        .with(
                                                                                                                                                                text("Something else here")
                                                                                                                                                        )
                                                                                                                                        )
                                                                                                                        )
                                                                                                        )
                                                                                        ),
                                                                                form()
                                                                                        .withClasses(Flex.d_flex,Spacing.mt_3)
                                                                                        .attr(AriaRoles.roleSearch)
                                                                                        .with(
                                                                                                input()
                                                                                                        .withClasses(FormControl.form_control,Spacing.me_2)
                                                                                                        .withType("search")
                                                                                                        .withPlaceholder("Search")
                                                                                                        .attr(
                                                                                                                AriaStatesAndProperties.ariaLabel("Search")
                                                                                                        ),
                                                                                                button()
                                                                                                        .withClasses(Buttons.btn,Buttons.btn_success)
                                                                                                        .withType("submit")
                                                                                                        .with(
                                                                                                                text("Search")
                                                                                                        )
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav class="navbar navbar-dark bg-dark fixed-top">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              Offcanvas dark navbar
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon">
              </span>
            </button>
            <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
              <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">
                  Dark offcanvas
                </h5>
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close">
                </button>
              </div>
              <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">
                      Home
                    </a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">
                      Link
                    </a>
                  </li>
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Dropdown
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark">
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
                        <hr class="dropdown-divider">
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">
                          Something else here
                        </a>
                      </li>
                    </ul>
                  </li>
                </ul>
                <form class="d-flex mt-3" role="search">
                  <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-success" type="submit">
                    Search
                  </button>
                </form>
              </div>
            </div>
          </div>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("offcanvas-navbar2", renderedHtml);

        uiDocumentation.documentSource("offcanvas-navbar2");

    }


}
