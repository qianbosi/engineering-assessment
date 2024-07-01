package org.example.service;

import org.example.vo.FoodFacility;
import java.util.List;

public interface FoodFacilityService {

    List<FoodFacility> getFacilityByFood(String filePath, int columnIndex, String food);
}
