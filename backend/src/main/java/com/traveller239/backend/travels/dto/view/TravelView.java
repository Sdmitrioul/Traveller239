package com.traveller239.backend.travels.dto.view;

import com.traveller239.backend.travels.entities.Currency;
import com.traveller239.backend.travels.entities.Travel;
import com.traveller239.backend.travels.entities.TravelStops;

import java.util.List;

public record TravelView(
        long id,
        String description,
        boolean documents,
        boolean smallParcel,
        boolean bigParcel,
        double cost,
        Currency currency,
        long userId,
        List<TravelStopView> stops
) {
    public static TravelView build(Travel travel) {
        return new TravelView(
                travel.getTravelId(),
                travel.getDescription(),
                travel.isDocuments(),
                travel.isSmallParcel(),
                travel.isBigParcel(),
                travel.getCost(),
                travel.getCurrency(),
                travel.getUser().getId(),
                travel.getTravelStops()
                        .stream()
                        .map(TravelStops::generateView)
                        .toList()
        );
    }
}
