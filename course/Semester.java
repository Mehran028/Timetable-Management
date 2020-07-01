package edu.uog.course;

public class Semester {

		
	    public static  String csvFile = "D:\\Semester.csv";
	
		private int SEMESTER_ID;
		
		private String SEMESTER_CODE;
		
		private String SEMESTER_NAME;
		
		private String SEMESTER_STARTDATE;
		
		private String SEMESTER_ENDDATE;
		
		
		
		

		public static String getCsvFile() {
			return csvFile;
		}

		public static void setCsvFile(String csvFile) {
			Semester.csvFile = csvFile;
		}

		public int getSEMESTER_ID() {
			return SEMESTER_ID;
		}

		public void setSEMESTER_ID(int sEMESTER_ID) {
			SEMESTER_ID = sEMESTER_ID;
		}

		public String getSEMESTER_CODE() {
			return SEMESTER_CODE;
		}

		public void setSEMESTER_CODE(String sEMESTER_CODE) {
			SEMESTER_CODE = sEMESTER_CODE;
		}

		public String getSEMESTER_NAME() {
			return SEMESTER_NAME;
		}

		public void setSEMESTER_NAME(String sEMESTER_NAME) {
			SEMESTER_NAME = sEMESTER_NAME;
		}

		public String getSEMESTER_STARTDATE() {
			return SEMESTER_STARTDATE;
		}

		public void setSEMESTER_STARTDATE(String sEMESTER_STARTDATE) {
			SEMESTER_STARTDATE = sEMESTER_STARTDATE;
		}

		public String getSEMESTER_ENDDATE() {
			return SEMESTER_ENDDATE;
		}

		public void setSEMESTER_ENDDATE(String sEMESTER_ENDDATE) {
			SEMESTER_ENDDATE = sEMESTER_ENDDATE;
		}

		public String toString() {
			
			String str = null;
			
			str = this.SEMESTER_ID
					+"," + this.SEMESTER_CODE
					+"," + this.SEMESTER_NAME
					+"," + this.SEMESTER_STARTDATE
					+"," + this.SEMESTER_ENDDATE;
			
			
			return str;
			
			
			
		}
		
	}
