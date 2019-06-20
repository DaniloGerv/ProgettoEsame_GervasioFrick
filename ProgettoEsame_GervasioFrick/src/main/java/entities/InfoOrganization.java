package entities;

import services.Utilities;

public class InfoOrganization {

	private int numCamere;
	private int numPiani;
	private int numPostiletto;
	private int camerePiano;
	private int pianoPiano;
	private int postiLettoPiano;

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
	
	public int getCamerePiano() {
		return this.camerePiano;
	}
	public void setCamerePiano(int camerePiano) {
		this.camerePiano = camerePiano;
	}
	
	public int getPianoPiano() {
		return this.pianoPiano;
	}
	
	public void setPianoPiano(int pianoPiano) {
		this.pianoPiano = pianoPiano;
	}
	public int getPostiLettoPiano() {
		return this.postiLettoPiano;
	}

	public void setPostilettoPiano(int postiLettoPiano) {
		this.postiLettoPiano = postiLettoPiano;
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