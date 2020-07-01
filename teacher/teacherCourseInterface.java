package edu.uog.teacher;

import java.util.List;
import java.util.Scanner;

import edu.uog.course.courseData;


public class teacherCourseInterface {	
	
	public static void TeacherCourseManu() {
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	int choice=-1;

	choice = -1;
	while (choice!=10) {
		System.out.println("=====================================================");
		System.out.println(" Teacher Course Menu");
		System.out.println("=====================================================");
		System.out.println("1.   Insert Teacher Course");
		System.out.println("2.   Show All Teacher Courses");
		System.out.println("3.   Search Teacher Course");
		System.out.println("4.   Delete One Teacher Course");
		System.out.println("5.   Delete All Teacher Courses");
		System.out.println("10.   Back");
		System.out.print("Enter Your Choice [1-10]: ");
		choice = scan.nextInt();

		switch (choice) {
		case 1:
			System.out.println("---------------------------------");
			System.out.println("Add New Room");
			System.out.println("---------------------------------");
			TeacherCourse teachercourse = new TeacherCourse();

			System.out.println("Enter Teacher Course ID: ");
			int id = scan.nextInt();
			teachercourse.setTEACHERCOURSE_ID(id);
			

			System.out.println("Enter Course ID: ");
			int courseid = scan.nextInt();
			teachercourse.setCOURSE_ID(courseData.findOne(courseid));

			 System.out.println("Enter Teacher ID: ");
			int teacherid = scan.nextInt();
			teachercourse.setTEACHER_ID(teacherData.findOne(teacherid));



			System.out.println("Enter Section: ");
			String section = scan.nextLine();
			section+=scan.nextLine();
			teachercourse.setSECTION(section);

			teachercourse = teacherCourseData.Save(teachercourse);
			System.out.println(teachercourse.toString());
			System.out.println("---------------------------------");
			break;
		case 2:
			System.out.println("---------------------------------");
			System.out.println("Show All Teacher Courses Data");
			System.out.println("---------------------------------");
			List<TeacherCourse> teachercourses = teacherCourseData.findAll();
			for (int i=0; i<teachercourses.size(); i++) {
				System.out.println(teachercourses.get(i).toString());
			}
			System.out.println("---------------------------------");
			break;
		case 3:
			System.out.println("---------------------------------");
			System.out.println("Search Teacher Course");
			System.out.println("---------------------------------");
			System.out.println("Enter search: ");
			String search = scan.nextLine();
			search+=scan.nextLine();
			List<TeacherCourse> teachercoursesearch = teacherCourseData.search(search);
			for (int i=0; i<teachercoursesearch.size(); i++) {
				System.out.println(teachercoursesearch.get(i).toString());
			}
			System.out.println("---------------------------------");
			
			break;

		case 4:
			System.out.println("---------------------------------");
			System.out.println("Delete One Teacher Course");
			System.out.println("---------------------------------");
			System.out.println("Enter Teacher Course ID: ");
			
			int delete = scan.nextInt();
			TeacherCourse teachercourse1 = teacherCourseData.deleteOne(delete);
			System.out.println(teachercourse1.toString());
			
			
			System.out.println("---------------------------------");
			break;
		
		case 5:
			System.out.println("---------------------------------");
			System.out.println("Delete All Teacher Courses");
			System.out.println("---------------------------------");
			String teachercourse2 = teacherCourseData.DeleteAll(); 
		      System.out.println(teachercourse2); 
			
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
