package repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import entities.MetaData;
import interfaces.IRepository;
import services.CsvReader;

public class MetaDataRepository implements IRepository<MetaData> {

	private static final String filename ="metaData.csv";
	private static List<MetaData> metaDataList=new ArrayList<MetaData>();
	
	public MetaDataRepository()
	{
		CsvReader reader=new CsvReader(filename);	//CsvReader return an ArrayList<String[]> object
		Iterator<String[]> iter=reader.read().iterator();	//iterating each String[] object contained into the ArrayList<String[]> returned before
		while (iter.hasNext())		//the cycle goes on until there are not any elements
		{
			String[] temp=iter.next();	//getting the element (String[])
			metaDataList.add(new MetaData(temp[0],temp[1],temp[2])); //Adding an instance of the MetaData class into the list
		}
	}
	
	//region These methods are not implemented
	@Override
	public void add(MetaData item) {
		
	}

	@Override
	public void update(MetaData item) {
		
	}

	@Override
	public void remove(MetaData item) {
		
	}
	
	//endregion 

	@Override
	public MetaData query(String aliasFilter) {
		return metaDataList.get(0);
		//return metaDataList.stream().filter(type->type.equals("string")).collect(Collectors.toList()).get(0);
	}
	
	@Override
	public List<MetaData> getAll() {

		return metaDataList;		
	}


}
