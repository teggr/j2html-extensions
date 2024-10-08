package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class BreadCrumb {

    public static final String breadcrumb = "breadcrumb";

    public static final String breadcrumb_item = "breadcrumb-item";

    public static final String active = "active";

    public static final String aria_current = "aria-current";

    public static final String page = "page";

    public static final String aria_label = "aria-label";

    public static Attribute ariaCurrent() {
        return new Attribute(aria_current, page);
    }

    public static Attribute ariaLabel() {
        return new Attribute(aria_label, breadcrumb);
    }

    public static String breadcrumbStyle(String divider) {
        return "--bs-breadcrumb-divider: " + divider + ";";
    }

}
