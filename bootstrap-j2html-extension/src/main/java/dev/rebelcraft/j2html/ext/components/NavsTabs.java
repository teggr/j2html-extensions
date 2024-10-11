package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class NavsTabs {

    public static final String nav = "nav";

    public static final String nav_item = "nav-item";

    public static final String nav_link = "nav_link";

    public static final String active = "active";

    public static final String disabled = "disabled";

    public static final String nav_tabs = "nav_tabs";

    public static final String nav_pills = "nav_pills";

    public static final String nav_underline = "nav_underline";

    public static final String nav_fill = "nav_fill";

    public static final String nav_justified = "nav_justified";

    public static Attribute ariaCurrentPage() {
        return new Attribute("aria-current", "page");
    }

    public static Attribute ariaCurrentTrue() {
        return new Attribute("aria-current", "true");
    }

    public static Attribute roleNavigation() {
        return new Attribute("role", "navigation");
    }

}
