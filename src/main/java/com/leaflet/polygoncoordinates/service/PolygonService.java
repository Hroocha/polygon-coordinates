package com.leaflet.polygoncoordinates.service;

import com.leaflet.polygoncoordinates.dtos.CoordinatesResponse;

public interface PolygonService {

    CoordinatesResponse getCoordinates(String pageUrl);
}
