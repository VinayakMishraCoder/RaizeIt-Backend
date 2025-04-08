package com.raiseit.backend.olaServices.cases.geocoding;

import com.raiseit.backend.olaServices.dto.response.GeocodeResponse;
import com.raiseit.backend.olaServices.restClient.OlaApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * Provides probable geographic coordinates and detailed
 * location information including formatted address for the given address as input.
 * */
@Service
@RequiredArgsConstructor
public class ForwardGeocodeUseCase {

    @Autowired
    private OlaApiService olaMapsService;

    public GeocodeResponse execute(String address) {

        Map<String, String> headers = Map.of(
                "X-Request-Id", UUID.randomUUID().toString(),
                "X-Correlation-Id", UUID.randomUUID().toString()
        );

        Map<String, String> queryParams = new HashMap<>( // important to keep it mutable, so can add api key.
                Map.of(
                        "address", address,
                        "language", "English"
                )
        );

        return olaMapsService.forwardGeocode(headers, queryParams);
    }
}
