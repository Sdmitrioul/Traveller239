package com.traveller239.backend.travels.repositories;

import com.traveller239.backend.travels.entities.TravelStops;
import com.traveller239.backend.travels.entities.TravelStopsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelStopsRepository extends JpaRepository<TravelStops, TravelStopsId> {
}
