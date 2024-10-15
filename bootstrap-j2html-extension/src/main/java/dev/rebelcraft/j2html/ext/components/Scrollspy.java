package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Scrollspy {

    public static Attribute dataBsSpyScroll() {
        return new Attribute("data-bs-spy", "scroll");
    }


    public static Attribute dataBsTarget(String target) {
        return new Attribute("data-bs-target", target);
    }

    public static Attribute dataBsSmoothScrollTrue() {
        return new Attribute("data-bs-smooth-scroll", "true");
    }

    public static Attribute tabIndexZero() {
        return new Attribute("tabindex", "0");
    }

}
