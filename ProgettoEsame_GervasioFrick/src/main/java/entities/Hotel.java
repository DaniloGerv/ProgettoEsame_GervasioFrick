package entities;
//
import interfaces.Struttura;
import services.Utilities;

public class Hotel implements Struttura{

	private String codice;
	private int categoria;
	private String insegna;
	private String tipoStruttura;
	private String areaCompetenza;
	private InfoOrganization infoOrganization;
	private InfoFacilities infoFacilities;
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

	public Hotel(String codice, int categoria, String insegna, String tipoStruttura, String areaCompetenza, int numCamere, int numPiani, int numPostiletto, int camerePiano, int pianoPiano, int postiLettoPiano,int numTelefoni, int numServizi, int numServiziPiano, Posizione posizione, int longitude, int latitude, int municipio, String descrizioneVia,int codiceVia, int civico) {
		this.codice=codice;
		this.categoria=categoria;
		this.insegna=insegna;
		this.tipoStruttura=tipoStruttura;
		this.areaCompetenza=areaCompetenza;
		/*
		 * per il costruttore di Hotel vengono richiamati altri 3 costruttori: InfoOrganization, InfoFacilities e Posizione
		 * in quanto queste 3 variabili della classe Hotel sono a loro volta CLassi
		 */
		this.infoOrganization= new InfoOrganization(numCamere, numPiani, numPostiletto, camerePiano, pianoPiano, postiLettoPiano);
		this.infoFacilities = new InfoFacilities(numTelefoni, numServizi, numServiziPiano);
		this.posizione = new Posizione(longitude, latitude, municipio, descrizioneVia, codiceVia, civico);
	}
	
	public String toString() {
		return this.tipoStruttura+": "+this.insegna+" , "+this.posizione.getUbicazione();
	}

}