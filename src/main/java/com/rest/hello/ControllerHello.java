package com.rest.hello;

import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerHello {
	
	@RequestMapping("/hello/{name}")
	public ResponseEntity<String> sayHello(@PathVariable("name") String name) {
		
		StringBuilder message = new StringBuilder();
		message.append("Hello ");
		
	
			
			Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");
			
			
			if(name !=null && p.matcher(name).matches()) {
				throw new UserNameValidationException("Invalid UserName");
			}
		
		
		message.append(name);
		
		return new ResponseEntity(message.toString(),HttpStatus.OK);
	}
	
}
