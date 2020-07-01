package edu.uog.course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class courseData {

	

	
	public static  List<Course> findAll() {
		List<Course> courses = new ArrayList<Course>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile2));
			
			while ((line =  bufferreader.readLine()) != null){
				Course course = new Course();
				Course prerequistecourse = new Course();
				
				String[] courseRow = line.split(",");
				
				course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
				course.setCOURSE_CODE(courseRow[1]);
				course.setCOURSE_DESC(courseRow[2]);
				course.setCOURSE_TITLE(courseRow[3]);
				course.setCOURSE_CREDITHOUR(Integer.parseInt(courseRow[4]));
				
				
				if (courseRow.length>5) {
					//courseData cdata = new courseData();
					prerequistecourse = courseData.findOne(Integer.parseInt(courseRow[5]));
					course.setCOURSEPREREQUIST_ID(prerequistecourse);
				}
									
				courses.add(course);
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return courses;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	public static Course findOne(int course_ID) {
		
		String line;
		
		try {
			
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile2));
			
			while ((line =  bufferreader.readLine()) != null){
				Course course = new Course();
				Course prerequistcourse = new Course();
				
				String[] courseRow = line.split(",");
				
				if(Integer.parseInt(courseRow[0]) == course_ID) {
				
					course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
					course.setCOURSE_CODE(courseRow[1]);
					course.setCOURSE_DESC(courseRow[2]);
					course.setCOURSE_TITLE(courseRow[3]);
					course.setCOURSE_CREDITHOUR(Integer.parseInt(courseRow[4]));
					
					if (courseRow.length>5) {
						
					}
						//courseData cdata = new courseData();
						prerequistcourse = courseData.findOne(Integer.parseInt(courseRow[5]));
						course.setCOURSEPREREQUIST_ID(prerequistcourse);
				
				return course;  //point
				}
				
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	public static List<Course> search(String search) {
		List<Course> courses = new ArrayList<Course>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Course.csvFile2));
			
			while ((line =  bufferreader.readLine()) != null){
				Course course = new Course();
				
				
				String[] courseRow = line.split(",");
				
				if (courseRow[1].contains(search) == true) {
					
					course.setCOURSE_ID(Integer.parseInt(courseRow[0]));
					course.setCOURSE_CODE(courseRow[1]);
					course.setCOURSE_DESC(courseRow[2]);
					course.setCOURSE_TITLE(courseRow[3]);
					course.setCOURSE_CREDITHOUR(Integer.parseInt(courseRow[4]));

					if (courseRow.length>5) { 
						course.setCOURSEPREREQUIST_ID(findOne(Integer.parseInt(courseRow[5])));}
					
					
					
				courses.add(course);
				
			}
		}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return courses;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	public static Course Save(Course course) {
			
		FileWriter filewriter;
		
		List<Course> courses = courseData.findAll();
		
		try {
			filewriter = new FileWriter(Course.csvFile2);
			
			for( int i=0; i<courses.size(); i++) {
				
				filewriter.append(courses.get(i).toString());
				filewriter.append("\n");
				
			}
				
			if (courses.size()>0) 
				
			
			{	course.setCOURSE_ID(courses.get(courses.size()-1).getCOURSE_ID()+1); }
		
		else 
			{course.setCOURSE_ID(1);}
		
			filewriter.append(course.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return course;
	}

	public static Course deleteOne(int course_ID) {
		
		

		FileWriter filewriter;
		List<Course> courses = findAll();
		Course course = courseData.findOne(course_ID);
		try 
		{
			filewriter = new FileWriter(Course.csvFile2);
			for(int i=0;i<courses.size();i++) 
			{
				if(courses.get(i).getCOURSE_ID()!=course_ID)
				{
					filewriter.append(courses.get(i).toString());
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
		return course;
	}
	


////////////////////////////////////////////////////////////////////////////////////////////
	 
	public static String DeleteAll() 
	{
		FileWriter filewriter;
		List<Course> courses = findAll();
		try 
		{
			filewriter = new FileWriter(Course.csvFile2);

			for(int i=0;i<courses.size();i++) 
			{
				courses.remove(i);
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
	
	

