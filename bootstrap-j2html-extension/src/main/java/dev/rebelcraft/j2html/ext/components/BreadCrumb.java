package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class BreadCrumb {

    public static final String breadcrumb = "breadcrumb";

    public static final String breadcrumb_item = "breadcrumb-item";

    public static final String active = "active";

    public static final String page = "page";

    public static String breadcrumbStyle(String divider) {
        return "--bs-breadcrumb-divider: " + divider + ";";
    }

}
