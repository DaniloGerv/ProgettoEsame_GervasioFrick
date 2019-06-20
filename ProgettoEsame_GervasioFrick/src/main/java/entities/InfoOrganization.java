package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;

public class InfoOrganization {

	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="camere",defaultNullRead=Utilities.NULLINT+"")
	private int numCamere;
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="piani_tot",defaultNullRead=Utilities.NULLINT+"")
	private int numPiani;
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="posti_letto",defaultNullRead=Utilities.NULLINT+"")
	private int numPostiletto;
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="camere_piano",defaultNullRead=Utilities.NULLSTRING)
	private String camerePiano;
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="piano_piano",defaultNullRead=Utilities.NULLSTRING)
	private String pianoPiano;
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="posti_letto_piano",defaultNullRead=Utilities.NULLSTRING)
	private String postiLettoPiano;

	public int getNumCamere() {
		return this.numCamere;
	}

	public void setNumCamere(int numCamere) {
		this.numCamere = numCamere;
	}

	public int getNumPiani() {
		return this.numPiani;
	}

	public void setNumPiani(int numPiani) {
		this.numPiani = numPiani;
	}

	public int getNumPostiletto() {
		return this.numPostiletto;
	}

	
	public void setNumPostiletto(int numPostiletto) {
		this.numPostiletto = numPostiletto;
	}
	
	public String getCamerePiano() {
		return this.camerePiano;
	}
	public void setCamerePiano(String camerePiano) {
		this.camerePiano = camerePiano;
	}
	
	public String getPianoPiano() {
		return this.pianoPiano;
	}
	
	public void setPianoPiano(String pianoPiano) {
		this.pianoPiano = pianoPiano;
	}
	public String getPostiLettoPiano() {
		return this.postiLettoPiano;
	}

	public void setPostilettoPiano(String postiLettoPiano) {
		this.postiLettoPiano = postiLettoPiano;
	}
	
	public InfoOrganization() {
		this.numCamere=Utilities.NULLINT;
		this.numPiani=Utilities.NULLINT;
		this.numPostiletto=Utilities.NULLINT;
		this.camerePiano = Utilities.NULLSTRING;
		this.pianoPiano= Utilities.NULLSTRING;
		this.postiLettoPiano= Utilities.NULLSTRING;
		
	}
	public InfoOrganization(int numCamere, int numPiani, int numPostiletto, String camerePiano, String pianoPiano, String postiLettoPiano) {
		this.numCamere = numCamere;
		this.numPiani = numPiani;
		this.numPostiletto = numPostiletto;
		this.camerePiano = camerePiano;
		this.pianoPiano= pianoPiano;
		this.postiLettoPiano= postiLettoPiano;
	}
	

}