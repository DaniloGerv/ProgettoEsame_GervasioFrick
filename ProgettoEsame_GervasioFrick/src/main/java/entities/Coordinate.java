package entities;

import com.univocity.parsers.annotations.NullString;
import com.univocity.parsers.annotations.Parsed;
import com.univocity.parsers.annotations.Trim;

import services.Utilities;
/**
 * Classe che descrive le coordinate di un punto e il municipio di appartenenza,si è utilizzato
 * come nelle classi precedenti la libreria univocity-parser csv
 * @author Luciano Frick
 *
 */
public class Coordinate {

	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="LATIT",defaultNullRead=Utilities.NULLDOUBLE+"")
	protected double latitude;
	
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="MUNICIPIO",defaultNullRead=Utilities.NULLINT+"")
	protected  int municipio;
	
	@Trim
	@NullString(nulls = { "?", "-",""})
	@Parsed(field="LONGIT",defaultNullRead=Utilities.NULLDOUBLE+"")
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
/**
 * costruttore di default di Coordinate con i valori provenienti dalla classe Utilities
 */
	public Coordinate() {
		this.latitude=Utilities.NULLDOUBLE;
		this.longitude=Utilities.NULLDOUBLE;
		this.municipio=Utilities.NULLINT;
		
	}

	/**
	 * costruttore di Coordinate coi parametri
	 * @param longitude, Parametro che rappresenta la longitudine di un punto
	 * @param latitude, Parametro che rappresenta la latitudine di in punto
	 * @param municipio, Parametro che rappresenta la zona in cui si trova l'hotel
	 */
	public Coordinate(double longitude, double latitude, int municipio) {
		this.longitude=longitude;
		this.latitude=latitude;
		this.municipio=municipio;
	}
/**
 * metodo per restituire sia la longitudine che la latitudine concatenandole come stringa
 * @return
 */
	public String getLocation() {
		return this.latitude +","+ this.longitude;
	}

	
}