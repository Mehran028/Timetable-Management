package edu.uog.teacher;

import java.util.List;
import java.util.Scanner;




public class teacherInterface {
	
	
	public static void TeacherManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("Teachers Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert Teacher");
			System.out.println("2.   Show All Teachers");
			System.out.println("3.   Search Teacher");
			System.out.println("4.   Delete One Teacher");
			System.out.println("5.   Delete All Teachers");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Teacher");
				System.out.println("---------------------------------");
				Teacher teacher = new Teacher();
				//Person person =  new Person();
				
				System.out.println("Enter Teacher For Name: ");
				String forname = scan.nextLine();
				forname+=scan.nextLine();
				teacher.setFOR_NAME(forname);
				
				System.out.println("Enter Teacher Sur Name: ");
				String surname = scan.nextLine();
				surname+=scan.nextLine();
				teacher.setSUR_NAME(surname);
				
				System.out.println("Enter Teacher Gender: ");
				String gender = scan.nextLine();
				gender+=scan.nextLine();
				teacher.setGENDER(gender);
				
				System.out.println("Enter Teacher Age: ");
				int age = scan.nextInt();
				teacher.setAGE(age);

				System.out.println("Enter Teacher Address: ");
				String address = scan.nextLine();
				address+=scan.nextLine();
				teacher.setADDRESS(address);

				
				teacher = teacherData.Save(teacher);
				System.out.println(teacher.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("Show All Teachers Data");
				System.out.println("---------------------------------");
				List<Teacher> teachers = teacherData.findAll();
				for (int i=0; i<teachers.size(); i++) {
					System.out.println(teachers.get(i).toString());
				}
				System.out.println("---------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("Search Teacher");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Teacher> teachersearch = teacherData.search(search);
				for (int i=0; i<teachersearch.size(); i++) {
					System.out.println(teachersearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;

			case 4:
				System.out.println("---------------------------------");
				System.out.println("Delete One Teacher");
				System.out.println("---------------------------------");
				System.out.println("Enter Teacher ID: ");
				
				int delete = scan.nextInt();
				Teacher teacher1 = teacherData.deleteOne(delete);
				System.out.println(teacher1.toString());
				
				
				System.out.println("---------------------------------");
				break;
			
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Delete All Teachers");
				System.out.println("---------------------------------");
				String teacher2 = teacherData.DeleteAll(); 
			      System.out.println(teacher2); 
				
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