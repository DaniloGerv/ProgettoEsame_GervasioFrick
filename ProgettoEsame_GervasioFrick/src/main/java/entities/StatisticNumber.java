package entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import repositories.MetaDataRepository;
import services.Utilities;

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
	
	public StatisticNumber(String fieldName,Collection<Hotel> filterItem) throws NumberFormatException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		super(fieldName);
		this.calculateStats(filterItem);
	}
	
	private void calculateStats(Collection<Hotel> filterItem) throws NoSuchMethodException, SecurityException, NumberFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Double value=0.0;
		this.count=1;
		Iterator<Hotel> iterator=filterItem.iterator();
		while (iterator.hasNext())
		{
			Method m = Hotel.class.getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);	
			Object find=m.invoke(iterator.next(),null);
			value=Double.parseDouble(find.toString());
			this.sum+=value;
			this.count++;
			
			if (value<this.min)
				this.min=value;
			if (value>this.max)
				this.max=value;
			
		}	
		this.avg=this.sum/this.count;
		this.calculateStd(filterItem);
		
	}
	
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

