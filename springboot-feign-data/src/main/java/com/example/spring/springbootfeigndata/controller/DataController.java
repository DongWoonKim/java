package com.example.spring.springbootfeigndata.controller;

import com.example.spring.springbootfeigndata.dto.DataRequest;
import com.example.spring.springbootfeigndata.dto.DataResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/data")
public class DataController {
    private Map<Long, DataResponse> dataStore = new HashMap<>();
    private Long idCounter = 1L;

    // 초기 데이터를 추가하는 메서드
    @PostConstruct
    public void initDataStore() {
        dataStore.put(idCounter++, new DataResponse(1L, "Item 1", 100));
        dataStore.put(idCounter++, new DataResponse(2L, "Item 2", 200));
        dataStore.put(idCounter++, new DataResponse(3L, "Item 3", 300));
        dataStore.put(idCounter++, new DataResponse(4L, "Item 4", 400));
        dataStore.put(idCounter++, new DataResponse(5L, "Item 5", 500));
    }

    @GetMapping("/{id}")
    public DataResponse getData(@PathVariable Long id) {
        DataResponse dataResponse = dataStore.get(id);
        if (dataResponse == null) {
            throw new RuntimeException("Data not found with ID : " + id);
        }

        return dataResponse;
    }

    @PostMapping
    public DataResponse createData(@RequestBody DataRequest dataRequest) {
        DataResponse newData = DataResponse.builder()
                .id(idCounter)
                .name(dataRequest.getName())
                .value(dataRequest.getValue())
                .build();

        dataStore.put(idCounter, newData);
        idCounter++;

        return newData;
    }

    @PutMapping("/{id}")
    public DataResponse updateDate(@PathVariable("id") Long id, @RequestBody DataRequest dataRequest) {
        DataResponse dataResponse = dataStore.get(id);
        if (dataResponse == null) {
            throw new RuntimeException("Data not found with ID : " + id);
        }

        dataResponse.setName(dataRequest.getName());
        dataResponse.setValue(dataRequest.getValue());
        dataStore.put(id, dataResponse);

        return dataResponse;
    }

    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable("id") Long id) {
        DataResponse removed = dataStore.remove(id);
        if (removed == null) {
            throw new RuntimeException("Data not found with ID : " + id);
        }

        return "Data with ID " + id + " deleted successfully";
    }

}
