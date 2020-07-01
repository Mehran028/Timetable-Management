package edu.uog.timetable;

import edu.uog.campus.Room;
import edu.uog.teacher.TeacherCourse;

public class TimeTable {
	
	public static  String csvFile = "D:\\TimeTable.csv";
	
	private int TIMETABLE_ID;
	
	private TeacherCourse TEACHERCOURSE_ID;
	
	private TimeSlot TIMESLOT_ID;
	
	private Room ROOM_ID;

	
	
	public static String getCsvFile() {
		return csvFile;
	}

	public static void setCsvFile(String csvFile) {
		TimeTable.csvFile = csvFile;
	}

	public int getTIMETABLE_ID() {
		return TIMETABLE_ID;
	}

	public void setTIMETABLE_ID(int tIMETABLE_ID) {
		TIMETABLE_ID = tIMETABLE_ID;
	}

	public TeacherCourse getTEACHERCOURSE_ID() {
		return TEACHERCOURSE_ID;
	}

	public void setTEACHERCOURSE_ID(TeacherCourse tEACHERCOURSE_ID) {
		TEACHERCOURSE_ID = tEACHERCOURSE_ID;
	}

	public TimeSlot getTIMESLOT_ID() {
		return TIMESLOT_ID;
	}

	public void setTIMESLOT_ID(TimeSlot tIMESLOT_ID) {
		TIMESLOT_ID = tIMESLOT_ID;
	}

	public Room getROOM_ID() {
		return ROOM_ID;
	}

	public void setROOM_ID(Room rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}
	
	

	public String toString() {
		
		String str = null;
		
		str = this.ROOM_ID.getROOM_ID()
				+"," + this.TIMETABLE_ID
				+"," + this.TEACHERCOURSE_ID.getTEACHERCOURSE_ID()
				+"," + this.TIMESLOT_ID.getTIMESLOT_ID();
		
		
		return str;
		
		
		
	}
}
