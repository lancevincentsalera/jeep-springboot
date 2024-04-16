package com.example.JeepCodesAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.JeepCodesAPI.model.*;
import com.example.JeepCodesAPI.repository.JeepCodeRepository;
import java.util.List;

@Service
public class JeepCodeService {
    @Autowired
    private JeepCodeRepository jeepCodeRepository;

    public List<Place> getPlacesByJeepCode(String code) {
        return jeepCodeRepository.findById(code).get().getPlaces();

    }

    public JeepCode addJeepCode(JeepCode jeepCode) {
        return jeepCodeRepository.save(jeepCode);
    }

    public List<JeepCode> getAllJeepCodes() {
        return jeepCodeRepository.findAll();
    }

    public JeepCode addPlaceToJeepCode(String code, Place place) {
        JeepCode jeepCode = jeepCodeRepository.findById(code).get();
        jeepCode.getPlaces().add(place);
        return jeepCodeRepository.save(jeepCode);
    }

    public JeepCode deletePlaceFromJeepCode(String code, Place place) {
        JeepCode jeepCode = jeepCodeRepository.findById(code).get();
        jeepCode.getPlaces().removeIf(p -> p.getName().equals(place.getName()));
        return jeepCodeRepository.save(jeepCode);
    }
}
