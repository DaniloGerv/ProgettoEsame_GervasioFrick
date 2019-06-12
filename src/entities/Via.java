package entities;

public class Via {

	private int codice;
	private String descrizione;

	public String getDescrizione() {
		return this.descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getCodice() {
		return this.codice;
	}

	
	public void setCodice(int codice) {
		this.codice = codice;
	}

	public Via() {
		
	}
	
	
	public Via(int codice, String descrizione) {
		this.codice=codice;
		this.descrizione=descrizione;
	}

}