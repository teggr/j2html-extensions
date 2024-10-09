package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

import static dev.rebelcraft.j2html.ext.components.BreadCrumb.aria_label;

public class ButtonGroup {

    public static final String btn_group = "btn-group";

    public static final String group = "group";

    public static final String toolbar = "toolbar";

    public static final String input_group = "input-group";

    public static final String input_group_text = "input-group-text";

    public static final String aria_describedby = "aria-describedby";

    public static final String btn_group_lg = "btn-group-lg";
    public static final String btn_group_sm = "btn-group-sm";

    public static final String btn_group_vertical = "btn-group-vertical";

    public static Attribute ariaLabel(String label) {
        return new Attribute(aria_label, label);
    }

    public static Attribute ariaDescribedBy(String description) {
        return new Attribute(aria_describedby, description);
    }

}
