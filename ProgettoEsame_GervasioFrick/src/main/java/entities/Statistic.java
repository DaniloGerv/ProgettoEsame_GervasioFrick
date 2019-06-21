package entities;


import services.Utilities;

public class Statistic {
	
	protected int count;
	protected String fieldName;
	
	public Statistic()
	{
		this.count=Utilities.NULLINT;
		this.fieldName=Utilities.NULLSTRING;
	}
	
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
