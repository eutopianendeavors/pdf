package edu.pdx.pdf.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.itextpdf.text.DocumentException;

import edu.pdx.pdf.dao.PDFDao;
import edu.pdx.pdf.model.Award;
import edu.pdx.pdf.utils.ConversionUtils;
import freemarker.template.TemplateException;

public class PdfService {
	private PDFDao dao;

	@GET
	@Path("/awardDoc")
	@Produces("application/pdf")
	public Response getAwardDoc(@QueryParam("stuid") String stuid, @QueryParam("aystart") String aystart,
			@QueryParam("ayend") String ayend, @QueryParam("ayin") String ayin) throws IOException, TemplateException,
			DocumentException {
		List<Award> awards = dao.getFinancialAid(ayin, aystart, ayend, stuid);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("awards", awards);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ConversionUtils.convertFTLtoPDF("awardDoc.ftl", model, output);
		ResponseBuilder response = Response.ok(output.toByteArray());
		response.header("Content-Disposition", "attachment; filename=awards.pdf");
		return response.build();
	}

	public PDFDao getDao() {
		return dao;
	}

	public void setDao(PDFDao dao) {
		this.dao = dao;
	}

}
