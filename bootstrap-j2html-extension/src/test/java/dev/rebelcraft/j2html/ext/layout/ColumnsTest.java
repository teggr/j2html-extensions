package dev.rebelcraft.j2html.ext.layout;

import dev.rebelcraft.j2html.ext.helpers.Clearfix;
import dev.rebelcraft.j2html.ext.utilities.*;
import dev.rebelcraft.j2html.ext.utilities.Float;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static dev.rebelcraft.j2html.ext.ExtendedTagCreator.comment;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColumnsTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void verticalAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClasses(Grid.row, Flex.align_items_start)
                                        .with(
                                                div("One of three columns")
                                                        .withClass(Grid.col),
                                                div("One of three columns")
                                                        .withClass(Grid.col),
                                                div("One of three columns")
                                                        .withClass(Grid.col)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row align-items-start">
                    <div class="col">
                      One of three columns
                    </div>
                    <div class="col">
                      One of three columns
                    </div>
                    <div class="col">
                      One of three columns
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-alignment", renderedHtml);

        uiDocumentation.documentSource("vertical-alignment");

    }

    @Test
    void verticalAlignment2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClasses(Grid.row, Flex.align_items_center)
                                        .with(
                                                div("One of three columns")
                                                        .withClass(Grid.col),
                                                div("One of three columns")
                                                        .withClass(Grid.col),
                                                div("One of three columns")
                                                        .withClass(Grid.col)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row align-items-center">
                    <div class="col">
                      One of three columns
                    </div>
                    <div class="col">
                      One of three columns
                    </div>
                    <div class="col">
                      One of three columns
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-alignment2", renderedHtml);

        uiDocumentation.documentSource("vertical-alignment2");

    }

    @Test
    void verticalAlignment3() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClasses(Grid.row, Flex.align_items_end)
                                        .with(
                                                div("One of three columns")
                                                        .withClass(Grid.col),
                                                div("One of three columns")
                                                        .withClass(Grid.col),
                                                div("One of three columns")
                                                        .withClass(Grid.col)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row align-items-end">
                    <div class="col">
                      One of three columns
                    </div>
                    <div class="col">
                      One of three columns
                    </div>
                    <div class="col">
                      One of three columns
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-alignment3", renderedHtml);

        uiDocumentation.documentSource("vertical-alignment3");

    }

    @Test
    void verticalAlignment4() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div("One of three columns")
                                                        .withClasses(Grid.col, Flex.align_self_start),
                                                div("One of three columns")
                                                        .withClasses(Grid.col, Flex.align_self_center),
                                                div("One of three columns")
                                                        .withClasses(Grid.col, Flex.align_self_end)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col align-self-start">
                      One of three columns
                    </div>
                    <div class="col align-self-center">
                      One of three columns
                    </div>
                    <div class="col align-self-end">
                      One of three columns
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("vertical-alignment4", renderedHtml);

        uiDocumentation.documentSource("vertical-alignment4");

    }

    @Test
    void horizontalAlignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClasses(Grid.row, Columns.justify_content_start)
                                        .with(
                                                div("One of two columns")
                                                        .withClass(Grid.col_4),
                                                div("One of two columns")
                                                        .withClass(Grid.col_4)
                                        ),
                                div()
                                        .withClasses(Grid.row, Columns.justify_content_center)
                                        .with(
                                                div("One of two columns")
                                                        .withClass(Grid.col_4),
                                                div("One of two columns")
                                                        .withClass(Grid.col_4)
                                        ),
                                div()
                                        .withClasses(Grid.row, Columns.justify_content_end)
                                        .with(
                                                div("One of two columns")
                                                        .withClass(Grid.col_4),
                                                div("One of two columns")
                                                        .withClass(Grid.col_4)
                                        ),
                                div()
                                        .withClasses(Grid.row, Columns.justify_content_around)
                                        .with(
                                                div("One of two columns")
                                                        .withClass(Grid.col_4),
                                                div("One of two columns")
                                                        .withClass(Grid.col_4)
                                        ),
                                div()
                                        .withClasses(Grid.row, Columns.justify_content_between)
                                        .with(
                                                div("One of two columns")
                                                        .withClass(Grid.col_4),
                                                div("One of two columns")
                                                        .withClass(Grid.col_4)
                                        ),
                                div()
                                        .withClasses(Grid.row, Columns.justify_content_evenly)
                                        .with(
                                                div("One of two columns")
                                                        .withClass(Grid.col_4),
                                                div("One of two columns")
                                                        .withClass(Grid.col_4)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row justify-content-start">
                    <div class="col-4">
                      One of two columns
                    </div>
                    <div class="col-4">
                      One of two columns
                    </div>
                  </div>
                  <div class="row justify-content-center">
                    <div class="col-4">
                      One of two columns
                    </div>
                    <div class="col-4">
                      One of two columns
                    </div>
                  </div>
                  <div class="row justify-content-end">
                    <div class="col-4">
                      One of two columns
                    </div>
                    <div class="col-4">
                      One of two columns
                    </div>
                  </div>
                  <div class="row justify-content-around">
                    <div class="col-4">
                      One of two columns
                    </div>
                    <div class="col-4">
                      One of two columns
                    </div>
                  </div>
                  <div class="row justify-content-between">
                    <div class="col-4">
                      One of two columns
                    </div>
                    <div class="col-4">
                      One of two columns
                    </div>
                  </div>
                  <div class="row justify-content-evenly">
                    <div class="col-4">
                      One of two columns
                    </div>
                    <div class="col-4">
                      One of two columns
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("horizontal-alignment", renderedHtml);

        uiDocumentation.documentSource("horizontal-alignment");

    }

    @Test
    void columnWrapping() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClass(Containers.container)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-9")
                                                        .withClass(Grid.col_9),
                                                div()
                                                        .withClass(Grid.col_4)
                                                        .with(
                                                                text(".col-4"),
                                                                br(),
                                                                text("Since 9 + 4 = 13 > 12, this 4-column-wide div gets wrapped onto a new line as one contiguous unit.")
                                                        ),
                                                div()
                                                        .withClass(Grid.col_6)
                                                        .with(
                                                                text(".col-6"),
                                                                br(),
                                                                text("Subsequent columns continue along the new line.")
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container">
                  <div class="row">
                    <div class="col-9">
                      .col-9
                    </div>
                    <div class="col-4">
                      .col-4
                      <br>
                      Since 9 + 4 = 13 &gt; 12, this 4-column-wide div gets wrapped onto a new line as one contiguous unit.
                    </div>
                    <div class="col-6">
                      .col-6
                      <br>
                      Subsequent columns continue along the new line.
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("column-wrapping", renderedHtml);

        uiDocumentation.documentSource("column-wrapping");

    }

    @Test
    void columnBreaks() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-6.col-sm-3")
                                                        .withClasses(Grid.col_6, Grid.col_sm_3),
                                                div(".col-6.col-sm-3")
                                                        .withClasses(Grid.col_6, Grid.col_sm_3),
                                                comment(" Force next columns to break to new line "),
                                                div()
                                                        .withClass(Sizing.w_100),
                                                div(".col-6.col-sm-3")
                                                        .withClasses(Grid.col_6, Grid.col_sm_3),
                                                div(".col-6.col-sm-3")
                                                        .withClasses(Grid.col_6, Grid.col_sm_3)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col-6 col-sm-3">
                      .col-6.col-sm-3
                    </div>
                    <div class="col-6 col-sm-3">
                      .col-6.col-sm-3
                    </div>
                    <!--  Force next columns to break to new line  -->
                    <div class="w-100">
                    </div>
                    <div class="col-6 col-sm-3">
                      .col-6.col-sm-3
                    </div>
                    <div class="col-6 col-sm-3">
                      .col-6.col-sm-3
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("column-breaks", renderedHtml);

        uiDocumentation.documentSource("column-breaks");

    }

    @Test
    void columnBreaks2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-6.col-sm-4")
                                                        .withClasses(Grid.col_6, Grid.col_sm_4),
                                                div(".col-6.col-sm-4")
                                                        .withClasses(Grid.col_6, Grid.col_sm_4),
                                                comment(" Force next columns to break to new line at md breakpoint and up "),
                                                div()
                                                        .withClasses(Sizing.w_100, Display.d_none, Display.d_md_block),
                                                div(".col-6.col-sm-4")
                                                        .withClasses(Grid.col_6, Grid.col_sm_4),
                                                div(".col-6.col-sm-4")
                                                        .withClasses(Grid.col_6, Grid.col_sm_4)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col-6 col-sm-4">
                      .col-6.col-sm-4
                    </div>
                    <div class="col-6 col-sm-4">
                      .col-6.col-sm-4
                    </div>
                    <!--  Force next columns to break to new line at md breakpoint and up  -->
                    <div class="w-100 d-none d-md-block">
                    </div>
                    <div class="col-6 col-sm-4">
                      .col-6.col-sm-4
                    </div>
                    <div class="col-6 col-sm-4">
                      .col-6.col-sm-4
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("column-breaks2", renderedHtml);

        uiDocumentation.documentSource("column-breaks2");

    }

    @Test
    void orderClasses() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div("First in DOM, no order applied")
                                                        .withClass(Grid.col),
                                                div("Second in DOM, with a larger order")
                                                        .withClasses(Grid.col, Columns.order_5),
                                                div("Third in DOM, with an order of 1")
                                                        .withClasses(Grid.col, Columns.order_1)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col">
                      First in DOM, no order applied
                    </div>
                    <div class="col order-5">
                      Second in DOM, with a larger order
                    </div>
                    <div class="col order-1">
                      Third in DOM, with an order of 1
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("order-classes", renderedHtml);

        uiDocumentation.documentSource("order-classes");

    }

    @Test
    void orderClasses2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div("First in DOM, ordered last")
                                                        .withClasses(Grid.col, Columns.order_last),
                                                div("Second in DOM, unordered")
                                                        .withClass(Grid.col),
                                                div("Third in DOM, ordered first")
                                                        .withClasses(Grid.col, Columns.order_first)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col order-last">
                      First in DOM, ordered last
                    </div>
                    <div class="col">
                      Second in DOM, unordered
                    </div>
                    <div class="col order-first">
                      Third in DOM, ordered first
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("order-classes2", renderedHtml);

        uiDocumentation.documentSource("order-classes2");

    }

    @Test
    void offsetClasses() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-md-4")
                                                        .withClass(Grid.col_md_4),
                                                div(".col-md-4.offset-md-4")
                                                        .withClasses(Grid.col_md_4, Columns.offset_md_4)
                                        ),
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-md-3.offset-md-3")
                                                        .withClasses(Grid.col_md_3, Columns.offset_md_3),
                                                div(".col-md-3.offset-md-3")
                                                        .withClasses(Grid.col_md_3, Columns.offset_md_3)
                                        ),
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-md-6.offset-md-3")
                                                        .withClasses(Grid.col_md_6, Columns.offset_md_3)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col-md-4">
                      .col-md-4
                    </div>
                    <div class="col-md-4 offset-md-4">
                      .col-md-4.offset-md-4
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-3 offset-md-3">
                      .col-md-3.offset-md-3
                    </div>
                    <div class="col-md-3 offset-md-3">
                      .col-md-3.offset-md-3
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-6 offset-md-3">
                      .col-md-6.offset-md-3
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("offset-classes", renderedHtml);

        uiDocumentation.documentSource("offset-classes");

    }

    @Test
    void offsetClasses2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-sm-5.col-md-6")
                                                        .withClasses(Grid.col_sm_5, Grid.col_md_6),
                                                div(".col-sm-5.offset-sm-2.col-md-6.offset-md-0")
                                                        .withClasses(Grid.col_sm_5, Columns.offset_sm_2, Grid.col_md_6, Columns.offset_md_0)
                                        ),
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-sm-6.col-md-5.col-lg-6")
                                                        .withClasses(Grid.col_sm_6, Grid.col_md_5, Grid.col_lg_6),
                                                div(".col-sm-6.col-md-5.offset-md-2.col-lg-6.offset-lg-0")
                                                        .withClasses(Grid.col_sm_6, Grid.col_md_5, Columns.offset_md_2, Grid.col_lg_6, Columns.offset_lg_0)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col-sm-5 col-md-6">
                      .col-sm-5.col-md-6
                    </div>
                    <div class="col-sm-5 offset-sm-2 col-md-6 offset-md-0">
                      .col-sm-5.offset-sm-2.col-md-6.offset-md-0
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-sm-6 col-md-5 col-lg-6">
                      .col-sm-6.col-md-5.col-lg-6
                    </div>
                    <div class="col-sm-6 col-md-5 offset-md-2 col-lg-6 offset-lg-0">
                      .col-sm-6.col-md-5.offset-md-2.col-lg-6.offset-lg-0
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("offset-classes2", renderedHtml);

        uiDocumentation.documentSource("offset-classes2");

    }

    @Test
    void marginUtilities() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Containers.container, Text.text_center)
                        .with(
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-md-4")
                                                        .withClass(Grid.col_md_4),
                                                div(".col-md-4.ms-auto")
                                                        .withClasses(Grid.col_md_4, Spacing.ms_auto)
                                        ),
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-md-3.ms-md-auto")
                                                        .withClasses(Grid.col_md_3, Spacing.ms_md_auto),
                                                div(".col-md-3.ms-md-auto")
                                                        .withClasses(Grid.col_md_3, Spacing.ms_md_auto)
                                        ),
                                div()
                                        .withClass(Grid.row)
                                        .with(
                                                div(".col-auto.me-auto")
                                                        .withClasses(Grid.col_auto, Spacing.me_auto),
                                                div(".col-auto")
                                                        .withClass(Grid.col_auto)
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="container text-center">
                  <div class="row">
                    <div class="col-md-4">
                      .col-md-4
                    </div>
                    <div class="col-md-4 ms-auto">
                      .col-md-4.ms-auto
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-md-3 ms-md-auto">
                      .col-md-3.ms-md-auto
                    </div>
                    <div class="col-md-3 ms-md-auto">
                      .col-md-3.ms-md-auto
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-auto me-auto">
                      .col-auto.me-auto
                    </div>
                    <div class="col-auto">
                      .col-auto
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("margin-utilities", renderedHtml);

        uiDocumentation.documentSource("margin-utilities");

    }

    @Test
    void standaloneColumnClasses() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div(
                        div(".col-3: width of 25%")
                                .withClasses( Grid.col_3, Spacing.p_3, Spacing.mb_2),
                        div(".col-sm-9: width of 75% above sm breakpoint")
                                .withClasses(Grid.col_sm_9, Spacing.p_3)
                )
        );

        //language=HTML
        assertEquals("""
                <div>
                  <div class="col-3 p-3 mb-2">
                    .col-3: width of 25%
                  </div>
                  <div class="col-sm-9 p-3">
                    .col-sm-9: width of 75% above sm breakpoint
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("standalone-column-classes", renderedHtml);

        uiDocumentation.documentSource("standalone-column-classes");

    }

    @Test
    void standaloneColumnClasses2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClass(Clearfix.clearfix)
                        .with(
                                img()
                                        .attr("src", "ttt")
                                        .withClasses(Grid.col_md_6, Float.float_md_end, Spacing.mb_3, Spacing.ms_md_3)
                                        .attr("alt", "yyy"),
                                p("A paragraph of placeholder text. We're using it here to show the use of the clearfix class. We're adding quite a few meaningless phrases here to demonstrate how the columns interact here with the floated image."),
                                p("As you can see the paragraphs gracefully wrap around the floated image. Now imagine how this would look with some actual content in here, rather than just this boring placeholder text that goes on and on, but actually conveys no tangible information at. It simply takes up space and should not really be read."),
                                p("And yet, here you are, still persevering in reading this placeholder text, hoping for some more insights, or some hidden easter egg of content. A joke, perhaps. Unfortunately, there's none of that here.")
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="clearfix">
                  <img src="ttt" class="col-md-6 float-md-end mb-3 ms-md-3" alt="yyy">            
                  <p>
                    A paragraph of placeholder text. We&#x27;re using it here to show the use of the clearfix class. We&#x27;re adding quite a few meaningless phrases here to demonstrate how the columns interact here with the floated image.
                  </p>
                  <p>
                    As you can see the paragraphs gracefully wrap around the floated image. Now imagine how this would look with some actual content in here, rather than just this boring placeholder text that goes on and on, but actually conveys no tangible information at. It simply takes up space and should not really be read.
                  </p>
                  <p>
                    And yet, here you are, still persevering in reading this placeholder text, hoping for some more insights, or some hidden easter egg of content. A joke, perhaps. Unfortunately, there&#x27;s none of that here.
                  </p>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("standalone-column-classes2", renderedHtml);

        uiDocumentation.documentSource("standalone-column-classes2");

    }


}
