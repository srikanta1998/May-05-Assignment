package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Hero;

@Service
public class HeroServiceImpl implements HeroService {

	List<Hero> list = List.of(new Hero(1L, "Pawan Kalyan", "45CR"), new Hero(2L, "Prabhas", "35CR"),
			new Hero(3L, "Allu Arjun", "25CR"));

	@Override
	public Hero heroById(Long id) {
		// TODO Auto-generated method stub

		Hero h1 = list.stream().filter(hero -> hero.getHeroId().equals(id)).findAny().orElse(null);
		
		return h1;
	}

}
