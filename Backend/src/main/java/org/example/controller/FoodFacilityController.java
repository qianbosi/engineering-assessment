package org.example.controller;

import org.example.service.FoodFacilityService;
import org.example.vo.FoodFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/foodFacility")
public class FoodFacilityController {
    @Autowired
    private FoodFacilityService foodFacilityService;

    @GetMapping("/searchBy")
    public ResponseEntity<List<FoodFacility>> getFacilityByFood(@RequestParam String food) {
        List<FoodFacility> foodFacilityList = foodFacilityService.getFacilityByFood(
                "Backend/Mobile_Food_Facility_Permit.csv",11, food);
        return ResponseEntity.ok(foodFacilityList.stream().filter(Objects::nonNull).collect(Collectors.toList()));
    }
}