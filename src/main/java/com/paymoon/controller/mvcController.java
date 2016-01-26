package com.paymoon.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class mvcController {

	 @RequestMapping(value="/hello/{id}",method=RequestMethod.GET)
    public String hello(@PathVariable("id") String id){
    	System.out.println(id);
        return id;
    }
}