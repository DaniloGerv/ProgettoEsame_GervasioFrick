package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import services.DataDownloader;

@SpringBootApplication
public class ProgettoEsameGervasioFrickApplication  {

	
	public static void main(String[] args) {
		
		String url="https://www.dati.gov.it/api/3/action/package_show?id=c432300c-687a-47ce-83f0-ddeb1f08cb55";
		if(args.length == 1)	//if url is given by args
			url = args[0];
		DataDownloader data=new DataDownloader(url);	
		boolean flag=data.readFromJson();
		if (flag) //if the download is done the spring application is started otherwise the program is closed
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
