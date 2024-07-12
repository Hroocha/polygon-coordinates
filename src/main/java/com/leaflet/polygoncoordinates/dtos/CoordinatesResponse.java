package com.leaflet.polygoncoordinates.dtos;

import com.leaflet.polygoncoordinates.entity.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;

public class CoordinatesResponse {
    private final ArrayList<Coordinates> polygonCoordinates;

    public CoordinatesResponse(Coordinates... coordinates) {
        polygonCoordinates = new ArrayList<>();
        polygonCoordinates.addAll(Arrays.asList(coordinates));
    }

    public CoordinatesResponse() {
        polygonCoordinates = new ArrayList<>();
    }

    public void addCoordinates(Coordinates coordinates) {
        polygonCoordinates.add(coordinates);
    }

    public ArrayList<Coordinates> getPolygonCoordinates() {
        return polygonCoordinates;
    }
}
