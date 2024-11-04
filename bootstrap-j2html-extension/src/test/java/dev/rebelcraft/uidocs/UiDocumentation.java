package dev.rebelcraft.uidocs;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.TestInfo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

public class UiDocumentation {

    private static File getDefaultOutputDirectory() {
        if (new File("pom.xml").exists()) {
            return new File("target/generated-snippets");
        }
        return new File("build/generated-snippets");
    }

    private final TestInfo testInfo;

    public UiDocumentation(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    public String render(Supplier<String> document) {
        return document.get();
    }

    public void document(String identifier, String output) throws IOException {

        System.out.println(testInfo.getTestClass());
        System.out.println(testInfo.getTestMethod());
        System.out.println(testInfo.getDisplayName());
        System.out.println(testInfo.getTags());

        File outputDirectory = getDefaultOutputDirectory();

        System.out.println(outputDirectory);

        File classOutput = new File(outputDirectory, testInfo.getTestClass().map(Class::getSimpleName).orElse("no-test-class"));

        System.out.println(classOutput);

        File methodOutput = new File(classOutput, testInfo.getTestMethod().map(Method::getName).orElse("no-method-name"));

        System.out.println(methodOutput);

        System.out.println(methodOutput.mkdirs());

        // what am I documenting here?

        // 1. the output as an index.html

        File indexFile = new File(methodOutput, identifier + ".html");

        System.out.println(indexFile);

        FileUtils.write(indexFile, output, StandardCharsets.UTF_8);

    }

}
