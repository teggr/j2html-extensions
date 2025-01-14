package dev.rebelcraft.j2html.ext.layout;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.div;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GuttersTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void horizontalGutters() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(BootstrapClasses.container, BootstrapClasses.px_4, BootstrapClasses.text_center)
                        .with(
                                div()
                                        .withClasses(BootstrapClasses.row, BootstrapClasses.gx_5)
                                        .with(
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container px-4 text-center">
                  <div class="row gx-5">
                    <div class="col">
                      <div class="p-3">
                        Custom column padding
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Custom column padding
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-gutters", renderedHtml);

        uiDocumentation.documentSource("horizontal-gutters");

    }

    @Test
    void horizontalGutters2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(BootstrapClasses.container, BootstrapClasses.overflow_hidden, BootstrapClasses.text_center)
                        .with(
                                div()
                                        .withClasses(BootstrapClasses.row, BootstrapClasses.gx_5)
                                        .with(
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container overflow-hidden text-center">
                  <div class="row gx-5">
                    <div class="col">
                      <div class="p-3">
                        Custom column padding
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Custom column padding
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-gutters2", renderedHtml);

        uiDocumentation.documentSource("horizontal-gutters2");

    }

    @Test
    void verticalGutters() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(BootstrapClasses.container, BootstrapClasses.overflow_hidden,BootstrapClasses.text_center)
                        .with(
                                div()
                                        .withClasses(BootstrapClasses.row, BootstrapClasses.gy_5)
                                        .with(
                                                div()
                                                        .withClass(BootstrapClasses.col_6)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col_6)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col_6)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col_6)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container overflow-hidden text-center">
                  <div class="row gy-5">
                    <div class="col-6">
                      <div class="p-3">
                        Custom column padding
                      </div>
                    </div>
                    <div class="col-6">
                      <div class="p-3">
                        Custom column padding
                      </div>
                    </div>
                    <div class="col-6">
                      <div class="p-3">
                        Custom column padding
                      </div>
                    </div>
                    <div class="col-6">
                      <div class="p-3">
                        Custom column padding
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-gutters", renderedHtml);

        uiDocumentation.documentSource("vertical-gutters");

    }

    @Test
    void horizontalAndVerticalGutters() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(BootstrapClasses.container, BootstrapClasses.text_center)
                        .with(
                                div()
                                        .withClasses(BootstrapClasses.row, BootstrapClasses.g_2)
                                        .with(
                                                div()
                                                        .withClass(BootstrapClasses.col_6)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col_6)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col_6)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col_6)
                                                        .with(
                                                                div("Custom column padding")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
            <div class="container text-center">
              <div class="row g-2">
                <div class="col-6">
                  <div class="p-3">
                    Custom column padding
                  </div>
                </div>
                <div class="col-6">
                  <div class="p-3">
                    Custom column padding
                  </div>
                </div>
                <div class="col-6">
                  <div class="p-3">
                    Custom column padding
                  </div>
                </div>
                <div class="col-6">
                  <div class="p-3">
                    Custom column padding
                  </div>
                </div>
              </div>
            </div>
            """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-and-vertical-gutters", renderedHtml);

        uiDocumentation.documentSource("horizontal-and-vertical-gutters");

    }

    @Test
    void rowColumnsGutters() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(BootstrapClasses.container, BootstrapClasses.text_center)
                        .with(
                                div()
                                        .withClasses(BootstrapClasses.row, BootstrapClasses.row_cols_2, BootstrapClasses.row_cols_lg_5, BootstrapClasses.g_2, BootstrapClasses.g_lg_3)
                                        .with(
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        ),
                                                div()
                                                        .withClass(BootstrapClasses.col)
                                                        .with(
                                                                div("Row column")
                                                                        .withClass(BootstrapClasses.p_3)
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row row-cols-2 row-cols-lg-5 g-2 g-lg-3">
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                    <div class="col">
                      <div class="p-3">
                        Row column
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("row-columns-gutters", renderedHtml);

        uiDocumentation.documentSource("row-columns-gutters");

    }

    @Test
    void noGutters() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(BootstrapClasses.row, BootstrapClasses.g_0, BootstrapClasses.text_center)
                        .with(
                                div(".col-sm-6.col-md-8")
                                        .withClasses(BootstrapClasses.col_sm_6, BootstrapClasses.col_md_8),
                                div(".col-6.col-md-4")
                                        .withClasses(BootstrapClasses.col_6, BootstrapClasses.col_md_4)
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="row g-0 text-center">
                  <div class="col-sm-6 col-md-8">
                    .col-sm-6.col-md-8
                  </div>
                  <div class="col-6 col-md-4">
                    .col-6.col-md-4
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("no-gutters", renderedHtml);

        uiDocumentation.documentSource("no-gutters");

    }


}
