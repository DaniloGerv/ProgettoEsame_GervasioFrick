package entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import services.Utilities;

/**
 * classe che estende Statistic, descrive le statistiche numeriche
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
	
	public StatisticNumber()
	{
		super();
		this.avg=Utilities.NULLDOUBLE;
		this.min=Utilities.NULLDOUBLE;
		this.max=Utilities.NULLDOUBLE;
		this.std=Utilities.NULLDOUBLE;
		this.sum=Utilities.NULLDOUBLE;
	}
	
	public StatisticNumber(String fieldName,List<Hotel> filterItem)
	{
		super(fieldName,filterItem);
	}
	
	private void getStat() throws NoSuchMethodException, SecurityException, NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Double value=0.0;
		Iterator<Hotel> iterator=filterItem.iterator();
		while (iterator.hasNext())
		{
			Method m = Hotel.class.getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);		
			value=Double.parseDouble( (String)m.invoke(iterator.next(),null));
			this.sum+=value;
			this.count++;
			
			if (value<this.min)
				this.min=value;
			if (value>this.max)
				this.max=value;
			
		}	
		this.avg=this.sum/this.count;
		this.calculateStd();
		
	}
	
	private void calculateStd() throws NoSuchMethodException, SecurityException, NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Double val=0.0;
		Iterator<Hotel> iterator=filterItem.iterator();
		while (iterator.hasNext())
		{
			Method m = Hotel.class.getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);		
			val+=Math.pow((Double.parseDouble( (String)m.invoke(iterator.next(),null))-this.avg),2);
			
		}
		this.std=Math.pow(val/this.count, 1/2);
	}
	
	
	
	
}

