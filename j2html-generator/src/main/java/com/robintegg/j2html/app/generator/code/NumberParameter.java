package com.robintegg.j2html.app.generator.code;

public final class NumberParameter implements Parameter {

    private final Integer number;

    NumberParameter(Integer number) {
        this.number = number;
    }

    public String printParam(String prefix, int indentLevel) {
        return "" + number;
    }

    @Override
    public boolean isNewlineRequired() {
        return false;
    }
}
