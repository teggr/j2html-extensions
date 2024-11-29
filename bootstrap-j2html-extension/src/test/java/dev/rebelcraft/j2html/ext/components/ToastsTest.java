package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.ext.forms.Select;
import dev.rebelcraft.j2html.ext.helpers.ColorsAndBackground;
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

class ToastsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void basic() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                 .withClasses(Toasts.toast)
                 .attr(AriaRoles.roleAlert)
                 .attr(AriaStatesAndProperties.ariaLive("assertive"))
                 .attr(AriaStatesAndProperties.ariaAtomic("true"))
                 .with(
                    div()
                     .withClasses(Toasts.toast_header)
                     .with(
                        img()
                         .withSrc("...")
                         .withClasses(Borders.rounded, Spacing.me_2)
                         .withAlt("..."),
                        strong()
                         .withClasses(Spacing.me_auto)
                         .with(
                            text("Bootstrap")
                          ),
                        small()
                         .with(
                            text("11 mins ago")
                          ),
                        button()
                         .withType("button")
                         .withClasses(CloseButton.btn_close)
                         .withData("bs-dismiss","toast")
                         .attr(
                            AriaStatesAndProperties.ariaLabel("Close")
                          )
                      ),
                    div()
                     .withClasses(Toasts.toast_body)
                     .with(
                        text("Hello, world! This is a toast message.")
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
              <div class="toast-header">
                <img src="..." class="rounded me-2" alt="...">
                <strong class="me-auto">
                  Bootstrap
                </strong>
                <small>
                  11 mins ago
                </small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
                </button>
              </div>
              <div class="toast-body">
                Hello, world! This is a toast message.
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("basic", renderedHtml);

        uiDocumentation.documentSource("basic");

    }

    @Test
    void liveExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Buttons.btn,Buttons.btn_primary)
                                .withId("liveToastBtn")
                                .with(
                                        text("Show live toast")
                                ),
                        div()
                                .withClasses(Toasts.toast_container, Position.position_fixed,Position.bottom_0,Position.end_0,Spacing.p_3)
                                .with(
                                        div()
                                                .withId("liveToast")
                                                .withClasses(Toasts.toast)
                                                .attr(AriaRoles.roleAlert)
                                                .attr(
                                                        AriaStatesAndProperties.ariaLive("assertive")
                                                )
                                                .attr(
                                                        AriaStatesAndProperties.ariaAtomic("true")
                                                )
                                                .with(
                                                        div()
                                                                .withClasses(Toasts.toast_header)
                                                                .with(
                                                                        img()
                                                                                .withSrc("...")
                                                                                .withClasses(Borders.rounded,Spacing.me_2)
                                                                                .withAlt("..."),
                                                                        strong()
                                                                                .withClasses(Spacing.me_auto)
                                                                                .with(
                                                                                        text("Bootstrap")
                                                                                ),
                                                                        small()
                                                                                .with(
                                                                                        text("11 mins ago")
                                                                                ),
                                                                        button()
                                                                                .withType("button")
                                                                                .withClasses(CloseButton.btn_close)
                                                                                .withData("bs-dismiss","toast")
                                                                                .attr(
                                                                                        AriaStatesAndProperties.ariaLabel("Close")
                                                                                )
                                                                ),
                                                        div()
                                                                .withClasses(Toasts.toast_body)
                                                                .with(
                                                                        text("Hello, world! This is a toast message.")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <button type="button" class="btn btn-primary" id="liveToastBtn">
          Show live toast
        </button>
        <div class="toast-container position-fixed bottom-0 end-0 p-3">
          <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
              <img src="..." class="rounded me-2" alt="...">
              <strong class="me-auto">
                Bootstrap
              </strong>
              <small>
                11 mins ago
              </small>
              <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
              </button>
            </div>
            <div class="toast-body">
              Hello, world! This is a toast message.
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("live-example", renderedHtml);

        uiDocumentation.documentSource("live-example");

    }

    @Test
    void translucent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Toasts.toast)
                        .attr(AriaRoles.roleAlert)
                        .attr(
                                AriaStatesAndProperties.ariaLive("assertive")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaAtomic("true")
                        )
                        .with(
                                div()
                                        .withClasses(Toasts.toast_header)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Borders.rounded,Spacing.me_2)
                                                        .withAlt("..."),
                                                strong()
                                                        .withClasses(Spacing.me_auto)
                                                        .with(
                                                                text("Bootstrap")
                                                        ),
                                                small()
                                                        .withClasses(Colors.text_body_secondary)
                                                        .with(
                                                                text("11 mins ago")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(CloseButton.btn_close)
                                                        .withData("bs-dismiss","toast")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                        )
                                        ),
                                div()
                                        .withClasses(Toasts.toast_body)
                                        .with(
                                                text("Hello, world! This is a toast message.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
          <div class="toast-header">
            <img src="..." class="rounded me-2" alt="...">
            <strong class="me-auto">
              Bootstrap
            </strong>
            <small class="text-body-secondary">
              11 mins ago
            </small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
            </button>
          </div>
          <div class="toast-body">
            Hello, world! This is a toast message.
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("translucent", renderedHtml);

        uiDocumentation.documentSource("translucent");

    }

    @Test
    void stacking() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Toasts.toast_container,Position.position_static)
                        .with(
                                div()
                                        .withClasses(Toasts.toast)
                                        .attr(AriaRoles.roleAlert)
                                        .attr(
                                                AriaStatesAndProperties.ariaLive("assertive")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaAtomic("true")
                                        )
                                        .with(
                                                div()
                                                        .withClasses(Toasts.toast_header)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Borders.rounded,Spacing.me_2)
                                                                        .withAlt("..."),
                                                                strong()
                                                                        .withClasses(Spacing.me_auto)
                                                                        .with(
                                                                                text("Bootstrap")
                                                                        ),
                                                                small()
                                                                        .withClasses(Colors.text_body_secondary)
                                                                        .with(
                                                                                text("just now")
                                                                        ),
                                                                button()
                                                                        .withType("button")
                                                                        .withClasses(CloseButton.btn_close)
                                                                        .withData("bs-dismiss","toast")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Toasts.toast_body)
                                                        .with(
                                                                text("See? Just like this.")
                                                        )
                                        ),
                                div()
                                        .withClasses(Toasts.toast)
                                        .attr(AriaRoles.roleAlert)
                                        .attr(
                                                AriaStatesAndProperties.ariaLive("assertive")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaAtomic("true")
                                        )
                                        .with(
                                                div()
                                                        .withClasses(Toasts.toast_header)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Borders.rounded,Spacing.me_2)
                                                                        .withAlt("..."),
                                                                strong()
                                                                        .withClasses(Spacing.me_auto)
                                                                        .with(
                                                                                text("Bootstrap")
                                                                        ),
                                                                small()
                                                                        .withClasses(Colors.text_body_secondary)
                                                                        .with(
                                                                                text("2 seconds ago")
                                                                        ),
                                                                button()
                                                                        .withType("button")
                                                                        .withClasses(CloseButton.btn_close)
                                                                        .withData("bs-dismiss","toast")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Toasts.toast_body)
                                                        .with(
                                                                text("Heads up, toasts will stack automatically")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="toast-container position-static">
              <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                  <img src="..." class="rounded me-2" alt="...">
                  <strong class="me-auto">
                    Bootstrap
                  </strong>
                  <small class="text-body-secondary">
                    just now
                  </small>
                  <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
                  </button>
                </div>
                <div class="toast-body">
                  See? Just like this.
                </div>
              </div>
              <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                  <img src="..." class="rounded me-2" alt="...">
                  <strong class="me-auto">
                    Bootstrap
                  </strong>
                  <small class="text-body-secondary">
                    2 seconds ago
                  </small>
                  <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
                  </button>
                </div>
                <div class="toast-body">
                  Heads up, toasts will stack automatically
                </div>
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("stacking", renderedHtml);

        uiDocumentation.documentSource("stacking");

    }

    @Test
    void customContent() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Toasts.toast,Flex.align_items_center)
                        .attr(AriaRoles.roleAlert)
                        .attr(
                                AriaStatesAndProperties.ariaLive("assertive")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaAtomic("true")
                        )
                        .with(
                                div()
                                        .withClasses(Flex.d_flex)
                                        .with(
                                                div()
                                                        .withClasses(Toasts.toast_body)
                                                        .with(
                                                                text("Hello, world! This is a toast message.")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(CloseButton.btn_close,Spacing.me_2,Spacing.m_auto)
                                                        .withData("bs-dismiss","toast")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="toast align-items-center" role="alert" aria-live="assertive" aria-atomic="true">
                  <div class="d-flex">
                    <div class="toast-body">
                      Hello, world! This is a toast message.
                    </div>
                    <button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close">
                    </button>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("custom-content", renderedHtml);

        uiDocumentation.documentSource("custom-content");

    }

    @Test
    void customContent2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Toasts.toast)
                        .attr(AriaRoles.roleAlert)
                        .attr(
                                AriaStatesAndProperties.ariaLive("assertive")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaAtomic("true")
                        )
                        .with(
                                div()
                                        .withClasses(Toasts.toast_body)
                                        .with(
                                                text("Hello, world! This is a toast message."),
                                                div()
                                                        .withClasses(Spacing.mt_2,Spacing.pt_2,Borders.border_top)
                                                        .with(
                                                                button()
                                                                        .withType("button")
                                                                        .withClasses(Buttons.btn,Buttons.btn_primary,Buttons.btn_sm)
                                                                        .with(
                                                                                text("Take action")
                                                                        ),
                                                                button()
                                                                        .withType("button")
                                                                        .withClasses(Buttons.btn,Buttons.btn_secondary,Buttons.btn_sm)
                                                                        .withData("bs-dismiss","toast")
                                                                        .with(
                                                                                text("Close")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
          <div class="toast-body">
            Hello, world! This is a toast message.
            <div class="mt-2 pt-2 border-top">
              <button type="button" class="btn btn-primary btn-sm">
                Take action
              </button>
              <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="toast">
                Close
              </button>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("custom-content2", renderedHtml);

        uiDocumentation.documentSource("custom-content2");

    }

    @Test
    void colorSchemes() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Toasts.toast,Flex.align_items_center, ColorsAndBackground.text_bg_primary,Borders.border_0)
                        .attr(AriaRoles.roleAlert)
                        .attr(
                                AriaStatesAndProperties.ariaLive("assertive")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaAtomic("true")
                        )
                        .with(
                                div()
                                        .withClasses(Flex.d_flex)
                                        .with(
                                                div()
                                                        .withClasses(Toasts.toast_body)
                                                        .with(
                                                                text("Hello, world! This is a toast message.")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(CloseButton.btn_close,CloseButton.btn_close_white,Spacing.me_2,Spacing.m_auto)
                                                        .withData("bs-dismiss","toast")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="toast align-items-center text-bg-primary border-0" role="alert" aria-live="assertive" aria-atomic="true">
              <div class="d-flex">
                <div class="toast-body">
                  Hello, world! This is a toast message.
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close">
                </button>
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("color-schemes", renderedHtml);

        uiDocumentation.documentSource("color-schemes");

    }

    @Test
    void placement() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        form()
                                .with(
                                        div()
                                                .withClasses(Spacing.mb_3)
                                                .with(
                                                        label()
                                                                .withFor("selectToastPlacement")
                                                                .with(
                                                                        text("Toast placement")
                                                                ),
                                                        select()
                                                                .withClasses(Select.form_select,Spacing.mt_2)
                                                                .withId("selectToastPlacement")
                                                                .with(
                                                                        option()
                                                                                .withValue("")
                                                                                .withCondSelected(true)
                                                                                .with(
                                                                                        text("Select a position...")
                                                                                ),
                                                                        option()
                                                                                .withValue("top-0 start-0")
                                                                                .with(
                                                                                        text("Top left")
                                                                                ),
                                                                        option()
                                                                                .withValue("top-0 start-50 translate-middle-x")
                                                                                .with(
                                                                                        text("Top center")
                                                                                ),
                                                                        option()
                                                                                .withValue("top-0 end-0")
                                                                                .with(
                                                                                        text("Top right")
                                                                                ),
                                                                        option()
                                                                                .withValue("top-50 start-0 translate-middle-y")
                                                                                .with(
                                                                                        text("Middle left")
                                                                                ),
                                                                        option()
                                                                                .withValue("top-50 start-50 translate-middle")
                                                                                .with(
                                                                                        text("Middle center")
                                                                                ),
                                                                        option()
                                                                                .withValue("top-50 end-0 translate-middle-y")
                                                                                .with(
                                                                                        text("Middle right")
                                                                                ),
                                                                        option()
                                                                                .withValue("bottom-0 start-0")
                                                                                .with(
                                                                                        text("Bottom left")
                                                                                ),
                                                                        option()
                                                                                .withValue("bottom-0 start-50 translate-middle-x")
                                                                                .with(
                                                                                        text("Bottom center")
                                                                                ),
                                                                        option()
                                                                                .withValue("bottom-0 end-0")
                                                                                .with(
                                                                                        text("Bottom right")
                                                                                )
                                                                )
                                                )
                                ),
                        div()
                                .attr(
                                        AriaStatesAndProperties.ariaLive("polite")
                                )
                                .attr(
                                        AriaStatesAndProperties.ariaAtomic("true")
                                )
                                .withClasses(Background.bg_body_secondary,Position.position_relative,"bd-example-toasts",Borders.rounded_3)
                                .with(
                                        div()
                                                .withClasses(Toasts.toast_container,Spacing.p_3)
                                                .withId("toastPlacement")
                                                .with(
                                                        div()
                                                                .withClasses(Toasts.toast)
                                                                .with(
                                                                        div()
                                                                                .withClasses(Toasts.toast_header)
                                                                                .with(
                                                                                        img()
                                                                                                .withSrc("...")
                                                                                                .withClasses(Borders.rounded,Spacing.me_2)
                                                                                                .withAlt("..."),
                                                                                        strong()
                                                                                                .withClasses(Spacing.me_auto)
                                                                                                .with(
                                                                                                        text("Bootstrap")
                                                                                                ),
                                                                                        small()
                                                                                                .with(
                                                                                                        text("11 mins ago")
                                                                                                )
                                                                                ),
                                                                        div()
                                                                                .withClasses(Toasts.toast_body)
                                                                                .with(
                                                                                        text("Hello, world! This is a toast message.")
                                                                                )
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <form>
          <div class="mb-3">
            <label for="selectToastPlacement">
              Toast placement
            </label>
            <select class="form-select mt-2" id="selectToastPlacement">
              <option value="" selected>
                Select a position...
              </option>
              <option value="top-0 start-0">
                Top left
              </option>
              <option value="top-0 start-50 translate-middle-x">
                Top center
              </option>
              <option value="top-0 end-0">
                Top right
              </option>
              <option value="top-50 start-0 translate-middle-y">
                Middle left
              </option>
              <option value="top-50 start-50 translate-middle">
                Middle center
              </option>
              <option value="top-50 end-0 translate-middle-y">
                Middle right
              </option>
              <option value="bottom-0 start-0">
                Bottom left
              </option>
              <option value="bottom-0 start-50 translate-middle-x">
                Bottom center
              </option>
              <option value="bottom-0 end-0">
                Bottom right
              </option>
            </select>
          </div>
        </form>
        <div aria-live="polite" aria-atomic="true" class="bg-body-secondary position-relative bd-example-toasts rounded-3">
          <div class="toast-container p-3" id="toastPlacement">
            <div class="toast">
              <div class="toast-header">
                <img src="..." class="rounded me-2" alt="...">
                <strong class="me-auto">
                  Bootstrap
                </strong>
                <small>
                  11 mins ago
                </small>
              </div>
              <div class="toast-body">
                Hello, world! This is a toast message.
              </div>
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement", renderedHtml);

        uiDocumentation.documentSource("placement");

    }

    @Test
    void placement2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .attr(
                                AriaStatesAndProperties.ariaLive("polite")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaAtomic("true")
                        )
                        .withClasses(Position.position_relative)
                        .with(
                                comment("Position it:"),
                                comment("- `.toast-container` for spacing between toasts"),
                                comment("- `top-0` & `end-0` to position the toasts in the upper right corner"),
                                comment("- `.p-3` to prevent the toasts from sticking to the edge of the container "),
                                div()
                                        .withClasses(Toasts.toast_container,Position.top_0,Position.end_0,Spacing.p_3)
                                        .with(
                                                comment("Then put toasts within"),
                                                div()
                                                        .withClasses(Toasts.toast)
                                                        .attr(AriaRoles.roleAlert)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLive("assertive")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaAtomic("true")
                                                        )
                                                        .with(
                                                                div()
                                                                        .withClasses(Toasts.toast_header)
                                                                        .with(
                                                                                img()
                                                                                        .withSrc("...")
                                                                                        .withClasses(Borders.rounded,Spacing.me_2)
                                                                                        .withAlt("..."),
                                                                                strong()
                                                                                        .withClasses(Spacing.me_auto)
                                                                                        .with(
                                                                                                text("Bootstrap")
                                                                                        ),
                                                                                small()
                                                                                        .withClasses(Colors.text_body_secondary)
                                                                                        .with(
                                                                                                text("just now")
                                                                                        ),
                                                                                button()
                                                                                        .withType("button")
                                                                                        .withClasses(CloseButton.btn_close)
                                                                                        .withData("bs-dismiss","toast")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Toasts.toast_body)
                                                                        .with(
                                                                                text("See? Just like this.")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Toasts.toast)
                                                        .attr(AriaRoles.roleAlert)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLive("assertive")
                                                        )
                                                        .attr(
                                                                AriaStatesAndProperties.ariaAtomic("true")
                                                        )
                                                        .with(
                                                                div()
                                                                        .withClasses(Toasts.toast_header)
                                                                        .with(
                                                                                img()
                                                                                        .withSrc("...")
                                                                                        .withClasses(Borders.rounded,Spacing.me_2)
                                                                                        .withAlt("..."),
                                                                                strong()
                                                                                        .withClasses(Spacing.me_auto)
                                                                                        .with(
                                                                                                text("Bootstrap")
                                                                                        ),
                                                                                small()
                                                                                        .withClasses(Colors.text_body_secondary)
                                                                                        .with(
                                                                                                text("2 seconds ago")
                                                                                        ),
                                                                                button()
                                                                                        .withType("button")
                                                                                        .withClasses(CloseButton.btn_close)
                                                                                        .withData("bs-dismiss","toast")
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                                                        )
                                                                        ),
                                                                div()
                                                                        .withClasses(Toasts.toast_body)
                                                                        .with(
                                                                                text("Heads up, toasts will stack automatically")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div aria-live="polite" aria-atomic="true" class="position-relative">
                  <!-- Position it: -->
                  <!-- - `.toast-container` for spacing between toasts -->
                  <!-- - `top-0` & `end-0` to position the toasts in the upper right corner -->
                  <!-- - `.p-3` to prevent the toasts from sticking to the edge of the container  -->
                  <div class="toast-container top-0 end-0 p-3">
                    <!-- Then put toasts within -->
                    <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                      <div class="toast-header">
                        <img src="..." class="rounded me-2" alt="...">
                        <strong class="me-auto">
                          Bootstrap
                        </strong>
                        <small class="text-body-secondary">
                          just now
                        </small>
                        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
                        </button>
                      </div>
                      <div class="toast-body">
                        See? Just like this.
                      </div>
                    </div>
                    <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                      <div class="toast-header">
                        <img src="..." class="rounded me-2" alt="...">
                        <strong class="me-auto">
                          Bootstrap
                        </strong>
                        <small class="text-body-secondary">
                          2 seconds ago
                        </small>
                        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
                        </button>
                      </div>
                      <div class="toast-body">
                        Heads up, toasts will stack automatically
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("placement2", renderedHtml);

        uiDocumentation.documentSource("placement2");

    }

    @Test
    void placement3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .attr(
                                AriaStatesAndProperties.ariaLive("polite")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaAtomic("true")
                        )
                        .withClasses(Flex.d_flex,Flex.justify_content_center,Flex.align_items_center,Sizing.w_100)
                        .with(
                                comment("Then put toasts within"),
                                div()
                                        .withClasses(Toasts.toast)
                                        .attr(AriaRoles.roleAlert)
                                        .attr(
                                                AriaStatesAndProperties.ariaLive("assertive")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaAtomic("true")
                                        )
                                        .with(
                                                div()
                                                        .withClasses(Toasts.toast_header)
                                                        .with(
                                                                img()
                                                                        .withSrc("...")
                                                                        .withClasses(Borders.rounded,Spacing.me_2)
                                                                        .withAlt("..."),
                                                                strong()
                                                                        .withClasses(Spacing.me_auto)
                                                                        .with(
                                                                                text("Bootstrap")
                                                                        ),
                                                                small()
                                                                        .with(
                                                                                text("11 mins ago")
                                                                        ),
                                                                button()
                                                                        .withType("button")
                                                                        .withClasses(CloseButton.btn_close)
                                                                        .withData("bs-dismiss","toast")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                                        )
                                                        ),
                                                div()
                                                        .withClasses(Toasts.toast_body)
                                                        .with(
                                                                text("Hello, world! This is a toast message.")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div aria-live="polite" aria-atomic="true" class="d-flex justify-content-center align-items-center w-100">
          <!-- Then put toasts within -->
          <div class="toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
              <img src="..." class="rounded me-2" alt="...">
              <strong class="me-auto">
                Bootstrap
              </strong>
              <small>
                11 mins ago
              </small>
              <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
              </button>
            </div>
            <div class="toast-body">
              Hello, world! This is a toast message.
            </div>
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("placement3", renderedHtml);

        uiDocumentation.documentSource("placement3");

    }

    @Test
    void accessibility() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Toasts.toast)
                        .attr(AriaRoles.roleAlert)
                        .attr(
                                AriaStatesAndProperties.ariaLive("polite")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaAtomic("true")
                        )
                        .withData("bs-delay","10000")
                        .with(
                                div()
                                        .attr(AriaRoles.roleAlert)
                                        .attr(
                                                AriaStatesAndProperties.ariaLive("assertive")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaAtomic("true")
                                        )
                                        .with(
                                                text("...")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div class="toast" role="alert" aria-live="polite" aria-atomic="true" data-bs-delay="10000">
          <div role="alert" aria-live="assertive" aria-atomic="true">
            ...
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("accessibility", renderedHtml);

        uiDocumentation.documentSource("accessibility");

    }

    @Test
    void accessibility2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .attr(AriaRoles.roleAlert)
                        .attr(
                                AriaStatesAndProperties.ariaLive("assertive")
                        )
                        .attr(
                                AriaStatesAndProperties.ariaAtomic("true")
                        )
                        .withClasses(Toasts.toast)
                        .withData("bs-autohide","false")
                        .with(
                                div()
                                        .withClasses(Toasts.toast_header)
                                        .with(
                                                img()
                                                        .withSrc("...")
                                                        .withClasses(Borders.rounded,Spacing.me_2)
                                                        .withAlt("..."),
                                                strong()
                                                        .withClasses(Spacing.me_auto)
                                                        .with(
                                                                text("Bootstrap")
                                                        ),
                                                small()
                                                        .with(
                                                                text("11 mins ago")
                                                        ),
                                                button()
                                                        .withType("button")
                                                        .withClasses(CloseButton.btn_close)
                                                        .withData("bs-dismiss","toast")
                                                        .attr(
                                                                AriaStatesAndProperties.ariaLabel("Close")
                                                        )
                                        ),
                                div()
                                        .withClasses(Toasts.toast_body)
                                        .with(
                                                text("Hello, world! This is a toast message.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <div role="alert" aria-live="assertive" aria-atomic="true" class="toast" data-bs-autohide="false">
          <div class="toast-header">
            <img src="..." class="rounded me-2" alt="...">
            <strong class="me-auto">
              Bootstrap
            </strong>
            <small>
              11 mins ago
            </small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close">
            </button>
          </div>
          <div class="toast-body">
            Hello, world! This is a toast message.
          </div>
        </div>
        """, renderedHtml);

        // document
        uiDocumentation.document("accessibility2", renderedHtml);

        uiDocumentation.documentSource("accessibility2");

    }


}
