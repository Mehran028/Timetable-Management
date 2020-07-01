package edu.uog.student;

import java.util.List;
import java.util.Scanner;

import edu.uog.person.Person;


public class studentInterface {
	
	
	@SuppressWarnings("unused")
	public static void StudentManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("Students Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert Student");
			System.out.println("2.   Show All Students");
			System.out.println("3.   Search Student");
			System.out.println("4.   Delete One Student");
			System.out.println("5.   Delete All Students");
			System.out.println("10.  Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			Object student = null;
			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Student");
				System.out.println("---------------------------------");
				Student student1 = new Student();
				
				Person person1  = new Person();
		
				System.out.println("Enter Person id: ");
				int personid = scan.nextInt();
				student1.setPERSON_ID(personid);
				
				System.out.println("Enter Student Roll No: ");
				String rollno = scan.nextLine();
				rollno+=scan.nextLine();
				student1.setSTUDENT_ROLLNO(rollno);

				System.out.println("Enter Study Program: ");
				String studyprogram = scan.nextLine();
				studyprogram+=scan.nextLine();
				student1.setSTUDY_PROGRAM(studyprogram);

				System.out.println("Enter Study Year: ");
				String studyyear = scan.nextLine();
				studyyear+=scan.nextLine();
				student1.setSTUDY_YEAR(studyyear);


				student = studentData.Save(student);
				System.out.println(student.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Show All Students Data");
				System.out.println("---------------------------------");
				List<Student> students = studentData.findAll();
				for (int i=0; i<students.size(); i++) {
					System.out.println(students.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 3:
			
				System.out.println("---------------------------------");
				System.out.println("Search Student");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Student> studentsearch = studentData.search(search);
				for (int i=0; i<studentsearch.size(); i++) {
					System.out.println(studentsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 4:
				

				System.out.println("---------------------------------");
				System.out.println("Delete Student");
				System.out.println("---------------------------------");
				System.out.println("Enter Student ID: ");
				
				int delete = scan.nextInt();
				Student student3 = studentData.deleteOne(delete);
				System.out.println(student3.toString());
				
				System.out.println("---------------------------------");
				break;
				
			case 5:
			
				System.out.println("---------------------------------");
				System.out.println("Delete All Students");
				System.out.println("---------------------------------");
				System.out.println("Enter Student ID: ");
				
				String student2 = studentData.DeleteAll(); 
			    System.out.println(student2); 
				
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