package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uitest.UiDocumentation;
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
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_primary, BootstrapClasses.text_white)
                                .with(
                                        text(".bg-primary")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_primary_subtle, BootstrapClasses.text_primary_emphasis)
                                .with(
                                        text(".bg-primary-subtle")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_secondary, BootstrapClasses.text_white)
                                .with(
                                        text(".bg-secondary")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_secondary_subtle, BootstrapClasses.text_secondary_emphasis)
                                .with(
                                        text(".bg-secondary-subtle")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_success, BootstrapClasses.text_white)
                                .with(
                                        text(".bg-success")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_success_subtle, BootstrapClasses.text_success_emphasis)
                                .with(
                                        text(".bg-success-subtle")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_danger, BootstrapClasses.text_white)
                                .with(
                                        text(".bg-danger")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_danger_subtle, BootstrapClasses.text_danger_emphasis)
                                .with(
                                        text(".bg-danger-subtle")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_warning, BootstrapClasses.text_dark)
                                .with(
                                        text(".bg-warning")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_warning_subtle, BootstrapClasses.text_warning_emphasis)
                                .with(
                                        text(".bg-warning-subtle")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_info, BootstrapClasses.text_dark)
                                .with(
                                        text(".bg-info")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_info_subtle, BootstrapClasses.text_info_emphasis)
                                .with(
                                        text(".bg-info-subtle")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_light, BootstrapClasses.text_dark)
                                .with(
                                        text(".bg-light")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_light_subtle, BootstrapClasses.text_light_emphasis)
                                .with(
                                        text(".bg-light-subtle")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_dark, BootstrapClasses.text_white)
                                .with(
                                        text(".bg-dark")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_dark_subtle, BootstrapClasses.text_dark_emphasis)
                                .with(
                                        text(".bg-dark-subtle")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_body_secondary)
                                .with(
                                        text(".bg-body-secondary")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_body_tertiary)
                                .with(
                                        text(".bg-body-tertiary")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_body, BootstrapClasses.text_body)
                                .with(
                                        text(".bg-body")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_black, BootstrapClasses.text_white)
                                .with(
                                        text(".bg-black")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_white, BootstrapClasses.text_dark)
                                .with(
                                        text(".bg-white")
                                ),
                        div()
                                .withClasses(BootstrapClasses.p_3, BootstrapClasses.mb_2, BootstrapClasses.bg_transparent, BootstrapClasses.text_body)
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
