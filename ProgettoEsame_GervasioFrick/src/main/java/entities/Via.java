package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;
/**
 * classe che descrive una Via
 * anche qui plug in di Univocity per non avere problemi con maiuscole e minuscole e con i campi vuoti
 * @author Luciano Frick
 *
 */
public class Via {

	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="CodiceVia",defaultNullRead=Utilities.NULLINT+"")
	private int codiceVia;
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="DescrizioneVia",defaultNullRead=Utilities.NULLSTRING)
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
/**
 * costruttore di default con i valori di default creati nella classe Utilities
 */
	public Via() {
		this.codiceVia=Utilities.NULLINT;
		this.descrizione=Utilities.NULLSTRING;
	}
	
	/**
	 * costruttore con parametri
	 * @param codice
	 * @param descrizione
	 */
	public Via(int codice, String descrizione) {
		this.codiceVia=codice;
		this.descrizione=descrizione;
	}

}