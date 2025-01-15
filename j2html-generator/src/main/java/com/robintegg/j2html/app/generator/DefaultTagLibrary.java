package com.robintegg.j2html.app.generator;

import com.robintegg.j2html.app.generator.css.StaticVariableReference;

public class DefaultTagLibrary implements TagLibrary {

    public DefaultTagLibrary() {
    }


    @Override
    public String commentMethodName() {
        return "rawHtml";
    }

    @Override
    public String wrapComment(String comment) {
        return "<!--" + comment + "-->";
    }

    @Override
    public String[] staticImports() {
        return new String[] { "j2html.TagCreator.*" };
    }

    @Override
    public StaticVariableReference cssReference(String className) {
        return null;
    }

}
