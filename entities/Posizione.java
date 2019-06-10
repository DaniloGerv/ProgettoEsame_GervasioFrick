package entities;

public class Posizione extends Coordinate {

	private Via indirizzo;
	private int civico;
	private String ubicazione;


	public Via getIndirizzo() {
		return this.indirizzo;
	}
	public void setIndirizzo(Via indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getUbicazione()
	{
		return this.ubicazione;
	}
	public void setUbicazione(String ubicazione)
	{
		this.ubicazione=ubicazione;
	}
	
	public int getCivico() {
		return this.civico;
	}
	public void setCivico(int civico) {
		this.civico = civico;
	}

	public Posizione() {}
	public Posizione(int longitude, int latitude, int municipio, String descrizioneVia,int codiceVia, int civico) {
		
		super(latitude, longitude, municipio);
		this.indirizzo=new Via(codiceVia,descrizioneVia);
		this.civico=civico;
	}

}