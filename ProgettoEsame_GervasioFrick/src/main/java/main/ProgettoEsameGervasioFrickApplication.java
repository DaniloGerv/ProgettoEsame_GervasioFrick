package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import repositories.HotelRepository;
import services.DataDownloader;

@SpringBootApplication
public class ProgettoEsameGervasioFrickApplication  {

	/**
	 * Main del programma. Inizialmente si istanzia un oggetto della classe DataDownloader per scaricare il json e il 
	 * csv contenete i dati. Successivamente si avvia la spring application.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//A DataDownloader object is inizialized for downloading the data from the json and then from the csv.
		String url="https://www.dati.gov.it/api/3/action/package_show?id=c432300c-687a-47ce-83f0-ddeb1f08cb55";
		if(args.length == 1)	//if url is given by args
			url = args[0];
		DataDownloader data=new DataDownloader(url);	
		if (data.readFromJson()) //if the download is done the spring application is started otherwise the program is closed
		{
			try 
			{
			SpringApplication.run(ProgettoEsameGervasioFrickApplication.class, args);
			}catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
		
	}

}
