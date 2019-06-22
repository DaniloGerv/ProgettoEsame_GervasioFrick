package entities;

import services.Utilities;

/**
 * Classe che descrive l'oggetto metaData composto da 3 informazioni essenziali: alias (nome del campo), 
 * sourceField (descrizione del campo) e type (tipo del campo). 
 * @author Luciano Frick
 *
 */

public class MetaData {
	
	private String alias; //name of the camp
	private String sourceField; //description of the camp
	private String type; //type of the camp
	
	/**
	 *Costruttore di default di metadata con valori passati dalla classe Utilities
	 */
	public MetaData()
	{
		this.setAlias(Utilities.NULLSTRING);
		this.setSourceField(Utilities.NULLSTRING);
		this.setType(Utilities.NULLSTRING);
	}
	
	/**
	 * Costruttore di metadata con parametri
	 * @param alias
	 * @param sourceField
	 * @param type
	 */
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
