package dev.rebelcraft.j2html.spring.starter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.BeanNameViewResolver;

@AutoConfiguration
public class J2HtmlExtensionsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(BeanNameViewResolver.class)
    public BeanNameViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }

}
