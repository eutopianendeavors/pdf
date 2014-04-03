package edu.pdx.pdf.utils;

public class QueryUtil {
	private String awardQuery;

	public String getAwardQuery(String aidyear_in, String aidyearstart_in, String aidyearend_in, String studentid_in) {
		String query = this.awardQuery.replace("<<aidyear_in>>", aidyear_in);
		query = query.replace("<<aidyearstart_in>>", aidyearstart_in);
		query = query.replace("<<aidyearend_in>>", aidyearend_in);
		query = query.replace("<<studentid_in>>", studentid_in);
		return query;
	}

	public void setAwardQuery(String awardQuery) {
		this.awardQuery = awardQuery;
	}

}
