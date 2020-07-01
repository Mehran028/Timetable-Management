package edu.uog.course;

import java.util.List;
import java.util.Scanner;


public class courseInterface {
	
	
	
	
	public static void CourseManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("Course Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert Course");
			System.out.println("2.   Show All Courses");
			System.out.println("3.   Search Course By ID");
			System.out.println("4.   Search Course By Coursecode");
			System.out.println("5.   Delete Course");
			System.out.println("6.   Delete All Courses");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Course");
				System.out.println("---------------------------------");
				Course course = new Course();
				
				System.out.println("Enter Course Code: ");
				String coursecode = scan.nextLine();
				coursecode+= scan.nextLine();
				course.setCOURSE_CODE(coursecode);

				System.out.println("Enter Course Desc: ");
				String coursedesc = scan.nextLine();
				coursecode+= scan.nextLine();
				course.setCOURSE_DESC(coursedesc);

				System.out.println("Enter Course Title: ");
				String coursetitle = scan.nextLine();
				coursetitle+= scan.nextLine();
				course.setCOURSE_TITLE(coursetitle);

				System.out.println("Enter Course Credithour: ");
				int coursecredithour = scan.nextInt();
				course.setCOURSE_CREDITHOUR(coursecredithour);
				
				System.out.println("Enter Course Prerequist Id: ");
				int prerequistcourse = scan.nextInt();
				course.setCOURSEPREREQUIST_ID(courseData.findOne(prerequistcourse));

				course = courseData.Save(course);
				System.out.println(course.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				
				System.out.println("---------------------------------");
				System.out.println("Show All Courses Data");
				System.out.println("---------------------------------");
		
				List<Course> course3 = courseData.findAll();
				for (int i=0; i<course3.size(); i++) {
					System.out.println(course3.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("   Search Course By Course-ID    ");
				System.out.println("---------------------------------");
				System.out.print("Enter search: ");
				courseData coursedata3 = new courseData();
				Scanner search1 = new Scanner(System.in);
				int id = search1.nextInt();
				@SuppressWarnings("static-access")
				Course course31 = coursedata3.findOne(id);
				System.out.println(course31.toString());
				System.out.println("----------------------------------");
				break;
				
			case 4:
				
				System.out.println("---------------------------------");
				System.out.println("Search By Course Code");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Course> coursesearch = courseData.search(search);
				for (int i=0; i<coursesearch.size(); i++) {
					System.out.println(coursesearch.get(i).toString());
				}
				System.out.println("---------------------------------");

				break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Delete Course");
				System.out.println("---------------------------------");
				System.out.println("Enter Course ID: ");
				
				int delete = scan.nextInt();
				Course course1 = courseData.deleteOne(delete);
				System.out.println(course1.toString());
				System.out.println("---------------------------------");
						
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Courses");
				System.out.println("---------------------------------");
				String course2 = courseData.DeleteAll(); 
			    System.out.println(course2); 
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