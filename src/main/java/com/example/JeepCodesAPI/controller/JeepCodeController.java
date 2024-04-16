package com.example.JeepCodesAPI.controller;

import com.example.JeepCodesAPI.model.*;
import com.example.JeepCodesAPI.service.JeepCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jeepcodes")
@CrossOrigin
public class JeepCodeController {
    @Autowired
    private JeepCodeService jeepCodeService;

    @GetMapping("/{code}")
    public ResponseEntity<List<Place>> getPlacesByJeepCode(@PathVariable String code) {
        List<Place> places = jeepCodeService.getPlacesByJeepCode(code);
        return new ResponseEntity<>(places, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JeepCode> addJeepCode(@RequestBody JeepCode jeepCode) {
        JeepCode newJeepCode = jeepCodeService.addJeepCode(jeepCode);
        return new ResponseEntity<>(newJeepCode, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JeepCode>> getAllRoutes() {
        List<JeepCode> allJeepCodes = jeepCodeService.getAllJeepCodes();
        return new ResponseEntity<>(allJeepCodes, HttpStatus.OK);
    }

    @GetMapping("/multiple")
    public ResponseEntity<Map<String, List<Place>>> getMultipleJeepRoutesByCode(@RequestParam List<String> codes) {
        Map<String, List<Place>> jeepCodesPlaces = new HashMap<>();
        for (String code : codes) {
            List<Place> places = jeepCodeService.getPlacesByJeepCode(code);
            jeepCodesPlaces.put(code, places);
        }
        return new ResponseEntity<>(jeepCodesPlaces, HttpStatus.OK);
    }

    @PostMapping("/{code}/addPlace")
    public ResponseEntity<JeepCode> addPlaceToJeepCode(@PathVariable String code, @RequestBody Place place) {
        JeepCode updatedJeepCode = jeepCodeService.addPlaceToJeepCode(code, place);
        return new ResponseEntity<>(updatedJeepCode, HttpStatus.OK);
    }

    @DeleteMapping("/{code}/deletePlace")
    public ResponseEntity<JeepCode> deletePlaceFromJeepCode(@PathVariable String code, @RequestBody Place place) {
        JeepCode updatedJeepCode = jeepCodeService.deletePlaceFromJeepCode(code, place);
        return new ResponseEntity<>(updatedJeepCode, HttpStatus.OK);
    }
}
