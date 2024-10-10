package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Modal {

    public static final String modal = "modal";

    public static final String modal_dialog = "modal-dialog";

    public static final String modal_content = "modal-content";

    public static final String modal_header = "modal-header";

    public static final String modal_title = "modal-title";

    public static final String modal_body = "modal-body";

    public static final String modal_footer = "modal-footer";

    public static final String tabindex = "tabindex";

    public static final String data_bs_dismiss = "data_bs_dismiss";

    public static final String data_bs_target = "data_bs_target";

    public static final String fade = "fade";

    public static final String aria_labelledby = "aria-labelledby";
    public static final String aria_hidden = "aria-hidden";

    public static final String data_bs_backdrop = "data-bs-backdrop";
    public static final String data_bs_keyboard = "data-bs-keyboard";

    public static final String modal_dialog_scrollable = "modal-dialog-scrollable";

    public static final String modal_dialog_centered = "modal-dialog-centered";

    public static final String modal_sm = "modal-sm";
    public static final String modal_lg = "modal-lg";
    public static final String modal_xl = "modal-xl";

    public static final String modal_fullscreen = "modal-fullscreen";
    public static final String modal_fullscreen_sm_down = "modal-fullscreen-sm-down";
    public static final String modal_fullscreen_md_down = "modal-fullscreen-md-down";
    public static final String modal_fullscreen_lg_down = "modal-fullscreen-lg-down";
    public static final String modal_fullscreen_xl_down = "modal-fullscreen-xl-down";
    public static final String modal_fullscreen_xxl_down = "modal-fullscreen-xxl-down";

    public static Attribute tabIndex(int index) {
        return new Attribute(tabindex, "" + index);
    }

    public static Attribute dataBsDismissModal() {
        return new Attribute(data_bs_dismiss, modal);
    }

    public static Attribute dataBsTarget(String target) {
        return new Attribute(data_bs_target, target);
    }

    public static Attribute ariaLabelledBy(String name) {
        return new Attribute(aria_labelledby, name);
    }

    public static Attribute ariaHiddenTrue() {
        return new Attribute(aria_hidden, "true");
    }

    public static Attribute dataBsBackdropStatic() {
        return new Attribute(data_bs_backdrop, "static");
    }

    public static Attribute dataBsKeyboardFalse() {
        return new Attribute(data_bs_keyboard, "false");
    }
}
