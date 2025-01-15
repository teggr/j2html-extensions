package com.robintegg.j2html.app.generator.code;

import org.junit.jupiter.api.Test;

import static com.robintegg.j2html.app.generator.code.CodeTreeCreator.*;
import static org.assertj.core.api.Assertions.assertThat;

class CodeTreeTest {

    @Test
    void shouldOutputEmptyCode() {

        CodeTree codeTree = codeTree();

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("");

    }

    @Test
    void shouldOutputBuilder() {

        CodeTree codeTree = codeTree();
        codeTree.withBuilderMethodCall(builder("h1"));

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("h1()");

    }

    @Test
    void shouldOutputBuilderWithChainedMethods() {

        CodeTree codeTree = codeTree();
        BuilderMethodCall builderMethodCall = builder("h1");
        builderMethodCall.withChainedMethodCall(chainedMethodCall("with"));
        builderMethodCall.withChainedMethodCall(chainedMethodCall("withId"));
        builderMethodCall.withChainedMethodCall(chainedMethodCall("withHef"));
        codeTree.withBuilderMethodCall(builderMethodCall);

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("""
                h1()
                  .with()
                  .withId()
                  .withHef()""");

    }

    @Test
    void shouldOutputBuilderWithChainedMethodsAndSingleStringParameter() {

        CodeTree codeTree = codeTree();
        BuilderMethodCall builderMethodCall = builder("h1");

        ChainedMethodCall with = chainedMethodCall("with");
        builderMethodCall.withChainedMethodCall(with);

        ChainedMethodCall withId = chainedMethodCall("withId");
        withId.withParameter(plainTextParameter("some-id"));
        builderMethodCall.withChainedMethodCall(withId);

        ChainedMethodCall withHef = chainedMethodCall("withHef");
        withHef.withParameter(plainTextParameter("http://"));
        builderMethodCall.withChainedMethodCall(withHef);

        codeTree.withBuilderMethodCall(builderMethodCall);

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("""
                h1()
                  .with()
                  .withId("some-id")
                  .withHef("http://")""");

    }

    @Test
    void shouldOutputBuilderWithChainedMethodsAndMultipleStringParameters() {

        CodeTree codeTree = new CodeTree();
        BuilderMethodCall builderMethodCall = builder("h1");

        ChainedMethodCall with = chainedMethodCall("with");
        builderMethodCall.withChainedMethodCall(with);

        ChainedMethodCall withId = chainedMethodCall("withId");
        withId.withParameter(plainTextParameter("some-id"));
        builderMethodCall.withChainedMethodCall(withId);

        ChainedMethodCall withHef = chainedMethodCall("withHef");
        withHef.withParameter(plainTextParameter("http://"));
        withHef.withParameter(plainTextParameter("something else"));
        builderMethodCall.withChainedMethodCall(withHef);

        codeTree.withBuilderMethodCall(builderMethodCall);

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("""
                h1()
                  .with()
                  .withId("some-id")
                  .withHef("http://","something else")""");

    }

    @Test
    void shouldOutputBuilderWithChainedMethodsAndSingleBuilderParameter() {

        CodeTree codeTree =codeTree();
        BuilderMethodCall builderMethodCall = builder("h1");

        ChainedMethodCall withId = chainedMethodCall("withId");
        withId.withParameter(plainTextParameter("some-id"));
        builderMethodCall.withChainedMethodCall(withId);

        ChainedMethodCall withHef = chainedMethodCall("withHef");
        withHef.withParameter( plainTextParameter("http://"));
        builderMethodCall.withChainedMethodCall(withHef);

        BuilderMethodCall pb = builder("p");

        ChainedMethodCall with = chainedMethodCall("with");
        with.withParameter(builderMethodCallParameter(pb));
        builderMethodCall.withChainedMethodCall(with);

        codeTree.withBuilderMethodCall(builderMethodCall);

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("""
                h1()
                  .withId("some-id")
                  .withHef("http://")
                  .with(
                    p()
                  )""");

    }

    @Test
    void shouldOutputBuilderWithChainedMethodsAndMultipleBuilderParameter() {

        CodeTree codeTree = codeTree();
        BuilderMethodCall builderMethodCall = builder("h1");

        ChainedMethodCall withId = chainedMethodCall("withId");
        withId.withParameter(plainTextParameter("some-id"));
        builderMethodCall.withChainedMethodCall(withId);

        ChainedMethodCall withHef = chainedMethodCall("withHef");
        withHef.withParameter(plainTextParameter("http://"));
        builderMethodCall.withChainedMethodCall(withHef);

        BuilderMethodCall pb = builder("p");
        BuilderMethodCall div = builder("div");

        ChainedMethodCall with = chainedMethodCall("with");
        with.withParameter(builderMethodCallParameter(pb));
        with.withParameter(builderMethodCallParameter(div));
        builderMethodCall.withChainedMethodCall(with);

        codeTree.withBuilderMethodCall(builderMethodCall);

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("""
                h1()
                  .withId("some-id")
                  .withHef("http://")
                  .with(
                    p(),
                    div()
                  )""");

    }

    @Test
    void shouldOutputBuilderWithChainedMethodsAndMultipleNestedParameters() {

        CodeTree codeTree = codeTree();
        BuilderMethodCall builderMethodCall = builder("h1");

        ChainedMethodCall withId = chainedMethodCall("withId");
        withId.withParameter(plainTextParameter("some-id"));
        builderMethodCall.withChainedMethodCall(withId);

        ChainedMethodCall withHef = chainedMethodCall("withHef");
        withHef.withParameter(plainTextParameter("http://"));
        builderMethodCall.withChainedMethodCall(withHef);

        BuilderMethodCall pb = builder("p");

        BuilderMethodCall div = builder("div");
        ChainedMethodCall nestedWith = chainedMethodCall("with");
        nestedWith.withParameter(builderMethodCallParameter(builder("a")));
        nestedWith.withParameter(builderMethodCallParameter(builder("hr")));
        div.withChainedMethodCall(nestedWith);

        ChainedMethodCall with = chainedMethodCall("with");
        with.withParameter(builderMethodCallParameter(pb));
        with.withParameter(builderMethodCallParameter(div));
        builderMethodCall.withChainedMethodCall(with);

        codeTree.withBuilderMethodCall(builderMethodCall);

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("""
                h1()
                  .withId("some-id")
                  .withHef("http://")
                  .with(
                    p(),
                    div()
                      .with(
                        a(),
                        hr()
                      )
                  )""");

    }

    @Test
    void shouldOutputBuilderWithChainedMethodsAndMultipleNestedParameterTypes() {

        CodeTree codeTree = codeTree();
        BuilderMethodCall builderMethodCall = builder("h1");

        ChainedMethodCall withId = chainedMethodCall("withId");
        withId.withParameter(plainTextParameter("some-id"));
        builderMethodCall.withChainedMethodCall(withId);

        ChainedMethodCall withHef = chainedMethodCall("withHef");
        withHef.withParameter(plainTextParameter("http://"));
        builderMethodCall.withChainedMethodCall(withHef);

        BuilderMethodCall pb = builder("p");

        BuilderMethodCall div = builder("div");
        ChainedMethodCall nestedWith = chainedMethodCall("with");
        nestedWith.withParameter(builderMethodCallParameter(builder("a")));
        nestedWith.withParameter(builderMethodCallParameter(builder("hr")));
        div.withChainedMethodCall(nestedWith);

        ChainedMethodCall with = chainedMethodCall("with");
        with.withParameter(
                methodCallParameter(
                        methodCall("text")
                                .withParameter(
                                        plainTextParameter("start value"))));
        with.withParameter(builderMethodCallParameter(pb));
        with.withParameter(
                methodCallParameter(
                        methodCall("text")
                                .withParameter(
                                        plainTextParameter("middle value"))));
        with.withParameter(builderMethodCallParameter(div));
        with.withParameter(
                methodCallParameter(
                        methodCall("text")
                                .withParameter(
                                        plainTextParameter("end value"))));
        builderMethodCall.withChainedMethodCall(with);

        codeTree.withBuilderMethodCall(builderMethodCall);

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("""
                h1()
                  .withId("some-id")
                  .withHef("http://")
                  .with(
                    text("start value"),
                    p(),
                    text("middle value"),
                    div()
                      .with(
                        a(),
                        hr()
                      ),
                    text("end value")
                  )""");

    }

    @Test
    void shouldOutputPlainMethodCall() {

        CodeTree codeTree = codeTree();

        MethodCall code = methodCall("code");
        code.withParameter(plainTextParameter("some code here"));

        codeTree.withMethodCall(code);

        String output = codeTree.printCode("  ");

        assertThat(output).isEqualTo("""
                code("some code here")""");

    }

}