package repositories;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.univocity.parsers.common.DataProcessingException;
import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.RetryableErrorHandler;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import entities.Hotel;
import entities.Statistic;
import entities.StatisticNumber;
import entities.StatisticString;
import interfaces.IRepository;
import services.CsvReader;
import services.FilterService;

/**
 * Repository che contiene i dati degli hotel, prelevandoli dal file dataFile.csv. Implementa l'interfaccia
 * IRepository<Hotel>.
 * @author danilogervasio
 *
 */

public class HotelRepository implements IRepository<Hotel> {

	private static final String filename ="dataFile.csv";  //Name of the file where the program has to take the data
	private static List<Hotel> hotelList=new ArrayList<Hotel>(); /*Colletion that will contain all the data taken from the csv
																  parsed to object */
	private static FilterService<Hotel> filterService=new FilterService<Hotel>(); //Object used for filtering the data
	
	
	
	/**
	 * Il costruttore effettua un parsing dei dati all'interno del csv in data object
	 * mediante l'utilizzo della libreria univocity-parser csv: viene popolata la collection hotelList.
	 */
	public HotelRepository()
	{
		try		//Parsing the csv into java object using Univocity-parser
		{
		BeanListProcessor<Hotel> rowProcessor = new BeanListProcessor<Hotel>(Hotel.class);
		CsvParserSettings parserSettings = new CsvParserSettings();	//Creating the settings for the csvParser
		parserSettings.setRowProcessor(rowProcessor);
		parserSettings.getFormat().setDelimiter(';');
		parserSettings.setHeaderExtractionEnabled(true);
		parserSettings.setProcessorErrorHandler(new RetryableErrorHandler<ParsingContext>() {		//If error occures while parsing the handleError is fired
		    @Override
		    public void handleError(DataProcessingException error, Object[] inputRow, ParsingContext context) {
		     		            getDefaultValue();		//putting a default value into the field that has generated the error
		        }
		    });
		CsvParser parser = new CsvParser(parserSettings);
		parser.parse(new CsvReader(filename).getReader());
		hotelList= rowProcessor.getBeans();		//Getting all the data parsed from the csv

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//region method not used
	
	@Override
	public void add(Hotel item) {
		
	}

	@Override
	public void update(Hotel item) {		
	}

	@Override
	public void remove(Hotel item) {
		
	}

	@Override
	public List<Hotel> query(String filter) {
		return null;
	}
	
	//endregion

	/**
	 * Restituisce l'intera collection contenente i dati.
	 */
	@Override
	public List<Hotel> getAll() {
		
		return hotelList;
	}
	
	/**
	 * Restituisce la lista degli hotel filtrata utilizzando il metodo select dell'oggetto filterService.
	 * @param fieldName, lista dei campi sul quale effettuare il filtraggio
	 * @param operator, lista degli operatori da utilizzare per ogni filtro
	 * @param value, lista dei valori da compare per ogni filtro
	 * @param logicalLinkOperator, lista dei operatori logici (AND, OR )che collegano ciascun filtro 
	 * (in caso in cui la variabile filter contenesse più filtri).
	 * @return
	 */
	
	public List<Hotel> filterField(List<String> fieldName, List<String> operator, List<Object> value,List<String> logicalLinkOperator) {
		return (List<Hotel>) filterService.select(hotelList, fieldName, operator, value,logicalLinkOperator);
		//filterService.select returns a collection of object so an implicit cast is needed.
	}
	
	/**
	 * Restituisce  la statistica effettuata su un campo con o senza filtri. Il metodo restituisce un oggetto generico
	 * di tipo Statistic ma in base a se il campo sul quale effettuare la statistica è di tipo numerico o stringa, si
	 * restituisce una statistica numerica o di stringa.
	 * @param fieldStat, nome del campo sul quale effettuare la statistica: in caso di campo errato interviene il gestore
	 * delle eccezioni.
	 * @param fieldName, lista dei campi sul quale effettuare il filtraggio
	 * @param operator, lista degli operatori da utilizzare per ogni filtro
	 * @param value, lista dei valori da compare per ogni filtro
	 * @param logicalLinkOperator, lista dei operatori logici (AND, OR )che collegano ciascun filtro 
	 * (in caso in cui la variabile filter contenesse più filtri).
	 * @return
	 * @throws NumberFormatException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	
	public Statistic getStats(String fieldStat,List<String> fieldName, List<String> operator, List<Object> value,List<String> logicalLinkOperator) throws NumberFormatException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{			
		switch (MetaDataRepository.getTypeOfAlias(fieldStat))		/*Checking the type of the field where the user
																	wants to execute the statistic invoking a static
																	method of the MetaData repository*/
		{
		case "integer":
		case "double":
		 if (fieldName==null)
			return new StatisticNumber(fieldStat,hotelList);
			else
			return new StatisticNumber(fieldStat,filterService.select(hotelList, fieldName, operator, value, logicalLinkOperator));
		default:
			
			if (fieldName==null)
				return new StatisticString(fieldStat,hotelList);
			else
			return new StatisticString(fieldStat,filterService.select(hotelList, fieldName, operator, value, logicalLinkOperator));			
		}
	}
		
	

}
