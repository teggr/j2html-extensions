package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Tooltips {

    public static Attribute dataBsToggleTooltip() {
        return new Attribute("data-bs-toggle", "tooltip");
    }

    public static Attribute dataBsTitle(String title) {
        return new Attribute("data-bs-title", "title");
    }

    public static Attribute dataBsPlacementTop() {
        return new Attribute("data-bs-placement", "top");
    }

    public static Attribute dataBsPlacementRight() {
        return new Attribute("data-bs-placement", "right");
    }

    public static Attribute dataBsPlacementBottom() {
        return new Attribute("data-bs-placement", "bottom");
    }

    public static Attribute dataBsPlacementLeft() {
        return new Attribute("data-bs-placement", "left");
    }

}
