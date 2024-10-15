package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Toasts {

    public static final String toast = "toast";

    public static final String toast_header = "toast-header";

    public static final String toast_body = "toast-body";

    public static final String toast_container = "toast-container";

    public static final String top_left = "top-0 start-0";
    public static final String top_center = "top-0 start-50 translate-middle-x";
    public static final String top_right = "top-0 end-0";
    public static final String middle_left = "top-50 start-0 translate-middle-y";
    public static final String middle_center = "top-50 start-50 translate-middle";
    public static final String middle_right = "top-50 end-0 translate-middle-y";
    public static final String bottom_left = "bottom-0 start-0";
    public static final String bottom_center = "bottom-0 start-50 translate-middle-x";
    public static final String bottom_right = "bottom-0 end-0";

    public static Attribute roleAlert() {
        return new Attribute("role", "alert");
    }

    public static Attribute ariaLiveAssertive() {
        return new Attribute("aria-live", "assertive");
    }

    public static Attribute ariaAtomicTrue() {
        return new Attribute("aria-atomic", "true");
    }

    public static Attribute dataBsDismissToast() {
        return new Attribute("data-bs-dismiss", toast);
    }

    public static Attribute ariaLabelClose() {
        return new Attribute("aria-label", "close");
    }

    public static Attribute ariaLivePolite() {
        return new Attribute("aria-live", "polite");
    }

    public static Attribute dataBsDelay(int delay) {
        return new Attribute("data-bs-delay", ""  +delay);
    }

}
