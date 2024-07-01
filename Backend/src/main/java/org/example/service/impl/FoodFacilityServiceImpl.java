package org.example.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.example.service.FoodFacilityService;
import org.example.vo.FoodFacility;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class FoodFacilityServiceImpl implements FoodFacilityService {
    @Override
    public List<FoodFacility> getFacilityByFood(String filePath, int columnIndex, String food) {
        AtomicReference<List<FoodFacility>> foodFacilityList = new AtomicReference<>(new ArrayList<>());
        try(FileReader fileReader = new FileReader(filePath)) {
            CSVReader csvReader = new CSVReader(fileReader);
            List<String[]> allData = csvReader.readAll();
            for (String[] row : allData) {
                if (row[columnIndex].toLowerCase().contains(food.toLowerCase())) {
                    FoodFacility foodFacility = new FoodFacility(Integer.parseInt(row[0]),
                            row[1],row[2],row[3],row[4],row[5],row[6],row[7],row[8],row[9],row[10],row[11],
                            row[12],row[13],row[14],row[15],row[16],row[17],row[18],row[19],row[20],
                            row[21],row[22],row[23],row[24],row[25],row[26],row[27],row[28]);
                    foodFacilityList.get().add(foodFacility);
                }
            }
            return foodFacilityList.get();
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
}