package com.example.demo.controller;


import java.util.Arrays;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.Serviceint;


@RestController
@RequestMapping("/demo")
public class Test {
	@Autowired
	Serviceint serv;
	@GetMapping("/status")
	public String isServiceRunning() {
		
		return " Student Service Is Running";
	}
@GetMapping("/count")
public Object[] countries() {
//	String url="https://countriesnow.space/api/v0.1/countries/population";
	String url ="https://api.agify.io/?name=meelad";
	RestTemplate rest=new RestTemplate();
	Object[] count=rest.getForObject(url, Object[].class);
	return count;
}
@GetMapping("/mail")
public boolean mail(){
return serv.sendEmail();
	
}

	
}
