package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Pagination {

    public static final String pagination = "pagination";

    public static final String page_item = "page-item";

    public static final String page_link = "page-link";

    public static final String double_arrow_left = "&laquo;";

    public static final String double_arrow_right = "&raquo;";

    public static final String disabled = "disabled";

    public static final String active = "active";

    public static final String pagination_sm = "pagination-sm";

    public static final String pagination_lg = "pagination-lg";

    public static Attribute tabIndex(int index) {
        return new Attribute("tabIndex", "" + index);
    }

}
