package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Accordion {

    public static final String accordion = "accordion";
    public static final String accordion_item = "accordion-item";
    public static final String accordion_header = "accordion-header";
    public static final String accordion_button = "accordion-button";
    public static final String accordion_collapse = "accordion-collapse";
    public static final String accordion_body = "accordion-body";
    public static final String accordion_flush = "accordion-flush";

    public static final String bs_parent = "bs-parent";

    public static Attribute bsParent(String selector) {
        return new Attribute(bs_parent, selector);
    }

}
