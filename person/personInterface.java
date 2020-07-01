package edu.uog.person;

import java.util.List;
import java.util.Scanner;



public class personInterface {

	
	public static void PersonManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;

		choice = -1;
		while (choice!=10) {
			System.out.println("=====================================================");
			System.out.println("Persons Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert Person");
			System.out.println("2.   Show Persons");
			System.out.println("3.   Search Person");
			System.out.println("4.   Delete One Person");
			System.out.println("5.   Delete All Persons");
			System.out.println("10.   Back");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("---------------------------------");
				System.out.println("Add New Person");
				System.out.println("---------------------------------");
				Person person = new Person();
				
				System.out.println("Enter Person Title: ");
				String title = scan.nextLine();
				title+=scan.nextLine();
				person.setTITLE(title);

				System.out.println("Enter For Name: ");
				String forname = scan.nextLine();
				forname+=scan.nextLine();
				person.setFOR_NAME(forname);

				System.out.println("Enter Sur Name: ");
				String surname = scan.nextLine();
				surname+=scan.nextLine();
				person.setSUR_NAME(surname);

				System.out.println("Enter Age: ");
				int age = scan.nextInt();
				person.setAGE(age);

				System.out.println("Enter Gender: ");
				String gender = scan.nextLine();
				gender+=scan.nextLine();
				person.setGENDER(gender);

				System.out.println("Enter Address: ");
				String address = scan.nextLine();
				address+=scan.nextLine();
				person.setADDRESS(address);

				person = personData.Save(person);
				System.out.println(person.toString());
				System.out.println("---------------------------------");
				break;
			case 2:
				
				System.out.println("---------------------------------");
				System.out.println("Show All Persons Data");
				System.out.println("---------------------------------");
				List<Person> persons = personData.findAll();
				for (int i=0; i<persons.size(); i++) {
					System.out.println(persons.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 3:

				System.out.println("---------------------------------");
				System.out.println("Search Person By Field");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Person> personsearch = personData.search(search);
				for (int i=0; i<personsearch.size(); i++) {
					System.out.println(personsearch.get(i).toString());
				}
				System.out.println("---------------------------------");

				break;
			case 4:

				System.out.println("---------------------------------");
				System.out.println("Delete Person");
				System.out.println("---------------------------------");
				System.out.println("Enter Person ID: ");
				
				int delete = scan.nextInt();
				Person person1 = personData.deleteOne(delete);
				System.out.println(person1.toString());
				
				System.out.println("---------------------------------");
				break;
				
			case 5:

				System.out.println("---------------------------------");
				System.out.println("Delete All Persons");
				System.out.println("---------------------------------");
				
				String person2 = personData.DeleteAll(); 
			    System.out.println(person2); 
				
				System.out.println("---------------------------------");
				break;

			case 10:
				break;
			}
		}
}
}