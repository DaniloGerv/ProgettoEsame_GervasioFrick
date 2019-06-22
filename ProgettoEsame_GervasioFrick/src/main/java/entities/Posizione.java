package entities;

import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;

/**
 * Classe che descrive la posizione di un Hotel, estende Coordinate. La variabile indirizzo è di tipo Via,
 * anche qui si è utilizzata la librearia univocity-parser csv.
 * @author Luciano Frick
 *
 */

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
	
/**
 * Costruttore di default di Posizione, con i valori di default creati nella classe Utilities.
 * Indirizzo è un oggetto di Via quindi è impostato di default a null.
 */
	public Posizione() {
		this.civico=Utilities.NULLSTRING;
		this.indirizzo=null;
		this.ubicazione=Utilities.NULLSTRING;
	}
	
	
	/**
	 * Costruttore di Posizione con parametri, ovviamente si necessitano anche le informazioni per l'inizializzazione
	 * dell'oggetto indirizzo (di tipo Via) quindi codiceVia e descrizioneVia.
	 * @param longitude, Parametro che rappresenta la longitudine di un punto, appartiene alla classe Posizione
	 * @param latitude, Parametro che rappresenta la latitudine di un punto, appartiene alla classe Posizione
	 * @param municipio, Parametro che rappresenta il numero del municipio (zona di Milano) dell'hotel, appartiene alla classe Posizione
	 * @param descrizioneVia, Parametro che rappresenta il nome della via
	 * @param codiceVia, Parametro che rappresenta il codice univoco di una via
	 * @param civico, Parametro che rappresenta il numero civico di un hotel
	 */
	public Posizione(int longitude, int latitude, int municipio, String descrizioneVia,int codiceVia, String civico) {
		
		super(latitude, longitude, municipio);//call to the superclass Coordinate's constructor
		this.indirizzo=new Via(codiceVia,descrizioneVia); //create an object indirizzo of type Via
		this.civico=civico;
	}

}