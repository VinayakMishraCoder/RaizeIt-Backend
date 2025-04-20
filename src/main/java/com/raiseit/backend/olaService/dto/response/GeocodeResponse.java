package com.raiseit.backend.olaService.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class GeocodeResponse {
    private String status;
    private List<GeocodingResult> geocodingResults;

    @Data
    public static class GeocodingResult {
        private String formatted_address;
        private String name;
        private Geometry geometry;
    }

    @Data
    public static class Geometry {
        private Location location;
    }

    @Data
    public static class Location {
        private double lat;
        private double lng;
    }
}
