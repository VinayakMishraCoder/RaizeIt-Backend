package com.raiseit.backend.olaServices.cases.routing;


import com.raiseit.backend.olaServices.dto.request.DistanceMatrixRequestDto;
import com.raiseit.backend.olaServices.dto.response.DistanceMatrixResponseDto;
import com.raiseit.backend.olaServices.restClient.OlaApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistanceMatrixCase {

    @Autowired
    private OlaApiClient olaApiClient;

    public DistanceMatrixResponseDto fetchDistanceMatrix(String origins, String destinations, String mode) {
        DistanceMatrixRequestDto requestDto = new DistanceMatrixRequestDto(origins, destinations, mode);
        return olaApiClient.getDistanceMatrix(requestDto);
    }
}
