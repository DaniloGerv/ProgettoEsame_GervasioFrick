package entities;

import services.Utilities;

public class InfoOrganization {

	private int numCamere;
	private int numPiani;
	private int numPostiletto;

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

	public InfoOrganization() {
		this.numCamere=Utilities.NULLINT;
		this.numPiani=Utilities.NULLINT;
		this.numPostiletto=Utilities.NULLINT;
		
	}
	public InfoOrganization(int numCamere, int numPiani, int numPostiletto) {
		this.numCamere = numCamere;
		this.numPiani = numPiani;
		this.numPostiletto = numPostiletto;
	}
	

}