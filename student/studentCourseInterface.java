package edu.uog.student;

import java.util.List;
import java.util.Scanner;

import edu.uog.course.Course;
import edu.uog.course.courseData;


public class studentCourseInterface {
	
	
	public static void StudentCourseManu()
	
	{
				@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("StudentCourses Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert StudentCourse");
			System.out.println("2.   Show All StudentCourses");
			System.out.println("3.   Search StudentCourse");
			System.out.println("4.   Delete One StudentCourse");
			System.out.println("5.   Delete All StudentCourses");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New StudentCourse");
				System.out.println("---------------------------------");
				StudentCourse studentcourse = new StudentCourse();
				
				System.out.println("Enter StudentCourse Id: ");
				int sid = scan.nextInt();
				studentcourse.setSTUDENTCOURSE_ID(sid);
				
				@SuppressWarnings("unused")
				Course course = new Course();
				System.out.println("Enter Course Id:  ");
				int courseid  = scan.nextInt();
				studentcourse.setCOURSE_ID(courseData.findOne(courseid));
				
				@SuppressWarnings("unused")
				Student student = new Student();
				System.out.println("Enter Student Id:  ");
				int studentid  = scan.nextInt();
				studentcourse.setSTUDENT_ID(studentData.findOne(studentid));
				


				System.out.println("Enter Section: ");
				String section = scan.nextLine();
				section+=scan.nextLine();
				studentcourse.setSECTION(section);

				studentcourse = studentCourseData.Save(studentcourse);
				System.out.println(studentcourse.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Show All Student Courses Data");
				System.out.println("---------------------------------");
				List<StudentCourse> studentcourses = studentCourseData.findAll();
				for (int i=0; i<studentcourses.size(); i++) {
					System.out.println(studentcourses.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Search RStudent Course");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<StudentCourse> studentcoursesearch = studentCourseData.search(search);
				for (int i=0; i<studentcoursesearch.size(); i++) {
					System.out.println(studentcoursesearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;

			case 4:
				System.out.println("---------------------------------");
				System.out.println("Delete One StudentCourse");
				System.out.println("---------------------------------");
				System.out.println("Enter StudentCourse ID: ");
				
				int delete = scan.nextInt();
				StudentCourse studentcourse1 = studentCourseData.deleteOne(delete);
				System.out.println(studentcourse1.toString());
				
				
				System.out.println("---------------------------------");
				break;
			
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Delete All StudentCourses");
				System.out.println("---------------------------------");
				String studentcourse2 = studentCourseData.DeleteAll(); 
			      System.out.println(studentcourse2); 
				
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





