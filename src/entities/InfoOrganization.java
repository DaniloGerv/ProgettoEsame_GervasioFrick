package entities;

public class InfoOrganization {

	private int numCamere;
	private int numPiani;
	private int numPostiletto;

	public int getNumCamere() {
		return this.numCamere;
	}

	/**
	 * 
	 * @param numCamere
	 */
	public void setNumCamere(int numCamere) {
		this.numCamere = numCamere;
	}

	public int getNumPiani() {
		return this.numPiani;
	}

	/**
	 * 
	 * @param numPiani
	 */
	public void setNumPiani(int numPiani) {
		this.numPiani = numPiani;
	}

	public int getNumPostiletto() {
		return this.numPostiletto;
	}

	/**
	 * 
	 * @param numPostiletto
	 */
	public void setNumPostiletto(int numPostiletto) {
		this.numPostiletto = numPostiletto;
	}

	public InfoOrganization() {
		// TODO - implement InfoOrganization.InfoOrganization
		throw new UnsupportedOperationException();
	}

}