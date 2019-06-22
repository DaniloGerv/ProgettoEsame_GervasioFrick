package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Hotel;
import entities.Statistic;
import repositories.HotelRepository;
import repositories.MetaDataRepository;
import services.Utilities;

/**
 * Controller relativo ai dati di ciascun hotel, fa riferimento ad una hotel repository:
 * questa è una variabile statica in quanto la struttura dati sul quale si fa riferimento (contenuta all'interno della suddetta
 * repository) deve essere univoca per ogni chiamata API effettuata all'hotel controller.
 * @author danilogervasio
 *
 */

@RestController
public class HotelController {
	
	private static HotelRepository repo=new HotelRepository();
	
	
	/**
	 *"/hotel"
	 * API di base che fornisce una panoramica delle API disponibili del controller
	 * @return
	 */
	@RequestMapping("/hotel")		//General method for getting the available API of this controller
	public String hotelHome()
	{
		return "Available API:		-/get (get all the data)		-/get?filter=NAMEFIRSTFIELD:conditionaOp(</>/<=/>=/==):FIRSTVALUE:logicOp(AND/OR):NAMESECONDFIELD:...	-/getByCategoria/{operators}/{value}		-/stats?filter";
	}
	
	
	/**
	 * "/hotel/get?filter"
	 * API che restituisce i dati relativi a tutti gli hotel se il filtro impostato è null, altrimenti
	 * restituisce i dati filtrati. Il filtro è impostato in questa maniera:
	 *?filter=NOMEPRIMOCAMPO:operatore(<,>,<=,>=,==):PRIMOVALORE:operatoreLogico(AND,OR):NOMESECONDOCAMPO:operatore:SECONDOVALORE:operatoreLogico: e così via
	 * I filtri non possono essere impostati sui campi di oggetti attributi di Hotel, ad esempio non si può impostare un filtro sull'attributo
	 * numeroCamere dell'attributo infoOrganizzation (oggetto di tipo InfoOrganizzation) di hotel.
	 * @param filter
	 * @return
	 */

	@GetMapping("/hotel/get") //filtered is /hotel/get?filter=NAMEFIELD:operator:value:AND:NAMESECONDFIELD:operator:value:OR:NAMETHIRDFIELD:operator:value
	public List<Hotel> getFiltered(@RequestParam(value="filter",defaultValue="",required=false) String filter)
	{
		if (filter.equals(""))		//if the filter is "" (if there isn't the filter the variable filter assumes "" as default value)
			return repo.getAll();		//return all the data
		else
		{
			//Each list contains the list of the relative values
			List<String> fieldNameList=new ArrayList<String>(); //all the fields where the user wants to  filter
			List<String> operatorList=new ArrayList<String>();
			List<Object> valueList=new ArrayList<Object>();
			List<String> logicalLinkOperator=new ArrayList<String>();
			String[] filtering=filter.split(":");
			
			int maxIndex=(filtering.length/4 );	 /*every filter contains 4 information (field,operator,value,logicalLink, these last
												 is used if there is another filter */
			if (filtering.length%4>0)
				maxIndex++;
			
			for (int i=0;i<maxIndex;i++)
			{
				String field=filtering[0+(4*i)];
				String operator=filtering[1+(4*i)];
				String value=filtering[2+(4*i)];
			
				fieldNameList.add(field); //Putting each string of the relative filter into its respective list
				operatorList.add(operator);
				
			
				
				switch (MetaDataRepository.getTypeOfAlias(field))	/*For the value is needded to know the type of the value in order to
																	let the filterService performs a correct filtering*/
				{
				case "integer":
					valueList.add(Integer.parseInt(value));
					break;
				case "double":
					valueList.add(Double.parseDouble(value));
					break;
				default:
					valueList.add(value);

				}

				if (filtering.length>(3+(4*i)))		/*If it is not it means that these iteraction of the cycle has analyzed the last filter values 
													3 values and not 4 because there is not any more filter*/
					logicalLinkOperator.add(filtering[3+(4*i)]);
				
			}
			return repo.filterField(fieldNameList, operatorList, valueList,logicalLinkOperator);	//returning the filtered data
		}
	}
	
	/**
	 * "/hotel/getByCategoria/{operator (<,>,<=,>=,==}/{value (da 1 a 5)}"
	 * API che restituisce gli hotel di una determinata categoria (se l'operatore è ==) oppure tutti gli hotel di categoria
	 * <=,>=,<,> (in base all'operatore scelto) di un determinato valore compreso da 1 a 5 (un valore al di fuori di questo range
	 * ritornerà una pagina di errore).
	 * @param operator
	 * @param value
	 * @return
	 */
	
	@GetMapping("/hotel/getByCategoria/{operator}/{value:[1-5]}")		//Filter by categoria value (between 1 to 5) 
	public List<Hotel> getByCategoria(@PathVariable String operator,@PathVariable int value)
	{
		if (Utilities.checkOperators(operator)) //Checking if the user enters the correct operator value
		{
			List<String> fieldNameList=new ArrayList<String>();
			fieldNameList.add("categoria");
			List<String> operatorList=new ArrayList<String>();
			operatorList.add(operator);
			List<Object> valueList=new ArrayList<Object>();
			valueList.add(value);
			return repo.filterField(fieldNameList,operatorList,valueList,null);	
		
		}else
		throw new ConstraintViolationException(null);  /*throwing exception that will be handled by the exceptionHandler into 
														the WebApiExceptionHandler class*/
	}
	
	
	
	/**
	 * "/hotel/stat?fieldStat=NOMECAMPOPERLASTATISTICA&filter=
	 * API che effettua una statistica in base al campo passato all'interno della variabile fieldStat.
	 * Si ricava il tipo del valore del campo in caso di numeri (integer o double) si effettua una statistica numerica, 
	 * restituendo min, max valore del campo, somma, media e scarto quadratico medio
	 * Viceversa si effettua una statistica su stringhe che restituisce ciascun valore assunto dal campo nella dataset con le relative
	 * occorrenze.
	 * Per entrambi le statistiche si restituisce il numero di elementi analizzati per effettuare la statistica.
	 * Si possono effettuare delle statistiche filtrate come per l'API get.
	 * @param fieldStat
	 * @param filter
	 * @return
	 * @throws NumberFormatException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@GetMapping("/hotel/stat") //filtered is /hotel/get?filter=NAMEFIELD:operator:value:AND:NAMESECONDFIELD:operator:value:OR:NAMETHIRDFIELD:operator:value
	public Statistic getStat(@RequestParam(value="fieldStat",defaultValue="",required=false) String fieldStat,@RequestParam(value="filter",defaultValue="",required=false) String filter) throws NumberFormatException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		if (filter.equals(""))		//if the filter is "" (if there isn't the filter the variable filter assumes "" as default value)
			return repo.getStats(fieldStat, null, null, null, null);		//return all the data
		else
		{
			//Each list contains the list of the relative values
			List<String> fieldNameList=new ArrayList<String>(); //all the fields where the user wants to  filter
			List<String> operatorList=new ArrayList<String>();
			List<Object> valueList=new ArrayList<Object>();
			List<String> logicalLinkOperator=new ArrayList<String>();
			String[] filtering=filter.split(":");
			
			int maxIndex=(filtering.length/4 );	 /*every filter contains 4 information (field,operator,value,logicalLink, these last
												 is used if there is another filter */
			if (filtering.length%4>0)
				maxIndex++;
			
			for (int i=0;i<maxIndex;i++)
			{
				String field=filtering[0+(4*i)];
				String operator=filtering[1+(4*i)];
				String value=filtering[2+(4*i)];
			
				fieldNameList.add(field); //Putting each string of the relative filter into its respective list
				operatorList.add(operator);
				
			
				
				switch (MetaDataRepository.getTypeOfAlias(field))	/*For the value is needded to know the type of the value in order to
																	let the filterService performs a correct filtering*/
				{
				case "integer":
					valueList.add(Integer.parseInt(value));
					break;
				case "double":
					valueList.add(Double.parseDouble(value));
					break;
				default:
					valueList.add(value);

				}

				if (filtering.length>(3+(4*i)))		/*If it is not it means that these iteraction of the cycle has analyzed the last filter values 
													3 values and not 4 because there is not any more filter*/
					logicalLinkOperator.add(filtering[3+(4*i)]);
				
			}
			return repo.getStats(fieldStat,fieldNameList, operatorList, valueList,logicalLinkOperator);	//returning the filtered data
		}
	}
}


