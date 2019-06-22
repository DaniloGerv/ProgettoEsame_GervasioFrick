package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;

/**
 * Classe che descrive la struttura di un hotel (numero piani, numero camere, ecc...).
 * Anche qui si è utilizzata la librearia univocity-parser csv 
 * @author Luciano Frick
 *
 */

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
	/**
	 * Costruttore di default di InfoOrganization passandogli i valori della classe Utilities
	 */
	public InfoOrganization() {
		this.numCamere=Utilities.NULLINT;
		this.numPiani=Utilities.NULLINT;
		this.numPostiletto=Utilities.NULLINT;
		this.camerePiano = Utilities.NULLSTRING;
		this.pianoPiano= Utilities.NULLSTRING;
		this.postiLettoPiano= Utilities.NULLSTRING;
	}
	
	/**
	 * Costruttore di InfoOrganization coi parametri
	 * @param numCamere, Parametro che rappresenta il numero totale delle camere di un hotel
	 * @param numPiani, Parametro che rappresenta il numero di piani di un hotel
	 * @param numPostiletto, Parametro che rappresenta il numero totale dei posti letto di un hotel
	 * @param camerePiano, Parametro che rappresenta il numero di camere per ogni piano
	 * @param pianoPiano, Parametro che rappresenta l'ordine dei piani
	 * @param postiLettoPiano, Parametro che rappresenta il numero di posti letto per ogni piano
	 */
	public InfoOrganization(int numCamere, int numPiani, int numPostiletto, String camerePiano, String pianoPiano, String postiLettoPiano) {
		this.numCamere = numCamere;
		this.numPiani = numPiani;
		this.numPostiletto = numPostiletto;
		this.camerePiano = camerePiano;
		this.pianoPiano= pianoPiano;
		this.postiLettoPiano= postiLettoPiano;
	}
	

}