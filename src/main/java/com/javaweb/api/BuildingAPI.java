package com.javaweb.api;

import java.util.ArrayList;
import java.util.List;

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
	public List<BuildingDTO> getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
			@RequestParam(value = "ward", required = false) String ward) {

		List<BuildingDTO> listBuilding = new ArrayList<BuildingDTO>();
		BuildingDTO building1 = new BuildingDTO();
		building1.setName("Thien");
		building1.setNumberOfBasement(2);
		building1.setWard("Nghiad");
		building1.setStreet("ffe");
		listBuilding.add(building1);
		BuildingDTO building2 = new BuildingDTO();
		building2.setName("Thien Long");
		building2.setNumberOfBasement(3);
		building2.setWard("Nghiadew");
		building2.setStreet("ffefe");
		listBuilding.add(building2);
		return listBuilding;
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
