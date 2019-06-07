package entities;

public class Hotel implements Struttura{

	private String codice;
	private int stelle;
	private String insegna;
	private String tipoStruttura;
	private String areaCompetenza;
	private InfoOrganization infoOrganization;
	private InfoFacilities infoFacilities;

	public String getCodice() {
		return this.codice;
	}

	/**
	 * 
	 * @param codice
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	public int getStelle() {
		return this.stelle;
	}

	/**
	 * 
	 * @param stelle
	 */
	public void setStelle(int stelle) {
		this.stelle = stelle;
	}

	public String getInsegna() {
		return this.insegna;
	}

	/**
	 * 
	 * @param insegna
	 */
	public void setInsegna(String insegna) {
		this.insegna = insegna;
	}

	public String getTipoStruttura() {
		return this.tipoStruttura;
	}

	/**
	 * 
	 * @param tipoStruttura
	 */
	public void setTipoStruttura(String tipoStruttura) {
		this.tipoStruttura = tipoStruttura;
	}

	public String getAreaCompetenza() {
		return this.areaCompetenza;
	}

	/**
	 * 
	 * @param areaCompetenza
	 */
	public void setAreaCompetenza(String areaCompetenza) {
		this.areaCompetenza = areaCompetenza;
	}

	public InfoOrganization getInfoOrganization() {
		return this.infoOrganization;
	}

	/**
	 * 
	 * @param infoOrganization
	 */
	public void setInfoOrganization(InfoOrganization infoOrganization) {
		this.infoOrganization = infoOrganization;
	}

	public InfoFacilities getInfoFacilities() {
		return this.infoFacilities;
	}

	/**
	 * 
	 * @param infoFacilities
	 */
	public void setInfoFacilities(InfoFacilities infoFacilities) {
		this.infoFacilities = infoFacilities;
	}

	public Hotel() {
		// TODO - implement Hotel.Hotel
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param codice
	 * @param stelle
	 * @param insegna
	 * @param tipoStruttura
	 * @param areaCompetenza
	 * @param infoOrganization
	 * @param infoFacilities
	 */
	public Hotel(String codice, int stelle, String insegna, String tipoStruttura, String areaCompetenza, InfoOrganization infoOrganization, InfoFacilities infoFacilities) {
		// TODO - implement Hotel.Hotel
		throw new UnsupportedOperationException();
	}

}