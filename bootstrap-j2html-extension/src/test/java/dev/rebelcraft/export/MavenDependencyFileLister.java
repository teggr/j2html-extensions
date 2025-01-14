package dev.rebelcraft.export;

import com.helger.commons.collection.impl.ICommonsList;
import com.helger.css.ECSSVersion;
import com.helger.css.decl.CSSSelector;
import com.helger.css.decl.CascadingStyleSheet;
import com.helger.css.decl.ICSSSelectorMember;
import com.helger.css.decl.visit.CSSVisitor;
import com.helger.css.decl.visit.DefaultCSSVisitor;
import com.helger.css.reader.CSSReader;
import com.palantir.javapoet.FieldSpec;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeSpec;

import javax.annotation.Nonnull;
import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MavenDependencyFileLister {

    public static void main(String[] args) throws IOException {

        String cssFilePath = "bootstrap-j2html-extension/src/bootstrap/css/bootstrap.css";

        CascadingStyleSheet css = CSSReader.readFromFile(new File(cssFilePath), StandardCharsets.UTF_8, ECSSVersion.CSS30);

        if (css == null) {

            System.out.println("No CSS found");

        }

        final int[] selectorCount = {0};
        final int[] ignoredPseudos = {0};
        final int[] ignoredHtmlElements = {0};

        Set<String> selectors = new HashSet<>();
        CSSVisitor.visitCSS(css, new DefaultCSSVisitor() {

            @Override
            public void onStyleRuleSelector(@Nonnull CSSSelector cssSelector) {
                super.onStyleRuleSelector(cssSelector);
                // System.out.println(cssSelector);
                ICommonsList<ICSSSelectorMember> allMembers = cssSelector.getAllMembers();
                for (ICSSSelectorMember member : allMembers) {
                    String selector = member.getAsCSSString();
                    if (selector.startsWith(":")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith("*")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith("[")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith(">")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith("+")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith(" ")) {
                        ignoredPseudos[0]++;
                    } else if (selector.startsWith("~")) {
                        ignoredPseudos[0]++;
                    } else if (!selector.startsWith(".")) {
                        ignoredHtmlElements[0]++;
                    } else {
                        System.out.println(selector);
                        selectors.add(selector);
                    }
                }
            }
        });

        System.out.println();
        System.out.println("Selector count: " + selectorCount[0]);
        System.out.println("Ignored pseudo selectors: " + ignoredPseudos[0]);
        System.out.println("Ignored HTML element selectors: " + ignoredHtmlElements[0]);
        System.out.println("Selectors: " + selectors.size());

        File file = new File("bootstrap-j2html-extension/src/main/java/");

        List<FieldSpec> variables = new ArrayList<>();
        for (String selector : selectors) {

            String className = selector.substring(selector.lastIndexOf(".") + 1);
            String variableName = className.replaceAll("-", "_");
            variables.add(FieldSpec
                    .builder(String.class, variableName, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .initializer("$S", className)
                    .build());

        }

        TypeSpec bootstrapTypeSpec = TypeSpec.classBuilder("BootstrapClasses")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addFields(variables)
                .build();

        JavaFile javaFile = JavaFile.builder("dev.rebelcraft.j2html.ext", bootstrapTypeSpec).build();

        javaFile.writeTo(file);

    }

}
