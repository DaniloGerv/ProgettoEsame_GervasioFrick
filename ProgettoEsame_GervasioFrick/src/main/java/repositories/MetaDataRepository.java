package repositories;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import entities.MetaData;
import interfaces.IRepository;
import services.CsvReader;

/**
 * Repository che contiene i dati relativo ai metaDati, prelevandoli dal file metaData.csv. Implementa l'interfaccia
 * IRepository<MetaData>.
 * @author danilogervasio
 *
 */

public class MetaDataRepository implements IRepository<MetaData> {

	private static final String filename ="metaData.csv";	//Name of the file where the program has to take the data
	private static List<MetaData> metaDataList=new ArrayList<MetaData>(); /*Colletion that will contain all the data taken from the csv
	  																		parsed to object */
	
	/**
	 * Costruttore che effettua il parsing dei dati prelevati all'interno del file in data object.
	 */
	
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
	
	@Override
	public List<MetaData> query(String aliasFilter) {		
		return null;
	}
	
	//endregion 

	
	/**
	 * Metodo statico richiamato dal HotelRepository per ottenere il tipo di un dato campo.
	 * @param aliasFilter, campo per il quale se ne vuole ottenere il tipo
	 * @return
	 */
	
	public static String getTypeOfAlias(String aliasFilter)//return the list of metaData which has the same field alias of the var aliasFilter
	{
		return metaDataList.stream().filter(data->data.getAlias().equals(aliasFilter.substring(0,1).toLowerCase()+aliasFilter.substring(1))).collect(Collectors.toList()).get(0).getType();
	}
	//the first char of the var aliasFilter has to be lower case, otherwise the interested metadata will not be found.
	
	
	/**
	 * Restituisce l'intera collezione di metadati.
	 */
	@Override
	public List<MetaData> getAll() {

		return metaDataList;		
	}


}
