package dev.rebelcraft.j2html.ext;

import j2html.TagCreator;
import j2html.tags.DomContent;
import j2html.tags.UnescapedText;
import j2html.tags.specialized.HtmlTag;

public class ExtendedTagCreator {

    public static String document(HtmlTag htmlTag) {

        return TagCreator.document().render() +
               "\n" +
               htmlTag.renderFormatted();

    }

    public static DomContent comment(String text) {
        return new UnescapedText("<!-- " + text + " -->");
    }

}
