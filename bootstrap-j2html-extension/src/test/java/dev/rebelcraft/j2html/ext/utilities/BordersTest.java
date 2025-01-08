package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.j2html.ext.content.Typography;
import dev.rebelcraft.j2html.ext.forms.FormControl;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BordersTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void additive() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Borders.border),
                        span()
                                .withClasses(Borders.border_top),
                        span()
                                .withClasses(Borders.border_end),
                        span()
                                .withClasses(Borders.border_bottom),
                        span()
                                .withClasses(Borders.border_start)
                )
        );

        //language=HTML
        assertEquals("""
                <span class="border">
                </span>
                <span class="border-top">
                </span>
                <span class="border-end">
                </span>
                <span class="border-bottom">
                </span>
                <span class="border-start">
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("additive", renderedHtml);

        uiDocumentation.documentSource("additive");

    }

    @Test
    void subtractive() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Borders.border, Borders.border_0),
                        span()
                                .withClasses(Borders.border, Borders.border_top_0),
                        span()
                                .withClasses(Borders.border, Borders.border_end_0),
                        span()
                                .withClasses(Borders.border, Borders.border_bottom_0),
                        span()
                                .withClasses(Borders.border, Borders.border_start_0)
                )
        );

        uiDocumentation.documentSource("subtractive");
        //language=HTML
        assertEquals("""
                <span class="border border-0">
                </span>
                <span class="border border-top-0">
                </span>
                <span class="border border-end-0">
                </span>
                <span class="border border-bottom-0">
                </span>
                <span class="border border-start-0">
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("subtractive", renderedHtml);

    }

    @Test
    void color() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Borders.border, Borders.border_primary),
                        span()
                                .withClasses(Borders.border, Borders.border_primary_subtle),
                        span()
                                .withClasses(Borders.border, Borders.border_secondary),
                        span()
                                .withClasses(Borders.border, Borders.border_secondary_subtle),
                        span()
                                .withClasses(Borders.border, Borders.border_success),
                        span()
                                .withClasses(Borders.border, Borders.border_success_subtle),
                        span()
                                .withClasses(Borders.border, Borders.border_danger),
                        span()
                                .withClasses(Borders.border, Borders.border_danger_subtle),
                        span()
                                .withClasses(Borders.border, Borders.border_warning),
                        span()
                                .withClasses(Borders.border, Borders.border_warning_subtle),
                        span()
                                .withClasses(Borders.border, Borders.border_info),
                        span()
                                .withClasses(Borders.border, Borders.border_info_subtle),
                        span()
                                .withClasses(Borders.border, Borders.border_light),
                        span()
                                .withClasses(Borders.border, Borders.border_light_subtle),
                        span()
                                .withClasses(Borders.border, Borders.border_dark),
                        span()
                                .withClasses(Borders.border, Borders.border_dark_subtle),
                        span()
                                .withClasses(Borders.border, Borders.border_black),
                        span()
                                .withClasses(Borders.border, Borders.border_white)
                )
        );

        //language=HTML
        assertEquals("""
                <span class="border border-primary">
                </span>
                <span class="border border-primary-subtle">
                </span>
                <span class="border border-secondary">
                </span>
                <span class="border border-secondary-subtle">
                </span>
                <span class="border border-success">
                </span>
                <span class="border border-success-subtle">
                </span>
                <span class="border border-danger">
                </span>
                <span class="border border-danger-subtle">
                </span>
                <span class="border border-warning">
                </span>
                <span class="border border-warning-subtle">
                </span>
                <span class="border border-info">
                </span>
                <span class="border border-info-subtle">
                </span>
                <span class="border border-light">
                </span>
                <span class="border border-light-subtle">
                </span>
                <span class="border border-dark">
                </span>
                <span class="border border-dark-subtle">
                </span>
                <span class="border border-black">
                </span>
                <span class="border border-white">
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("color", renderedHtml);

        uiDocumentation.documentSource("color");

    }

    @Test
    void modify() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Spacing.mb_4)
                                .with(
                                        label()
                                                .withFor("exampleFormControlInput1")
                                                .withClasses(FormControl.form_label)
                                                .with(
                                                        text("Email address")
                                                ),
                                        input()
                                                .withType("email")
                                                .withClasses(FormControl.form_control, Borders.border_success)
                                                .withId("exampleFormControlInput1")
                                                .withPlaceholder("name@example.com")
                                ),
                        div()
                                .withClasses(Typography.h4, Spacing.pb_2, Spacing.mb_4, Colors.text_danger, Borders.border_bottom, Borders.border_danger)
                                .with(
                                        text("Dangerous heading")
                                ),
                        div()
                                .withClasses(Spacing.p_3, Background.bg_info, Background.bg_opacity_10, Borders.border, Borders.border_info, Borders.border_start_0, Borders.rounded_end)
                                .with(
                                        text("Changing border color and width")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="mb-4">
                  <label for="exampleFormControlInput1" class="form-label">
                    Email address
                  </label>
                  <input type="email" class="form-control border-success" id="exampleFormControlInput1" placeholder="name@example.com">
                </div>
                <div class="h4 pb-2 mb-4 text-danger border-bottom border-danger">
                  Dangerous heading
                </div>
                <div class="p-3 bg-info bg-opacity-10 border border-info border-start-0 rounded-end">
                  Changing border color and width
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("modify", renderedHtml);

        uiDocumentation.documentSource("modify");

    }

    @Test
    void opacityExample() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        div()
                                .withClasses(Borders.border, Borders.border_success, Spacing.p_2, Spacing.mb_2)
                                .with(
                                        text("This is default success border")
                                ),
                        div()
                                .withClasses(Borders.border, Borders.border_success, Spacing.p_2)
                                .withStyle("--bs-border-opacity:.5;")
                                .with(
                                        text("This is 50% opacity success border")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="border border-success p-2 mb-2">
                  This is default success border
                </div>
                <div class="border border-success p-2" style="--bs-border-opacity:.5;">
                  This is 50% opacity success border
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
                                .withClasses(Borders.border, Borders.border_success, Spacing.p_2, Spacing.mb_2)
                                .with(
                                        text("This is default success border")
                                ),
                        div()
                                .withClasses(Borders.border, Borders.border_success, Spacing.p_2, Spacing.mb_2, Borders.border_opacity_75)
                                .with(
                                        text("This is 75% opacity success border")
                                ),
                        div()
                                .withClasses(Borders.border, Borders.border_success, Spacing.p_2, Spacing.mb_2, Borders.border_opacity_50)
                                .with(
                                        text("This is 50% opacity success border")
                                ),
                        div()
                                .withClasses(Borders.border, Borders.border_success, Spacing.p_2, Spacing.mb_2, Borders.border_opacity_25)
                                .with(
                                        text("This is 25% opacity success border")
                                ),
                        div()
                                .withClasses(Borders.border, Borders.border_success, Spacing.p_2, Borders.border_opacity_10)
                                .with(
                                        text("This is 10% opacity success border")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <div class="border border-success p-2 mb-2">
                  This is default success border
                </div>
                <div class="border border-success p-2 mb-2 border-opacity-75">
                  This is 75% opacity success border
                </div>
                <div class="border border-success p-2 mb-2 border-opacity-50">
                  This is 50% opacity success border
                </div>
                <div class="border border-success p-2 mb-2 border-opacity-25">
                  This is 25% opacity success border
                </div>
                <div class="border border-success p-2 border-opacity-10">
                  This is 10% opacity success border
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("opacity-example2", renderedHtml);

        uiDocumentation.documentSource("opacity-example2");

    }

    @Test
    void width() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        span()
                                .withClasses(Borders.border, Borders.border_1),
                        span()
                                .withClasses(Borders.border, Borders.border_2),
                        span()
                                .withClasses(Borders.border, Borders.border_3),
                        span()
                                .withClasses(Borders.border, Borders.border_4),
                        span()
                                .withClasses(Borders.border, Borders.border_5)
                )
        );

        //language=HTML
        assertEquals("""
                <span class="border border-1">
                </span>
                <span class="border border-2">
                </span>
                <span class="border border-3">
                </span>
                <span class="border border-4">
                </span>
                <span class="border border-5">
                </span>
                """, renderedHtml);

        // document
        uiDocumentation.document("width", renderedHtml);

        uiDocumentation.documentSource("width");

    }

    @Test
    void radius() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_top)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_end)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_bottom)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_start)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_circle)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_pill)
                                .withAlt("...")
                )
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="rounded" alt="...">
                <img src="..." class="rounded-top" alt="...">
                <img src="..." class="rounded-end" alt="...">
                <img src="..." class="rounded-bottom" alt="...">
                <img src="..." class="rounded-start" alt="...">
                <img src="..." class="rounded-circle" alt="...">
                <img src="..." class="rounded-pill" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("radius", renderedHtml);

        uiDocumentation.documentSource("radius");

    }

    @Test
    void sizes() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_0)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_1)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_2)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_3)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_4)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_5)
                                .withAlt("...")
                )
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="rounded-0" alt="...">
                <img src="..." class="rounded-1" alt="...">
                <img src="..." class="rounded-2" alt="...">
                <img src="..." class="rounded-3" alt="...">
                <img src="..." class="rounded-4" alt="...">
                <img src="..." class="rounded-5" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("sizes", renderedHtml);

        uiDocumentation.documentSource("sizes");

    }

    @Test
    void sizes2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_bottom_1)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_start_2)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses("rounded-end-circle")
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses("rounded-start-pill")
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(Borders.rounded_5, Borders.rounded_top_0)
                                .withAlt("...")
                )
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="rounded-bottom-1" alt="...">
                <img src="..." class="rounded-start-2" alt="...">
                <img src="..." class="rounded-end-circle" alt="...">
                <img src="..." class="rounded-start-pill" alt="...">
                <img src="..." class="rounded-5 rounded-top-0" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("sizes2", renderedHtml);

        uiDocumentation.documentSource("sizes2");

    }


}
