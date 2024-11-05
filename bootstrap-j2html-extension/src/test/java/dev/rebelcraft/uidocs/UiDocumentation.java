package dev.rebelcraft.uidocs;

import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.printer.lexicalpreservation.LexicalPreservingPrinter;
import j2html.Config;
import j2html.rendering.IndentedHtml;
import j2html.tags.DomContent;
import j2html.utils.Indenter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.TestInfo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
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

    public String render(Supplier<String> document) {
        return document.get();
    }

    public String render(DomContent domContent) throws IOException {
        Config config = Config.global()
                .withIndenter((level, text) -> String.join("", Collections.nCopies(level, "  ")) + text);
        return domContent.render(IndentedHtml.inMemory(config)).toString();
    }

    public <T> void documentSource(String identifier) throws IOException {

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

        // 1. the originating source

        File indexFile = new File(methodOutput, identifier + ".java");

        System.out.println(indexFile);

        // collect the source code

        String javaFile = "src/test/java/" + testInfo.getTestClass().map(Class::getName).orElse("").replaceAll("\\.", "/") + ".java";

        System.out.println(javaFile);

        ParserConfiguration parserConfiguration = StaticJavaParser.getParserConfiguration();
        parserConfiguration.setLanguageLevel(ParserConfiguration.LanguageLevel.JAVA_17);

        CompilationUnit compilationUnit = StaticJavaParser.parse(new File(javaFile));
        LexicalPreservingPrinter.setup(compilationUnit);

        MethodVisitor methodVisitor = new MethodVisitor( testInfo.getTestMethod().map(Method::getName).orElse("") );

        compilationUnit.accept(methodVisitor, null);

        String output = methodVisitor.getMethodSource();

        System.out.println(output);

        FileUtils.write(indexFile, output, StandardCharsets.UTF_8);

    }

    public static class MethodVisitor extends VoidVisitorAdapter<Void> {

        private final String methodName;
        private  String methodSource;

        public MethodVisitor(String methodName) {
            this.methodName = methodName;
        }

        public String getMethodSource() {
            return methodSource;
        }

        @Override
        public void visit(MethodDeclaration method, Void arg) {
            super.visit(method, arg);
            // Check if this is the method we are looking for
            if (method.getNameAsString().equals(methodName )) {

                method.accept(new VoidVisitorAdapter<Void>() {

                    @Override
                    public void visit(MethodCallExpr methodCall, Void arg) {
                        super.visit(methodCall, arg);
                        if (methodCall.getNameAsString().equals("render")) {
                            // Get the argument to render() and print it
                            Expression argument = methodCall.getArgument(0);
                            System.out.println("Argument to render() method:");
                            System.out.println(argument.toString());

                            methodSource = LexicalPreservingPrinter.print(argument);

                        }
                    }

                }, null);

                // This prints the method's source code
            }
        }
    }
}
