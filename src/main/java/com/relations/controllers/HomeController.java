package com.relations.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class HomeController {
@GetMapping("")
public String sayHello()
{
return "hello spring";	
}
@PostMapping("")
public String ReadDatas(@RequestParam String  nom)
{
	return "bienvenu "+nom;
	
}
@GetMapping("/read")
public String readUrlData(@PathParam(value = "id") String id,@PathParam(value = "nom") String nom)
{
	return "ID= "+id+" nom= "+nom;
}
@GetMapping("search/{id}")
public String readPath(@PathVariable long id)
{
	return "you are looking for user with id "+id;
	
}
}
