package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

import java.util.Arrays;

public class Collapse {

    public static final String collapse = "collapse";
    public static final String collapse_horizontal = "collapse-horizontal";
    public static final String collapsing = "collapsing";
    public static final String show = "show";
    public static final String collapsed = "collapsed";

    public static final String data_bs_toggle = "data-bs-toggle";
    public static final String data_bs_target = "data-bs-target";

    public static final String aria_expanded = "aria-expanded";
    public static final String aria_controls = "aria-controls";

    public static Attribute dataBSToggle(boolean collapseState) {
        return new Attribute(data_bs_toggle, collapseState ? collapse : collapsed);
    }

    public static Attribute dataBSTarget(String selector) {
        return new Attribute(data_bs_target, selector);
    }

    public static Attribute ariaExpanded(Boolean expanded) {
        return new Attribute(aria_expanded, expanded.toString());
    }

    public static Attribute ariaControls(String ...targetIds) {
        return new Attribute(aria_controls, String.join(" ", targetIds));
    }

}
