package dev.rebelcraft.j2html.ext.components;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;
import static dev.rebelcraft.j2html.ext.TestUtils.demo;
import static dev.rebelcraft.j2html.ext.components.Alert.*;
import static j2html.TagCreator.*;

class AlertExamplesTest {

    @Test
    void example() throws MalformedURLException, FileNotFoundException {

        String output = demo(each(
                div().withClasses(alert, alert_primary).attr(role())
                        .withText("A simple primary alert with ")
                        .with(
                                a().withHref("#").withClass(alert_link)
                                        .withText("an example link")
                        )
                        .withText(". Give it a click if you like.")
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