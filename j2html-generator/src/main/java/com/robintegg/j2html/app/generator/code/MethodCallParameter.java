package com.robintegg.j2html.app.generator.code;

public final class MethodCallParameter implements Parameter {

    private final MethodCall methodCall;

    MethodCallParameter(MethodCall methodCall) {
        this.methodCall = methodCall;
    }

    public String printParam(String prefix, int indentLevel) {
        return methodCall.printMethod(prefix, indentLevel);
    }

    @Override
    public boolean isNewlineRequired() {
        return true;
    }

}
