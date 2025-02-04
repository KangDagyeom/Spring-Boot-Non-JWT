package com.javaweb.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.object.BuildingDTO;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

	@GetMapping
	public BuildingDTO getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
			@RequestParam(value = "ward", required = false) String ward) {

		BuildingDTO building = new BuildingDTO();
		building.setName(name);
		building.setNumberOfBasement(numberOfBasement);
		building.setWard(ward);
		return building;
	}

	@PostMapping
	public BuildingDTO postBuilding(@RequestBody BuildingDTO buildingDTO) {
		return buildingDTO;
	}

	@DeleteMapping("/{id}/{name}")
	public void deleteBuilding(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		System.out.printf("Đã xóa tòa nhà có id là: %d và name: %s%n", id, name);
	}

	
}
