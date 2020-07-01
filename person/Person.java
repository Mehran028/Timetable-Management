package edu.uog.person;

public class Person {
	
	public static  String csvFile3 = "D:\\Person.csv";
	



	private int PERSON_ID;
	
	private String TITLE;
	
	private String FOR_NAME;
	
	private String SUR_NAME;
	
	private int AGE;
	
	private String GENDER;
	
	private String ADDRESS;

	
	public int getPERSON_ID() {
		return PERSON_ID;
	}

	public void setPERSON_ID(int pERSON_ID) {
		PERSON_ID = pERSON_ID;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getFOR_NAME() {
		return FOR_NAME;
	}

	public void setFOR_NAME(String fOR_NAME) {
		FOR_NAME = fOR_NAME;
	}

	public String getSUR_NAME() {
		return SUR_NAME;
	}

	public void setSUR_NAME(String sUR_NAME) {
		SUR_NAME = sUR_NAME;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public static String getCsvFile() {
		return csvFile3;
	}

	public static void setCsvFile(String csvFile) {
		Person.csvFile3 = csvFile;
	}

	public String toString() {
		
		String str = null;
		
		str = this.PERSON_ID
				+"," + this.TITLE
				+"," + this.FOR_NAME
				+"," + this.SUR_NAME
				+"," + this.AGE
				+"," + this.GENDER
				+"," + this.ADDRESS;
		
		
		return str;
		
		
		
	}
	

}
