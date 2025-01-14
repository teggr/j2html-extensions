package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BadgesTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void headings() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        h1()
                                .with(
                                        text("Example heading"),
                                        span()
                                                .withClasses(BootstrapClasses.badge, BootstrapClasses.text_bg_secondary)
                                                .with(
                                                        text("New")
                                                )
                                ),
                        h2()
                                .with(
                                        text("Example heading"),
                                        span()
                                                .withClasses(BootstrapClasses.badge, BootstrapClasses.text_bg_secondary)
                                                .with(
                                                        text("New")
                                                )
                                ),
                        h3()
                                .with(
                                        text("Example heading"),
                                        span()
                                                .withClasses(BootstrapClasses.badge, BootstrapClasses.text_bg_secondary)
                                                .with(
                                                        text("New")
                                                )
                                ),
                        h4()
                                .with(
                                        text("Example heading"),
                                        span()
                                                .withClasses(BootstrapClasses.badge, BootstrapClasses.text_bg_secondary)
                                                .with(
                                                        text("New")
                                                )
                                ),
                        h5()
                                .with(
                                        text("Example heading"),
                                        span()
                                                .withClasses(BootstrapClasses.badge, BootstrapClasses.text_bg_secondary)
                                                .with(
                                                        text("New")
                                                )
                                ),
                        h6()
                                .with(
                                        text("Example heading"),
                                        span()
                                                .withClasses(BootstrapClasses.badge, BootstrapClasses.text_bg_secondary)
                                                .with(
                                                        text("New")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <h1>
                  Example heading
                  <span class="badge text-bg-secondary">
                    New
                  </span>
                </h1>
                <h2>
                  Example heading
                  <span class="badge text-bg-secondary">
                    New
                  </span>
                </h2>
                <h3>
                  Example heading
                  <span class="badge text-bg-secondary">
                    New
                  </span>
                </h3>
                <h4>
                  Example heading
                  <span class="badge text-bg-secondary">
                    New
                  </span>
                </h4>
                <h5>
                  Example heading
                  <span class="badge text-bg-secondary">
                    New
                  </span>
                </h5>
                <h6>
                  Example heading
                  <span class="badge text-bg-secondary">
                    New
                  </span>
                </h6>
                """, renderedHtml);

        // document
        uiDocumentation.document("headings", renderedHtml);

        uiDocumentation.documentSource("headings");

    }

    @Test
    void buttons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .withType("button")
                        .withClasses(BootstrapClasses.btn,BootstrapClasses.btn_primary)
                        .with(
                                text("Notifications"),
                                span()
                                        .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_secondary)
                                        .with(
                                                text("4")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary">
                  Notifications
                  <span class="badge text-bg-secondary">
                    4
                  </span>
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("headings", renderedHtml);

        uiDocumentation.documentSource("headings");

    }

    @Test
    void positioned() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .withType("button")
                        .withClasses(BootstrapClasses.btn,BootstrapClasses.btn_primary, BootstrapClasses.position_relative)
                        .with(
                                text("Inbox"),
                                span()
                                        .withClasses(BootstrapClasses.position_absolute, BootstrapClasses.top_0, BootstrapClasses.start_100, BootstrapClasses.translate_middle,BootstrapClasses.badge,BootstrapClasses.rounded_pill, BootstrapClasses.bg_danger)
                                        .with(
                                                text("99+"),
                                                span()
                                                        .withClasses(BootstrapClasses.visually_hidden)
                                                        .with(
                                                                text("unread messages")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary position-relative">
                  Inbox
                  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                    99+
                    <span class="visually-hidden">
                      unread messages
                    </span>
                  </span>
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("positioned", renderedHtml);

        uiDocumentation.documentSource("positioned");

    }

    @Test
    void positioned2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                button()
                        .withType("button")
                        .withClasses(BootstrapClasses.btn,BootstrapClasses.btn_primary,BootstrapClasses.position_relative)
                        .with(
                                text("Profile"),
                                span()
                                        .withClasses(BootstrapClasses.position_absolute,BootstrapClasses.top_0,BootstrapClasses.start_100,BootstrapClasses.translate_middle,BootstrapClasses.p_2,BootstrapClasses.bg_danger, BootstrapClasses.border,BootstrapClasses.border_light,BootstrapClasses.rounded_circle)
                                        .with(
                                                span()
                                                        .withClasses(BootstrapClasses.visually_hidden)
                                                        .with(
                                                                text("New alerts")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <button type="button" class="btn btn-primary position-relative">
                  Profile
                  <span class="position-absolute top-0 start-100 translate-middle p-2 bg-danger border border-light rounded-circle">
                    <span class="visually-hidden">
                      New alerts
                    </span>
                  </span>
                </button>
                """, renderedHtml);

        // document
        uiDocumentation.document("positioned2", renderedHtml);

        uiDocumentation.documentSource("positioned2");

    }

    @Test
    void backgroundColors() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_primary)
                                .with(
                                        text("Primary")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_secondary)
                                .with(
                                        text("Secondary")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_success)
                                .with(
                                        text("Success")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_danger)
                                .with(
                                        text("Danger")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_warning)
                                .with(
                                        text("Warning")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_info)
                                .with(
                                        text("Info")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_light)
                                .with(
                                        text("Light")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.text_bg_dark)
                                .with(
                                        text("Dark")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <span class="badge text-bg-primary">
                  Primary
                </span>
                <span class="badge text-bg-secondary">
                  Secondary
                </span>
                <span class="badge text-bg-success">
                  Success
                </span>
                <span class="badge text-bg-danger">
                  Danger
                </span>
                <span class="badge text-bg-warning">
                  Warning
                </span>
                <span class="badge text-bg-info">
                  Info
                </span>
                <span class="badge text-bg-light">
                  Light
                </span>
                <span class="badge text-bg-dark">
                  Dark
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("background-colors", renderedHtml);

        uiDocumentation.documentSource("background-colors");

    }

    @Test
    void pillBadges() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.rounded_pill,BootstrapClasses.text_bg_primary)
                                .with(
                                        text("Primary")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.rounded_pill,BootstrapClasses.text_bg_secondary)
                                .with(
                                        text("Secondary")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.rounded_pill,BootstrapClasses.text_bg_success)
                                .with(
                                        text("Success")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.rounded_pill,BootstrapClasses.text_bg_danger)
                                .with(
                                        text("Danger")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.rounded_pill,BootstrapClasses.text_bg_warning)
                                .with(
                                        text("Warning")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.rounded_pill,BootstrapClasses.text_bg_info)
                                .with(
                                        text("Info")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.rounded_pill,BootstrapClasses.text_bg_light)
                                .with(
                                        text("Light")
                                ),
                        span()
                                .withClasses(BootstrapClasses.badge,BootstrapClasses.rounded_pill,BootstrapClasses.text_bg_dark)
                                .with(
                                        text("Dark")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <span class="badge rounded-pill text-bg-primary">
                  Primary
                </span>
                <span class="badge rounded-pill text-bg-secondary">
                  Secondary
                </span>
                <span class="badge rounded-pill text-bg-success">
                  Success
                </span>
                <span class="badge rounded-pill text-bg-danger">
                  Danger
                </span>
                <span class="badge rounded-pill text-bg-warning">
                  Warning
                </span>
                <span class="badge rounded-pill text-bg-info">
                  Info
                </span>
                <span class="badge rounded-pill text-bg-light">
                  Light
                </span>
                <span class="badge rounded-pill text-bg-dark">
                  Dark
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("pill-badges", renderedHtml);

        uiDocumentation.documentSource("pill-badges");

    }


}
