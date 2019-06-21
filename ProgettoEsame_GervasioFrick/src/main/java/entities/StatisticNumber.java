package entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import services.FilterService;
import services.Utilities;

public class StatisticNumber extends Statistic {

	private double min;
	private double max;
	private double avg;
	private double sum;
	private double std;
	
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
	
	private double min()
	{
	 
		Method m = Hotel.class.getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);	
		
				try {
					
					Hotel max=Collections.max(filterItem,Comparator.comparingDouble(Hotel::));
					Hotel highest = filterItem.stream()
                            .max((fc1, fc2) -> m.invoke(fc1, null) - m.invoke((fc2,null))
                            .get();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				
	}
	
	private double max()
	{
		
	}
	
	private double avg()
	{
		
	}
	
	private double sum()
	{
		
	}
	
	
}

