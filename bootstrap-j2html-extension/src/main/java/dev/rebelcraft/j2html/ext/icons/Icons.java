package dev.rebelcraft.j2html.ext.icons;

import j2html.attributes.Attribute;

public class Icons {

    public static final String bi = "bi";

    public static Attribute ariaHiddenTrue() {
        return new Attribute("aria-hidden", "true");
    }

    public static Attribute roleImg() {
        return new Attribute("role", "img");
    }

    public static Attribute ariaLabel(String label) {
        return new Attribute("aria-label", label);
    }

}
