package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackgroundTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void backgroundColor() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_primary, Colors.text_white)
                                .with(
                                        text(".bg-primary")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_primary_subtle, Colors.text_primary_emphasis)
                                .with(
                                        text(".bg-primary-subtle")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_secondary, Colors.text_white)
                                .with(
                                        text(".bg-secondary")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_secondary_subtle, Colors.text_secondary_emphasis)
                                .with(
                                        text(".bg-secondary-subtle")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_success, Colors.text_white)
                                .with(
                                        text(".bg-success")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_success_subtle, Colors.text_success_emphasis)
                                .with(
                                        text(".bg-success-subtle")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_danger, Colors.text_white)
                                .with(
                                        text(".bg-danger")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_danger_subtle, Colors.text_danger_emphasis)
                                .with(
                                        text(".bg-danger-subtle")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_warning, Colors.text_dark)
                                .with(
                                        text(".bg-warning")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_warning_subtle, Colors.text_warning_emphasis)
                                .with(
                                        text(".bg-warning-subtle")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_info, Colors.text_dark)
                                .with(
                                        text(".bg-info")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_info_subtle, Colors.text_info_emphasis)
                                .with(
                                        text(".bg-info-subtle")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_light, Colors.text_dark)
                                .with(
                                        text(".bg-light")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_light_subtle, Colors.text_light_emphasis)
                                .with(
                                        text(".bg-light-subtle")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_dark, Colors.text_white)
                                .with(
                                        text(".bg-dark")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_dark_subtle, Colors.text_dark_emphasis)
                                .with(
                                        text(".bg-dark-subtle")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_body_secondary)
                                .with(
                                        text(".bg-body-secondary")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_body_tertiary)
                                .with(
                                        text(".bg-body-tertiary")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_body, Colors.text_body)
                                .with(
                                        text(".bg-body")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_black, Colors.text_white)
                                .with(
                                        text(".bg-black")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_white, Colors.text_dark)
                                .with(
                                        text(".bg-white")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Spacing.mb_2, Background.bg_transparent, Colors.text_body)
                                .with(
                                        text(".bg-transparent")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="p-3 mb-2 bg-primary text-white">
                  .bg-primary
                </div>
                <div class="p-3 mb-2 bg-primary-subtle text-primary-emphasis">
                  .bg-primary-subtle
                </div>
                <div class="p-3 mb-2 bg-secondary text-white">
                  .bg-secondary
                </div>
                <div class="p-3 mb-2 bg-secondary-subtle text-secondary-emphasis">
                  .bg-secondary-subtle
                </div>
                <div class="p-3 mb-2 bg-success text-white">
                  .bg-success
                </div>
                <div class="p-3 mb-2 bg-success-subtle text-success-emphasis">
                  .bg-success-subtle
                </div>
                <div class="p-3 mb-2 bg-danger text-white">
                  .bg-danger
                </div>
                <div class="p-3 mb-2 bg-danger-subtle text-danger-emphasis">
                  .bg-danger-subtle
                </div>
                <div class="p-3 mb-2 bg-warning text-dark">
                  .bg-warning
                </div>
                <div class="p-3 mb-2 bg-warning-subtle text-warning-emphasis">
                  .bg-warning-subtle
                </div>
                <div class="p-3 mb-2 bg-info text-dark">
                  .bg-info
                </div>
                <div class="p-3 mb-2 bg-info-subtle text-info-emphasis">
                  .bg-info-subtle
                </div>
                <div class="p-3 mb-2 bg-light text-dark">
                  .bg-light
                </div>
                <div class="p-3 mb-2 bg-light-subtle text-light-emphasis">
                  .bg-light-subtle
                </div>
                <div class="p-3 mb-2 bg-dark text-white">
                  .bg-dark
                </div>
                <div class="p-3 mb-2 bg-dark-subtle text-dark-emphasis">
                  .bg-dark-subtle
                </div>
                <div class="p-3 mb-2 bg-body-secondary">
                  .bg-body-secondary
                </div>
                <div class="p-3 mb-2 bg-body-tertiary">
                  .bg-body-tertiary
                </div>
                <div class="p-3 mb-2 bg-body text-body">
                  .bg-body
                </div>
                <div class="p-3 mb-2 bg-black text-white">
                  .bg-black
                </div>
                <div class="p-3 mb-2 bg-white text-dark">
                  .bg-white
                </div>
                <div class="p-3 mb-2 bg-transparent text-body">
                  .bg-transparent
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("background-color", renderedHtml);

        uiDocumentation.documentSource("background-color");

    }

}
