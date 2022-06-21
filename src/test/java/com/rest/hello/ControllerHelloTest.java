package com.rest.hello;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
public class ControllerHelloTest {

	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Test
	public void CheckHelloApi() throws Exception {
	   String uri = "/api/hello/Vinod";
	   
	   MockMvc   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
	   String content = mvcResult.getResponse().getContentAsString();
		  System.out.print(content);

	   assertTrue(content.equals("Hello Vinod"));
	}
	
	@Test
	public void CheckHelloNegativeApi() throws Exception {
	   String uri = "/api/hello/34567";
	   
	   MockMvc   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(500, status);
	   String content = mvcResult.getResponse().getContentAsString();
		  System.out.print(content);

	   assertTrue(content.equals("Invalid UserName"));
	}
}
