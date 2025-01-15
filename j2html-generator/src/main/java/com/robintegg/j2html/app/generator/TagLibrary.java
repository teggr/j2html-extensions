package com.robintegg.j2html.app.generator;

import com.robintegg.j2html.app.generator.css.StaticVariableReference;

public interface TagLibrary {

    String commentMethodName();

    String wrapComment(String comment);

    String[] staticImports();

    StaticVariableReference cssReference(String className);

}
