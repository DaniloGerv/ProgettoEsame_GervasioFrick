package services;


import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

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
		for(T item:src) {		//each item of the source collection is analyzed
			try {
				Method m = item.getClass().getMethod("get"+fieldName.get(0).substring(0, 1).toUpperCase()+fieldName.get(0).substring(1),null);	
				
				try {
					Object tmp = m.invoke(item);		//getting the value of the interested field of the item
					if(FilterService.check(tmp, operator.get(0), value.get(0)))	//checking if the value respects the filter, if it does, it will be added into the out collection
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
		}
		
		if (logicalLinkOperator!=null && logicalLinkOperator.size()>0)	//If the list is null the compiler will leave the conditional statement so 
																		//there will not be error
		{
			List<String> subLogicalLinkOperator=null;
			if (logicalLinkOperator.size()>1)
				subLogicalLinkOperator=logicalLinkOperator.subList(1, logicalLinkOperator.size());
			
			if (logicalLinkOperator.get(0).equals("AND"))	
				return select(out,fieldName.subList(1, fieldName.size()),operator.subList(1, operator.size()),value.subList(1,value.size()),subLogicalLinkOperator);
			else
			{
				Collection<T> temp=select(src,fieldName.subList(1, fieldName.size()),operator.subList(1, operator.size()),value.subList(1,value.size()),subLogicalLinkOperator);
				out.addAll(temp);
			}
		}
		return out;

			

		
	}
}
