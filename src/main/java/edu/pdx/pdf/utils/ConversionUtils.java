package edu.pdx.pdf.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class ConversionUtils {
	public static Configuration getDefaultConfiguration() {
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(ConversionUtils.class, "/");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		return cfg;
	}

	public static void convertFTLtoPDF(String ftlPath, Map<?, ?> model,
			OutputStream output) throws IOException, TemplateException,
			DocumentException {
		Configuration cfg = ConversionUtils.getDefaultConfiguration();
		Template template = cfg.getTemplate(ftlPath);
		Writer writer = new StringWriter();
		template.process(model, writer);

		Document document = new Document(PageSize.LETTER);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, output);
		document.open();
		document.addAuthor("pdx.edu");
		document.addCreator("pdx.edu");
		document.addSubject("pdx.edu generated PDF");
		document.addCreationDate();

		XMLWorkerHelper worker = XMLWorkerHelper.getInstance();

		worker.parseXHtml(pdfWriter, document,
				new StringReader(writer.toString()));
		document.close();

	}

}
