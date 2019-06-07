public class Coordinate {

	private int latitude;
	/**
	 * Zone in cui è divisa Milano (da 1 a 9)
	 */
	private int municipio;
	private int longitude;

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

	public int getLatitude() {
		return this.latitude;
	}

	/**
	 * 
	 * @param latitude
	 */
	public void setLatitude(int latitude) {
		this.latitude = latitude;
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
	public Coordinate(int longitude, int latitude, int municipio) {
		// TODO - implement Coordinate.Coordinate
		throw new UnsupportedOperationException();
	}

}