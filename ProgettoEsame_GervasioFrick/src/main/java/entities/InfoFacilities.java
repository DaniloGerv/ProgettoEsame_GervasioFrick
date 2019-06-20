package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;

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

	public InfoFacilities() {
		this.numServizi=Utilities.NULLINT;
		this.numTelefoni=Utilities.NULLINT;
		this.numServiziPiano = Utilities.NULLSTRING;
		
	}
	public InfoFacilities(int numTelefoni, int numServizi, String numServiziPiano) {
		this.numTelefoni = numTelefoni;
		this.numServizi = numServizi;
		this.numServiziPiano = numServiziPiano;
	}

}