package com.robintegg.j2html.app.generator.code;

public final class PlainTextParameter implements Parameter {

    private final String plainText;

    PlainTextParameter(String plainText) {
        this.plainText = plainText;
    }

    public String printParam(String prefix, int indentLevel) {
        return "\"" + plainText + "\"";
    }

    @Override
    public boolean isNewlineRequired() {
        return false;
    }
}
