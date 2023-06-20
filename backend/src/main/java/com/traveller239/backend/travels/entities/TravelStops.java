package com.traveller239.backend.travels.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travel_stops")
@IdClass(value = TravelStopsId.class)
public class TravelStops {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "travel_id", nullable = false)
    private Travel travel;

    @Id
    private int position;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String city;
}
