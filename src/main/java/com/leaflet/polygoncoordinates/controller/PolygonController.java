package com.leaflet.polygoncoordinates.controller;

import com.leaflet.polygoncoordinates.dtos.CoordinatesResponse;
import com.leaflet.polygoncoordinates.entity.Coordinates;
import com.leaflet.polygoncoordinates.service.PolygonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PolygonController {

    private final PolygonService polygonService;

    @GetMapping("/map/polygon")
    public ResponseEntity<?> getPolygonCoordinates(@RequestParam(value = "url") String pageUrl) {
        CoordinatesResponse coordinates = polygonService.getCoordinates(pageUrl);
        for (Coordinates c : coordinates.getPolygonCoordinates()) {
//            log.info(String.valueOf(c));
            System.out.println(c);
        }
        return ResponseEntity.ok(coordinates);
    }

}
