package com.bzdgn.fmexample.exception;

import java.io.Writer;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FTLTemplateExceptionHandler implements TemplateExceptionHandler {

	@Override
	public void handleTemplateException(TemplateException te, Environment env, Writer out) throws TemplateException {
		//TODO: handle
	}

}
