package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Dropdowns {

    public static final String dropdown = "dropdown";

    public static final String dropdown_toggle = "dropdown-toggle";

    public static final String data_bs_toggle = "data-bs-theme";

    public static final String button = "button";

    public static final String dropdown_menu = "dropdown-menu";

    public static final String dropdown_item = "dropdown-item";

    public static final String dropdown_divider = "dropdown-divider";

    public static final String dropdown_toggle_split = "dropdown-toggle-split";

    public static final String dropdown_menu_dark = "dropdown-menu-dark";

    public static final String dropdown_center = "dropdown-center";

    public static final String dropup = "dropup";

    public static final String dropup_center = "dropup-center";

    public static final String dropend = "dropend";

    public static final String dropstart = "dropstart";

    public static final String dropdown_item_text = "dropdown-item-text";

    public static final String active = "active";

    public static final String disabled = "disabled";

    public static final String dropdown_menu_end = "dropdown-menu-end";

    public static final String dropdown_menu_sm_end = "dropdown-menu-sm-end";

    public static final String dropdown_menu_md_end = "dropdown-menu-md-end";

    public static final String dropdown_menu_lg_end = "dropdown-menu-lg-end";

    public static final String dropdown_menu_xl_end = "dropdown-menu-xl-end";

    public static final String dropdown_menu_xxl_end = "dropdown-menu-xxl-end";

    public static final String dropdown_menu_sm_start = "dropdown-menu-sm-start";

    public static final String dropdown_menu_md_start = "dropdown-menu-md-start";

    public static final String dropdown_menu_lg_start = "dropdown-menu-lg-start";

    public static final String dropdown_menu_xl_start = "dropdown-menu-xl-start";

    public static final String dropdown_menu_xxl_start = "dropdown-menu-xxl-start";

    public static final String data_bs_display = "data-bs-display";

    public static final String dropdown_header = "dropdown-header";

    public static final String data_bs_offset = "data-bs-offset";
    public static final String data_bs_reference = "data-bs-reference";

    public static final String data_bs_auto_close = "data-bs-auto-close";


    public static Attribute dataBsDisplayStatic() {
        return new Attribute(data_bs_display, "static");
    }

    public static Attribute dataBsOffset(String offset) {
        return new Attribute(data_bs_offset, offset);
    }

    public static Attribute dataBsReference(String reference) {
        return new Attribute(data_bs_reference, reference);
    }

    public static Attribute dataBsAutoCloseTrue() {
        return new Attribute(data_bs_auto_close, "true");
    }

    public static Attribute dataBsAutoCloseInside() {
        return new Attribute(data_bs_auto_close, "inside");
    }

    public static Attribute dataBsAutoCloseOutside() {
        return new Attribute(data_bs_auto_close, "outside");
    }

    public static Attribute dataBsAutoCloseFalse() {
        return new Attribute(data_bs_auto_close, "false");
    }

}
