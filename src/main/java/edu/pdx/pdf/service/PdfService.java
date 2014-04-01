package edu.pdx.pdf.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.itextpdf.text.DocumentException;

import edu.pdx.pdf.FactureBean;
import edu.pdx.pdf.utils.ConversionUtils;
import freemarker.template.TemplateException;

public class PdfService {
	@GET
	@Path("/downloadFile")
	@Produces("application/pdf")
	public Response downloadFile() throws IOException, TemplateException,
			DocumentException {
		Map<?, ?> model = getModel();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ConversionUtils.convertFTLtoPDF("factemplate.ftl", model, output);
		ResponseBuilder response = Response.ok(output.toByteArray());
		response.header("Content-Disposition", "attachment; filename=test.pdf");
		return response.build();
	}

	private Map<?, ?> getModel() {
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("custname", "cedric Lalime");
		input.put("selname", "Lionnel leunkeu");

		// create list
		List<FactureBean> systems = new ArrayList<FactureBean>();
		FactureBean fb[] = new FactureBean[5];

		fb[0] = new FactureBean("Pel", "Pelle", 3, 1500, 19.6);
		fb[1] = new FactureBean("cim", "Sac de ciment", 10, 4600, 12.5);
		fb[2] = new FactureBean("Cl", "Clous", 2, 500, 12);
		fb[3] = new FactureBean("Tr", "Truelle", 2, 1000, 10);
		fb[4] = new FactureBean("Hu", "Huile", 1, 579.23, 10.3);
		systems.add(fb[0]);
		systems.add(fb[1]);
		systems.add(fb[2]);
		systems.add(fb[3]);
		systems.add(fb[4]);

		input.put("systems", systems);
		input.put("message", "Lalime");
		double montHt = fb[0].getMontHT() + fb[1].getMontHT()
				+ fb[2].getMontHT() + fb[3].getMontHT() + fb[4].getMontHT();
		double monttva = fb[0].getMontTVA() + fb[1].getMontTVA()
				+ fb[2].getMontTVA() + fb[3].getMontTVA() + fb[4].getMontTVA();
		input.put("montHT", montHt);
		input.put("montTVA", monttva);
		input.put("montTTC", montHt + monttva);
		return input;
	}

}
