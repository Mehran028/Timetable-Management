package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;

import edu.uog.campus.roomData;
import edu.uog.teacher.teacherCourseData;

public class timetableInterface {
	

	public static void TimeTableManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("TimeTable Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert TimeTable");
			System.out.println("2.   Show All TimeTable");
			System.out.println("3.   Search TimeTable");
			System.out.println("4.   Delete One TimeTable");
			System.out.println("5.   Delete All TimeTable");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				
				TimeTable timetable = new TimeTable();
				System.out.println("Enter TimeTable ID: ");
				int id = scan.nextInt();
				timetable.setTIMETABLE_ID(id);
				;
				System.out.println("Enter TeacherCourse ID: ");
				int tcid = scan.nextInt();
				timetable.setTEACHERCOURSE_ID(teacherCourseData.findOne(tcid));
				
				System.out.println("Enter TimeSlot ID: ");
				int tsid = scan.nextInt();
				timetable.setTIMESLOT_ID(timeslotData.findOne(tsid));
				
				System.out.println("Enter Room ID: ");
				int rid = scan.nextInt();
				timetable.setROOM_ID(roomData.findOne(rid));
				
				
				timetable = timtableData.Save(timetable);
				System.out.println(timetable.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Show All TimeTable Data");
				System.out.println("---------------------------------");
				List<TimeTable> timetables = timtableData.findAll();
				for (int i=0; i<timetables.size(); i++) {
					System.out.println(timetables.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Search TimeTable");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<TimeTable> timetablesearch = timtableData.search(search);
				for (int i=0; i<timetablesearch.size(); i++) {
					System.out.println(timetablesearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;

			case 4:
				System.out.println("---------------------------------");
				System.out.println("Delete One TimeTable");
				System.out.println("---------------------------------");
				System.out.println("Enter TimeTable ID: ");
				
				int delete = scan.nextInt();
				TimeTable timetable1 = timtableData.deleteOne(delete);
				System.out.println(timetable1.toString());
				
				
				System.out.println("---------------------------------");
				break;
			
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Delete All TimeTable");
				System.out.println("---------------------------------");
				String timetable2 = timtableData.DeleteAll(); 
			      System.out.println(timetable2); 
				
				System.out.println("---------------------------------");
				break;
			
				case 10:
				break;
				

				default:
					System.out.println("Invalid choice!");
			}
		}
}

}
