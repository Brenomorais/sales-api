package com.brenomorais.sales.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestResource {
	
	@RequestMapping("/")
	public String Test(){
		return "API Start";
	}

}
