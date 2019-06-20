package entities;

import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;

public class Posizione extends Coordinate {

	@Nested(type=Via.class)
	private Via indirizzo;
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="Civico",defaultNullRead=Utilities.NULLSTRING)
	private String civico;
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
	
	public String getCivico() {
		return this.civico;
	}
	public void setCivico(String civico) {
		this.civico = civico;
	}

	public Posizione() {
		this.civico=Utilities.NULLSTRING;
		this.indirizzo=null;
		this.ubicazione=Utilities.NULLSTRING;
		
	}
	public Posizione(int longitude, int latitude, int municipio, String descrizioneVia,int codiceVia, String civico) {
		
		super(latitude, longitude, municipio);//call to the superclass Coordinate's constructor
		this.indirizzo=new Via(codiceVia,descrizioneVia); //create an object indirizzo of type Via
		this.civico=civico;
	}

}