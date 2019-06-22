package entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe che estende Statistic, descrive le statistiche su campi di tipo stringa.
 * E' presente un attributo occurances: una mappa che gestisce il numero di occorrenze presenti per ciascun valore
 * del campo che si sta analizzando
 * @author danilogervasio
 *
 */

public class StatisticString extends Statistic {
	
	private Map<Object, Long> occurences;	//Map for linking the number of occurences of each value analyzed
	
	/**
	 * costruttore vuoto
	 */
	public StatisticString()
	{
		super();
		this.occurences=null;
	}
	
	/**
	 * Costruttore che istanzia la statistica sul campo fieldName. Si genera una lista di stringhe considerando il valore del campo
	 * sul quale effettuare la statistica di ciascun oggetto della collection passata come parametro, filterItem.
	 * @param fieldName
	 * @param filterItem
	 */
	public StatisticString(String fieldName,Collection<Hotel> filterItem) 
	{
		super(fieldName);
		List<String> item=new ArrayList<String>();
		Iterator<Hotel> iterator=filterItem.iterator();
		Method m=null;
		
		try {
			m = Hotel.class.getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}	
		
		while(iterator.hasNext())
		{
			try {
				
				item.add(m.invoke(iterator.next(), null).toString());		/*Generating a list of string of all the values of fieldName 
																			contained in each Object.This is done by invoking for each object
																			the method .getFIELDNAME()*/
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			this.count++;
		}
				this.toMap(item);	//When the list of string is ready we can map each string occurences in the string
	}
	

	public void setOccurences(Map<Object,Long> occurences)
	{
		this.occurences=occurences;
	}
	
	public Map<Object,Long>  getOccurences()
	{
		return this.occurences;
	}
	
	/**
	 * Metodo privato, invocato internamente dal costruttore per mappare le occorrenze delle stringhe individuate.
	 * Il parametro item corrisponde alla lista di stringhe generata nel costruttore.
	 * @param item
	 */
	
	private void toMap(List<String> item)
	{
		
		this.occurences=item.stream().collect(Collectors.groupingBy(s -> s, 
                Collectors.counting()));
	}
	


}
