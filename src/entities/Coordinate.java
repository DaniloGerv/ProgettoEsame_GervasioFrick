package entities;

public class Coordinate {

	protected int latitude;
	protected  int municipio;
	protected  int longitude;

	public int getLatitude() {
		return this.latitude;
	}

	/**
	 * 
	 * @param lat
	 */
	public void setLatitude(int lat) {
		this.latitude = lat;
	}

	public int getMunicipio() {
		return this.municipio;
	}

	/**
	 * 
	 * @param municipio
	 */
	public void setMunicipio(int municipio) {
		this.municipio = municipio;
	}
	
	public int getLongitude() {
		return this.longitude;
	}

	/**
	 * 
	 * @param longitude
	 */
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public Coordinate() {
		// TODO - implement Coordinate.Coordinate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param longitude
	 * @param latitude
	 * @param municipio
	 */
	protected Coordinate(int longitude, int latitude, int municipio) {
		this.longitude=longitude;
		this.latitude=latitude;
		this.municipio=municipio;
	}

	public String getLocation() {
		return ("Latitude: " + this.latitude + "\nLongitude: "+ this.longitude + "\nMunicipio: " + this.municipio );
	}

}