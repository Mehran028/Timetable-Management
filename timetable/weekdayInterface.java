package edu.uog.timetable;

import java.util.List;
import java.util.Scanner;


public class weekdayInterface {

	public static void WeekDayManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("WeekDays Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert WeekDay");
			System.out.println("2.   Show All WeekDays");
			System.out.println("3.   Search WeekDay");
			System.out.println("4.   Delete One WeekDay");
			System.out.println("5.   Delete All WeekDays");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New WeekDay");
				System.out.println("---------------------------------");
				WeekDay weekday = new WeekDay();
				
				System.out.println("Enter WeekDay Name: ");
				String name = scan.nextLine();
				name+=scan.nextLine();
				weekday.setWEEKDAY_NAME(name);


				weekday = weekdayData.Save(weekday);
				System.out.println(weekday.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Show All WeekDays Data");
				System.out.println("---------------------------------");
				List<WeekDay> weekdays = weekdayData.findAll();
				for (int i=0; i<weekdays.size(); i++) {
					System.out.println(weekdays.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Search WeekDay by Week Name");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<WeekDay> weekdaysearch = weekdayData.search(search);
				for (int i=0; i<weekdaysearch.size(); i++) {
					System.out.println(weekdaysearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;

			case 4:
				System.out.println("---------------------------------");
				System.out.println("Delete One WeekDay");
				System.out.println("---------------------------------");
				System.out.println("Enter WeekDay ID: ");
				
				int delete = scan.nextInt();
				WeekDay weekday1 = weekdayData.deleteOne(delete);
				System.out.println(weekday1.toString());
				
				
				System.out.println("---------------------------------");
				break;
			
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Delete All WeekDays");
				System.out.println("---------------------------------");
				String weekday2 = weekdayData.DeleteAll(); 
			      System.out.println(weekday2); 
				
				System.out.println("---------------------------------");
				break;
			
				case 10:
				break;
				

				default:
					System.out.println("Invalid choice!");
			}
		}

	}}
