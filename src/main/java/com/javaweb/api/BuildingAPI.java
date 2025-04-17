package com.javaweb.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.connection.BuildingDAO;
import com.javaweb.object.BuildingDTO;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	BuildingDAO api = new BuildingDAO();
	@GetMapping
	public List<BuildingDTO> getBuilding(@RequestParam(name = "name") String name) {
		String query = "SELECT * FROM building WHERE name LIKE ?";
		

		List<BuildingDTO> result = new ArrayList();
		try(Connection conn = api.getConnect();PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, "%" + name + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				BuildingDTO buildingDTO = new BuildingDTO();
				buildingDTO.setName(rs.getString("name"));
				buildingDTO.setStreet(rs.getString("street"));
				buildingDTO.setWard(rs.getString("ward"));
				buildingDTO.setNumberOfBasement(rs.getInt("numberofbasement"));
				result.add(buildingDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

//	public void validateField(BuildingDTO buildingDTO) {
//		if (buildingDTO.getName() == null || buildingDTO.getName().equals("")
//				|| buildingDTO.getNumberOfBasement() == null) {
//			throw new GlobalExceptionHandler("All fields are required !");
//
//		}
//	}

//	@PostMapping
//	public BuildingDTO postBuilding(@RequestBody BuildingDTO buildingDTO) {
//		return buildingDTO;
//	}

	@DeleteMapping("/{id}/{name}")
	public void deleteBuilding(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		System.out.printf("Đã xóa tòa nhà có id là: %d và name: %s%n", id, name);
	}

}
