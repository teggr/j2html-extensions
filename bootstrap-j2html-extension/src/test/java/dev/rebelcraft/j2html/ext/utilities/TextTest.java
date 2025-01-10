package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.j2html.ext.components.Badge;
import dev.rebelcraft.j2html.ext.helpers.ColorsAndBackground;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TextTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void textAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Text.text_start)
                                .with(
                                        text("Start aligned text on all viewport sizes.")
                                ),
                        p()
                                .withClasses(Text.text_center)
                                .with(
                                        text("Center aligned text on all viewport sizes.")
                                ),
                        p()
                                .withClasses(Text.text_end)
                                .with(
                                        text("End aligned text on all viewport sizes.")
                                ),
                        p()
                                .withClasses(Text.text_sm_end)
                                .with(
                                        text("End aligned text on viewports sized SM (small) or wider.")
                                ),
                        p()
                                .withClasses(Text.text_md_end)
                                .with(
                                        text("End aligned text on viewports sized MD (medium) or wider.")
                                ),
                        p()
                                .withClasses(Text.text_lg_end)
                                .with(
                                        text("End aligned text on viewports sized LG (large) or wider.")
                                ),
                        p()
                                .withClasses(Text.text_xl_end)
                                .with(
                                        text("End aligned text on viewports sized XL (extra large) or wider.")
                                ),
                        p()
                                .withClasses(Text.text_xxl_end)
                                .with(
                                        text("End aligned text on viewports sized XXL (extra extra large) or wider.")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="text-start">
                  Start aligned text on all viewport sizes.
                </p>
                <p class="text-center">
                  Center aligned text on all viewport sizes.
                </p>
                <p class="text-end">
                  End aligned text on all viewport sizes.
                </p>
                <p class="text-sm-end">
                  End aligned text on viewports sized SM (small) or wider.
                </p>
                <p class="text-md-end">
                  End aligned text on viewports sized MD (medium) or wider.
                </p>
                <p class="text-lg-end">
                  End aligned text on viewports sized LG (large) or wider.
                </p>
                <p class="text-xl-end">
                  End aligned text on viewports sized XL (extra large) or wider.
                </p>
                <p class="text-xxl-end">
                  End aligned text on viewports sized XXL (extra extra large) or wider.
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-alignment", renderedHtml);

        uiDocumentation.documentSource("text-alignment");

    }

    @Test
    void textWrappingAndOverflow() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Badge.badge, ColorsAndBackground.text_bg_primary, Text.text_wrap)
                        .withStyle("width: 6rem;")
                        .with(
                                text("This text should wrap.")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="badge text-bg-primary text-wrap" style="width: 6rem;">
                  This text should wrap.
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-wrapping-and-overflow", renderedHtml);

        uiDocumentation.documentSource("text-wrapping-and-overflow");

    }

    @Test
    void textWrappingAndOverflow2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Text.text_nowrap, Background.bg_body_secondary, Borders.border)
                        .withStyle("width: 8rem;")
                        .with(
                                text("This text should overflow the parent.")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="text-nowrap bg-body-secondary border" style="width: 8rem;">
                  This text should overflow the parent.
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-wrapping-and-overflow2", renderedHtml);

        uiDocumentation.documentSource("text-wrapping-and-overflow2");

    }

    @Test
    void wordbreak() throws Exception {

        String renderedHtml = uiDocumentation.render(
                p()
                        .withClasses(Text.text_break)
                        .with(
                                text("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm")
                        )
        );

        //language=HTML
        assertEquals("""
                <p class="text-break">
                  mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("wordbreak", renderedHtml);

        uiDocumentation.documentSource("wordbreak");

    }

    @Test
    void textTransform() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Text.text_lowercase)
                                .with(
                                        text("Lowercased text.")
                                ),
                        p()
                                .withClasses(Text.text_uppercase)
                                .with(
                                        text("Uppercased text.")
                                ),
                        p()
                                .withClasses(Text.text_capitalize)
                                .with(
                                        text("CapiTaliZed text.")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="text-lowercase">
                  Lowercased text.
                </p>
                <p class="text-uppercase">
                  Uppercased text.
                </p>
                <p class="text-capitalize">
                  CapiTaliZed text.
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-transform", renderedHtml);

        uiDocumentation.documentSource("text-transform");

    }

    @Test
    void fontSize() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Text.fs_1)
                                .with(
                                        text(".fs-1 text")
                                ),
                        p()
                                .withClasses(Text.fs_2)
                                .with(
                                        text(".fs-2 text")
                                ),
                        p()
                                .withClasses(Text.fs_3)
                                .with(
                                        text(".fs-3 text")
                                ),
                        p()
                                .withClasses(Text.fs_4)
                                .with(
                                        text(".fs-4 text")
                                ),
                        p()
                                .withClasses(Text.fs_5)
                                .with(
                                        text(".fs-5 text")
                                ),
                        p()
                                .withClasses(Text.fs_6)
                                .with(
                                        text(".fs-6 text")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="fs-1">
                  .fs-1 text
                </p>
                <p class="fs-2">
                  .fs-2 text
                </p>
                <p class="fs-3">
                  .fs-3 text
                </p>
                <p class="fs-4">
                  .fs-4 text
                </p>
                <p class="fs-5">
                  .fs-5 text
                </p>
                <p class="fs-6">
                  .fs-6 text
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("font-size", renderedHtml);

        uiDocumentation.documentSource("font-size");

    }

    @Test
    void fontWeightAndItalics() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Text.fw_bold)
                                .with(
                                        text("Bold text.")
                                ),
                        p()
                                .withClasses(Text.fw_bolder)
                                .with(
                                        text("Bolder weight text (relative to the parent element).")
                                ),
                        p()
                                .withClasses(Text.fw_semibold)
                                .with(
                                        text("Semibold weight text.")
                                ),
                        p()
                                .withClasses(Text.fw_medium)
                                .with(
                                        text("Medium weight text.")
                                ),
                        p()
                                .withClasses(Text.fw_normal)
                                .with(
                                        text("Normal weight text.")
                                ),
                        p()
                                .withClasses(Text.fw_light)
                                .with(
                                        text("Light weight text.")
                                ),
                        p()
                                .withClasses(Text.fw_lighter)
                                .with(
                                        text("Lighter weight text (relative to the parent element).")
                                ),
                        p()
                                .withClasses(Text.fst_italic)
                                .with(
                                        text("Italic text.")
                                ),
                        p()
                                .withClasses(Text.fst_normal)
                                .with(
                                        text("Text with normal font style")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="fw-bold">
                  Bold text.
                </p>
                <p class="fw-bolder">
                  Bolder weight text (relative to the parent element).
                </p>
                <p class="fw-semibold">
                  Semibold weight text.
                </p>
                <p class="fw-medium">
                  Medium weight text.
                </p>
                <p class="fw-normal">
                  Normal weight text.
                </p>
                <p class="fw-light">
                  Light weight text.
                </p>
                <p class="fw-lighter">
                  Lighter weight text (relative to the parent element).
                </p>
                <p class="fst-italic">
                  Italic text.
                </p>
                <p class="fst-normal">
                  Text with normal font style
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("font-weight-and-italics", renderedHtml);

        uiDocumentation.documentSource("font-weight-and-italics");

    }

    @Test
    void lineHeight() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Text.lh_1)
                                .with(
                                        text("This is a long paragraph written to show how the line-height of an element is affected by our utilities. Classes are applied to the element itself or sometimes the parent element. These classes can be customized as needed with our utility API.")
                                ),
                        p()
                                .withClasses(Text.lh_sm)
                                .with(
                                        text("This is a long paragraph written to show how the line-height of an element is affected by our utilities. Classes are applied to the element itself or sometimes the parent element. These classes can be customized as needed with our utility API.")
                                ),
                        p()
                                .withClasses(Text.lh_base)
                                .with(
                                        text("This is a long paragraph written to show how the line-height of an element is affected by our utilities. Classes are applied to the element itself or sometimes the parent element. These classes can be customized as needed with our utility API.")
                                ),
                        p()
                                .withClasses(Text.lh_lg)
                                .with(
                                        text("This is a long paragraph written to show how the line-height of an element is affected by our utilities. Classes are applied to the element itself or sometimes the parent element. These classes can be customized as needed with our utility API.")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="lh-1">
                  This is a long paragraph written to show how the line-height of an element is affected by our utilities. Classes are applied to the element itself or sometimes the parent element. These classes can be customized as needed with our utility API.
                </p>
                <p class="lh-sm">
                  This is a long paragraph written to show how the line-height of an element is affected by our utilities. Classes are applied to the element itself or sometimes the parent element. These classes can be customized as needed with our utility API.
                </p>
                <p class="lh-base">
                  This is a long paragraph written to show how the line-height of an element is affected by our utilities. Classes are applied to the element itself or sometimes the parent element. These classes can be customized as needed with our utility API.
                </p>
                <p class="lh-lg">
                  This is a long paragraph written to show how the line-height of an element is affected by our utilities. Classes are applied to the element itself or sometimes the parent element. These classes can be customized as needed with our utility API.
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("line-height", renderedHtml);

        uiDocumentation.documentSource("line-height");

    }

    @Test
    void monospace() throws Exception {

        String renderedHtml = uiDocumentation.render(
                p()
                        .withClasses(Text.font_monospace)
                        .with(
                                text("This is in monospace")
                        )
        );

        //language=HTML
        assertEquals("""
                <p class="font-monospace">
                  This is in monospace
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("monospace", renderedHtml);

        uiDocumentation.documentSource("monospace");

    }

    @Test
    void resetColor() throws Exception {

        String renderedHtml = uiDocumentation.render(
                p()
                        .withClasses(Colors.text_body_secondary)
                        .with(
                                text("Secondary body text with a"),
                                a()
                                        .withHref("#")
                                        .withClasses(Text.text_reset)
                                        .with(
                                                text("reset link")
                                        ),
                                text(".")
                        )
        );

        //language=HTML
        assertEquals("""
                <p class="text-body-secondary">
                  Secondary body text with a 
                  <a href="#" class="text-reset">
                    reset link
                  </a>
                  .
                </p>
                """, renderedHtml);

        // document
        uiDocumentation.document("reset-color", renderedHtml);

        uiDocumentation.documentSource("reset-color");

    }

    @Test
    void textDecoration() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .withClasses(Text.text_decoration_underline)
                                .with(
                                        text("This text has a line underneath it.")
                                ),
                        p()
                                .withClasses(Text.text_decoration_line_through)
                                .with(
                                        text("This text has a line going through it.")
                                ),
                        a()
                                .withHref("#")
                                .withClasses(Text.text_decoration_none)
                                .with(
                                        text("This link has its text decoration removed")
                                )
                )
        );

        //language=HTML
        assertEquals("""
                <p class="text-decoration-underline">
                  This text has a line underneath it.
                </p>
                <p class="text-decoration-line-through">
                  This text has a line going through it.
                </p>
                <a href="#" class="text-decoration-none">
                  This link has its text decoration removed
                </a>
                """, renderedHtml);

        // document
        uiDocumentation.document("text-decoration", renderedHtml);

        uiDocumentation.documentSource("text-decoration");

    }


}
