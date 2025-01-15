package com.robintegg.j2html.app.generator;

import j2html.utils.EscapeUtil;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

public class J2HtmlWrapper {

    private final String packageName;
    private final boolean includeImports;
    private final TagLibrary tagLibrary;
    private final String template;
    private final String className;
    private final String testName;
    private final boolean testOnly;

    public J2HtmlWrapper(String packageName, boolean includeImports, TagLibrary tagLibrary, String template, String className, String testName, boolean testOnly) {
        this.packageName = packageName;
        this.includeImports = includeImports;
        this.tagLibrary = tagLibrary;
        this.template = template;
        this.className = className  != null ? StringUtils.capitalize(className) : "ExampleTest";
        this.testName = testName != null ? StringUtils.uncapitalize(testName) : "example";
        this.testOnly = testOnly;
    }

    public String getJ2HtmlCode(String htmlText, String j2HtmlCode) {

        String unitTestName = testName;
        String snippetName = toKebabCase( unitTestName );
        String escapedHtmlText = EscapeUtil.escape(htmlText);

        if ("junituitest".equals(template)) {
            if(testOnly) {
                return UITEST_SNIPPET_TEMPLATE
                        .replace("<<INSERT_TEST_NAME_HERE>>", unitTestName)
                        .replace("<<INSERT_CODE_HERE>>", j2HtmlCode)
                        .replace("<<INSERT_CONTENT_HERE>>", escapedHtmlText)
                        .replace("<<INSERT_SNIPPET_NAME_HERE>>", snippetName);
            } else {
                StringBuilder b = new StringBuilder();
                if (includeImports) {
                    Stream.of(tagLibrary.staticImports())
                            .map(i -> "import static " + i + ";\n")
                            .forEach(b::append);
                    b.append("\n");
                }
                return UITEST_TEMPLATE
                        .replace("<<INSERT_PACKAGE_NAME>>", packageName)
                        .replace("<<INSERT_IMPORTS_HERE>>", b.toString())
                        .replace("<<INSERT_CLASS_NAME_HERE>>", className)
                        .replace("<<INSERT_TEST_NAME_HERE>>", unitTestName)
                        .replace("<<INSERT_CODE_HERE>>", j2HtmlCode)
                        .replace("<<INSERT_CONTENT_HERE>>", escapedHtmlText)
                        .replace("<<INSERT_SNIPPET_NAME_HERE>>", snippetName);
            }
        } else {
            StringBuilder b = new StringBuilder();
            if (includeImports) {
                Stream.of(tagLibrary.staticImports())
                        .map(i -> "import static " + i + ";\n")
                        .forEach(b::append);
                b.append("\n");
            }
            b.append(j2HtmlCode);
            b.append("\n");
            return b.toString();
        }
    }

    private static final String UITEST_TEMPLATE = """
            package <<INSERT_PACKAGE_NAME>>;
            
            import dev.rebelcraft.uidocs.UiDocumentation;
            import org.junit.jupiter.api.BeforeEach;
            import org.junit.jupiter.api.Test;
            import org.junit.jupiter.api.TestInfo;
            
            <<INSERT_IMPORTS_HERE>>
            import static org.junit.jupiter.api.Assertions.assertEquals;
            
            class <<INSERT_CLASS_NAME_HERE>> {
            
                private UiDocumentation uiDocumentation;
            
                @BeforeEach
                void init(TestInfo testInfo) {
                    uiDocumentation = new UiDocumentation(testInfo);
                }
            
                @Test
                void <<INSERT_TEST_NAME_HERE>>() throws Exception {
            
                    String renderedHtml = uiDocumentation.render(
                            <<INSERT_CODE_HERE>>
                    );
            
                    //language=HTML
                    assertEquals(\"\"\"
                        <<INSERT_CONTENT_HERE>>
                        \"\"\", renderedHtml);
            
                    // document
                    uiDocumentation.document(\"<<INSERT_SNIPPET_NAME_HERE>>\", renderedHtml);
            
                    uiDocumentation.documentSource(\"<<INSERT_SNIPPET_NAME_HERE>>\");
            
                }
            
            }
            """;

    private static final String UITEST_SNIPPET_TEMPLATE = """
            @Test
            void <<INSERT_TEST_NAME_HERE>>() throws Exception {
            
                String renderedHtml = uiDocumentation.render(
                        <<INSERT_CODE_HERE>>
                );
            
                //language=HTML
                assertEquals(\"\"\"
                    <<INSERT_CONTENT_HERE>>
                    \"\"\", renderedHtml);
            
                // document
                uiDocumentation.document(\"<<INSERT_SNIPPET_NAME_HERE>>\", renderedHtml);
            
                uiDocumentation.documentSource(\"<<INSERT_SNIPPET_NAME_HERE>>\");
            
            }
            """;

    public static String toKebabCase(String input) {
        // Step 1: Insert space before each uppercase letter (for camelCase or PascalCase)
        // This converts "myVariableName" to "my Variable Name" or "MyVariableName" to "My Variable Name"
        String spaced = input.replaceAll("([a-z])([A-Z])", "$1 $2");

        // Step 2: Replace spaces, underscores, or multiple hyphens with a single hyphen
        String kebab = spaced.replaceAll("[\\s_]+", "-");

        // Step 3: Convert the whole string to lowercase
        return kebab.toLowerCase();
    }
}
