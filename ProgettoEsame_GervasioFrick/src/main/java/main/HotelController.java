package main;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Hotel;
import repositories.HotelRepository;
import services.Utilities;

@RestController
public class HotelController {
	
	private static HotelRepository repo=new HotelRepository();
	
	@RequestMapping("/hotel")
	public String hotelHome()
	{
		return "Available API:		-/getAll		-/getByCategoria/{operators}/{value}		-/stats?filter";
	}
	
	@GetMapping("/hotel/getAll")    
   	public List<Hotel> getAll()
   	{
		return repo.getAll(); //Call the hotel repository for getting the data
	   	
   	} 
	
	@GetMapping("/hotel/getByCategoria/{operators}/{value}")
	public List<Hotel> getFiltered(@PathVariable String operators,@PathVariable int value)
	{
		if (Utilities.checkOperators(operators) && value<=5 && value>=1)  //Checking if the user enters the correct operator and the correct value
		return repo.filterField("categoria",operators, value);
		else
		return null;
	}

}
