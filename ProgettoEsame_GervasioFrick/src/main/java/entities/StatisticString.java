package entities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticString extends Statistic {
	
	private Map<Object, Long> occurences;
	
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
		
		this.count=1;
		while(iterator.hasNext())
		{
			try {
				
				item.add(m.invoke(iterator.next(), null).toString());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			this.count++;
		}
				this.toMap(item);
	}
	

	public void setOccurences(Map<Object,Long> occurences)
	{
		this.occurences=occurences;
	}
	
	public Map<Object,Long>  getOccurences()
	{
		return this.occurences;
	}
	
	
	public void toMap(List<String> item)
	{
		
		this.occurences=item.stream().collect(Collectors.groupingBy(s -> s, 
                Collectors.counting()));
	}
	


}
