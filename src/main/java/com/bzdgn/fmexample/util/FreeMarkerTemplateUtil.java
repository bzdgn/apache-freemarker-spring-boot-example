package com.bzdgn.fmexample.util;

import static freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;

import java.io.IOException;
import java.util.Locale;

import com.bzdgn.fmexample.exception.FTLTemplateExceptionHandler;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTemplateUtil {
	
    private FreeMarkerTemplateUtil() { }

    @SuppressWarnings("rawtypes")
	public static Template createTemplateFromFile(final Class clazz, final String filename) throws IOException {
        Configuration configuration = new Configuration(DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setClassForTemplateLoading(clazz, "/templates/");
        configuration.setTemplateExceptionHandler(new FTLTemplateExceptionHandler());
        configuration.setDefaultEncoding("UTF-8");
        configuration.setEncoding(Locale.ENGLISH, "UTF-8");
        
        return configuration.getTemplate(filename);
    }

}
