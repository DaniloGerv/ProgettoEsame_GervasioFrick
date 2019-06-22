package services;


import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Servizio di filtraggio dei dati di un generico tipo T. I suoi metodi sono statici.
 * @author danilogervasio
 *
 * @param <T>
 */

public class FilterService<T> {
	
	
	/**
	 * Metodo che restituisce vero se l'oggetto value soddisfa il confronto con l'oggetto th utilizzando l'operatore 
	 * operator. Se gli oggetti sono di tipo numerico si controlla se l'operatore è "<","<=",">",">=","=="; altrimenti
	 * per oggetti di tipo stringa si controlla solamente se questi due sono uguali (in tal caso il parametro operator
	 * non viene mai utilizzato).
	 * @param value, oggetto da confrontare
	 * @param operator, operatore con il quale effettuare il confronto
	 * @param th, oggetto con il quale si confronta l'oggetto principale
	 * @return
	 */
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
	
	
	/**
	 * Metodo ricorsivo che restituisce una collection di dati di tipo generico T filtrati. Il caso base della ricorsione
	 * è quando la lista logicalLinkOperator è nulla o vuota, in tal caso significa che bisogna effettuare un solo filtro,
	 * quindi non sono presenti operatori AND o OR.
	 * Viceversa si richiama la ricorsione considerando per ciascun parametro la sottolista e come source dei dati
	 * si condisdera la collection uscente dall'istanza ricorsiva chiamante nel caso AND (bisogna effettuare il filtro
	 * successivo sui dati filtrati) oppure si considera la collection sorgente dell'istanza ricorsiva chiamante nel caso OR.
	 * @param src, collection sorgente di dati di tipo generico T
	 * @param fieldName, lista di campi sul quale effettuare il filtro per ciascun oggetto nella collection src
	 * @param operator, lista degli operatori da utilizzare per effettuare ciascun filtro
	 * @param value, lista dei valori da compare per ogni filtro
	 * @param logicalLinkOperator, lista dei operatori logici (AND, OR )che collegano ciascun filtro 
	 * (in caso in cui la variabile filter contenesse più filtri).
	 * @return
	 */
	public Collection<T> select(Collection<T> src, List<String> fieldName,List<String>  operator, List<Object> value,List<String> logicalLinkOperator) {
		
		//Base case
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
		//Recursive part: it is fired when the logicalLinkOPerator is not null and it has some elements (like AND or OR for connecting filter)
		if (logicalLinkOperator!=null && logicalLinkOperator.size()>0)	/*If the logicalLinkOperator list is null the compiler will leave the
																		conditional statement so there will not be error*/
		{
			List<String> subLogicalLinkOperator=null;
			if (logicalLinkOperator.size()>1)
				subLogicalLinkOperator=logicalLinkOperator.subList(1, logicalLinkOperator.size());
			
			if (logicalLinkOperator.get(0).equals("AND"))	/*With the AND the out collection becames the actual src collection of the recursive call:
															the found data (inside the out collection) is then filtered again in the recursive call */
				return select(out,fieldName.subList(1, fieldName.size()),operator.subList(1, operator.size()),value.subList(1,value.size()),subLogicalLinkOperator);
			else
			{//With the OR statement all the data (from the recursive call and the actual found data) is returned.
				Collection<T> temp=select(src,fieldName.subList(1, fieldName.size()),operator.subList(1, operator.size()),value.subList(1,value.size()),subLogicalLinkOperator);
				out.addAll(temp);	
			}
		}
		return out;
	}
}
