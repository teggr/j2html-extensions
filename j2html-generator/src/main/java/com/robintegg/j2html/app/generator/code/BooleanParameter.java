package com.robintegg.j2html.app.generator.code;

public final class BooleanParameter implements Parameter {

    private final boolean value;

    BooleanParameter(boolean value) {
        this.value = value;
    }

    public String printParam(String prefix, int indentLevel) {
        return "" + value;
    }

    @Override
    public boolean isNewlineRequired() {
        return false;
    }
}
