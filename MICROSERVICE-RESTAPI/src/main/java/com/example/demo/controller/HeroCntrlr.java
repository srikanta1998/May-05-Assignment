package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Hero;
import com.example.demo.service.HeroService;

@RestController
@RequestMapping("/hero")
public class HeroCntrlr {

	@Autowired
	private HeroService heroService;
	
	@GetMapping("/{id}")
	public Hero getHeroById(@PathVariable("id") Long id) 
	{
		return heroService.heroById(id);
	}
	
}
