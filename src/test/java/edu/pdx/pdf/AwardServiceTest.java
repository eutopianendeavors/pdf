package edu.pdx.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itextpdf.text.DocumentException;

import edu.pdx.pdf.dao.PDFDao;
import edu.pdx.pdf.model.Award;
import edu.pdx.pdf.utils.ConversionUtils;
import freemarker.template.TemplateException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/pdf-servlet.xml", "/pdf-servlet-test.xml" })
public class AwardServiceTest {
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void testAwardsService() throws IOException, TemplateException, DocumentException {
		PDFDao dao = applicationContext.getBean(PDFDao.class);
		List<Award> awards = dao.getFinancialAid("1314", "2012", "2014", "908206360"); // 937663870
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("awards", awards);
		OutputStream output = new ByteArrayOutputStream();
		ConversionUtils.convertFTLtoPDF("awardDoc.ftl", model, output);
	}

}
