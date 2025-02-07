package com.javaweb.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.object.BuildingDTO;

import CustomException.FieldRequiredException;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

	@PostMapping
	public Object getBuilding(@RequestBody BuildingDTO building) {

//		try {
//
//			validateField(building);
//		} catch (FieldRequiredException e) {
//			ErrorHandler errorHandler = new ErrorHandler();
//			errorHandler.setError(e.getMessage());
//			List<String> details = new ArrayList<String>();
//			details.add("Revision your input!");
//			errorHandler.setDetails(details);
//			return errorHandler;
//		}
//
//		BuildingDTO building2 = new BuildingDTO();
//		building2.setName("Thien Long");
//		building2.setNumberOfBasement(3);
//		building2.setWard("Nghiadew");
//		building2.setStreet("ffefe");
		System.out.print(5 / 0);
		return null;
	}

	public void validateField(BuildingDTO buildingDTO) {
		if (buildingDTO.getName() == null || buildingDTO.getName().equals("")
				|| buildingDTO.getNumberOfBasement() == null) {
			throw new FieldRequiredException("All fields are required !");

		}
	}

//	@PostMapping
//	public BuildingDTO postBuilding(@RequestBody BuildingDTO buildingDTO) {
//		return buildingDTO;
//	}

	@DeleteMapping("/{id}/{name}")
	public void deleteBuilding(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		System.out.printf("Đã xóa tòa nhà có id là: %d và name: %s%n", id, name);
	}

}
