package main;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.MetaData;
import repositories.MetaDataRepository;
import services.MetaDataService;

@RestController
public class MetaDataController {

	private static MetaDataRepository repo=new MetaDataRepository();

	@RequestMapping("/metadata")    
   	public List<MetaData> getMetaData()
   	{
   		return this.repo.getAll();
	   	
   	} 
	
}
