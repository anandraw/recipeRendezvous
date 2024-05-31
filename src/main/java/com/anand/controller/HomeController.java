package com.anand.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anand.responce.ApiResponce;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@GetMapping
	public ResponseEntity<ApiResponce> homeController(){
		
		ApiResponce res=new ApiResponce("welcome to RecipeRendezvous",true);
		return new ResponseEntity<ApiResponce>(res,HttpStatus.OK);
	}

}
