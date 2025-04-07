package com.raiseit.backend.olaServices.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class ReverseGeocodeResponse {
    private String error_message;
    private List<String> info_messages;
    private List<Result> results;
    private PlusCode plus_code;
    private String status;

    @Data
    public static class Result {
        private String formatted_address;
        private String types;
        private String name;
        private Geometry geometry;
        private List<AddressComponent> address_components;
        private PlusCode plus_code;
        private String place_id;
        private List<String> layer;
    }

    @Data
    public static class Geometry {
        private Viewport viewport;
        private Location location;
        private String location_type;
    }

    @Data
    public static class Viewport {
        private Coordinate southwest;
        private Coordinate northeast;
    }

    @Data
    public static class Coordinate {
        private double lat;
        private double lng;
    }

    @Data
    public static class Location {
        private double lat;
        private double lng;
    }

    @Data
    public static class AddressComponent {
        private List<String> types;
        private String short_name;
        private String long_name;
    }

    @Data
    public static class PlusCode {
        private String compound_code;
        private String global_code;
    }
}
