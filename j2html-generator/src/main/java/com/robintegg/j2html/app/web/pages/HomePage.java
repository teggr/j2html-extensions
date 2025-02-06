package com.robintegg.j2html.app.web.pages;

import j2html.rendering.IndentedHtml;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import java.util.Map;

import static dev.rebelcraft.j2html.bootstrap.Bootstrap.col;
import static dev.rebelcraft.j2html.bootstrap.Bootstrap.*;
import static dev.rebelcraft.j2html.htmx.HtmxAttributes.*;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class HomePage implements View {

    private final Layout layout;
    private final Links links;

    @Override
    public String getContentType() {
        return MediaType.TEXT_HTML_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String msg = (String) model.get("msg");
        String packageName = (String) model.get("packageName");
        boolean includeImports = !model.containsKey("includeImports") || (boolean) model.get("includeImports"); // default true
        String tagLibraryId = (String) model.get("tagLibraryId");
        String template = (String) model.get("template");
        String className = (String) model.get("className");
        String testName = (String) model.get("testName");
        boolean testOnly = model.containsKey("testOnly") && (boolean) model.get("testOnly"); // default false

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
                                div()
                                        .withClass("row")
                                        .with(

                                                div()
                                                        .withClass(col_6)
                                                        .with(
                                                                form()
                                                                        .withAction(links.of("/generate"))
                                                                        .withMethod("post")
                                                                        .attr(hxPost(links.of("/generate")))
                                                                        .attr(hxTarget( "#generated-code"))
                                                                        .attr(hxSelect( "#generated-code-insert"))
                                                                        .attr(hxIndicator( "#spinner"))
                                                                        .with(
                                                                                div()
                                                                                        .withClass(mb_3)
                                                                                        .with(
                                                                                                label("Put your HTML here")
                                                                                                        .withClass(form_label)
                                                                                                        .withFor("content"),
                                                                                                textarea()
                                                                                                        .withClass(form_control)
                                                                                                        .withStyle("height: 350px;")
                                                                                                        .withId("content")
                                                                                                        .withName("content")
                                                                                                        .withText("<h1>hello j2html community</h1>")
                                                                                        ),

                                                                                div()
                                                                                        .withClasses(mb_3, form_check)
                                                                                        .with(
                                                                                                input()
                                                                                                        .withType("checkbox")
                                                                                                        .withClass(form_check_input)
                                                                                                        .withId("includeImports")
                                                                                                        .withName("includeImports")
                                                                                                        .withCondChecked(includeImports),
                                                                                                label("Include Imports")
                                                                                                        .withClass(form_check_label)
                                                                                                        .attr("for", "includeImports")
                                                                                        ),
                                                                                div()
                                                                                        .withClasses(mb_3, form_check)
                                                                                        .with(
                                                                                                input()
                                                                                                        .withType("checkbox")
                                                                                                        .withClass(form_check_input)
                                                                                                        .withId("tagLibraryId")
                                                                                                        .withName("tagLibraryId")
                                                                                                        .withCondChecked("j2htmlExtensions".equals(tagLibraryId))
                                                                                                        .withValue("j2htmlExtensions"),
                                                                                                label("Use j2html Extensions Library")
                                                                                                        .withClass(form_check_label)
                                                                                                        .attr("for", "tagLibraryId")
                                                                                        ),
                                                                                div()
                                                                                        .withClasses(mb_3)
                                                                                        .with(
                                                                                                select()
                                                                                                        .withClass(form_select)
                                                                                                        .attr("aria-label", "Select Template")
                                                                                                        .withName("template")
                                                                                                        .with(
                                                                                                                option("Choose a template")
                                                                                                                        .attr("selected")
                                                                                                                        .withCondSelected(template == null),
                                                                                                                option("JUnit UI Test Snippet")
                                                                                                                        .attr("value", "junituitest")
                                                                                                                        .withCondSelected("junituitest".equals(template))
                                                                                                        )
                                                                                        ),
                                                                                div()
                                                                                        .withClasses(row)
                                                                                        .with(
                                                                                                div()
                                                                                                        .withClasses(col)
                                                                                                        .with(
                                                                                                                div()
                                                                                                                        .withClass(mb_3)
                                                                                                                        .with(
                                                                                                                                label("Package Name")
                                                                                                                                        .attr("for", "packageName")
                                                                                                                                        .withClass(form_label),
                                                                                                                                input()
                                                                                                                                        .withClass(form_control)
                                                                                                                                        .withId("packageName")
                                                                                                                                        .attr("aria-describedby", "packageName")
                                                                                                                                        .withName("packageName")
                                                                                                                                        .withValue(packageName)
                                                                                                                        ),
                                                                                                                div()
                                                                                                                        .withClass(mb_3)
                                                                                                                        .with(
                                                                                                                                label("Class Name")
                                                                                                                                        .attr("for", "className")
                                                                                                                                        .withClass(form_label),
                                                                                                                                input()
                                                                                                                                        .withClass(form_control)
                                                                                                                                        .withId("className")
                                                                                                                                        .attr("aria-describedby", "className")
                                                                                                                                        .withName("className")
                                                                                                                                        .withValue(className)
                                                                                                                        )
                                                                                                        ),
                                                                                                div()
                                                                                                        .withClasses(col)
                                                                                                        .with(
                                                                                                                div()
                                                                                                                        .withClass(mb_3)
                                                                                                                        .with(
                                                                                                                                label("Test Name")
                                                                                                                                        .attr("for", "testName")
                                                                                                                                        .withClass(form_label),
                                                                                                                                input()
                                                                                                                                        .withClass(form_control)
                                                                                                                                        .withId("testName")
                                                                                                                                        .attr("aria-describedby", "testName")
                                                                                                                                        .withName("testName")
                                                                                                                                        .withValue(testName)
                                                                                                                        ),
                                                                                                                div()
                                                                                                                        .withClasses(mb_3, form_check)
                                                                                                                        .with(
                                                                                                                                input()
                                                                                                                                        .withType("checkbox")
                                                                                                                                        .withClass(form_check_input)
                                                                                                                                        .withId("testOnly")
                                                                                                                                        .withName("testOnly")
                                                                                                                                        .withCondChecked(includeImports),
                                                                                                                                label("Test Only")
                                                                                                                                        .withClass(form_check_label)
                                                                                                                                        .attr("for", "testOnly")
                                                                                                                        )
                                                                                                        )
                                                                                        ),
                                                                                button("Generate j2html")
                                                                                        .withClasses(btn, btn_primary)
                                                                                        .withType("submit")
                                                                        )
                                                        ),
                                                div()
                                                        .withClass(col_6)
                                                        .with(
                                                                div().withId("generated-code").with(
                                                                        img()
                                                                                .withId("spinner")
                                                                                .withClass(htmx_indicator)
                                                                                .withSrc("https://raw.githubusercontent.com/n3r4zzurr0/svg-spinners/main/svg-css/90-ring.svg")
                                                                ),
                                                                //language=javascript
                                                                script()
                                                                        .with(rawHtml("""
                                                                                document.addEventListener("htmx:load", (event) => {
                                                                                    let code = document.getElementById("generated-code-insert");
                                                                                    if(code != null) {
                                                                                        Prism.highlightAllUnder(code);
                                                                                    }
                                                                                })
                                                                                """))
                                                        )
                                        )
                        )


        ).render(IndentedHtml.into(response.getWriter()));

    }

}
