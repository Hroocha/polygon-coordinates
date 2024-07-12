package com.leaflet.polygoncoordinates.service;

import com.leaflet.polygoncoordinates.dtos.CoordinatesResponse;
import com.leaflet.polygoncoordinates.entity.Coordinates;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PolygonServiceImpl implements PolygonService {

    public CoordinatesResponse getCoordinates(String pageUrl) {
        CoordinatesResponse coordinatesResponse = new CoordinatesResponse();
        try {
            Document document = Jsoup.connect(pageUrl).get();
            Element scriptElement = document.body();
            String scriptText = scriptElement.html();

            List<Double> numbers = new ArrayList<>();

            String word = "var polygon";
            scriptText = trimString(scriptText, word);

            Pattern pattern = Pattern.compile("-?\\d+\\.\\d+");
            Matcher matcher = pattern.matcher(scriptText);

            while (matcher.find()) {
                numbers.add(Double.parseDouble(matcher.group()));
            }

            for (int i = 0; i < numbers.size(); i++) {
                Coordinates coordinates = new Coordinates(numbers.get(i), numbers.get(++i));
                coordinatesResponse.addCoordinates(coordinates);
            }

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return coordinatesResponse;
    }

    private String trimString(String inputString, String word) {
        int index = inputString.indexOf(word);
        if (index != -1) {
            return inputString.substring(index + word.length());
        }
        return inputString;
    }
}
