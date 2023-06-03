package com.example.liveasydemo.controller;

import com.example.liveasydemo.model.Load;
import com.example.liveasydemo.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loads")
public class LoadController {
    // LoadController class is used to handle all the requests related to Load entity
    private final LoadRepository loadRepository;

    @Autowired
    public LoadController(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    // This method is used to create a new load and maps to the POST request
    @PostMapping("/load")
    public ResponseEntity<String> createLoad(@RequestBody Load load) {
        loadRepository.save(load);

        // Return the response with status code 201
        return ResponseEntity.status(HttpStatus.CREATED).body("Load details added successfully");
    }

    // This method is used to get all the loads of a particular shipper and maps to the GET request
    @GetMapping("/load")
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam("shipperId") String shipperId) {
        // Convert the string shipperId to UUID
        UUID shipperID = UUID.fromString(shipperId);

        // Get all the loads of the shipper with the given shipperId
        List<Load> loads = loadRepository.findAllByShipperId(shipperID);

        // Return the list of loads with the given shipperId with status code 200
        return ResponseEntity.ok(loads);
    }

    // This method is used to get all the loads using loadid and maps to the GET request
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable("loadId") Long loadId) {
        // Get the load with the given loadId
        Load load = loadRepository.findById(loadId).orElse(null);

        // If the load is present then return the load with status code 200 else return 404
        if (load != null) {
            return ResponseEntity.ok(load);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // This method is used to update the details of a particular load and maps to the PUT request
    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoadById(@PathVariable("loadId") Long loadId, @RequestBody Load updatedLoad) {
        // Get the load with the given loadId
        Load load = loadRepository.findById(loadId).orElse(null);

        // If the load is present then update the details of the load and return 200 else return 404
        if (load != null) {
            load.setLoadingPoint(updatedLoad.getLoadingPoint());
            load.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            load.setProductType(updatedLoad.getProductType());
            load.setTruckType(updatedLoad.getTruckType());
            load.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            load.setWeight(updatedLoad.getWeight());
            load.setComment(updatedLoad.getComment());
            load.setDate(updatedLoad.getDate());
            loadRepository.save(load);
            return ResponseEntity.ok("Load updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // This method is used to delete a particular load and maps to the DELETE request
    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoadById(@PathVariable("loadId") Long loadId) {
        // Get the load with the given loadId
        Load load = loadRepository.findById(loadId).orElse(null);

        // If the load is present then delete the load and return 200 else return 404
        if (load != null) {
            loadRepository.delete(load);
            return ResponseEntity.ok("Load deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
