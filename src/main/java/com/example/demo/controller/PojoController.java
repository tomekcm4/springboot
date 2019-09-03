package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.PojoRepo;
import com.example.demo.model.Pojo;

@Controller
public class PojoController {

	@Autowired
	PojoRepo repo;

	@RequestMapping("/")
	public String home() {

		return "home.jsp";

	}

	@RequestMapping("/add")
	
	public String addPojo(Pojo pojo) {

		repo.save(pojo);
		return "home.jsp";
	}

	@RequestMapping("/list")
	@ResponseBody
	public List<Pojo> getPojo() {

		return repo.findAll();

	}

}
