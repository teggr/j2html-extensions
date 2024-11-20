package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class OffCanvas {

    public static final String offcanvas = "offcanvas";

    public static final String show = "show";

    public static final String offcanvas_header = "offcanvas-header";

    public static final String offcanvas_title = "offcanvas-title";

    public static final String offcanvas_body = "offcanvas-body";

    public static final String offcanvas_sm = "offcanvas-sm";
    public static final String offcanvas_md = "offcanvas-md";
    public static final String offcanvas_lg = "offcanvas-lg";
    public static final String offcanvas_xl = "offcanvas-xl";
    public static final String offcanvas_xxl = "offcanvas-xxl";

    public static final String offcanvas_start = "offcanvas-start";
    public static final String offcanvas_end = "offcanvas-end";
    public static final String offcanvas_top = "offcanvas-top";
    public static final String offcanvas_bottom = "offcanvas-bottom";

    public static Attribute tabIndex(int index) {
        return new Attribute("tabIndex", "" + index);
    }

    public static Attribute dataBsDismissOffcanvas() {
        return new Attribute("data-bs-dismiss", offcanvas);
    }

    public static Attribute dataBsToggleOffcanvas() {
        return new Attribute("data-bs-toggle", offcanvas);
    }

    public static Attribute dataBsScrollTrue() {
        return new Attribute("data-bs-scroll", "true");
    }

    public static Attribute dataBsBackdropTrue() {
        return new Attribute("data-bs-backdrop", "false");
    }

    public static Attribute dataBsBackdropStatic() {
        return new Attribute("data-bs-backdrop", "static");
    }

}
