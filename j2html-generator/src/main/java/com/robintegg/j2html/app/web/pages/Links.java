package com.robintegg.j2html.app.web.pages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Links {

  @Value("${server.servlet.context-path:}")
  private String contextPath;

  public String of(String relativeUrl) {
    if (!relativeUrl.startsWith("/")) {
      relativeUrl += "/";
    }
    return contextPath + relativeUrl;
  }

}
