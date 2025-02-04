package com.javaweb.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaweb.object.BuildingDTO;

@Controller
public class BuildingAPI {
	@RequestMapping(value = "/api/building/", method = RequestMethod.GET)
	@ResponseBody
	private BuildingDTO getBuilding(@RequestParam(value = "name",required = false) String name,
							 @RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
							 @RequestParam(value = "ward", required = false) String ward) {
		BuildingDTO getResult = new BuildingDTO();
		getResult.setName(name);
		getResult.setNumberOfBasement(numberOfBasement);
		getResult.setWard(ward);
		return getResult;

	}
	
	@RequestMapping(value = "/api/building/", method = RequestMethod.POST)
	private BuildingDTO postBuilding(@RequestBody BuildingDTO buildingDTO) {
		return buildingDTO;

	}
}
