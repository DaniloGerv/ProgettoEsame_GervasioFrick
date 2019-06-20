package main;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Hotel;
import repositories.HotelRepository;

@RestController
@RequestMapping("/hotel/")
public class HotelController {
	
	private static HotelRepository repo=new HotelRepository();
	
	
	
	@GetMapping("/getAll")    
   	public List<Hotel> getAll()
   	{
		return repo.getAll(); //Call the hotel repository for getting the data
	   	
   	} 

}
