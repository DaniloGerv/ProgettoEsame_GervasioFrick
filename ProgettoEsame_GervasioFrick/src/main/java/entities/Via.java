package entities;

import services.Utilities;

public class Via {

	private int codiceVia;
	private String descrizione;

	public String getDescrizione() {
		return this.descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getCodiceVia() {
		return this.codiceVia;
	}

	
	public void setCodiceVia(int codiceVia) {
		this.codiceVia = codiceVia;
	}

	public Via() {
		this.codiceVia=Utilities.NULLINT;
		this.descrizione=Utilities.NULLSTRING;
	}
	
	
	public Via(int codice, String descrizione) {
		this.codiceVia=codice;
		this.descrizione=descrizione;
	}

}