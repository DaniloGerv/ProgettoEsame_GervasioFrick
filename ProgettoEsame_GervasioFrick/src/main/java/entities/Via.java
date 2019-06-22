package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;
/**
 * classe che descrive una Via
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
	 * @param codiceVia, PArametro che rappresenta il codice univoco di una via
	 * @param descrizione, Parametro che rappresenta il nome di una via
	 */
	public Via(int codice, String descrizione) {
		this.codiceVia=codice;
		this.descrizione=descrizione;
	}

}