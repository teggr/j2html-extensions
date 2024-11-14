package dev.rebelcraft.j2html.ext.content;

import dev.rebelcraft.j2html.ext.utilities.Borders;
import dev.rebelcraft.j2html.ext.utilities.Text;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FiguresTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void figures() throws Exception {

        String renderedHtml = uiDocumentation.render(
                figure()
                        .withClasses(Figures.figure)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Figures.figure_img,Images.img_fluid, Borders.rounded)
                                        .withAlt("..."),
                                figcaption()
                                        .withClasses(Figures.figure_caption)
                                        .with(
                                                text("A caption for the above image.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <figure class="figure">
                  <img src="..." class="figure-img img-fluid rounded" alt="...">
                  <figcaption class="figure-caption">
                    A caption for the above image.
                  </figcaption>
                </figure>
                """, renderedHtml);

        // document
        uiDocumentation.document("figures", renderedHtml);

        uiDocumentation.documentSource("figures");

    }

    @Test
    void figures2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                figure()
                        .withClasses(Figures.figure)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(Figures.figure_img,Images.img_fluid,Borders.rounded)
                                        .withAlt("..."),
                                figcaption()
                                        .withClasses(Figures.figure_caption, Text.text_end)
                                        .with(
                                                text("A caption for the above image.")
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <figure class="figure">
                  <img src="..." class="figure-img img-fluid rounded" alt="...">
                  <figcaption class="figure-caption text-end">
                    A caption for the above image.
                  </figcaption>
                </figure>
                """, renderedHtml);

        // document
        uiDocumentation.document("figures2", renderedHtml);

        uiDocumentation.documentSource("figures2");

    }


}
