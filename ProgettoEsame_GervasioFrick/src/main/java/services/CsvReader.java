package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
	private static final String COMMA_DELIMITER = ",";  //const for separating value into csv
	private BufferedReader reader;
	private String filename;
	private ArrayList<String[]> rowList;  //each row contains a row of the csv file
	
	public CsvReader(String filename) 
	{
		this.filename=filename;
		this.rowList=new ArrayList<String[]>();
		try
		{
			reader=new BufferedReader(new FileReader (this.filename));  //Reading the csv file, this is instruction can throw exception
		
		}catch (FileNotFoundException e)
		{
			System.out.println("Error reading file: "+this.filename);
		}catch (Exception ex)
		{
			ex.printStackTrace();
		}
	
		
	}
	
	public ArrayList<String[]> read ()  //return the data of the csv
	{
	
		String temp=null;
		try
		{
		 while ((temp = reader.readLine()) != null) //reading each line of the bufferedReader linked to the file
	     {		
		        String[] values = temp.split(COMMA_DELIMITER);  //the string is splitted from the ',' char and each value that has been found is put into an array of string
		        rowList.add(values); //adding into each row of the rowList the values of that line
		 }

			this.reader.close();
			
		}catch (IOException e)
		{
		System.out.println("Error reading line from file: "+this.filename);
		}
		
		return this.rowList;
		
	}

}
