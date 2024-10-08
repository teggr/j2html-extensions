package dev.rebelcraft.j2html.ext.components;

import j2html.attributes.Attribute;

public class Alert {

    public static final String alert = "alert";
    public static final String alert_primary = "alert-primary";
    public static final String alert_secondary = "alert-secondary" ;
    public static final String alert_success = "alert-success" ;
    public static final String alert_danger = "alert-danger" ;
    public static final String alert_warning =  "alert-warning";
    public static final String alert_info =  "alert-info";
    public static final String alert_light = "alert-light" ;
    public static final String alert_dark = "alert-dark";

    public static final String alert_link = "alert-link";
    public static final String alert_heading = "alert-heading";
    public static final String alert_dismissible  = "alert-dismissible";

    public static final String data_bs_dismiss = "data-bs-dismiss";

    public static final String fade  = "fade";

    public static Attribute dataBsDismiss() {
        return new Attribute(data_bs_dismiss, alert);
    }

    public static Attribute role() {
        return new Attribute("role", alert);
    }

}
