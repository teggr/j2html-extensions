package com.robintegg.j2html.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@Configuration
public class J2HtmlGeneratorApplicationConfiguration {

  @Bean
  public ViewResolver j2htmlViewResolver() {
    return new BeanNameViewResolver();
  }

}
