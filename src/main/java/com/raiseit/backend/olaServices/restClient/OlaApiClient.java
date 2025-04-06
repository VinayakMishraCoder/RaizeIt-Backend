package com.raiseit.backend.olaServices.restClient;

import com.raiseit.backend.olaServices.dto.response.GeocodeResponse;
import com.raiseit.backend.utils.RestApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class OlaApiClient {

    final String BASE_URL =  "https://api.olamaps.io";

    @Value("${ola.api.key}")
    public static String API_KEY;

    private final RestApiClient restApiClient;

    public GeocodeResponse forwardGeocode(Map<String, String> headers, Map<String, String> queryParams) {
        return restApiClient.get(
                BASE_URL,
                "/places/v1/geocode",
                headers,
                queryParams,
                GeocodeResponse.class
        );
    }
}
