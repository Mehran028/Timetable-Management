package edu.uog.student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.course.courseData;
;

public class studentCourseData {
	

	
	public static List<StudentCourse> findAll() {
		List<StudentCourse> studentcourses = new ArrayList<StudentCourse>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				StudentCourse student = new StudentCourse();
			
				String[] studentcourseRow = line.split(",");
				
				student.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
				student.setCOURSE_ID(courseData.findOne(Integer.parseInt(studentcourseRow[1])));
				student.setSTUDENT_ID(studentData.findOne(Integer.parseInt(studentcourseRow[2])));
				student.setSECTION(studentcourseRow[3]);
				
				studentcourses.add(student);

				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return studentcourses;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("resource")
	public static StudentCourse findOne(int student_ID) {
		
		String line;
		
		try {
			
			BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				StudentCourse student = new StudentCourse();
				
				String[] studentcourseRow = line.split(",");
				
				if(Integer.parseInt(studentcourseRow[0]) == student_ID) {
				
					student.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
					student.setCOURSE_ID(courseData.findOne(Integer.parseInt(studentcourseRow[1])));
					student.setSTUDENT_ID(studentData.findOne(Integer.parseInt(studentcourseRow[2])));
					student.setSECTION(studentcourseRow[3]);
					

				return student;
				}
				
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	public static List<StudentCourse> search(String search) {
		List<StudentCourse> studentcourses = new ArrayList<StudentCourse>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				StudentCourse student = new StudentCourse();
				
				String[] studentcourseRow = line.split(",");
				
				if (studentcourseRow[1].contains(search) == true) {
					
					student.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
					student.setCOURSE_ID(courseData.findOne(Integer.parseInt(studentcourseRow[1])));
					student.setSTUDENT_ID(studentData.findOne(Integer.parseInt(studentcourseRow[2])));
					student.setSECTION(studentcourseRow[3]);
					
					studentcourses.add(student);

			}
		}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return studentcourses;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	public static StudentCourse Save(StudentCourse studentcourse) {
			
		FileWriter filewriter;
		
		List<StudentCourse> studentcourses = findAll();
		
		
		
		
		try {
			filewriter = new FileWriter(StudentCourse.csvFile);
			
			for( int i=0; i<studentcourses.size(); i++) {
				
				filewriter.append(studentcourses.get(i).toString());
				filewriter.append("\n");
				
			}
				
			if (studentcourses.size()>0) 
				
			
	{studentcourse.setSTUDENTCOURSE_ID(studentcourses.get(studentcourses.size()-1).getSTUDENTCOURSE_ID()+1);}
		
		else 
			{studentcourse.setSTUDENTCOURSE_ID(1);}
		
			filewriter.append(studentcourse.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return studentcourse;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////

	//@SuppressWarnings({ "resource", "unused" })
	public static StudentCourse deleteOne(int studentcourse_ID) {
		

		FileWriter filewriter;
		List<StudentCourse> studentcourses = findAll();
		StudentCourse studentcourse = studentCourseData.findOne(studentcourse_ID);
		try 
		{
			filewriter = new FileWriter(StudentCourse.csvFile);
			for(int i=0;i<studentcourses.size();i++) 
			{
				if(studentcourses.get(i).getSTUDENTCOURSE_ID()!=studentcourse_ID)
				{
					filewriter.append(studentcourses.get(i).toString());
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
		return studentcourse;
	}
	////////////////////////////////////////////////////////////////////////////////////////////

	public static String DeleteAll() 
    {
		FileWriter filewriter;
		List<StudentCourse> studentcourses = findAll();
		try 
		{
			filewriter = new FileWriter(StudentCourse.csvFile);
			
			for(int i=0;i<studentcourses.size();i++) 
			{
				studentcourses.remove(i);
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


	}



