package com.robintegg.j2html.app.web.controllers;

import com.robintegg.j2html.app.generator.J2HtmlGenerator;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
class HomeController {

    private final J2HtmlGenerator j2HtmlGenerator;

    @GetMapping("/")
    public String get() {
        return "homePage";
    }

    @PostMapping("/generate")
    public String generate(
            @RequestParam(name= "packageName", required = false) String packageName,
            @RequestParam(name="includeImports", required = false) boolean includeImports,
            @RequestParam(name= "tagLibraryId", required = false) String tagLibraryId,
            @RequestParam(name="template", required = false) String template,
            @RequestParam(name="className", required = false) String className,
            @RequestParam(name="testName", required = false) String testName,
            @RequestParam(name="testOnly", required = false) boolean testOnly,
            @RequestParam("content") String content,
            Model model,
            HttpServletResponse response
    ) {
        response.addHeader("HX-Trigger", "code-updated");
        String generatedText = j2HtmlGenerator.generateFromHtml(packageName, includeImports, tagLibraryId, content, template, className, testName, testOnly);
        model.addAttribute("generatedText", generatedText);
        model.addAttribute("includeImports", includeImports);
        model.addAttribute("tagLibraryId", tagLibraryId);
        model.addAttribute("template", template);
        model.addAttribute("packageName", packageName);
        model.addAttribute("testName", testName);
        return "generatePage";
    }

}