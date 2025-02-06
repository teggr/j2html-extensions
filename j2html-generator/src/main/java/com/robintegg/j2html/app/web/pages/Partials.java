package com.robintegg.j2html.app.web.pages;

import dev.rebelcraft.j2html.ext.aria.AriaRoles;
import j2html.tags.specialized.DivTag;

import static dev.rebelcraft.j2html.bootstrap.Bootstrap.alert;
import static dev.rebelcraft.j2html.bootstrap.Bootstrap.alert_danger;
import static j2html.TagCreator.div;
import static j2html.TagCreator.iff;

public class Partials {

    public static DivTag showAlertIfMessage(String msg) {
        return iff(msg != null,
                div()
                        .withClasses(alert, alert_danger)
                        .attr(AriaRoles.roleAlert)
                        .withText(msg)
        );
    }

}
