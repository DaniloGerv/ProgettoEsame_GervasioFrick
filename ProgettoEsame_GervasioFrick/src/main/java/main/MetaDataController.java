package main;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.MetaData;
import repositories.MetaDataRepository;

@RestController
public class MetaDataController {

	private static MetaDataRepository repo=new MetaDataRepository();
	
	
	@GetMapping("/metadata")    
   	public List<MetaData> getMetaData()
   	{
		return repo.getAll();	//Call the metaData repository for getting the data
	   	
   	} 
	
}
