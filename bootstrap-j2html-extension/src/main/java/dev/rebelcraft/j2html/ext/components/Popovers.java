package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Popovers {

    public static final String disabled = "disabled";



    public static Attribute dataBsToggle() {
        return new Attribute("data-bs-toggle", "popover");
    }

    public static Attribute dataBsTitle(String title) {
        return new Attribute("data-bs-title", title);
    }

    public static Attribute dataBsContent(String content) {
        return new Attribute("data-bs-content", content);
    }

    public static Attribute dataBsContainer(String container) {
        return new Attribute("data-bs-container", "container");
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

    public static Attribute dataBsCustomClass(String customClass) {
        return new Attribute("data-bs-custom-class", customClass);
    }

    public static Attribute dataBsTriggerFocus() {
        return new Attribute("data-bs-trigger", "focus");
    }

    public static Attribute dataBsTriggerHoverFocus() {
        return new Attribute("data-bs-trigger", "hover focus");
    }

}
