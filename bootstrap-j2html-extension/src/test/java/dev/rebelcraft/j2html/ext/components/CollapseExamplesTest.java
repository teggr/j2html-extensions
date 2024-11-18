package dev.rebelcraft.j2html.ext.components;

import com.codeborne.selenide.Configuration;
import dev.rebelcraft.j2html.ext.utilities.Display;
import dev.rebelcraft.j2html.ext.utilities.Spacing;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static dev.rebelcraft.j2html.ext.TestUtils.demo;
import static dev.rebelcraft.j2html.ext.components.Collapse.*;
import static j2html.TagCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollapseExamplesTest {

    @Test
    void example() throws MalformedURLException, FileNotFoundException {

        String output = demo( each(
                p().withClasses(Display.d_inline_flex, Spacing.gap_1)
                        .with(
                                a().withClasses(Buttons.btn, Buttons.btn_primary)
                                        .attr(dataBSToggle(true))
                                        .withHref("#collapseExample")
                                        .attr("role", "button")
                                        .attr(ariaExpanded(Boolean.FALSE))
                                        .attr(ariaControls("collapseExample"))
                                        .withText("Link with href"),
                                button().withClasses(Buttons.btn, Buttons.btn_primary)
                                        .withType("button")
                                        .attr(dataBSToggle(true))
                                        .attr(dataBSTarget("#collapseExample"))
                                        .attr(ariaExpanded(Boolean.FALSE))
                                        .attr(ariaControls("collapseExample"))
                                        .withText("Button with data-bs-target")
                        ),
                div().withClasses(collapse)
                        .withId("collapseExample")
                        .with(
                                div().withClasses(Card.card, Card.card_body)
                                        .withText("Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.")
                        )
        ));

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

}