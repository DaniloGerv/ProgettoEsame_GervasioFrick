package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;

public class Posizione extends Coordinate {

	private Via indirizzo;
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="Civico",defaultNullRead=Utilities.NULLINT+"")
	private int civico;
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="Ubicazione",defaultNullRead=Utilities.NULLSTRING)
	private String ubicazione;


	public Via getIndirizzo() {
		return this.indirizzo;
	}
	public void setIndirizzo(Via indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getUbicazione()
	{
		return this.ubicazione;
	}
	public void setUbicazione(String ubicazione)
	{
		this.ubicazione=ubicazione;
	}
	
	public int getCivico() {
		return this.civico;
	}
	public void setCivico(int civico) {
		this.civico = civico;
	}

	public Posizione() {
		this.civico=Utilities.NULLINT;
		this.indirizzo=null;
		this.ubicazione=Utilities.NULLSTRING;
		
	}
	public Posizione(int longitude, int latitude, int municipio, String descrizioneVia,int codiceVia, int civico) {
		
		super(latitude, longitude, municipio);
		this.indirizzo=new Via(codiceVia,descrizioneVia);
		this.civico=civico;
	}

}