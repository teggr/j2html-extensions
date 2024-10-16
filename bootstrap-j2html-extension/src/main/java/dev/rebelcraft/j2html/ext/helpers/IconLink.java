package dev.rebelcraft.j2html.ext.helpers;

import j2html.attributes.Attribute;

public class IconLink {

    public static final String icon_link = "icon-link";

    public static final String icon_link_hover = "icon-link-hover";

    public static final String bi = "bi";

    public static Attribute ariaHiddenTrue() {
        return new Attribute("aria-hidden", "true");
    }

    public static Attribute xlinkHref(String href) {
        return new Attribute("xlink:href", href);
    }

}
