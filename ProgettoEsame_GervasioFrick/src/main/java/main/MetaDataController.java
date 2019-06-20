package main;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import entities.MetaData;
import repositories.MetaDataRepository;

@RestController
public class MetaDataController {

	private static MetaDataRepository repo=new MetaDataRepository();

	@GetMapping("/metadata")    
   	public List<MetaData> getMetaData()
   	{
   		return this.repo.getAll();
	   	
   	} 
	
}
