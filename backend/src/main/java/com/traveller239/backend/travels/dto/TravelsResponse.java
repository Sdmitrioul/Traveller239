package com.traveller239.backend.travels.dto;

import com.traveller239.backend.travels.dto.view.TravelView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TravelsResponse {
    private List<TravelView> travels;

    private int offset;
}
