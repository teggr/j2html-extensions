package dev.rebelcraft.j2html.ext.content;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
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
                        .withClasses(BootstrapClasses.figure)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(BootstrapClasses.figure_img,BootstrapClasses.img_fluid, BootstrapClasses.rounded)
                                        .withAlt("..."),
                                figcaption()
                                        .withClasses(BootstrapClasses.figure_caption)
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
                        .withClasses(BootstrapClasses.figure)
                        .with(
                                img()
                                        .withSrc("...")
                                        .withClasses(BootstrapClasses.figure_img,BootstrapClasses.img_fluid,BootstrapClasses.rounded)
                                        .withAlt("..."),
                                figcaption()
                                        .withClasses(BootstrapClasses.figure_caption, BootstrapClasses.text_end)
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
