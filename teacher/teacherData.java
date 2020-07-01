package edu.uog.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.person.Person;


public class teacherData {
	

	public static List<Teacher> findAll() {
		List<Teacher> teachers = new ArrayList<Teacher>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				Teacher teacher = new Teacher();
				@SuppressWarnings("unused")
				Person person  = new Person();
				
				String[] teacherRow = line.split(",");
				
				teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
				teacher.setFOR_NAME(teacherRow[1]);
				teacher.setSUR_NAME(teacherRow[2]);
				teacher.setGENDER(teacherRow[3]);
				teacher.setAGE(Integer.parseInt(teacherRow[4]));
				teacher.setADDRESS(teacherRow[5]);
				
				//person.setFOR_NAME(teacherRow[1]);
				//person.setFOR_NAME(teacherRow[2]);
				//person.setGENDER(teacherRow[3]);
				//person.setAGE(Integer.parseInt(teacherRow[4]));
				//person.setADDRESS(teacherRow[5]);
				
				teachers.add(teacher);
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return teachers;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("resource")
	public static Teacher findOne(int teacher_ID) {
		
		String line;
		
		try {
			
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				Teacher teacher = new Teacher();
				@SuppressWarnings("unused")
				Person person = new Person();
				String[] teacherRow = line.split(",");
				
				if(Integer.parseInt(teacherRow[0]) == teacher_ID) {
				

					teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
					teacher.setFOR_NAME(teacherRow[1]);
					teacher.setSUR_NAME(teacherRow[2]);
					teacher.setGENDER(teacherRow[3]);
					teacher.setAGE(Integer.parseInt(teacherRow[4]));
					teacher.setADDRESS(teacherRow[5]);
				return teacher;
				}
				
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	public static List<Teacher> search(String search) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				Teacher teacher = new Teacher();
				@SuppressWarnings("unused")
				Person person = new Person();
				
				String[] teacherRow = line.split(",");
				
				if (teacherRow[1].contains(search) == true) {
					

					teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
					teacher.setFOR_NAME(teacherRow[1]);
					teacher.setSUR_NAME(teacherRow[2]);
					teacher.setGENDER(teacherRow[3]);
					teacher.setAGE(Integer.parseInt(teacherRow[4]));
					teacher.setADDRESS(teacherRow[5]);
				teachers.add(teacher);
				
			}
		}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return teachers;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	public static Teacher Save(Teacher teacher) {
			
		FileWriter filewriter;
		
		List<Teacher> teachers = findAll();
		
		
		
		
		try {
			filewriter = new FileWriter(Teacher.csvFile);
			
			for( int i=0; i<teachers.size(); i++) {
				
				filewriter.append(teachers.get(i).toString());
				filewriter.append("\n");
				
			}
				
			if (teachers.size()>0) 
				
			
			{	teacher.setTEACHER_ID(teachers.get(teachers.size()-1).getTEACHER_ID()+1); }
		
		else 
			{teacher.setTEACHER_ID(1);}
		
			filewriter.append(teacher.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return teacher;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	//@SuppressWarnings({ "resource", "unused" })
	public static Teacher deleteOne(int teacher_ID) {
		
		

		FileWriter filewriter;
		List<Teacher> teachers = findAll();
		Teacher teacher = teacherData.findOne(teacher_ID);
		try 
		{
			filewriter = new FileWriter(Teacher.csvFile);
			for(int i=0;i<teachers.size();i++) 
			{
				if(teachers.get(i).getTEACHER_ID()!=teacher_ID)
				{
					filewriter.append(teachers.get(i).toString());
					filewriter.append("\n");
				}
			}
			    filewriter.flush();
				filewriter.close();
	    } 
		catch (IOException e) 
		{   
			System.out.println("CSV File not Found!" +e);  
			e.printStackTrace();    
		}
		return teacher;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	 
	public static String DeleteAll() 
	    {
			FileWriter filewriter;
			List<Teacher> teachers = findAll();
			try 
			{
				filewriter = new FileWriter(Teacher.csvFile);
				
				for(int i=0;i<teachers.size();i++) 
				{
					teachers.remove(i);
				}
					filewriter.flush();
					filewriter.close();
		    } 
			catch (IOException e) 
			{   
				System.out.println("CSV File not found!" +e);  
				e.printStackTrace();    
			}
			return "Deleted Successfully";
		}
	
 ////////////////////////////////////////////////////////////////////////////////////////
	
	

	
	
	

}
