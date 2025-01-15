package com.robintegg.j2html.app.generator.code;

public final class BuilderMethodCallParameter implements Parameter {

    private final BuilderMethodCall builderMethodCall;

    BuilderMethodCallParameter(BuilderMethodCall builderMethodCall) {
        this.builderMethodCall = builderMethodCall;
    }

    public String printParam(String prefix, int indentLevel) {
        return builderMethodCall.printBuilder(prefix, indentLevel);
    }

    @Override
    public boolean isNewlineRequired() {
        return true;
    }

}
