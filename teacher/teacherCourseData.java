package edu.uog.teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.course.Course;
import edu.uog.course.courseData;


public class teacherCourseData {
	
	@SuppressWarnings("unused")
	public static List<TeacherCourse> findAll() {
		List<TeacherCourse> teachercourses = new ArrayList<TeacherCourse>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				TeacherCourse teachercourse = new TeacherCourse();
				Course course = new Course();
				Teacher teacher = new Teacher();
				String[] teachercourseRow = line.split(",");
				
				teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
				teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(teachercourseRow[1])));
				teachercourse.setTEACHER_ID(teacherData.findOne(Integer.parseInt(teachercourseRow[2])));
				teachercourse.setSECTION(teachercourseRow[3]);
				
				teachercourses.add(teachercourse);
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return teachercourses;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("resource")
	public static  TeacherCourse findOne(int teachercourse_ID) {
		
		String line;
		
		try {
			
			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				TeacherCourse teachercourse  = new TeacherCourse();
				
				String[] teachercourseRow = line.split(",");
				
				if(Integer.parseInt(teachercourseRow[0]) == teachercourse_ID) {
				
					teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
					teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(teachercourseRow[1])));
					teachercourse.setTEACHER_ID(teacherData.findOne(Integer.parseInt(teachercourseRow[2])));
					teachercourse.setSECTION(teachercourseRow[3]);
					
				
				return teachercourse;
				}
				
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	public static List<TeacherCourse> search(String search) {
		List<TeacherCourse> teachercourses = new ArrayList<TeacherCourse>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				TeacherCourse teachercourse = new TeacherCourse();
				
				String[] teachercourseRow = line.split(",");
				
				if (teachercourseRow[1].contains(search) == true) {
					
					teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
					teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(teachercourseRow[1])));
					teachercourse.setTEACHER_ID(teacherData.findOne(Integer.parseInt(teachercourseRow[2])));
					teachercourse.setSECTION(teachercourseRow[3]);
					
				teachercourses.add(teachercourse);
				
			}
		}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return teachercourses;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	public static TeacherCourse Save(TeacherCourse teachercourse) {
			
		FileWriter filewriter;
		
		List<TeacherCourse> teachercourses = findAll();
		
		
		
		
		try {
			filewriter = new FileWriter(TeacherCourse.csvFile);
			
			for( int i=0; i<teachercourses.size(); i++) {
				
				filewriter.append(teachercourses.get(i).toString());
				filewriter.append("\n");
				
			}
				
			if (teachercourses.size()>0) 
				
			
			{	teachercourse.setTEACHERCOURSE_ID(teachercourses.get(teachercourses.size()-1).getTEACHERCOURSE_ID()+1); }
		
		else 
			{teachercourse.setTEACHERCOURSE_ID(1);}
		
			filewriter.append(teachercourse.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return teachercourse;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	//@SuppressWarnings({ "resource", "unused" })
	public static TeacherCourse deleteOne(int teachercourse_ID) {
		
		

		FileWriter filewriter;
		List<TeacherCourse> teachercourses = findAll();
		TeacherCourse teachercourse = teacherCourseData.findOne(teachercourse_ID);
		try 
		{
			filewriter = new FileWriter(TeacherCourse.csvFile);
			for(int i=0;i<teachercourses.size();i++) 
			{
				if(teachercourses.get(i).getTEACHERCOURSE_ID()!=teachercourse_ID)
				{
					filewriter.append(teachercourses.get(i).toString());
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
		return teachercourse;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	 
	public static String DeleteAll() 
	    {
			FileWriter filewriter;
			List<TeacherCourse> teachercourses = findAll();
			try 
			{
				filewriter = new FileWriter(TeacherCourse.csvFile);
				
				for(int i=0;i<teachercourses.size();i++) 
				{
					teachercourses.remove(i);
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
