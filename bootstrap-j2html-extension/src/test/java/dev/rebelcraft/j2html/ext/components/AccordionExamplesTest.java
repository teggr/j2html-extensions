package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties;
import dev.rebelcraft.uidocs.UiDocumentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccordionExamplesTest {

    private UiDocumentation uiDocumentation;

    @BeforeEach
    void init(TestInfo testInfo) {
        uiDocumentation = new UiDocumentation(testInfo);
    }

    @Test
    void example() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Accordion.accordion)
                        .withId("accordionExample")
                        .with(
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#collapseOne")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("true")
                                                                        )
                                                                        .attr(AriaStatesAndProperties.ariaControls("collapseOne"))
                                                                        .with(
                                                                                text("Accordion Item #1")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("collapseOne")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse,Collapse.show)
                                                        .withData("bs-parent","#accordionExample")
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                strong()
                                                                                        .with(
                                                                                                text("This is the first item's accordion body.")
                                                                                        ),
                                                                                text("It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-body")
                                                                                        ),
                                                                                text(", though the transition does limit overflow.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button,Collapse.collapsed)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#collapseTwo")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .attr(AriaStatesAndProperties.ariaControls("collapseTwo"))
                                                                        .with(
                                                                                text("Accordion Item #2")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("collapseTwo")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse)
                                                        .withData("bs-parent","#accordionExample")
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                strong()
                                                                                        .with(
                                                                                                text("This is the second item's accordion body.")
                                                                                        ),
                                                                                text("It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-body")
                                                                                        ),
                                                                                text(", though the transition does limit overflow.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button,Collapse.collapsed)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#collapseThree")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .attr(AriaStatesAndProperties.ariaControls("collapseThree"))
                                                                        .with(
                                                                                text("Accordion Item #3")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("collapseThree")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse)
                                                        .withData("bs-parent","#accordionExample")
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                strong()
                                                                                        .with(
                                                                                                text("This is the third item's accordion body.")
                                                                                        ),
                                                                                text("It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-body")
                                                                                        ),
                                                                                text(", though the transition does limit overflow.")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="accordion" id="accordionExample">
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Accordion Item #1
                      </button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
                      <div class="accordion-body">
                        <strong>
                          This is the first item&#x27;s accordion body.
                        </strong>
                        It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It&#x27;s also worth noting that just about any HTML can go within the
                        <code>
                          .accordion-body
                        </code>
                        , though the transition does limit overflow.
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Accordion Item #2
                      </button>
                    </h2>
                    <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                      <div class="accordion-body">
                        <strong>
                          This is the second item&#x27;s accordion body.
                        </strong>
                        It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It&#x27;s also worth noting that just about any HTML can go within the 
                        <code>
                          .accordion-body
                        </code>
                        , though the transition does limit overflow.
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Accordion Item #3
                      </button>
                    </h2>
                    <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                      <div class="accordion-body">
                        <strong>
                          This is the third item&#x27;s accordion body.
                        </strong>
                        It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It&#x27;s also worth noting that just about any HTML can go within the
                        <code>
                          .accordion-body
                        </code>
                        , though the transition does limit overflow.
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("example", renderedHtml);

        uiDocumentation.documentSource("example");

    }

    @Test
    void flush() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Accordion.accordion,Accordion.accordion_flush)
                        .withId("accordionFlushExample")
                        .with(
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button,Collapse.collapsed)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#flush-collapseOne")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaControls("flush-collapseOne")
                                                                        )
                                                                        .with(
                                                                                text("Accordion Item #1")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("flush-collapseOne")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse)
                                                        .withData("bs-parent","#accordionFlushExample")
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                text("Placeholder content for this accordion, which is intended to demonstrate the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-flush")
                                                                                        ),
                                                                                text(" class. This is the first item's accordion body.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button,Collapse.collapsed)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#flush-collapseTwo")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaControls("flush-collapseTwo")
                                                                        )
                                                                        .with(
                                                                                text("Accordion Item #2")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("flush-collapseTwo")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse)
                                                        .withData("bs-parent","#accordionFlushExample")
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                text("Placeholder content for this accordion, which is intended to demonstrate the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-flush")
                                                                                        ),
                                                                                text(" class. This is the second item's accordion body. Let's imagine this being filled with some actual content.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button,Collapse.collapsed)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#flush-collapseThree")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaControls("flush-collapseThree")
                                                                        )
                                                                        .with(
                                                                                text("Accordion Item #3")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("flush-collapseThree")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse)
                                                        .withData("bs-parent","#accordionFlushExample")
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                text("Placeholder content for this accordion, which is intended to demonstrate the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-flush")
                                                                                        ),
                                                                                text(" class. This is the third item's accordion body. Nothing more exciting happening here in terms of content, but just filling up the space to make it look, at least at first glance, a bit more representative of how this would look in a real-world application.")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="accordion accordion-flush" id="accordionFlushExample">
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                        Accordion Item #1
                      </button>
                    </h2>
                    <div id="flush-collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                      <div class="accordion-body">
                        Placeholder content for this accordion, which is intended to demonstrate the
                        <code>
                          .accordion-flush
                        </code>
                         class. This is the first item&#x27;s accordion body.
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                        Accordion Item #2
                      </button>
                    </h2>
                    <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                      <div class="accordion-body">
                        Placeholder content for this accordion, which is intended to demonstrate the
                        <code>
                          .accordion-flush
                        </code>
                         class. This is the second item&#x27;s accordion body. Let&#x27;s imagine this being filled with some actual content.
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree">
                        Accordion Item #3
                      </button>
                    </h2>
                    <div id="flush-collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                      <div class="accordion-body">
                        Placeholder content for this accordion, which is intended to demonstrate the
                        <code>
                          .accordion-flush
                        </code>
                         class. This is the third item&#x27;s accordion body. Nothing more exciting happening here in terms of content, but just filling up the space to make it look, at least at first glance, a bit more representative of how this would look in a real-world application.
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("flush", renderedHtml);

        uiDocumentation.documentSource("flush");

    }

    @Test
    void alwaysOpen() throws Exception {

        String renderedHtml = uiDocumentation.render(
                div()
                        .withClasses(Accordion.accordion)
                        .withId("accordionPanelsStayOpenExample")
                        .with(
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#panelsStayOpen-collapseOne")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("true")
                                                                        )
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaControls("panelsStayOpen-collapseOne")
                                                                        )
                                                                        .with(
                                                                                text("Accordion Item #1")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("panelsStayOpen-collapseOne")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse,Collapse.show)
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                strong()
                                                                                        .with(
                                                                                                text("This is the first item's accordion body.")
                                                                                        ),
                                                                                text("It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-body")
                                                                                        ),
                                                                                text(", though the transition does limit overflow.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button,Collapse.collapsed)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#panelsStayOpen-collapseTwo")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaControls("panelsStayOpen-collapseTwo")
                                                                        )
                                                                        .with(
                                                                                text("Accordion Item #2")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("panelsStayOpen-collapseTwo")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse)
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                strong()
                                                                                        .with(
                                                                                                text("This is the second item's accordion body.")
                                                                                        ),
                                                                                text("It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-body")
                                                                                        ),
                                                                                text(", though the transition does limit overflow.")
                                                                        )
                                                        )
                                        ),
                                div()
                                        .withClasses(Accordion.accordion_item)
                                        .with(
                                                h2()
                                                        .withClasses(Accordion.accordion_header)
                                                        .with(
                                                                button()
                                                                        .withClasses(Accordion.accordion_button,Collapse.collapsed)
                                                                        .withType("button")
                                                                        .withData("bs-toggle","collapse")
                                                                        .withData("bs-target","#panelsStayOpen-collapseThree")
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaExpanded("false")
                                                                        )
                                                                        .attr(
                                                                                AriaStatesAndProperties.ariaControls("panelsStayOpen-collapseThree")
                                                                        )
                                                                        .with(
                                                                                text("Accordion Item #3")
                                                                        )
                                                        ),
                                                div()
                                                        .withId("panelsStayOpen-collapseThree")
                                                        .withClasses(Accordion.accordion_collapse,Collapse.collapse)
                                                        .with(
                                                                div()
                                                                        .withClasses(Accordion.accordion_body)
                                                                        .with(
                                                                                strong()
                                                                                        .with(
                                                                                                text("This is the third item's accordion body.")
                                                                                        ),
                                                                                text("It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the"),
                                                                                code()
                                                                                        .with(
                                                                                                text(".accordion-body")
                                                                                        ),
                                                                                text(", though the transition does limit overflow.")
                                                                        )
                                                        )
                                        )
                        )
        );

        //language=HTML
        assertEquals("""
                <div class="accordion" id="accordionPanelsStayOpenExample">
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                        Accordion Item #1
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show">
                      <div class="accordion-body">
                        <strong>
                          This is the first item&#x27;s accordion body.
                        </strong>
                        It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It&#x27;s also worth noting that just about any HTML can go within the
                        <code>
                          .accordion-body
                        </code>
                        , though the transition does limit overflow.
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="false" aria-controls="panelsStayOpen-collapseTwo">
                        Accordion Item #2
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse">
                      <div class="accordion-body">
                        <strong>
                          This is the second item&#x27;s accordion body.
                        </strong>
                        It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It&#x27;s also worth noting that just about any HTML can go within the
                        <code>
                          .accordion-body
                        </code>
                        , though the transition does limit overflow.
                      </div>
                    </div>
                  </div>
                  <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseThree" aria-expanded="false" aria-controls="panelsStayOpen-collapseThree">
                        Accordion Item #3
                      </button>
                    </h2>
                    <div id="panelsStayOpen-collapseThree" class="accordion-collapse collapse">
                      <div class="accordion-body">
                        <strong>
                          This is the third item&#x27;s accordion body.
                        </strong>
                        It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It&#x27;s also worth noting that just about any HTML can go within the
                        <code>
                          .accordion-body
                        </code>
                        , though the transition does limit overflow.
                      </div>
                    </div>
                  </div>
                </div>
                """, renderedHtml);

        // document
        uiDocumentation.document("always-open", renderedHtml);

        uiDocumentation.documentSource("always-open");

    }


}
