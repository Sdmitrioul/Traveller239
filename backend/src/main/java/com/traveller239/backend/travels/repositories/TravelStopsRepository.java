package com.traveller239.backend.travels.repositories;

import com.traveller239.backend.travels.entities.TravelStops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface TravelStopsRepository extends JpaRepository<TravelStops, Long> {
    @Query(value = """
            select st 
            from TravelStops st
            where  st.travel.travelId in :travelIds
            """)
    List<TravelStops> findAllByTravelIds(Set<Long> travelIds);
}
