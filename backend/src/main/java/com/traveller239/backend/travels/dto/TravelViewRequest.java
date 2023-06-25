package com.traveller239.backend.travels.dto;

import com.traveller239.backend.auth.user.User;
import com.traveller239.backend.travels.dto.view.TravelStopView;
import com.traveller239.backend.travels.entities.Currency;
import com.traveller239.backend.travels.entities.Travel;
import com.traveller239.backend.travels.entities.TravelStops;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelViewRequest {
    private String description;
    private boolean documents;
    private boolean smallParcel;
    private boolean bigParcel;
    private double cost;
    private Currency currency;
    private List<TravelStopView> stops;

    public Travel generateTravel(final User user) {
        return Travel.builder()
                .user(user)
                .travelStops(Collections.emptyList())
                .description(description)
                .documents(documents)
                .smallParcel(smallParcel)
                .bigParcel(bigParcel)
                .cost(cost)
                .currency(currency)
                .build();
    }

    public List<TravelStops> getStops(final Travel travel) {
        return getStops()
                .stream()
                .map(stop -> stop.generateStop(travel))
                .toList();
    }
}
