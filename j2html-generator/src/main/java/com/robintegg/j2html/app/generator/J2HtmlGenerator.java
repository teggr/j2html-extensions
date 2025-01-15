package com.robintegg.j2html.app.generator;

public interface J2HtmlGenerator {

    String generateFromHtml(String packageName, boolean includeImports, String useExtensions, String htmlText, String template, String className, String testName, boolean testOnly);

}
