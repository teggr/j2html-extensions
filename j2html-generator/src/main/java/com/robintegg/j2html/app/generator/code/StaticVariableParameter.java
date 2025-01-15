package com.robintegg.j2html.app.generator.code;

public final class StaticVariableParameter implements Parameter {

    private final String className;
    private final String variableName;

    StaticVariableParameter(String className, String variableName) {
        this.className = className;
        this.variableName = variableName;
    }

    public String printParam(String prefix, int indentLevel) {
        return className + "." + variableName;
    }

    @Override
    public boolean isNewlineRequired() {
        return false;
    }
}
