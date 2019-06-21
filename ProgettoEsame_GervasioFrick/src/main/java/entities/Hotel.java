package entities;
import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

//
import interfaces.Struttura;
import services.Utilities;

/**
 * classe che descrive un Hotel e che implementa l'interfaccia Struttura
 * plug in Univocity usato per non creare problemi tra maiuscole e minuscole delle variabili e con i campi vuoti
 * @author Luciano Frick
 *
 */

public class Hotel implements Struttura{

	/**
	 * per ciascun attributo si è definita una corrispondenza con l'attributo relativo contenuto nel file csv, utilizzando la libreria
	 * univocity-parser csv. Ad esempio l'attributo "codice" corrisponde al campo "Codice" del csv, inoltre se tale campo nel file csv
	 * contiene valori quali "?", "-" o "", l'attributo assume il valore contenuto nella costante NULLSTRING della classe Utilities.
	 * (Il ragionamento è ripetuto per gli altri attributi della classe Hotel e delle classi collegate).
	 */
	@Trim
	@NullString(nulls = { "?", "-","" })
    @Parsed(field="Codice",defaultNullRead = Utilities.NULLSTRING)
	private String codice;
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="categoria",defaultNullRead=""+Utilities.NULLINT)
	private int categoria;
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="insegna",defaultNullRead=Utilities.NULLSTRING)
	private String insegna;
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="tipo_att_strut_extra",defaultNullRead=Utilities.NULLSTRING)
	private String tipoStruttura;
	@Trim
	@NullString(nulls = { "?", "-","" })
	@Parsed(field="Area di Competenza",defaultNullRead=Utilities.NULLSTRING)
	private String areaCompetenza;
	@Nested(type=InfoOrganization.class)
	private InfoOrganization infoOrganization;
	@Nested(type=InfoFacilities.class)
	private InfoFacilities infoFacilities;
	/**
	 * Si specifica mediante la parola chiave Nested che l'attributo posizione deve essere mappato nel csv considerando i suoi
	 * attributi, proprio perché tale attributo è un oggetto della classe Posizione
	 */
	@Nested(type=Posizione.class)	
	private Posizione posizione;

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getCategoria() {
		return this.categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public String getInsegna() {
		return this.insegna;
	}

	public void setInsegna(String insegna) {
		this.insegna = insegna;
	}

	public String getTipoStruttura() {
		return this.tipoStruttura;
	}

	public void setTipoStruttura(String tipoStruttura) {
		this.tipoStruttura = tipoStruttura;
	}

	public String getAreaCompetenza() {
		return this.areaCompetenza;
	}

	public void setAreaCompetenza(String areaCompetenza) {
		this.areaCompetenza = areaCompetenza;
	}

	public InfoOrganization getInfoOrganization() {
		return this.infoOrganization;
	}

	public void setInfoOrganization(InfoOrganization infoOrganization) {
		this.infoOrganization = infoOrganization;
	}

	public InfoFacilities getInfoFacilities() {
		return this.infoFacilities;
	}

	public void setInfoFacilities(InfoFacilities infoFacilities) {
		this.infoFacilities = infoFacilities;
	}
	
	public Posizione getPosizione() {
		return this.posizione;
	}
	
	public void setPosizione(Posizione posizione) {
		this.posizione=posizione;
	}
/**
 * costruttore di default di Hotel che inizializza i suoi attributi con i valori di default implementati nella classe statica Utilities
 */
	public Hotel() {
		this.codice=Utilities.NULLSTRING;
		this.categoria=Utilities.NULLINT;
		this.insegna=Utilities.NULLSTRING;
		this.tipoStruttura=Utilities.NULLSTRING;
		this.areaCompetenza=Utilities.NULLSTRING;
		this.infoOrganization=null;
		this.infoFacilities=null;
		this.posizione=null;
		
	}
/**
 *per il costruttore di Hotel vengono richiamati i seguenti costruttori: InfoOrganization, InfoFacilities e Posizione;
 in quanto queste 3 variabili, contenute nella classe Hotel, sono degli oggetti.
 * @param codice
 * @param categoria
 * @param insegna
 * @param tipoStruttura
 * @param areaCompetenza
 * @param numCamere
 * @param numPiani
 * @param numPostiletto
 * @param camerePiano
 * @param pianoPiano
 * @param postiLettoPiano
 * @param numTelefoni
 * @param numServizi
 * @param numServiziPiano
 * @param posizione
 * @param longitude
 * @param latitude
 * @param municipio
 * @param descrizioneVia
 * @param codiceVia
 * @param civico
 */
	public Hotel(String codice, int categoria, String insegna, String tipoStruttura, String areaCompetenza, int numCamere, int numPiani, int numPostiletto, String camerePiano, String pianoPiano, String postiLettoPiano,int numTelefoni, int numServizi, String numServiziPiano, Posizione posizione, int longitude, int latitude, int municipio, String descrizioneVia,int codiceVia, String civico) {
		this.codice=codice;
		this.categoria=categoria;
		this.insegna=insegna;
		this.tipoStruttura=tipoStruttura;
		this.areaCompetenza=areaCompetenza;
		this.infoOrganization= new InfoOrganization(numCamere, numPiani, numPostiletto, camerePiano, pianoPiano, postiLettoPiano);
		this.infoFacilities = new InfoFacilities(numTelefoni, numServizi, numServiziPiano);
		this.posizione = new Posizione(longitude, latitude, municipio, descrizioneVia, codiceVia, civico);
	}
	/**
	 * overriding toString dell'oggetto Hotel, si è scelto di stampare le informazioni principali riguardanti l'oggetto.
	 */
	public String toString() {
		return this.tipoStruttura+": "+this.insegna+" , "+this.posizione.getUbicazione();
	}

}