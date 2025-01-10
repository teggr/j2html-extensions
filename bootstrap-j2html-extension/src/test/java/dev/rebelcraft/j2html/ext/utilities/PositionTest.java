package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.j2html.ext.components.Badge;
import dev.rebelcraft.j2html.ext.components.Buttons;
import dev.rebelcraft.j2html.ext.components.Progress;
import dev.rebelcraft.j2html.ext.helpers.ColorsAndBackground;
import dev.rebelcraft.j2html.ext.helpers.VisuallyHidden;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.path;
import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.svg;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void positionValues() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Position.position_static)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Position.position_relative)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Position.position_absolute)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Position.position_fixed)
                                .with(
                                        text("...")
                                ),
                        div()
                                .withClasses(Position.position_sticky)
                                .with(
                                        text("...")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="position-static">
                  ...
                </div>
                <div class="position-relative">
                  ...
                </div>
                <div class="position-absolute">
                  ...
                </div>
                <div class="position-fixed">
                  ...
                </div>
                <div class="position-sticky">
                  ...
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("position-values", renderedHtml);

        uiDocumentation.documentSource("position-values");

    }

    @Test
    void arrangeElements() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Position.position_relative)
                        .with(
                                div()
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_0),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_0, Position.end_0),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_50, Position.start_50),
                                div()
                                        .withClasses(Position.position_absolute, Position.bottom_50, Position.end_50),
                                div()
                                        .withClasses(Position.position_absolute, Position.bottom_0, Position.start_0),
                                div()
                                        .withClasses(Position.position_absolute, Position.bottom_0, Position.end_0)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="position-relative">
                  <div class="position-absolute top-0 start-0">
                  </div>
                  <div class="position-absolute top-0 end-0">
                  </div>
                  <div class="position-absolute top-50 start-50">
                  </div>
                  <div class="position-absolute bottom-50 end-50">
                  </div>
                  <div class="position-absolute bottom-0 start-0">
                  </div>
                  <div class="position-absolute bottom-0 end-0">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("arrange-elements", renderedHtml);

        uiDocumentation.documentSource("arrange-elements");

    }

    @Test
    void centerElements() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Position.position_relative)
                        .with(
                                div()
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_0, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_50, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_100, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_50, Position.start_0, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_50, Position.start_50, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_50, Position.start_100, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_100, Position.start_0, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_100, Position.start_50, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_100, Position.start_100, Position.translate_middle)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="position-relative">
                  <div class="position-absolute top-0 start-0 translate-middle">
                  </div>
                  <div class="position-absolute top-0 start-50 translate-middle">
                  </div>
                  <div class="position-absolute top-0 start-100 translate-middle">
                  </div>
                  <div class="position-absolute top-50 start-0 translate-middle">
                  </div>
                  <div class="position-absolute top-50 start-50 translate-middle">
                  </div>
                  <div class="position-absolute top-50 start-100 translate-middle">
                  </div>
                  <div class="position-absolute top-100 start-0 translate-middle">
                  </div>
                  <div class="position-absolute top-100 start-50 translate-middle">
                  </div>
                  <div class="position-absolute top-100 start-100 translate-middle">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("center-elements", renderedHtml);

        uiDocumentation.documentSource("center-elements");

    }

    @Test
    void centerElements2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Position.position_relative)
                        .with(
                                div()
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_0),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_50, Position.translate_middle_x),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_0, Position.end_0),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_50, Position.start_0, Position.translate_middle_y),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_50, Position.start_50, Position.translate_middle),
                                div()
                                        .withClasses(Position.position_absolute, Position.top_50, Position.end_0, Position.translate_middle_y),
                                div()
                                        .withClasses(Position.position_absolute, Position.bottom_0, Position.start_0),
                                div()
                                        .withClasses(Position.position_absolute, Position.bottom_0, Position.start_50, Position.translate_middle_x),
                                div()
                                        .withClasses(Position.position_absolute, Position.bottom_0, Position.end_0)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="position-relative">
                  <div class="position-absolute top-0 start-0">
                  </div>
                  <div class="position-absolute top-0 start-50 translate-middle-x">
                  </div>
                  <div class="position-absolute top-0 end-0">
                  </div>
                  <div class="position-absolute top-50 start-0 translate-middle-y">
                  </div>
                  <div class="position-absolute top-50 start-50 translate-middle">
                  </div>
                  <div class="position-absolute top-50 end-0 translate-middle-y">
                  </div>
                  <div class="position-absolute bottom-0 start-0">
                  </div>
                  <div class="position-absolute bottom-0 start-50 translate-middle-x">
                  </div>
                  <div class="position-absolute bottom-0 end-0">
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("center-elements2", renderedHtml);

        uiDocumentation.documentSource("center-elements2");

    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        button()
                                .withType("button")
                                .withClasses(Buttons.btn, Buttons.btn_primary, Position.position_relative)
                                .with(
                                        text("Mails"),
                                        span()
                                                .withClasses(Position.position_absolute, Position.top_0, Position.start_100, Position.translate_middle, Badge.badge, Borders.rounded_pill, ColorsAndBackground.text_bg_secondary)
                                                .with(
                                                        text("+99"),
                                                        span()
                                                                .withClasses(VisuallyHidden.visually_hidden)
                                                                .with(
                                                                        text("unread messages")
                                                                )
                                                )
                                ),
                        div()
                                .withClasses(Position.position_relative, Spacing.py_2, Spacing.px_4, ColorsAndBackground.text_bg_secondary, Borders.border, Borders.border_secondary, Borders.rounded_pill)
                                .with(
                                        text("Marker"),
                                        svg()
                                                .attr("width", "1em")
                                                .attr("height", "1em")
                                                .attr("viewBox", "0 0 16 16")
                                                .withClasses(Position.position_absolute, Position.top_100, Position.start_50, Position.translate_middle, Spacing.mt_1)
                                                .attr("fill", "var(--bs-secondary)")
                                                .attr("xmlns", "http://www.w3.org/2000/svg")
                                                .with(
                                                        path()
                                                                .attr("d", "M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1.753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z")
                                                )
                                ),
                        button()
                                .withType("button")
                                .withClasses(Buttons.btn, Buttons.btn_primary, Position.position_relative)
                                .with(
                                        text("Alerts"),
                                        span()
                                                .withClasses(Position.position_absolute, Position.top_0, Position.start_100, Position.translate_middle, Badge.badge, Borders.border, Borders.border_light, Borders.rounded_circle, Background.bg_danger, Spacing.p_2)
                                                .with(
                                                        span()
                                                                .withClasses(VisuallyHidden.visually_hidden)
                                                                .with(
                                                                        text("unread messages")
                                                                )
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary position-relative">
                  Mails 
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill text-bg-secondary">
                    +99 
                    <span class="visually-hidden">
                      unread messages
                    </span>
                  </span>
                </button>
                <div class="position-relative py-2 px-4 text-bg-secondary border border-secondary rounded-pill">
                  Marker 
                  <svg width="1em" height="1em" viewBox="0 0 16 16" class="position-absolute top-100 start-50 translate-middle mt-1" fill="var(--bs-secondary)" xmlns="http://www.w3.org/2000/svg">
                    <path d="M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1.753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z">
                    </path>
                  </svg>
                </div>
                <button type="button" class="btn btn-primary position-relative">
                  Alerts 
                  <span class="position-absolute top-0 start-100 translate-middle badge border border-light rounded-circle bg-danger p-2">
                    <span class="visually-hidden">
                      unread messages
                    </span>
                  </span>
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

    @Test
    void examples2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Position.position_relative, Spacing.m_4)
                        .with(
                                div()
                                        .withClasses(Progress.progress)
                                        .attr(AriaRoles.roleProgressbar)
                                        .attr(
                                                AriaStatesAndProperties.ariaLabel("Progress")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuenow("50")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemin("0")
                                        )
                                        .attr(
                                                AriaStatesAndProperties.ariaValuemax("100")
                                        )
                                        .withStyle("height: 1px;")
                                        .with(
                                                div()
                                                        .withClasses(Progress.progress_bar)
                                                        .withStyle("width: 50%")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_0, Position.translate_middle, Buttons.btn, Buttons.btn_sm, Buttons.btn_primary, Borders.rounded_pill)
                                        .withStyle("width: 2rem; height:2rem;")
                                        .with(
                                                text("1")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_50, Position.translate_middle, Buttons.btn, Buttons.btn_sm, Buttons.btn_primary, Borders.rounded_pill)
                                        .withStyle("width: 2rem; height:2rem;")
                                        .with(
                                                text("2")
                                        ),
                                button()
                                        .withType("button")
                                        .withClasses(Position.position_absolute, Position.top_0, Position.start_100, Position.translate_middle, Buttons.btn, Buttons.btn_sm, Buttons.btn_secondary, Borders.rounded_pill)
                                        .withStyle("width: 2rem; height:2rem;")
                                        .with(
                                                text("3")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="position-relative m-4">
                  <div class="progress" role="progressbar" aria-label="Progress" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="height: 1px;">
                    <div class="progress-bar" style="width: 50%">
                    </div>
                  </div>
                  <button type="button" class="position-absolute top-0 start-0 translate-middle btn btn-sm btn-primary rounded-pill" style="width: 2rem; height:2rem;">
                    1
                  </button>
                  <button type="button" class="position-absolute top-0 start-50 translate-middle btn btn-sm btn-primary rounded-pill" style="width: 2rem; height:2rem;">
                    2
                  </button>
                  <button type="button" class="position-absolute top-0 start-100 translate-middle btn btn-sm btn-secondary rounded-pill" style="width: 2rem; height:2rem;">
                    3
                  </button>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("examples2", renderedHtml);

        uiDocumentation.documentSource("examples2");

    }


}
