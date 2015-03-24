package com.chrylis.sandbox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.AjaxThymeleafViewResolver;
import org.thymeleaf.spring4.view.FlowAjaxThymeleafView;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AjaxThymeleafViewResolver ajaxThymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {
        AjaxThymeleafViewResolver viewResolver = new AjaxThymeleafViewResolver();
        viewResolver.setViewClass(FlowAjaxThymeleafView.class);
        viewResolver.setTemplateEngine(springTemplateEngine);
        return viewResolver;
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter(FlowExecutor executor) {
        FlowHandlerAdapter adapter = new FlowHandlerAdapter();
        adapter.setFlowExecutor(executor);
        adapter.setSaveOutputToFlashScopeOnRedirect(true);
        return adapter;
    }

    @Bean
    public FlowHandlerMapping flowHandlerMapping(FlowDefinitionRegistry registry) {
        FlowHandlerMapping mapping = new FlowHandlerMapping();
        mapping.setOrder(-1);
        mapping.setFlowRegistry(registry);
        return mapping;
    }
}
