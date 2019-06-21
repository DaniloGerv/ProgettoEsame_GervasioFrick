package entities;

import java.util.List;

import services.Utilities;


/**
 *  superclasse che descrive statistiche generali
 * @author Luciano Frick
 *
 */
public class Statistic {
	
	protected int count;
	protected String fieldName;
	protected List<Hotel> filterItem;
	
	/**
	 * costruttore di default di Statistic, con i soliti valori passati dalla classe Utilities
	 */
	public Statistic()
	{
		this.count=Utilities.NULLINT;
		this.fieldName=Utilities.NULLSTRING;
		this.filterItem=null;
	}
	
	/**
	 * costruttore di Statistic coi parametri 
	 * @param fieldName
	 * @param filterItem
	 */
	public Statistic(String fieldName,List<Hotel> filterItem)
	{
		this.count=Utilities.NULLINT;
		this.fieldName=fieldName;
		this.filterItem=filterItem;
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
	
	public List<Hotel> getFilterItem()
	{
		return this.filterItem;
	}
	
	public void setFilterItem(List<Hotel> filterItem)
	{
		this.filterItem=filterItem;
	}

}
