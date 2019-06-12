package entities;

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
		
	}
	public InfoFacilities(int numTelefoni, int numServizi) {
		this.numTelefoni = numTelefoni;
		this.numServizi = numServizi;
	}

}