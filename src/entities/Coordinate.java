package entities;

import services.Utilities;

public class Coordinate {

	protected double latitude;
	protected  int municipio;
	protected  double longitude;

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}
	
	public double getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude=longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public Coordinate() {
		this.latitude=Utilities.NULLDOUBLE;
		this.longitude=Utilities.NULLDOUBLE;
		this.municipio=Utilities.NULLINT;
		
	}

	
	public Coordinate(double longitude, double latitude, int municipio) {
		this.longitude=longitude;
		this.latitude=latitude;
		this.municipio=municipio;
	}

	public String getLocation() {
		return this.latitude +","+ this.longitude;
	}

	
}