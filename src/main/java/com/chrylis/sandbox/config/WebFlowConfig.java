package com.chrylis.sandbox.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

    @Bean
    public FlowDefinitionRegistry flowRegistry(FlowBuilderServices services) {
        return getFlowDefinitionRegistryBuilder(services).
            addFlowLocationPattern("classpath:/flows/**/*-flow.xml").
            build();
    }

    @Bean
    public FlowBuilderServices flowBuilderServices(MvcViewFactoryCreator creator) {
        return getFlowBuilderServicesBuilder().
            setViewFactoryCreator(creator).
            build();
    }

    @Bean
    public FlowExecutor flowExecutor(FlowDefinitionRegistry registry) {
        return getFlowExecutorBuilder(registry).build();
    }

    @Bean
    public MvcViewFactoryCreator creator(List<ViewResolver> resolvers) {
        System.err.println(resolvers);

        MvcViewFactoryCreator creator = new MvcViewFactoryCreator();
        creator.setViewResolvers(resolvers);
        creator.setUseSpringBeanBinding(true);
        return creator;
    }
}
