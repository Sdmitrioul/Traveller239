package com.traveller239.backend.travels;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelStopsId implements Serializable {
    private Travel travel;

    private int position;
}
