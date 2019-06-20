package entities;

import services.Utilities;

public class MetaData {
	
	private String alias;
	private String sourceField;
	private String type;
	
	public MetaData()
	{
		this.setAlias(Utilities.NULLSTRING);
		this.setSourceField(Utilities.NULLSTRING);
		this.setType(Utilities.NULLSTRING);
	}
	
	public MetaData(String alias,String sourceField,String type)
	{
		this.setAlias(alias);
		this.setSourceField(sourceField);
		this.setType(type);
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
