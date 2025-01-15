package com.robintegg.j2html.app.generator;

import com.robintegg.j2html.app.generator.css.CssLookup;
import com.robintegg.j2html.app.generator.css.StaticVariableReference;

public class J2HtmlTagLibrary implements TagLibrary {

    private final CssLookup cssLookup;

    public J2HtmlTagLibrary(CssLookup cssLookup) {
        this.cssLookup = cssLookup;
    }

    @Override
    public String commentMethodName() {
        return "comment";
    }

    @Override
    public String wrapComment(String comment) {
        return comment;
    }

    @Override
    public String[] staticImports() {
        return new String[] {
                "j2html.TagCreator.*",
                "dev.rebelcraft.j2html.ext.ExtendedTagCreator.*",
                "dev.rebelcraft.j2html.ext.aria.AriaRoles.*",
                "dev.rebelcraft.j2html.ext.aria.AriaStatesAndProperties.*"
        };
    }

    @Override
    public StaticVariableReference cssReference(String className) {
        return cssLookup.getStaticVariableReference(className);
    }

}
