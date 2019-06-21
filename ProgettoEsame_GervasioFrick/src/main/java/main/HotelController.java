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
	
	@RequestMapping("/hotel")
	public String hotelHome()
	{
		return "Available API:		-/get (get all the data)		-/get?filter=NAMEFIRSTFIELD:conditionaOp(</>/<=/>=/==):FIRSTVALUE:logicOp(AND/OR):NAMESECONDFIELD:...	-/getByCategoria/{operators}/{value}		-/stats?filter";
	}
	

	@GetMapping("/hotel/get") //filtered is /hotel/get?filter=NAMEFIELD:operator:value:AND:NAMESECONDFIELD:operator:value:OR:NAMETHIRDFIELD:operator:value
	public List<Hotel> getFiltered(@RequestParam(value="filter",defaultValue="",required=false) String filter)
	{
		if (filter.equals(""))		//if the filter is "" (if there isn't the filter the variable filter assumes "" as default value)
			return repo.getAll();		//return all the data
		else
		{
			//Each list contains the list of the relative values
			List<String> fieldNameList=new ArrayList<String>(); //all the fields where the user wants to  filter
			List<String> operatorList=new ArrayList<String>();
			List<Object> valueList=new ArrayList<Object>();
			List<String> logicalLinkOperator=new ArrayList<String>();
			String[] filtering=filter.split(":");
			
			int maxIndex=(filtering.length/4 );	 /*every filter contains 4 information (field,operator,value,logicalLink, these last
												 is used if there is another filter */
			if (filtering.length%4>0)
				maxIndex++;
			
			for (int i=0;i<maxIndex;i++)
			{
				String field=filtering[0+(4*i)];
				String operator=filtering[1+(4*i)];
				String value=filtering[2+(4*i)];
			
				fieldNameList.add(field); //Putting each string of the relative filter into its respective list
				operatorList.add(operator);
				
			
				
				switch (MetaDataRepository.getTypeOfAlias(field))	/*For the value is needded to know the type of the value in order to
																	let the filterService performs a correct filtering*/
				{
				case "integer":
					valueList.add(Integer.parseInt(value));
					break;
				case "double":
					valueList.add(Double.parseDouble(value));
					break;
				default:
					valueList.add(value);

				}

				if (filtering.length>(3+(4*i)))		/*If it is not it means that these iteraction of the cycle has analyzed the last filter values 
													3 values and not 4 because there is not any more filter*/
					logicalLinkOperator.add(filtering[3+(4*i)]);
				
			}
			return repo.filterField(fieldNameList, operatorList, valueList,logicalLinkOperator);	//returning the filtered data
		}
	}
	
	@GetMapping("/hotel/getByCategoria/{operator}/{value:[1-5]}")		//Filter by categoria value (between 1 to 5) 
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


