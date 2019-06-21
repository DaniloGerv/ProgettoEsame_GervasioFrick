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

public class HotelRepository implements IRepository<Hotel> {

	private static final String filename ="dataFile.csv";
	private static List<Hotel> hotelList=new ArrayList<Hotel>();
	private static FilterService<Hotel> filterService=new FilterService<Hotel>();
	private static MetaDataRepository repoMetaData=new MetaDataRepository();
	
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

	@Override
	public List<Hotel> getAll() {
		
		return hotelList;
	}
	
	public List<Hotel> filterField(List<String> fieldName, List<String> operator, List<Object> value,List<String> logicalLinkOperator) {
		return (List<Hotel>) filterService.select(hotelList, fieldName, operator, value,logicalLinkOperator);

	}
	
	
	public Statistic getStats(String fieldStat,List<String> fieldName, List<String> operator, List<Object> value,List<String> logicalLinkOperator) throws NumberFormatException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{			
		switch (MetaDataRepository.getTypeOfAlias(fieldStat))
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
