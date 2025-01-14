package dev.rebelcraft.j2html.ext.helpers;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColoredLinksTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void linkColors() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_primary)
                       .with(
                          text("Primary link")
                        )
                    ),
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_secondary)
                       .with(
                          text("Secondary link")
                        )
                    ),
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_success)
                       .with(
                          text("Success link")
                        )
                    ),
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_danger)
                       .with(
                          text("Danger link")
                        )
                    ),
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_warning)
                       .with(
                          text("Warning link")
                        )
                    ),
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_info)
                       .with(
                          text("Info link")
                        )
                    ),
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_light)
                       .with(
                          text("Light link")
                        )
                    ),
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_dark)
                       .with(
                          text("Dark link")
                        )
                    ),
                  p()
                   .with(
                      a()
                       .withHref("#")
                       .withClasses(BootstrapClasses.link_body_emphasis)
                       .with(
                          text("Emphasis link")
                        )
                    )
                )
        );

        //language=HTML
        assertEquals("""
            <p>
              <a href="#" class="link-primary">
                Primary link
              </a>
            </p>
            <p>
              <a href="#" class="link-secondary">
                Secondary link
              </a>
            </p>
            <p>
              <a href="#" class="link-success">
                Success link
              </a>
            </p>
            <p>
              <a href="#" class="link-danger">
                Danger link
              </a>
            </p>
            <p>
              <a href="#" class="link-warning">
                Warning link
              </a>
            </p>
            <p>
              <a href="#" class="link-info">
                Info link
              </a>
            </p>
            <p>
              <a href="#" class="link-light">
                Light link
              </a>
            </p>
            <p>
              <a href="#" class="link-dark">
                Dark link
              </a>
            </p>
            <p>
              <a href="#" class="link-body-emphasis">
                Emphasis link
              </a>
            </p>
            """, renderedHtml);

        // document
        uiDocumentation.document("link-colors", renderedHtml);

        uiDocumentation.documentSource("link-colors");

    }

    @Test
    void linkUtilities() throws Exception {

        String renderedHtml = uiDocumentation.render(
                each(
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_primary,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Primary link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_secondary,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Secondary link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_success,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Success link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_danger,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Danger link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_warning,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Warning link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_info,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Info link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_light,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Light link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_dark,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_100_hover)
                                                .with(
                                                        text("Dark link")
                                                )
                                ),
                        p()
                                .with(
                                        a()
                                                .withHref("#")
                                                .withClasses(BootstrapClasses.link_body_emphasis,BootstrapClasses.link_offset_2,BootstrapClasses.link_underline_opacity_25,BootstrapClasses.link_underline_opacity_75_hover)
                                                .with(
                                                        text("Emphasis link")
                                                )
                                )
                )
        );

        //language=HTML
        assertEquals("""
        <p>
          <a href="#" class="link-primary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
            Primary link
          </a>
        </p>
        <p>
          <a href="#" class="link-secondary link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
            Secondary link
          </a>
        </p>
        <p>
          <a href="#" class="link-success link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
            Success link
          </a>
        </p>
        <p>
          <a href="#" class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
            Danger link
          </a>
        </p>
        <p>
          <a href="#" class="link-warning link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
            Warning link
          </a>
        </p>
        <p>
          <a href="#" class="link-info link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
            Info link
          </a>
        </p>
        <p>
          <a href="#" class="link-light link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
            Light link
          </a>
        </p>
        <p>
          <a href="#" class="link-dark link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
            Dark link
          </a>
        </p>
        <p>
          <a href="#" class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover">
            Emphasis link
          </a>
        </p>
        """, renderedHtml);

        // document
        uiDocumentation.document("link-utilities", renderedHtml);

        uiDocumentation.documentSource("link-utilities");

    }


}
