package entities;

import services.Utilities;

public class MetaData {
	
	private String alias;
	private String sourceField;
	private String type;
	
	public MetaData()
	{
		this.alias =Utilities.NULLSTRING;
		this.sourceField=Utilities.NULLSTRING;
		this.type=Utilities.NULLSTRING;
	}
	
	public MetaData(String alias,String sourceField,String type)
	{
		this.alias=alias;
		this.sourceField=sourceField;
		this.type=type;
	}

}
