package com.robintegg.j2html.app.generator.code;

public interface Parameter {

    String printParam(String prefix, int indentLevel);

    boolean isNewlineRequired();

}
