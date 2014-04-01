package edu.pdx.pdf;

public class FactureBean {
	private String ref;
	private String design;
	private int qte;
	private double prixu;
	private double tva;
	private double montHT;
	private double montTVA;
	private double montTTC;
	private double montTHC;

	public FactureBean(String ref, String design, int qte, double prixu, double tva) {
		super();
		this.ref = ref;
		this.design = design;
		this.qte = qte;
		this.prixu = prixu;
		this.tva = tva;
		this.montHT = prixu*qte;
		setMontTHC(prixu*qte);
		setMontTVA((getMontTHC()*tva)/100);
		setMontTTC(montTHC+montTVA);
		
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public double getPrixu() {
		return prixu;
	}

	public void setPrixu(int prixu) {
		this.prixu = prixu;
	}

	public double getTVA() {
		return tva;
	}

	public void setTVA(int tVA) {
		tva = tVA;
	}

	public double getMontHT() {
		return montHT;
	}

	public void setMontHT(int montHT) {
		this.montHT = montHT;
	}

	public double getMontTVA() {
		return montTVA;
	}

	public void setMontTVA(double montTVA) {
		this.montTVA = montTVA;
	}

	public double getMontTTC() {
		return montTTC;
	}

	public void setMontTTC(double montTTC) {
		this.montTTC = montTTC;
	}

	public double getMontTHC() {
		return montTHC;
	}

	public void setMontTHC(double montTHC) {
		this.montTHC = montTHC;
	}

}
