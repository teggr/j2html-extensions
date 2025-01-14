package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.BootstrapClasses;
import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uitest.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PaginationTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void overview() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                 .attr(
                    AriaStatesAndProperties.ariaLabel("Page navigation example")
                  )
                 .with(
                    ul()
                     .withClasses(BootstrapClasses.pagination)
                     .with(
                        li()
                         .withClasses(BootstrapClasses.page_item)
                         .with(
                            a()
                             .withClasses(BootstrapClasses.page_link)
                             .withHref("#")
                             .with(
                                text("Previous")
                              )
                          ),
                        li()
                         .withClasses(BootstrapClasses.page_item)
                         .with(
                            a()
                             .withClasses(BootstrapClasses.page_link)
                             .withHref("#")
                             .with(
                                text("1")
                              )
                          ),
                        li()
                         .withClasses(BootstrapClasses.page_item)
                         .with(
                            a()
                             .withClasses(BootstrapClasses.page_link)
                             .withHref("#")
                             .with(
                                text("2")
                              )
                          ),
                        li()
                         .withClasses(BootstrapClasses.page_item)
                         .with(
                            a()
                             .withClasses(BootstrapClasses.page_link)
                             .withHref("#")
                             .with(
                                text("3")
                              )
                          ),
                        li()
                         .withClasses(BootstrapClasses.page_item)
                         .with(
                            a()
                             .withClasses(BootstrapClasses.page_link)
                             .withHref("#")
                             .with(
                                text("Next")
                              )
                          )
                      )
                  )
        );

        //language=HTML
        assertEquals("""
            <nav aria-label="Page navigation example">
              <ul class="pagination">
                <li class="page-item">
                  <a class="page-link" href="#">
                    Previous
                  </a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">
                    1
                  </a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">
                    2
                  </a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">
                    3
                  </a>
                </li>
                <li class="page-item">
                  <a class="page-link" href="#">
                    Next
                  </a>
                </li>
              </ul>
            </nav>
            """, renderedHtml);

        // document
        uiDocumentation.document("overview", renderedHtml);

        uiDocumentation.documentSource("overview");

    }

    @Test
    void workingWithIcons() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Page navigation example")
                        )
                        .with(
                                ul()
                                        .withClasses(BootstrapClasses.pagination)
                                        .with(
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Previous")
                                                                        )
                                                                        .with(
                                                                                span()
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaHidden("true")
                                                                                        )
                                                                                        .with(
                                                                                                text("«")
                                                                                        )
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("1")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("2")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("3")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaLabel("Next")
                                                                        )
                                                                        .with(
                                                                                span()
                                                                                        .attr(
                                                                                                AriaStatesAndProperties.ariaHidden("true")
                                                                                        )
                                                                                        .with(
                                                                                                text("»")
                                                                                        )
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav aria-label="Page navigation example">
          <ul class="pagination">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">
                  &laquo;
                </span>
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                1
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                2
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                3
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">
                  &raquo;
                </span>
              </a>
            </li>
          </ul>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("working-with-icons", renderedHtml);

        uiDocumentation.documentSource("working-with-icons");

    }

    @Test
    void disabledAndActiveStates() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .attr(
                                AriaStatesAndProperties.ariaLabel("...")
                        )
                        .with(
                                ul()
                                        .withClasses(BootstrapClasses.pagination)
                                        .with(
                                                li()
                                                        .withClasses(BootstrapClasses.page_item,BootstrapClasses.disabled)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .with(
                                                                                text("Previous")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("1")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item,BootstrapClasses.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("2")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("3")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Next")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav aria-label="...">
          <ul class="pagination">
            <li class="page-item disabled">
              <a class="page-link">
                Previous
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                1
              </a>
            </li>
            <li class="page-item active" aria-current="page">
              <a class="page-link" href="#">
                2
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                3
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                Next
              </a>
            </li>
          </ul>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("disabled-and-active-states", renderedHtml);

        uiDocumentation.documentSource("disabled-and-active-states");

    }

    @Test
    void disabledAndActiveStates2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .attr(
                                AriaStatesAndProperties.ariaLabel("...")
                        )
                        .with(
                                ul()
                                        .withClasses(BootstrapClasses.pagination)
                                        .with(
                                                li()
                                                        .withClasses(BootstrapClasses.page_item,BootstrapClasses.disabled)
                                                        .with(
                                                                span()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .with(
                                                                                text("Previous")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("1")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item,BootstrapClasses.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .with(
                                                                                text("2")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("3")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Next")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav aria-label="...">
          <ul class="pagination">
            <li class="page-item disabled">
              <span class="page-link">
                Previous
              </span>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                1
              </a>
            </li>
            <li class="page-item active" aria-current="page">
              <span class="page-link">
                2
              </span>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                3
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                Next
              </a>
            </li>
          </ul>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("disabled-and-active-states2", renderedHtml);

        uiDocumentation.documentSource("disabled-and-active-states2");

    }

    @Test
    void sizing() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .attr(
                                AriaStatesAndProperties.ariaLabel("...")
                        )
                        .with(
                                ul()
                                        .withClasses(BootstrapClasses.pagination,BootstrapClasses.pagination_lg)
                                        .with(
                                                li()
                                                        .withClasses(BootstrapClasses.page_item,BootstrapClasses.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .with(
                                                                                text("1")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("2")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("3")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav aria-label="...">
          <ul class="pagination pagination-lg">
            <li class="page-item active" aria-current="page">
              <span class="page-link">
                1
              </span>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                2
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                3
              </a>
            </li>
          </ul>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("sizing", renderedHtml);

        uiDocumentation.documentSource("sizing");

    }

    @Test
    void sizing2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .attr(
                                AriaStatesAndProperties.ariaLabel("...")
                        )
                        .with(
                                ul()
                                        .withClasses(BootstrapClasses.pagination,BootstrapClasses.pagination_sm)
                                        .with(
                                                li()
                                                        .withClasses(BootstrapClasses.page_item,BootstrapClasses.active)
                                                        .attr(
                                                                AriaStatesAndProperties.ariaCurrent("page")
                                                        )
                                                        .with(
                                                                span()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .with(
                                                                                text("1")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("2")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("3")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav aria-label="...">
          <ul class="pagination pagination-sm">
            <li class="page-item active" aria-current="page">
              <span class="page-link">
                1
              </span>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                2
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                3
              </a>
            </li>
          </ul>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("sizing2", renderedHtml);

        uiDocumentation.documentSource("sizing2");

    }

    @Test
    void alignment() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Page navigation example")
                        )
                        .with(
                                ul()
                                        .withClasses(BootstrapClasses.pagination, BootstrapClasses.justify_content_center)
                                        .with(
                                                li()
                                                        .withClasses(BootstrapClasses.page_item,BootstrapClasses.disabled)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .with(
                                                                                text("Previous")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("1")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("2")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("3")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Next")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-center">
            <li class="page-item disabled">
              <a class="page-link">
                Previous
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                1
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                2
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                3
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                Next
              </a>
            </li>
          </ul>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("alignment", renderedHtml);

        uiDocumentation.documentSource("alignment");

    }

    @Test
    void alignment2() throws Exception {

        String renderedHtml = uiDocumentation.render(
                nav()
                        .attr(
                                AriaStatesAndProperties.ariaLabel("Page navigation example")
                        )
                        .with(
                                ul()
                                        .withClasses(BootstrapClasses.pagination,BootstrapClasses.justify_content_end)
                                        .with(
                                                li()
                                                        .withClasses(BootstrapClasses.page_item,BootstrapClasses.disabled)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .with(
                                                                                text("Previous")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("1")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("2")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("3")
                                                                        )
                                                        ),
                                                li()
                                                        .withClasses(BootstrapClasses.page_item)
                                                        .with(
                                                                a()
                                                                        .withClasses(BootstrapClasses.page_link)
                                                                        .withHref("#")
                                                                        .with(
                                                                                text("Next")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-end">
            <li class="page-item disabled">
              <a class="page-link">
                Previous
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                1
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                2
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                3
              </a>
            </li>
            <li class="page-item">
              <a class="page-link" href="#">
                Next
              </a>
            </li>
          </ul>
        </nav>
        """, renderedHtml);

        // document
        uiDocumentation.document("alignment2", renderedHtml);

        uiDocumentation.documentSource("alignment2");

    }



}
