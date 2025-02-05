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
	public Object getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
			@RequestParam(value = "ward", required = false) String ward) {

		try {
			System.out.print(5 / 0);
		} catch (Exception e) {
			ErrorHandler errorHandler = new ErrorHandler();
			errorHandler.setError(e.getMessage());
			List<String> details = new ArrayList<String>();
			details.add("Khong the chia het cho 0 !");
			errorHandler.setDetails(details);
			return errorHandler;
		}

		BuildingDTO building2 = new BuildingDTO();
		building2.setName("Thien Long");
		building2.setNumberOfBasement(3);
		building2.setWard("Nghiadew");
		building2.setStreet("ffefe");

		return building2;
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
