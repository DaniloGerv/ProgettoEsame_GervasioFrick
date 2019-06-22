package main;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.MetaData;
import repositories.MetaDataRepository;

/**
 * Controller che restituisce i metadati organizzati dal programma.Fa riferimento ad una metaData repository:
 * questa è una variabile statica in quanto la struttura dati sul quale si fa riferimento (contenuta all'interno della suddetta
 * repository) deve essere univoca per ogni chiamata API effettuata al metaData controller.
 * @author danilogervasio
 *
 */

@RestController
public class MetaDataController {

	private static MetaDataRepository repo=new MetaDataRepository();
	
	
	/**
	 * "/metadata"
	 * API che restituisce la lista dei metaDati
	 * @return
	 */
	@GetMapping("/metadata")    
   	public List<MetaData> getMetaData()
   	{
		return repo.getAll();	//Call the metaData repository for getting the data
	   	
   	} 
	
}
