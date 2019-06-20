package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;

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

	public Via() {
		this.codiceVia=Utilities.NULLINT;
		this.descrizione=Utilities.NULLSTRING;
	}
	
	
	public Via(int codice, String descrizione) {
		this.codiceVia=codice;
		this.descrizione=descrizione;
	}

}