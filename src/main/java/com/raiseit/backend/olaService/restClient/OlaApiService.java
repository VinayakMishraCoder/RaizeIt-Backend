package com.raiseit.backend.olaService.restClient;

import com.raiseit.backend.olaService.dto.response.DistanceMatrixResponse;
import com.raiseit.backend.olaService.dto.response.GeocodeResponse;
import com.raiseit.backend.olaService.dto.response.ReverseGeocodeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class OlaApiService {

    final String BASE_URL =  "https://api.olamaps.io";

    @Value("${ola.api.key}")
    public String API_KEY;

    @Autowired
    private RestApiClient restApiClient;

    public GeocodeResponse forwardGeocode(Map<String, String> headers, Map<String, String> queryParams) {
        queryParams.put("api_key", API_KEY);
        return restApiClient.get(
                BASE_URL,
                "/places/v1/geocode",
                headers,
                queryParams,
                GeocodeResponse.class
        );
    }

    public ReverseGeocodeResponse reverseGeocode(Map<String, String> headers, Map<String, String> queryParams) {
        queryParams.put("api_key", API_KEY);
        return restApiClient.get(
                BASE_URL,
                "/places/v1/reverse-geocode",
                headers,
                queryParams,
                ReverseGeocodeResponse.class
        );
    }

    public DistanceMatrixResponse getDistanceMatrixResponse(Map<String, String> headers, Map<String, String> queryParams) {
        queryParams.put("api_key", API_KEY);
        return restApiClient.get(
                BASE_URL,
                "/routing/v1/distanceMatrix",
                headers,
                queryParams,
                DistanceMatrixResponse.class
        );
    }
}
