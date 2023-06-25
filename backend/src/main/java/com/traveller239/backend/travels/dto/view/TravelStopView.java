package com.traveller239.backend.travels.dto.view;

import com.traveller239.backend.travels.entities.Travel;
import com.traveller239.backend.travels.entities.TravelStops;

import java.util.Date;

public record TravelStopView(int position, Date date, String city) {
    public static TravelStopView build(TravelStops stop) {
        return new TravelStopView(stop.getPosition(), stop.getDate(), stop.getCity());
    }

    public TravelStops generateStop(Travel travel) {
        return TravelStops
                .builder()
                .travel(travel)
                .position(position)
                .date(date)
                .city(city)
                .build();
    }
}
