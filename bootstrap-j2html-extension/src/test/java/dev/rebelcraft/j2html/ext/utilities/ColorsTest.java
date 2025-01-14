package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void colors() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(BootstrapClasses.text_primary)
                                .with(
                                        text(".text-primary")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_primary_emphasis)
                                .with(
                                        text(".text-primary-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_secondary)
                                .with(
                                        text(".text-secondary")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_secondary_emphasis)
                                .with(
                                        text(".text-secondary-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_success)
                                .with(
                                        text(".text-success")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_success_emphasis)
                                .with(
                                        text(".text-success-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_danger)
                                .with(
                                        text(".text-danger")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_danger_emphasis)
                                .with(
                                        text(".text-danger-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_warning, BootstrapClasses.bg_dark)
                                .with(
                                        text(".text-warning")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_warning_emphasis)
                                .with(
                                        text(".text-warning-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_info, BootstrapClasses.bg_dark)
                                .with(
                                        text(".text-info")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_info_emphasis)
                                .with(
                                        text(".text-info-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_light, BootstrapClasses.bg_dark)
                                .with(
                                        text(".text-light")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_light_emphasis)
                                .with(
                                        text(".text-light-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_dark, BootstrapClasses.bg_white)
                                .with(
                                        text(".text-dark")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_dark_emphasis)
                                .with(
                                        text(".text-dark-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_body)
                                .with(
                                        text(".text-body")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_body_emphasis)
                                .with(
                                        text(".text-body-emphasis")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_body_secondary)
                                .with(
                                        text(".text-body-secondary")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_body_tertiary)
                                .with(
                                        text(".text-body-tertiary")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_black, BootstrapClasses.bg_white)
                                .with(
                                        text(".text-black")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_white, BootstrapClasses.bg_dark)
                                .with(
                                        text(".text-white")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_black_50, BootstrapClasses.bg_white)
                                .with(
                                        text(".text-black-50")
                                ),
                        p()
                                .withClasses(BootstrapClasses.text_white_50, BootstrapClasses.bg_dark)
                                .with(
                                        text(".text-white-50")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="text-primary">
                  .text-primary
                </p>
                <p class="text-primary-emphasis">
                  .text-primary-emphasis
                </p>
                <p class="text-secondary">
                  .text-secondary
                </p>
                <p class="text-secondary-emphasis">
                  .text-secondary-emphasis
                </p>
                <p class="text-success">
                  .text-success
                </p>
                <p class="text-success-emphasis">
                  .text-success-emphasis
                </p>
                <p class="text-danger">
                  .text-danger
                </p>
                <p class="text-danger-emphasis">
                  .text-danger-emphasis
                </p>
                <p class="text-warning bg-dark">
                  .text-warning
                </p>
                <p class="text-warning-emphasis">
                  .text-warning-emphasis
                </p>
                <p class="text-info bg-dark">
                  .text-info
                </p>
                <p class="text-info-emphasis">
                  .text-info-emphasis
                </p>
                <p class="text-light bg-dark">
                  .text-light
                </p>
                <p class="text-light-emphasis">
                  .text-light-emphasis
                </p>
                <p class="text-dark bg-white">
                  .text-dark
                </p>
                <p class="text-dark-emphasis">
                  .text-dark-emphasis
                </p>
                <p class="text-body">
                  .text-body
                </p>
                <p class="text-body-emphasis">
                  .text-body-emphasis
                </p>
                <p class="text-body-secondary">
                  .text-body-secondary
                </p>
                <p class="text-body-tertiary">
                  .text-body-tertiary
                </p>
                <p class="text-black bg-white">
                  .text-black
                </p>
                <p class="text-white bg-dark">
                  .text-white
                </p>
                <p class="text-black-50 bg-white">
                  .text-black-50
                </p>
                <p class="text-white-50 bg-dark">
                  .text-white-50
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("colors", renderedHtml);

        uiDocumentation.documentSource("colors");

    }

    @Test
    void opacityExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(BootstrapClasses.text_primary)
                                .with(
                                        text("This is default primary text")
                                ),
                        div()
                                .withClasses(BootstrapClasses.text_primary)
                                .withStyle("--bs-text-opacity:.5;")
                                .with(
                                        text("This is 50% opacity primary text")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="text-primary">
                  This is default primary text
                </div>
                <div class="text-primary" style="--bs-text-opacity:.5;">
                  This is 50% opacity primary text
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("opacity-example", renderedHtml);

        uiDocumentation.documentSource("opacity-example");

    }

    @Test
    void opacityExample2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(BootstrapClasses.text_primary)
                                .with(
                                        text("This is default primary text")
                                ),
                        div()
                                .withClasses(BootstrapClasses.text_primary, BootstrapClasses.text_opacity_75)
                                .with(
                                        text("This is 75% opacity primary text")
                                ),
                        div()
                                .withClasses(BootstrapClasses.text_primary, BootstrapClasses.text_opacity_50)
                                .with(
                                        text("This is 50% opacity primary text")
                                ),
                        div()
                                .withClasses(BootstrapClasses.text_primary, BootstrapClasses.text_opacity_25)
                                .with(
                                        text("This is 25% opacity primary text")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="text-primary">
                  This is default primary text
                </div>
                <div class="text-primary text-opacity-75">
                  This is 75% opacity primary text
                </div>
                <div class="text-primary text-opacity-50">
                  This is 50% opacity primary text
                </div>
                <div class="text-primary text-opacity-25">
                  This is 25% opacity primary text
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("opacity-example2", renderedHtml);

        uiDocumentation.documentSource("opacity-example2");

    }

}
