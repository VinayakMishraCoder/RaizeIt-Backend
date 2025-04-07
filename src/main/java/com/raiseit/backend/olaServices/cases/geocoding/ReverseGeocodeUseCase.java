package com.raiseit.backend.olaServices.cases.geocoding;

import com.raiseit.backend.olaServices.dto.response.ReverseGeocodeResponse;
import com.raiseit.backend.olaServices.restClient.OlaApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * This API converts geographic coordinates back into readable addresses or place names
 * based upon the satisfying criteria with a reasonable probability.
 * */
@Service
@RequiredArgsConstructor
public class ReverseGeocodeUseCase {

    private final OlaApiService olaMapsClient;

    /*
    * latlng :- The coordinates of which you want to do the reverse geocoding to get the address
    * i.e. :- 12.931316595874005,77.61649243443775
    * */
    public ReverseGeocodeResponse execute(String address) {

        Map<String, String> headers = Map.of(
                "X-Request-Id", UUID.randomUUID().toString(),
                "X-Correlation-Id", UUID.randomUUID().toString()
        );

        Map<String, String> queryParams = Map.of(
                "latlng", address
        );

        return olaMapsClient.reverseGeocode(headers, queryParams);
    }
}
