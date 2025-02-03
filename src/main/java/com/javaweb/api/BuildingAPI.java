package com.javaweb.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuildingAPI {
	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
	private void getBuilding(@RequestParam(value = "name") String name,
							 @RequestParam(value = "numberOfBasement") Integer numberOfBasement) {
		System.out.print(name);
		System.out.print(numberOfBasement);

	}
}
