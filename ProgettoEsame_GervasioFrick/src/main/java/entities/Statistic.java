package entities;


import services.Utilities;


/**
 *  superclasse che descrive statistiche generali
 * @author Luciano Frick
 *
 */
public class Statistic {
	
	protected int count;
	protected String fieldName;
	
	/**
	 * costruttore di default di Statistic, con i soliti valori passati dalla classe Utilities
	 */
	public Statistic()
	{
		this.count=Utilities.NULLINT;
		this.fieldName=Utilities.NULLSTRING;
	}
	
	/**
	 * costruttore di Statistic coi parametri 
	 * @param fieldName
	 */
	public Statistic(String fieldName)
	{
		this.count=Utilities.NULLINT;
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
