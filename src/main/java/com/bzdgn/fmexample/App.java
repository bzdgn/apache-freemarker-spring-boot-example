package com.bzdgn.fmexample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.bzdgn.fmexample.model.ValueObject;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@SpringBootApplication
public class App {
	public static void main(String[] args) throws TemplateException, IOException {
		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
		
		Template template = ctx.getBean(Template.class);

        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "Vogella example");

        input.put("exampleObject", new ValueObject("Java object", "me"));

        List<ValueObject> systems = new ArrayList<ValueObject>();
        systems.add(new ValueObject("Android", "Google"));
        systems.add(new ValueObject("iOS States", "Apple"));
        systems.add(new ValueObject("Ubuntu", "Canonical"));
        systems.add(new ValueObject("Windows7", "Microsoft"));
        input.put("systems", systems);

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }
        
        ctx.close();
	}
}
