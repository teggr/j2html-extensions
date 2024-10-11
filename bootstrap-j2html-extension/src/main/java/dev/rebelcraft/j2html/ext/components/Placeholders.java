package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Placeholders {

    public static final String placeholder_glow = "placeholder-glow";

    public static final String placeholder = "placeholder";

    public static final String placeholder_xs = "placeholder-xs";
    public static final String placeholder_sm = "placeholder-sm";
    public static final String placeholder_lg = "placeholder-lg";

    public static final String placeholder_wave = "placeholder-wave";

    public static Attribute tabIndex(int index) {
        return new Attribute("tabIndex", "" + index);
    }

}
