package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;

/**
 * Classe che descrive i servizi di un hotel (telefoni e bagni).
 * Anche qui si è utilizzata la librearia univocity-parser csv 
 * @author Luciano Frick
 *
 */

public class InfoFacilities {

	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="nro_apparecchi_tel_ricettiva",defaultNullRead=Utilities.NULLINT+"")
	private int numTelefoni;
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="numero_servizi",defaultNullRead=Utilities.NULLINT+"")
	private int numServizi;
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="numero_servizi_piano",defaultNullRead=Utilities.NULLSTRING)
	private String numServiziPiano;

	public int getNumTelefoni() {
		return this.numTelefoni;
	}

	public void setNumTelefoni(int numTelefoni) {
		this.numTelefoni = numTelefoni;
	}

	public int getNumServizi() {
		return this.numServizi;
	}
	public void setNumServizi(int numServizi) {
		this.numServizi = numServizi;
	}
	
	public String getNumServiziPiano() {
		return this.numServiziPiano;
	}
	
	public void setNumServiziPiano(String numServiziPiano) {
		this.numServiziPiano = numServiziPiano;
	}
	
	/**
	 * Costruttore di default di InfoFacilities con i valori di default creati nella classe Utilities
	 */
	public InfoFacilities() {
		this.numServizi=Utilities.NULLINT;
		this.numTelefoni=Utilities.NULLINT;
		this.numServiziPiano = Utilities.NULLSTRING;
	}
	
	/**
	 * Costruttore di InfoFacilities coi parametri
	 * @param numTelefoni, Parametro che rappresenta il numero di telefoni utilizzabili nell'hotel
	 * @param numServizi, Parametro che rappresenta il numero di toilette nell'hotel
	 * @param numServiziPiano, Parametro che rappresenta il numero di toilette per ogni piano
	 */
	public InfoFacilities(int numTelefoni, int numServizi, String numServiziPiano) {
		this.numTelefoni = numTelefoni;
		this.numServizi = numServizi;
		this.numServiziPiano = numServiziPiano;
	}

}