package entities;


import services.Utilities;


/**
 *  superclasse che descrive statistiche generali.
 *  Il campo count indica il numero di oggetti analizzati durante la statistica;
 *  il campo fieldName indica l'attributo sul quale viene effettua la statistica.
 * @author Luciano Frick
 *
 */
public class Statistic {
	
	protected int count;	//Number of object analyzed for the statistic
	protected String fieldName; //Field interested for the statistic
	
	/**
	 * costruttore di default di Statistic
	 */
	public Statistic()
	{
		this.count=Utilities.NULLINT;
		this.fieldName=Utilities.NULLSTRING;
	}
	
	/**
	 * costruttore di Statistic con parametri, inizialmente il campo count è inizializzato a 1 (si è pronti per 
	 * effettuare l'analisi sul primo oggetto).
	 * @param fieldName
	 */
	public Statistic(String fieldName)
	{
		this.count=1;
		this.fieldName=fieldName;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public void setCount(int count)
	{
		this.count=count;
	}
	
	public String getFieldName()
	{
		return this.fieldName;
	}
	
	public void setFieldName(String fieldName)
	{
		this.fieldName=fieldName;
	}
	


}
