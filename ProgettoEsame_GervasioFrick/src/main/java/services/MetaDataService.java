package services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.MetaData;

public class MetaDataService {
	
	private static final String filename ="metaData.csv";
	private static List<MetaData> metaDataList=new ArrayList<MetaData>();
	
	public static List<MetaData> getMetaData()
	{
		if (metaDataList.size()==0)  //if the size is not 0 it means that the list has already been initialized
		{
			CsvReader reader=new CsvReader(filename);	//CsvReader return an ArrayList<String[]> object
			Iterator<String[]> iter=reader.read().iterator();	//iterating each String[] object contained into the ArrayList<String[]> returned before
			while (iter.hasNext())		//the cycle goes on until there are not any elements
			{
				String[] temp=iter.next();	//getting the element (String[])
				metaDataList.add(new MetaData(temp[0],temp[1],temp[2])); //Adding an instance of the MetaData class into the list
			}
		}
		
		return metaDataList;
		
		
	}
	
	

}
