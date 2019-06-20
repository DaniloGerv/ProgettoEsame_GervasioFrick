package repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.MetaData;
import interfaces.IRepository;
import services.CsvReader;

public class MetaDataRepository implements IRepository<MetaData> {

	private static final String filename ="metaData.csv";
	private static List<MetaData> metaDataList=new ArrayList<MetaData>();
	
	@Override
	public void add(MetaData item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MetaData item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(MetaData item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MetaData> query(String filter) {
		return null;
	}

	@Override
	public List<MetaData> getAll() {

			CsvReader reader=new CsvReader(filename);	//CsvReader return an ArrayList<String[]> object
			Iterator<String[]> iter=reader.read().iterator();	//iterating each String[] object contained into the ArrayList<String[]> returned before
			while (iter.hasNext())		//the cycle goes on until there are not any elements
			{
				String[] temp=iter.next();	//getting the element (String[])
				metaDataList.add(new MetaData(temp[0],temp[1],temp[2])); //Adding an instance of the MetaData class into the list
			}
		
		return metaDataList;		
	}


}
