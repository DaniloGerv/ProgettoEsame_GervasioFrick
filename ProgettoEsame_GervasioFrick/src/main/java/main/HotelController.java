package main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Hotel;
import repositories.HotelRepository;
import repositories.MetaDataRepository;
import services.Utilities;

@RestController
public class HotelController {
	
	private static HotelRepository repo=new HotelRepository();
	private static MetaDataRepository repoMetaData=new MetaDataRepository();
	
	@RequestMapping("/hotel")
	public String hotelHome()
	{
		return "Available API:		-/getAll		-/getByCategoria/{operators}/{value}		-/stats?filter";
	}
	

   	 
	
	@GetMapping("/hotel/get") //exemple filter is /hotel/get?filter=NAMEFIELD:operator:value:AND:NAMESECONDFIELD:operator:value:OR:NAMETHIRDFIELD:operator:value
	public List<Hotel> getFiltered(@RequestParam(value="filter",defaultValue="",required=false) String filter)
	{
		if (filter.equals(""))
			return repo.getAll();
		else
		{
			List<String> fieldNameList=new ArrayList<String>();
			List<String> operatorList=new ArrayList<String>();
			List<Object> valueList=new ArrayList<Object>();
			List<String> logicalLinkOperator=new ArrayList<String>();
			String[] filtering=filter.split(":");
			int maxIndex=(filtering.length/4 );
			if (filtering.length%4>0)
				maxIndex++;
			
			for (int i=0;i<maxIndex;i++)
			{
				String field=filtering[0+(4*i)];
				fieldNameList.add(field);
				operatorList.add(filtering[1+(4*i)]);
				
				switch (repoMetaData.query(field).getType())
				{
				case "int":
					valueList.add(Integer.parseInt(filtering[2+(4*1)]));
					break;
				case "double":
					valueList.add(Double.parseDouble(filtering[2+(4*i)]));
					break;
				default:
					valueList.add(filtering[2+(4*i)]);

				}
				

				if (filtering.length>(3+(4*i)))
					logicalLinkOperator.add(filtering[3+(4*i)]);
				
			}
			return repo.filterField(fieldNameList, operatorList, valueList,logicalLinkOperator);
		}
	}
	
	@GetMapping("/hotel/getByCategoria/{operator}/{value:[1-5]}")		//Filter by categoria value (between 1 to 5) ecc...
	public List<Hotel> getByCategoria(@PathVariable String operator,@PathVariable int value)
	{
		if (Utilities.checkOperators(operator)) //Checking if the user enters the correct operator value
		{
			List<String> fieldNameList=new ArrayList<String>();
			fieldNameList.add("categoria");
			List<String> operatorList=new ArrayList<String>();
			operatorList.add(operator);
			List<Object> valueList=new ArrayList<Object>();
			valueList.add(value);
			return repo.filterField(fieldNameList,operatorList,valueList,null);	
		
		}else
		return null;	//Error message here
	}
}


