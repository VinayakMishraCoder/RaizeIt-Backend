package com.raiseit.backend.olaServices.dto.response;


import lombok.Data;

@Data
public class ElementDto {
    private int duration;
    private int distance;
    private String polyline;
    private String status;
}
