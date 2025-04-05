package com.raiseit.backend.olaServices.dto.response;


import lombok.Data;

import java.util.List;

@Data
public class RowDto {
    private List<ElementDto> elements;
}
