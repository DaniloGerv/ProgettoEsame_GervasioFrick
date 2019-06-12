package entities;

import main.java.interfaces.Struttura;

public class Hotel implements Struttura{

	private String codice;
	private int stelle;
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

	public int getStelle() {
		return this.stelle;
	}

	public void setStelle(int stelle) {
		this.stelle = stelle;
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
		
	}

	public Hotel(String codice, int stelle, String insegna, String tipoStruttura, String areaCompetenza, InfoOrganization infoOrganization, InfoFacilities infoFacilities, Posizione posizione) {
		
	}
	
	public String toString() {
		return this.tipoStruttura+": "+this.insegna+" , "+this.posizione.getUbicazione();
	}

}