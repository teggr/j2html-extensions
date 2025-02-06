package com.robintegg.j2html.app.web.pages;

import dev.rebelcraft.j2html.htmx.HtmxAttributes;
import j2html.rendering.IndentedHtml;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

import static dev.rebelcraft.j2html.bootstrap.Bootstrap.container_fluid;
import static j2html.TagCreator.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class GeneratePage implements View {

    private final Layout layout;

    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String generatedText = (String) model.get("generatedText");
        String msg = (String) model.get("msg");

        layout.render(
                "j2html-generator",
                model,
                request,
                response,
                div()
                        .withClass(container_fluid)
                        .with(
                                h1("Generate j2html code from HTML snippets"),
                                hr(),
                                Partials.showAlertIfMessage(msg),
                                div().withId("generated-code-insert")
                                        .with(
                                                img()
                                                        .withId("spinner")
                                                        .withClass(HtmxAttributes.htmx_indicator)
                                                        .withSrc("https://raw.githubusercontent.com/n3r4zzurr0/svg-spinners/main/svg-css/90-ring.svg"),
                                                pre(
                                                        code().withClass("language-java").with(
                                                                rawHtml(generatedText)
                                                        )
                                                )
                                        )
                        )

        ).render(IndentedHtml.into(response.getWriter()));

    }

}
