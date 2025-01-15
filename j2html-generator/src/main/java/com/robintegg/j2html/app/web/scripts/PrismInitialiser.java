package com.robintegg.j2html.app.web.scripts;

import def.dom.Globals;
import def.js.Function;

public class PrismInitialiser {

    public static void main(String[] args) {

        Globals.document.addEventListener(
                "htmx:afterProcessNode", event -> {

                    Function prism = (Function)Globals.window.$get("Prism");
                    prism.$invoke("highlightAll");

                });

    }

}
