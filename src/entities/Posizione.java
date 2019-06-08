package entities;

public class Posizione extends Coordinate {

	private Via indirizzo;
	private int civico;

	public Via getIndirizzo() {
		return this.indirizzo;
	}

	/**
	 * 
	 * @param indirizzo
	 */
	public void setIndirizzo(Via indirizzo) {
		this.indirizzo = indirizzo;
	}

	public int getCivico() {
		return this.civico;
	}

	/**
	 * 
	 * @param civico
	 */
	public void setCivico(int civico) {
		this.civico = civico;
	}

	public Posizione() {
        //TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param indirizzo
	 * @param civico
	 */
	public Posizione(int longitude, int latitude, int municipio, Via indirizzo, int civico) {
		super(latitude, longitude, municipio);
		this.indirizzo=indirizzo;
		this.civico=civico;
		this.getLocation();
		this.getUbicazione();
	}
	
	public  String getLocation() {
		return getLocation();
	}

	public String getUbicazione() {
		return (indirizzo.getDescrizione() + this.getCivico() + this.getMunicipio() ).toString();
	}
}