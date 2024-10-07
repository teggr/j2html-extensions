package dev.rebelcraft.j2html.ext.components;

import com.codeborne.selenide.Configuration;
import j2html.tags.DomContent;
import j2html.tags.specialized.ButtonTag;
import j2html.tags.specialized.DivTag;
import j2html.tags.specialized.H2Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static dev.rebelcraft.j2html.ext.TestUtils.demo;
import static dev.rebelcraft.j2html.ext.components.Accordion.*;
import static j2html.TagCreator.*;

public class AccordionExamplesTest {

    @Test
    void example() throws MalformedURLException, FileNotFoundException {

        String output = demo(
                AccordionExamplesTest.accordion()
                        .withId("accordionExample")
                        .with(
                                accordionItem(
                                        accordionHeader()
                                                .with(accordionButton("#collapseOne", true, true, "collapseOne")
                                                        .withText("Accordion Item #1")),
                                        accordionCollapse("collapseOne", "#accordionExample", true,
                                                accordionBody(
                                                        rawHtml("<strong>This is the first item's accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.")
                                                )
                                        )
                                ),
                                accordionItem(
                                        accordionHeader()
                                                .with(accordionButton("#collapseTwo", false, false, "collapseTwo")
                                                        .withText("Accordion Item #2")),
                                        accordionCollapse("collapseTwo", "#accordionExample", false,
                                                accordionBody(
                                                        rawHtml(" <strong>This is the second item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.")
                                                )
                                        )
                                ),
                                accordionItem(
                                        accordionHeader()
                                                .with(accordionButton("#collapseThree", false, false, "collapseThree")
                                                        .withText("Accordion Item #3")),
                                        accordionCollapse("collapseThree", "#accordionExample", false,
                                                accordionBody(
                                                        rawHtml("<strong>This is the third item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.")
                                                )
                                        )
                                )
                        )

        );

        System.out.println(output);

        File resourcesDirectory = new File("target/test-resources");

        resourcesDirectory.mkdirs();

        File outputFile = new File(resourcesDirectory, "quickstart.html");

        try (PrintWriter out = new PrintWriter(outputFile)) {
            out.println(output);
        }

        //Configuration.headless = true;
        Configuration.reportsFolder = "target/test-reports";

        open(outputFile.toURI().toURL());
        String test = screenshot("test");
        System.out.println(test);

    }

    private static DivTag accordion() {

        return div()
                .withClass(Accordion.accordion);

    }

    private static DivTag accordionItem(DomContent header, DomContent body) {

        return div()
                .withClass(accordion_item)
                .with(header, body);

    }

    private static H2Tag accordionHeader() {

        return h2()
                .withClass(accordion_header);

    }

    private static ButtonTag accordionButton(String selector, boolean collapse, boolean expanded, String controls) {

        return button()
                .withClass(accordion_button)
                .withType("button")
                .attr(Collapse.dataBSTarget(selector))
                .attr(Collapse.dataBSToggle(collapse))
                .attr(Collapse.ariaExpanded(expanded))
                .attr(Collapse.ariaControls(controls));

    }

    private static DivTag accordionCollapse(String id, String selector, boolean show, DomContent... contents) {

        return div()
                .withId(id)
                .withClasses(accordion_collapse, Collapse.collapse, iff(show, "show"))
                .attr(Accordion.bsParent(selector))
                .with(contents);

    }

    private static DivTag accordionBody(DomContent... contents) {

        return div()
                .withClass(accordion_body)
                .with(contents);

    }
}
