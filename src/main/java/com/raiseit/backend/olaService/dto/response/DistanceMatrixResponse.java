package com.raiseit.backend.olaService.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class DistanceMatrixResponse {
    private List<Row> rows;

    @Data
    public static class Row {
        private List<Element> elements;
    }

    @Data
    public static class Element {
        private int duration;
        private int distance;
        private String polyline;
        private String status;
    }
}
