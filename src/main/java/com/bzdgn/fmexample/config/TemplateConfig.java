package com.bzdgn.fmexample.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.bzdgn.fmexample.util.FreeMarkerTemplateUtil;

import freemarker.template.Template;

@Configuration
public class TemplateConfig {
	
    @Bean
    public Template getTemplateBean(final @Value("classpath:/templates/helloworld.ftl") Resource templateResource) throws IOException {
        return createTemplateFromFile(templateResource.getFilename());
    }

    private Template createTemplateFromFile(final String filename) throws IOException {
        return FreeMarkerTemplateUtil.createTemplateFromFile(this.getClass(), filename);
    }

}
