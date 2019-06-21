package entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import repositories.MetaDataRepository;
import services.Utilities;

/**
 * classe che estende Statistic, descrive le statistiche numeriche.
 * I vari attributi indicano rispettivamente il minimo,massimo,la media, la somma e lo scarto quadratico medio
 * relativo al valore del campo sul quale si effettua la statistica
 * @author Luciano Frick
 *
 */

public class StatisticNumber extends Statistic {

	private double min;
	private double max;
	private double avg;
	private double sum;
	private double std;
	
	public double getMin(){
		return this.min;
	}
	
	public void setMin(double min){
		this.min=min;
	}
	
	public double getMax(){
		return this.max;
	}
	
	public void setMax(double max){
		this.max=max;
	}
	
	public double getAvg(){
		return this.avg;
	}
	
	public void setAvg(double avg){
		this.avg=avg;
	}
	
	public double getSum(){
		return this.sum;
	}
	
	public void setSum(double sum){
		this.sum=sum;
	}
	
	public double getStd(){
		return this.std;
	}
	
	public void setStd(double std)
	{
		this.std=std;
	}
	
	/**
	 * Costruttore di default the richiama il costruttore della superclasse Statistic.
	 */
	public StatisticNumber()
	{
		super();
		this.avg=Utilities.NULLDOUBLE;
		this.min=Utilities.NULLDOUBLE;
		this.max=Utilities.NULLDOUBLE;
		this.std=Utilities.NULLDOUBLE;
		this.sum=Utilities.NULLDOUBLE;
	}
	
	/**
	 * Costruttore che istanzia una statistica numerica sul campo fieldName considerando l'insieme di dati contenuti nella
	 * collection filterItem. Viene istanziato il costruttore della classe padre e si richiama il calcolo della statistica
	 * @param fieldName	  
	 * @param filterItem
	 */
	
	
	public StatisticNumber(String fieldName,Collection<Hotel> filterItem) {
		super(fieldName);
		this.calculateStats(filterItem);		//execute the statistic
	}
	
	/**
	 * Calcola la statistica metiante un iteratore della collezione di oggetti Hotel passata come parametro
	 * @param filterItem
	 */
	
	private void calculateStats(Collection<Hotel> filterItem) 
	{
		Double value=0.0;
		Iterator<Hotel> iterator=filterItem.iterator();
		while (iterator.hasNext()) //Analyzing each object of filteItem
		{
			Method m= null;
			try {
				//prepare for invoking the method .getFIELDNAME() on each object in order to get the value of the field for each object.
				m = Hotel.class.getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);	
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}	
		
			try {
				value=Double.parseDouble(m.invoke(iterator.next(),null).toString());  //taking the value of the field
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
			this.sum+=value;
			this.count++;
			
			/*Because the iterator has to be done , in this case this is the best solution for calculating the min and max
			(there are better way to do this into a collection)*/
			if (value<this.min)
				this.min=value;
			if (value>this.max)
				this.max=value;
			
		}	
		this.avg=this.sum/this.count;
		try {
			//Calculate the std
			this.calculateStd(filterItem);	
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo per il calcolo dello scarto quadratico medio richiamato una volta ottenuta la media ed il numero totale 
	 * di oggetti analizzati. In questo caso si sono gestite l'eccezioni senza l'utilizzo di try catch ma dando la possibilità
	 * al metodo di eseguire vari tipi di eccezioni in caso di errore.
	 * @param filterItem
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws NumberFormatException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private void calculateStd(Collection<Hotel> filterItem) throws NoSuchMethodException, SecurityException, NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Double val=0.0;
		Iterator<Hotel> iterator=filterItem.iterator();
		while (iterator.hasNext())
		{
			Method m = Hotel.class.getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);		
			val+=Math.pow((Double.parseDouble( m.invoke(iterator.next(),null).toString())-this.avg),2);
			
		}
		this.std=Math.pow(val/this.count, 1/2);
	}
	
	
	
	
	
}

