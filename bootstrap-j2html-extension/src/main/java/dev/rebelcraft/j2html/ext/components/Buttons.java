package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Buttons {

    public static final String btn = "btn";

    public static final String btn_primary = "btn-primary";
    public static final String btn_secondary = "btn-secondary";
    public static final String btn_success = "btn-success";
    public static final String btn_danger = "btn-danger";
    public static final String btn_warning = "btn-warning";
    public static final String btn_info = "btn-info";
    public static final String btn_light = "btn-light";
    public static final String btn_dark = "btn-dark";

    public static final String btn_link = "btn-link";

    public static final String text_nowrap = "text-nowrap";

    public static final String button = "button";

    public static final String btn_outline_primary = "btn-outline-primary";
    public static final String btn_outline_secondary = "btn-outline-secondary";
    public static final String btn_outline_success = "btn-outline-success";
    public static final String btn_outline_danger = "btn-outline-danger";
    public static final String btn_outline_warning = "btn-outline-warning";
    public static final String btn_outline_info = "btn-outline-info";
    public static final String btn_outline_light = "btn-outline-light";
    public static final String btn_outline_dark = "btn-outline-dark";

    public static final String btn_lg = "btn-lg";
    public static final String btn_sm = "btn-sm";

    public static final String disabled = "disabled";
    public static final String aria_disabled = "aria-disabled";

    public static final String active = "active";
    public static final String aria_pressed = "aria-pressed";

    public static Attribute disabled() {
        return new Attribute(disabled);
    }

    public static Attribute ariaDisabled() {
        return new Attribute(aria_disabled, "true");
    }

    public static Attribute dataBsToggle() {
        return new Attribute("data-bs-toggle", "button");
    }

    public static Attribute ariaPressed() {
        return new Attribute(aria_pressed, "true");
    }

}
