package edu.uog.course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class semesterData {
	
	

	public static List<Semester> findAll() {
		List<Semester> semesters = new ArrayList<Semester>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Semester.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				Semester semester = new Semester();
				
				String[] semesterRow = line.split(",");
				
				semester.setSEMESTER_ID(Integer.parseInt(semesterRow[0]));
				semester.setSEMESTER_CODE(semesterRow[1]);
				semester.setSEMESTER_NAME(semesterRow[2]);
				semester.setSEMESTER_STARTDATE(semesterRow[3]);
				semester.setSEMESTER_ENDDATE(semesterRow[4]);
				
				semesters.add(semester);
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return semesters;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("resource")
	public static Semester findOne(int semester_ID) {
		
		String line;
		
		try {
			
			BufferedReader bufferreader = new BufferedReader(new FileReader(Semester.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				Semester semester = new Semester();
				
				String[] semesterRow = line.split(",");
				
				if(Integer.parseInt(semesterRow[0]) == semester_ID) {
				
					semester.setSEMESTER_ID(Integer.parseInt(semesterRow[0]));
					semester.setSEMESTER_CODE(semesterRow[1]);
					semester.setSEMESTER_NAME(semesterRow[2]);
					semester.setSEMESTER_STARTDATE(semesterRow[3]);
					semester.setSEMESTER_ENDDATE(semesterRow[4]);
					
				return semester;
				}
				
				
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	public static List<Semester> search(String search) {
		List<Semester> semesters = new ArrayList<Semester>();
		String line;
		
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferreader = new BufferedReader(new FileReader(Semester.csvFile));
			
			while ((line =  bufferreader.readLine()) != null){
				Semester semester = new Semester();
				
				String[] semesterRow = line.split(",");
				
				if (semesterRow[1].contains(search) == true) {
					
					semester.setSEMESTER_ID(Integer.parseInt(semesterRow[0]));
					semester.setSEMESTER_CODE(semesterRow[1]);
					semester.setSEMESTER_NAME(semesterRow[2]);
					semester.setSEMESTER_STARTDATE(semesterRow[3]);
					semester.setSEMESTER_ENDDATE(semesterRow[4]);
					
				semesters.add(semester);
				
			}
		}
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return semesters;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	public static Semester Save(Semester semester) {
			
		FileWriter filewriter;
		
		List<Semester> semesters = findAll();
		
		
		
		
		try {
			filewriter = new FileWriter(Semester.csvFile);
			
			for( int i=0; i<semesters.size(); i++) {
				
				filewriter.append(semesters.get(i).toString());
				filewriter.append("\n");
				
			}
				
			if (semesters.size()>0) 
				
			
			{	semester.setSEMESTER_ID(semesters.get(semesters.size()-1).getSEMESTER_ID()+1); }
		
		else 
			{semester.setSEMESTER_ID(1);}
		
			filewriter.append(semester.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
			
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return semester;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////
	//@SuppressWarnings({ "resource", "unused" })
	public static Semester deleteOne(int semester_ID) {
		
		

		FileWriter filewriter;
		List<Semester> semesters = findAll();
		Semester semester = semesterData.findOne(semester_ID);
		try 
		{
			filewriter = new FileWriter(Semester.csvFile);
			for(int i=0;i<semesters.size();i++) 
			{
				if(semesters.get(i).getSEMESTER_ID()!=semester_ID)
				{
					filewriter.append(semesters.get(i).toString());
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
		return semester;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	 
	public static String DeleteAll() 
	    {
			FileWriter filewriter;
			List<Semester> semesters = findAll();
			try 
			{
				filewriter = new FileWriter(Semester.csvFile);
				
				for(int i=0;i<semesters.size();i++) 
				{
					semesters.remove(i);
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
