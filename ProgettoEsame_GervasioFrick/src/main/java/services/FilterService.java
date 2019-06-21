package services;


import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class FilterService<T> {
	
	
	public static boolean check(Object value, String operator, Object th) {
		if (th instanceof Number && value instanceof Number) {	
			Double thC = ((Number)th).doubleValue();
			Double valuec = ((Number)value).doubleValue();
			
			
			if (operator.equals("=="))
				return value.equals(th);
			else if (operator.equals(">"))
				return valuec > thC;
			else if (operator.equals("<"))
				return valuec < thC;
			else if (operator.equals("<="))
				return valuec<=thC;
			else if (operator.equals(">="))
				return valuec>=thC;
				
		}else if(th instanceof String && value instanceof String)
			return value.equals(th);
		return false;		
	}
	
	public Collection<T> select(Collection<T> src, List<String> fieldName,List<String>  operator, List<Object> value,List<String> logicalLinkOperator) {
		
		
		Collection<T> out = new ArrayList<T>();		
		boolean flag=false;
		Iterator<String> logicalLinkListIterator=null;
		if (logicalLinkOperator==null)
			flag=true;
		else
		logicalLinkListIterator=logicalLinkOperator.iterator();
		
		int i=0;
		while (flag||logicalLinkListIterator.hasNext())
		{
			
			if (i==0||(i!=0&&i<logicalLinkOperator.size()&&logicalLinkOperator.get(i).equals("OR")))
			for(T item:src) {		//each item of the source collection is analyzed
				try {
					Method m = item.getClass().getMethod("get"+fieldName.get(i).substring(0, 1).toUpperCase()+fieldName.get(i).substring(1),null);	
					
					try {
						Object tmp = m.invoke(item);		//getting the value of the interested field of the item
						if(FilterService.check(tmp, operator.get(i), value.get(i)))	//checking if the value respects the filter, if it does, it will be added into the out collection

							out.add(item);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}					
			}else
			{	Collection<T> temp=new ArrayList<T>();
				temp.addAll(out);
				out.clear();
				for(T item:temp) {		//each item of the source collection is analyzed
					try {
						Method m = item.getClass().getMethod("get"+fieldName.get(i).substring(0, 1).toUpperCase()+fieldName.get(i).substring(1),null);	
						
						try {
							Object tmp = m.invoke(item);		//getting the value of the interested field of the item
							if(FilterService.check(tmp, operator.get(i), value.get(i)))	//checking if the value respects the filter, if it does, it will be added into the out collection
							{	
								out.add(item);
							}
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					}					
				}
			}
			i++;
		}
		
		return out;
		/*
		
		if (logicalLinkOperator!=null && logicalLinkOperator.size()>0)	//If the list is null the compiler will leave the conditional statement so 
																		//there will not be error
		{
			List<String> subLogicalLinkOperator=null;
			if (logicalLinkOperator.size()>1)
				subLogicalLinkOperator=logicalLinkOperator.subList(1, logicalLinkOperator.size()-1);
			
			if (logicalLinkOperator.get(0).equals("AND"))	
				return select(out,fieldName.subList(1, fieldName.size()-1),operator.subList(1, operator.size()-1),value.subList(1,value.size()-1),subLogicalLinkOperator);
			else
			{
				Collection<T> temp=select(out,fieldName.subList(1, fieldName.size()-1),operator.subList(1, operator.size()-1),value.subList(1,value.size()-1),subLogicalLinkOperator);
				out.addAll(temp);
			}
		}
		return out;*/

			

		
	}
	
	
}
