package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class CloseButton {

    public static final String btn_close = "btn-close";

    public static final String close = "close";
    public static final String data_bs_theme = "data-bs-theme";

    public static Attribute dataBsThemeDark() {
        return new Attribute(data_bs_theme, "dark");
    }

    public static final String btn_close_white = "btn-close-white";
}
