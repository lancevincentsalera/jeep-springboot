package com.example.JeepCodesAPI.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;;

@Entity
@Table(name = "jeepcode")
public class JeepCode {
    @Id
    @javax.validation.constraints.Pattern(regexp = "\\d{2}[A-Z]", message = "Invalid jeep code")
    private String code;

    @ManyToMany
    @JoinTable(
        name = "jeepcode_place",
        joinColumns = @JoinColumn(name = "code"),
        inverseJoinColumns = @JoinColumn(name = "place_name")
    )
    private List<Place> places;

    public String getCode() {
        return code;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    
}
