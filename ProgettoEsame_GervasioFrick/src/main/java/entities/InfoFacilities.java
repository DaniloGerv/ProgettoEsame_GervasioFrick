package entities;

import services.Utilities;

public class InfoFacilities {

	private int numTelefoni;
	private int numServizi;
	private int numServiziPiano;

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
	
	public int getNumServiziPiano() {
		return this.numServiziPiano;
	}
	
	public void setNumServiziPiano(int numServiziPiano) {
		this.numServiziPiano = numServiziPiano;
	}

	public InfoFacilities() {
		this.numServizi=Utilities.NULLINT;
		this.numTelefoni=Utilities.NULLINT;
		this.numServiziPiano = Utilities.NULLINT;
		
	}
	public InfoFacilities(int numTelefoni, int numServizi, int numServiziPiano) {
		this.numTelefoni = numTelefoni;
		this.numServizi = numServizi;
		this.numServiziPiano = numServiziPiano;
	}

}