package edu.uog;


import java.util.Scanner;

import edu.uog.campus.roomInterface;
import edu.uog.course.courseInterface;
import edu.uog.course.semesterInterface;
import edu.uog.person.personInterface;
import edu.uog.student.studentCourseInterface;
import edu.uog.student.studentInterface;
import edu.uog.teacher.teacherCourseInterface;
import edu.uog.teacher.teacherInterface;
import edu.uog.timetable.timeslotInterface;
import edu.uog.timetable.timetableInterface;
import edu.uog.timetable.weekdayInterface;


public class TimeTableManagement {


	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("Main Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Rooms");
			System.out.println("2.   Courses");
			System.out.println("3.   Person");
			System.out.println("4.   Student");
			System.out.println("5.   StudentCourse");
			System.out.println("6.   Semester");
			System.out.println("7.   Teacher");
			System.out.println("8.   Teacher Course");
			System.out.println("9.   WeekDay");
			System.out.println("10.  TimeSlot");
			System.out.println("11.  TimeTable");
			System.out.println("Enter Your Choice [1-12]: ");
			choice = scan.nextInt();
	
			switch (choice) {
			case 1:
				roomInterface.RoomManu();
				choice=-1;
				break;

			case 2:
				courseInterface.CourseManu();
				choice=-1;
				
				break;
				
			case 3:
				personInterface.PersonManu();
				choice=-1;
				
				
				break;
			case 4:
				studentInterface.StudentManu();
				choice=-1;
				
				break;
			case 5:
				studentCourseInterface.StudentCourseManu();
				choice=-1;
				
				break;
				
			case 6:
				semesterInterface.SemesterManu();
				choice=-1;
				
				break;
				
			case 7:
				teacherInterface.TeacherManu();
				choice=-1;
				
				break;
			
			case 8:
				teacherCourseInterface.TeacherCourseManu();
				choice=-1;
				
			case 9:
				weekdayInterface.WeekDayManu();
				choice=-1;
				break;
				
			case 10:
				timeslotInterface.TimeSlotManu();
				choice=-1;
				break;
				
			case 11:
				timetableInterface.TimeTableManu();
				choice=-1;
				break;
				
				
				
			case 12:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		}

		}
	
}
