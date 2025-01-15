package com.robintegg.j2html.app.generator.code;


import java.util.ArrayList;
import java.util.List;

public final class BuilderMethodCall {

    private final String methodName;
    private final List<ChainedMethodCall> chainedCalls = new ArrayList<>();

    BuilderMethodCall(String methodName) {
        this.methodName = methodName;
    }

    public BuilderMethodCall withChainedMethodCall(ChainedMethodCall chainedCall) {
        chainedCalls.add(chainedCall);
        return this;
    }

    public String printBuilder(String prefix, int indentLevel) {
        String indent = prefix.repeat(indentLevel);
        StringBuilder sb = new StringBuilder();
        sb.append(indent).append(methodName).append("()");
        if (!chainedCalls.isEmpty()) {
            for (ChainedMethodCall chainedCall : chainedCalls) {
                sb.append("\n");
                sb.append(chainedCall.printMethod(prefix, indentLevel + 1));
            }
        }
        return sb.toString();
    }

}
