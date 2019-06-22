package entities;
import com.univocity.parsers.annotations.Nested;
import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

//
import interfaces.Struttura;
import services.Utilities;

/**
 * Classe che descrive un Hotel e che implementa l'interfaccia Struttura
 * @author Luciano Frick
 *
 */

public class Hotel implements Struttura{

	/**
	 * Per ciascun attributo si è definita una corrispondenza con l'attributo relativo contenuto nel file csv, utilizzando la libreria
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
 * @param codice, Parametro che rappresenta codice alfanumerico univoco dell'hotel
 * @param categoria, Parametro che rappresenta il numero di stelle dell'hotel
 * @param insegna, Parametro che rappresenta il nome dell'hotel
 * @param tipoStruttura, Parametro che rappresenta il tipo della struttura ospitante
 * @param areaCompetenza, Parametro che rappresenta l'area in cui compete l'hotel
 * @param numCamere, Parametro che rappresenta il num totale delle camere dell'hotel, appartiene alla classe InfoOrganization
 * @param numPiani, Parametro che rappresenta il numero di piani dell'hotel, appartiene alla classe InfoOrganization
 * @param numPostiletto, Parametro che rappresenta il numero totale dei posti letto, appartiene alla classe InfoOrganization
 * @param camerePiano, Parametro che rappresenta il numero di camere per ogni piano, apparteiene alla classe InfoOrganization
 * @param pianoPiano, Parametro che rappresenta l'ordine dei piani, appartiene alla classe InfoOrganization; settato come Stringa perchè altrimenti crea problemi come integer
 * @param postiLettoPiano, Parametro che rappresenta il numero di posti letto per ogni piano, appartiene alla classe InfoOrganization
 * @param numTelefoni, Parametro che rappresenta il numero di telefoni utilizzabili nell'hotel, appartiene alla classe InfoFacilities
 * @param numServizi, Parametro che rappresenta il numero di toilette presenti nell'hotel, appartiene alla classe InfoFacilities
 * @param numServiziPiano, Parametro che rappresenta il numero di toilette per ogni piano, appartiene alla classe InfoFacilities
 * @param posizione, Parametro che rappresenta l'allocazione dell'hotel
 * @param longitude, Parametro che rappresenta la longitudine di un punto, appartiene alla classe Posizione
 * @param latitude, Parametro che rappresenta la latitudine di un punto, appartiene alla classe Posizione
 * @param municipio, Parametro che rappresenta il numero del municipio (zona di Milano) dell'hotel, appartiene alla classe Posizione
 * @param descrizioneVia, Parametro che rappresenta il nome della via, appartiene alla classe Via
 * @param codiceVia, Parametro che rappresenta il codice univoco di una via, appartiene alla classe Via
 * @param civico, Parametro che rappresenta il numero civico dell'hotel, appartiene alla classe Posizione
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
	 * Overriding toString dell'oggetto Hotel, si è scelto di stampare le informazioni principali riguardanti l'oggetto.
	 */
	public String toString() {
		return this.tipoStruttura+": "+this.insegna+" , "+this.posizione.getUbicazione();
	}

}