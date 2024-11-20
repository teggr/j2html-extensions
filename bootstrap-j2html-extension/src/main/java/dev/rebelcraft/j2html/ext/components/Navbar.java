package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Navbar {

    public static final String navbar = "navbar";

    public static final String navbar_expand = "navbar-expand";

    public static final String navbar_expand_sm = "navbar-expand-sm";
    public static final String navbar_expand_md = "navbar-expand-md";
    public static final String navbar_expand_lg = "navbar-expand-lg";
    public static final String navbar_expand_xl = "navbar-expand-xl";
    public static final String navbar_expand_xxl = "navbar-expand-xxl";

    public static final String navigation = "navigation";

    public static final String navbar_brand = "navbar-brand";

    public static final String navbar_nav = "navbar-nav";

    public static final String navbar_toggler = "navbar-toggler";

    public static final String navbar_toggler_icon = "navbar-toggler-icon";

    public static final String navbar_text = "navbar-text";

    public static final String navbar_collapse = "navbar-collapse";

    public static final String navbar_scroll = "navbar-scroll";

    public static final String nav_item = "nav-item";

    public static final String nav_link = "nav-link";

    public static final String active = "active";

    public static final String navbar_nav_scroll = "navbar-nav-scroll";

    public static Attribute dataBsToggleCollapse() {
        return new Attribute("data-bs-toggle", "collapse");
    }

    public static Attribute dataBsTarget(String selector) {
        return new Attribute("data-bs-target", selector);
    }

    public static Attribute dataBsThemeDark() {
        return new Attribute("data-bs-theme", "dark");
    }

    public static final String navbar_dark = "navbar-dark";
}
