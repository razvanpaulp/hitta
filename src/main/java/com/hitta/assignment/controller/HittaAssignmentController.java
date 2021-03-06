package com.hitta.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hitta.assignment.command.CommandInterpreter;

@Controller
public class HittaAssignmentController {

	@Autowired
	CommandInterpreter commandInterpreter;

	@RequestMapping(value = "commands", method = RequestMethod.GET)
	private ResponseEntity<String> interpretCommands() {
		try {
			commandInterpreter.interpretCommands();
		} catch (Exception e) {
			return new ResponseEntity<String>("Ups, something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Enjoy watching the pictures", HttpStatus.ACCEPTED);
	}


}
