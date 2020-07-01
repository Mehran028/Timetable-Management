package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;


public class timeslotInterface {
	
	public static void TimeSlotManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println(" TimeSlot Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert TimeSlot");
			System.out.println("2.   Show All TimeSlots");
			System.out.println("3.   Search TimeSlot");
			System.out.println("4.   Delete One TimeSlot");
			System.out.println("5.   Delete All TimeSlots");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New TimeSlot");
				System.out.println("---------------------------------");
				TimeSlot timeslot = new TimeSlot();
				@SuppressWarnings("unused") WeekDay 
				weekday = new WeekDay();

				
				System.out.println("Enter TimeSlot ID: ");
				int id = scan.nextInt();
				timeslot.setTIMESLOT_ID(id);
				
				System.out.println("Enter WeekDay ID: ");
				int weekdayid = scan.nextInt();
				timeslot.setWEEKDAY_ID(weekdayData.findOne(weekdayid));
				
				System.out.println("Enter TimeSlot Start: ");
				String tsstart = scan.nextLine();
				tsstart+=scan.nextLine();
				timeslot.setTIMESLOT_START(tsstart);
				
				System.out.println("Enter TimeSlot End: ");
				String tsend = scan.nextLine();
				tsend+=scan.nextLine();
				timeslot.setTIMESLOT_END(tsend);


				timeslot = timeslotData.Save(timeslot);
				System.out.println(timeslot.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Show All TimeSlots Data");
				System.out.println("---------------------------------");
				List<TimeSlot> timeslots = timeslotData.findAll();
				for (int i=0; i<timeslots.size(); i++) {
					System.out.println(timeslots.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Search TimeSlot");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<TimeSlot> timeslotsearch = timeslotData.search(search);
				for (int i=0; i<timeslotsearch.size(); i++) {
					System.out.println(timeslotsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;

			case 4:
				System.out.println("---------------------------------");
				System.out.println("Delete One TimeSlot");
				System.out.println("---------------------------------");
				System.out.println("Enter TimeSlot ID: ");
				
				int delete = scan.nextInt();
				TimeSlot timeslot1 = timeslotData.deleteOne(delete);
				System.out.println(timeslot1.toString());
				
				
				System.out.println("---------------------------------");
				break;
			
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Delete All TimeSlot");
				System.out.println("---------------------------------");
				String timeslot2 = timeslotData.DeleteAll(); 
			      System.out.println(timeslot2); 
				
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