package main;


import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entities.Hotel;
import entities.MetaData;
import services.CsvReader;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/m")
    public List<MetaData> greeting() {
    	List<MetaData> i=new ArrayList<MetaData>();
    	i.add(new MetaData());
    	i.add(new MetaData());
        return i;
    }
    
 
    
}

