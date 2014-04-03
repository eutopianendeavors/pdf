package edu.pdx.pdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import edu.pdx.pdf.model.Award;
import edu.pdx.pdf.utils.QueryUtil;

public class PDFDao extends JdbcDaoSupport {

	private QueryUtil queryUtil;

	public List<Award> getFinancialAid(String aidyear_in, String aidyearstart_in, String aidyearend_in,
			String studentid_in) {
		String query = queryUtil.getAwardQuery(aidyear_in, aidyearstart_in, aidyearend_in, studentid_in);
		// List<Award> financialAids = getJdbcTemplate().query(query,
		// new BeanPropertyRowMapper<Award>(Award.class));
		List<Award> financialAids = getJdbcTemplate().query(query, new RowMapper<Award>() {

			@Override
			public Award mapRow(ResultSet rs, int rowNum) throws SQLException {
				Award award = new Award();
				award.setStu_id(rs.getString("stu_id") != null ? rs.getString("stu_id") : "N/A");
				award.setStu_pidm(rs.getString("stu_pidm") != null ? rs.getString("stu_pidm") : "N/A");
				award.setStu_name(rs.getString("stu_name") != null ? rs.getString("stu_name") : "N/A");
				award.setStu_addr1(rs.getString("stu_addr1") != null ? rs.getString("stu_addr1") : "N/A");
				award.setStu_addr2(rs.getString("stu_addr2") != null ? rs.getString("stu_addr2") : "N/A");
				award.setAward_name(rs.getString("award_name") != null ? rs.getString("award_name") : "N/A");
				award.setAward_year(rs.getString("award_year") != null ? rs.getString("award_year") : "N/A");
				award.setPlus_award(rs.getString("plus_award") != null ? rs.getString("plus_award") : "N/A");
				award.setFall_award(rs.getString("fall_award") != null ? rs.getString("fall_award") : "N/A");
				award.setFall(rs.getString("fall") != null ? rs.getString("fall") : "N/A");
				award.setWinter_award(rs.getString("winter_award") != null ? rs.getString("winter_award") : "N/A");
				award.setWinter(rs.getString("winter") != null ? rs.getString("winter") : "N/A");
				award.setSpring_award(rs.getString("spring_award") != null ? rs.getString("spring_award") : "N/A");
				award.setSpring(rs.getString("spring") != null ? rs.getString("spring") : "N/A");
				award.setSummer_award(rs.getString("summer_award") != null ? rs.getString("summer_award") : "N/A");
				award.setSummer(rs.getString("summer") != null ? rs.getString("summer") : "N/A");
				award.setFall_total(rs.getString("fall_total") != null ? rs.getString("fall_total") : "N/A");
				award.setWinter_total(rs.getString("winter_total") != null ? rs.getString("winter_total") : "N/A");
				award.setSpring_total(rs.getString("spring_total") != null ? rs.getString("spring_total") : "N/A");
				award.setSummer_total(rs.getString("summer_total") != null ? rs.getString("summer_total") : "N/A");
				award.setYear_total(rs.getString("year_total") != null ? rs.getString("year_total") : "N/A");
				// TODO Auto-generated method stub
				return award;
			}

		});
		return financialAids;
	}

	public QueryUtil getQueryUtil() {
		return queryUtil;
	}

	public void setQueryUtil(QueryUtil queryUtil) {
		this.queryUtil = queryUtil;
	}

}
