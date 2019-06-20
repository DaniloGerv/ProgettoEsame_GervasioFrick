package repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import entities.Hotel;
import entities.MetaData;
import entities.prova;
import interfaces.IRepository;
import services.CsvReader;

public class HotelRepository implements IRepository<Hotel> {

	private static final String filename ="prova.csv";
	private static HashSet<MetaData> hotelSet=new HashSet<MetaData>();
	
	@SuppressWarnings("deprecation")
	public HotelRepository()
	{
		BeanListProcessor<prova> rowProcessor = new BeanListProcessor<prova>(prova.class);

		CsvParserSettings parserSettings = new CsvParserSettings();
		parserSettings.setRowProcessor(rowProcessor);
		parserSettings.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(parserSettings);
		parser.parse(new CsvReader(filename).getReader());
		List<prova> beans = rowProcessor.getBeans();
		Iterator<prova> temp=beans.iterator();
		while (temp.hasNext())
		{
			System.out.println(temp.next().ToString());
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

		return null;
	}

}
