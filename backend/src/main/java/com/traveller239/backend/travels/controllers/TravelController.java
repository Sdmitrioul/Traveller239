package com.traveller239.backend.travels.controllers;

import com.traveller239.backend.travels.TravelService;
import com.traveller239.backend.travels.dto.TravelViewRequest;
import com.traveller239.backend.travels.dto.TravelsResponse;
import com.traveller239.backend.travels.dto.view.TravelView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/travels")
@RequiredArgsConstructor
public class TravelController {
    private final TravelService service;

    @GetMapping("")
    public ResponseEntity<TravelsResponse> getTravels(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size
    ) {
        return ResponseEntity.ok(service.getPages(page, size));
    }

    @PostMapping("/create")
    public ResponseEntity<TravelView> createTravel(
            @Validated @RequestBody TravelViewRequest view
    ) {
        var saved = service.createTravel(view);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/search")
    public ResponseEntity<List<TravelView>> searchTravels(
            @RequestParam String fromCity,
            @RequestParam String toCity,
            @RequestParam(required = false) LocalDate arrivalDate
    ) {
        return ResponseEntity.ok(service.findTravels(arrivalDate, fromCity, toCity));
    }
}
