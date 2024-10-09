package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Carousel {

    public static final String carousel = "carousel";

    public static final String slide = "slide";

    public static final String carousel_inner = "carousel-inner";

    public static final String carousel_item = "carousel-item";

    public static final String carousel_control_prev = "carousel-control-prev";

    public static final String data_bs_slide = "data-bs-slide";
    public static final String prev = "prev";
    public static final String next = "next";

    public static final String carousel_control_prev_icon = "carousel-control-prev-icon";

    public static final String visually_hidden = "visually-hidden";

    public static final String carousel_control_next = "carousel-control-next";

    public static final String carousel_control_next_icon = "carousel-control-next-icon";

    public static final String active = "active";

    public static final String button = "button";

    public static final String carousel_indicators = "carousel-indicators";

    public static final String carousel_caption = "carousel-caption";

    public static final String carousel_fade = "carousel-fade";

    public static final String data_bs_slide_to = "data-bs-slide-to";

    public static final String data_bs_ride = "data-bs-ride";

    public static final String data_bs_interval = "data-bs-interval";

    public static final String data_bs_touch = "data-bs-touch";

    public static final String carousel_dark = "carousel-dark";

    public static Attribute dataBsSlidePrev() {
        return new Attribute(data_bs_slide, prev);
    }

    public static Attribute dataBsSlideNext() {
        return new Attribute(data_bs_slide, next);
    }

    public static Attribute dataBsSlideTo(int slide) {
        return new Attribute(data_bs_slide_to, ""+slide);
    }

    public static Attribute dataBsRideCarousel() {
        return new Attribute(data_bs_ride, "carousel");
    }

    public static Attribute dataBsRideTrue() {
        return new Attribute(data_bs_ride, "true");
    }

    public static Attribute dataBsInterval(int interval) {
        return new Attribute(data_bs_interval, "" + interval);
    }

    public static Attribute dataBsTouchDisable() {
        return new Attribute(data_bs_touch, "false");
    }

}
