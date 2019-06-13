package entities;

import services.Utilities;

public class InfoFacilities {

	private int numTelefoni;
	private int numServizi;

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

	public InfoFacilities() {
		this.numServizi=Utilities.NULLINT;
		this.numTelefoni=Utilities.NULLINT;
		
	}
	public InfoFacilities(int numTelefoni, int numServizi) {
		this.numTelefoni = numTelefoni;
		this.numServizi = numServizi;
	}

}