package com.robintegg.j2html.app.generator.code;

import java.util.ArrayList;
import java.util.List;

public final class CodeTree {

    private List<RenderableCode> codeSnippets = new ArrayList<>();

    CodeTree() {
    }

    public CodeTree withBuilderMethodCall(BuilderMethodCall builderMethodCall) {
        codeSnippets.add(builderMethodCall::printBuilder);
        return this;
    }

    public CodeTree withMethodCall(MethodCall methodCall) {
        codeSnippets.add(methodCall::printMethod);
        return this;
    }

    public String printCode(String prefix) {
        int indentLevel = 0;

        StringBuilder sb = new StringBuilder();
        for (RenderableCode builder : codeSnippets) {
            sb.append(builder.print(prefix, indentLevel));
        }
        return sb.toString();
    }

    private interface RenderableCode {
        String print(String prefix, int indentLevel);
    }

}
