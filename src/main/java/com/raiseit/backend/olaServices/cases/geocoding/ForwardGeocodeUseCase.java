package com.raiseit.backend.olaServices.cases.geocoding;

import com.raiseit.backend.olaServices.dto.response.GeocodeResponse;
import com.raiseit.backend.olaServices.restClient.OlaApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ForwardGeocodeUseCase {

    private final OlaApiClient olamapsClient;

    public GeocodeResponse execute(String address) {

        Map<String, String> headers = Map.of(
                "X-Request-Id", UUID.randomUUID().toString(),
                "X-Correlation-Id", UUID.randomUUID().toString()
        );

        Map<String, String> queryParams = Map.of(
                "address", address,
                "language", "English",
                "api_key", OlaApiClient.API_KEY
        );

        return olamapsClient.forwardGeocode(headers, queryParams);
    }
}
