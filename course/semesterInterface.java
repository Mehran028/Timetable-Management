package edu.uog.course;

import java.util.List;
import java.util.Scanner;


public class semesterInterface {
	

	public static void SemesterManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("Semester Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert semester");
			System.out.println("2.   Show All Semester");
			System.out.println("3.   Search Semester");
			System.out.println("4.   Delete One Semester");
			System.out.println("5.   Delete All Semesters");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Semester");
				System.out.println("---------------------------------");
				Semester semester = new Semester();
				
				System.out.println("Enter Semester Code: ");
				String code = scan.nextLine();
				code+=scan.nextLine();
				semester.setSEMESTER_CODE(code);

				System.out.println("Enter Semester Name: ");
				String name = scan.nextLine();
				name+=scan.nextLine();
				semester.setSEMESTER_NAME(name);
				
				System.out.println("Enter Semester Start Date: ");
				String startdate = scan.nextLine();
				startdate+=scan.nextLine();
				semester.setSEMESTER_STARTDATE(startdate);

				System.out.println("Enter Semester End Date: ");
				String enddate = scan.nextLine();
				enddate+=scan.nextLine();
				semester.setSEMESTER_ENDDATE(enddate);


				semester = semesterData.Save(semester);
				System.out.println(semester.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Show All Semesters Data");
				System.out.println("---------------------------------");
				List<Semester> semesters = semesterData.findAll();
				for (int i=0; i<semesters.size(); i++) {
					System.out.println(semesters.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Search Semester");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Semester> semestersearch = semesterData.search(search);
				for (int i=0; i<semestersearch.size(); i++) {
					System.out.println(semestersearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;

			case 4:
				System.out.println("---------------------------------");
				System.out.println("Delete One Semester");
				System.out.println("---------------------------------");
				System.out.println("Enter Semester ID: ");
				
				int delete = scan.nextInt();
				Semester semester1 = semesterData.deleteOne(delete);
				System.out.println(semester1.toString());
				
				
				System.out.println("---------------------------------");
				break;
			
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Delete All Semesters");
				System.out.println("---------------------------------");
				String semester2 = semesterData.DeleteAll(); 
			      System.out.println(semester2); 
				
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
