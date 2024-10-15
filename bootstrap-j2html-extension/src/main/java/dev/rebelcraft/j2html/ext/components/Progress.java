package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Progress {

    public static final String progress = "progress";

    public static final String progress_bar = "progress-bar";

    public static final String progress_stacked = "progress-stacked";

    public static final String progress_bar_striped = "progress-bar-striped";

    public static final String progress_bar_animated = "progress-bar-animated";

    public static Attribute roleProgressBar() {
        return new Attribute("role", "progressbar");
    }

    public static Attribute ariaLabel(String label) {
        return new Attribute("aria-label", label);
    }

    public static Attribute ariaValueNow(int value) {
        return new Attribute("aria-valuenow", "" + value);
    }

    public static Attribute ariaValueMin(int value) {
        return new Attribute("aria-valuemin", "" + value);
    }

    public static Attribute ariaValueMax(int value) {
        return new Attribute("aria-valuemax", "" + value);
    }

}
