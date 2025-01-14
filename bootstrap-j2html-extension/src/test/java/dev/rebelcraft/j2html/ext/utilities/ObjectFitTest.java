package dev.rebelcraft.j2html.ext.utilities;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectFitTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void examples() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_contain, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_cover, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_fill, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_scale, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_none, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("...")
                )
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="object-fit-contain border rounded" alt="...">
                <img src="..." class="object-fit-cover border rounded" alt="...">
                <img src="..." class="object-fit-fill border rounded" alt="...">
                <img src="..." class="object-fit-scale border rounded" alt="...">
                <img src="..." class="object-fit-none border rounded" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("examples", renderedHtml);

        uiDocumentation.documentSource("examples");

    }

    @Test
    void responsive() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_sm_contain, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_md_contain, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_lg_contain, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_xl_contain, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("..."),
                        img()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_xxl_contain, BootstrapClasses.border, BootstrapClasses.rounded)
                                .withAlt("...")
                )
        );

        //language=HTML
        assertEquals("""
                <img src="..." class="object-fit-sm-contain border rounded" alt="...">
                <img src="..." class="object-fit-md-contain border rounded" alt="...">
                <img src="..." class="object-fit-lg-contain border rounded" alt="...">
                <img src="..." class="object-fit-xl-contain border rounded" alt="...">
                <img src="..." class="object-fit-xxl-contain border rounded" alt="...">
                """, renderedHtml);

        // document
        uiDocumentation.document("responsive", renderedHtml);

        uiDocumentation.documentSource("responsive");

    }

    @Test
    void videoTest() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        video()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_contain)
                                .attr("autoplay"),
                        video()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_cover)
                                .attr("autoplay"),
                        video()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_fill)
                                .attr("autoplay"),
                        video()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_scale)
                                .attr("autoplay"),
                        video()
                                .withSrc("...")
                                .withClasses(BootstrapClasses.object_fit_none)
                                .attr("autoplay")
                )
        );

        //language=HTML
        assertEquals("""
                <video src="..." class="object-fit-contain" autoplay>
                </video>
                <video src="..." class="object-fit-cover" autoplay>
                </video>
                <video src="..." class="object-fit-fill" autoplay>
                </video>
                <video src="..." class="object-fit-scale" autoplay>
                </video>
                <video src="..." class="object-fit-none" autoplay>
                </video>
                """, renderedHtml);

        // document
        uiDocumentation.document("video-test", renderedHtml);

        uiDocumentation.documentSource("video-test");

    }

}
