package com.raiseit.backend.olaServices.cases.distanceMatrix;

import com.raiseit.backend.olaServices.dto.response.DistanceMatrixResponse;
import com.raiseit.backend.olaServices.restClient.OlaApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Provides distance and ETA between different origin and destination points.
 * If there are "x" number of origins and "y" number of destinations, the resultant output has "x*y" number of combinations.
 * The origin and destination locations are pipe-separated.
 *
 *
 * origins : string (query)
 * Pipe separated origin coordinates in the format lat1,lng1|lat2,lng2 e.g: 28.71866756826579,77.03699668376802|28.638555357785652,76.96550156007675
 *
 * destinations : string (query)
 * Pipe separated destination coordinates in the format lat1,lng1|lat2,lng2 e.g: 28.638555357785652,76.96550156007675|28.53966907108812,77.05190669909288
 * */
@Service
@RequiredArgsConstructor
public class DistanceMatrixUseCase {

    @Autowired
    private OlaApiService olaApiService;

    public DistanceMatrixResponse execute(String origins, String destinations) {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("origins", origins);
        queryParams.put("destinations", destinations);
        queryParams.put("mode", "driving");

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");

        return olaApiService.getDistanceMatrixResponse(headers, queryParams);
    }
}
