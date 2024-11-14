package dev.rebelcraft.j2html.ext.components;

import dev.rebelcraft.j2html.ext.helpers.VisuallyHidden;
import j2html.TagCreator;
import j2html.attributes.Attribute;
import j2html.tags.specialized.SpanTag;

public class Spinners {

    public static final String spinner_border = "spinner-border";

    public static final String spinner_grow = "spinner-grow";

    public static final String spinner_border_sm = "spinner-border-sm";
    public static final String spinner_grow_sm = "spinner-grow-sm";

    public static Attribute roleStatus() {
        return new Attribute("role", "status");
    }

    public static SpanTag loader() {
        return TagCreator.span("Loading...").withClass(VisuallyHidden.visually_hidden);
    }

    public static Attribute ariaHiddenTrue() {
        return new Attribute("aria-hidden", "true");
    }

}
