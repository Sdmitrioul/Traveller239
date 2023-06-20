package com.traveller239.backend.travels.entities;

import com.traveller239.backend.auth.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travels")
public class Travel {
    @Id
    @GeneratedValue
    @Column(name = "travel_id")
    private Long travelId;

    @Column(nullable = false, length = 1024)
    private String description;

    private boolean documents;

    @Column(nullable = false, name = "small_parcel")
    private boolean smallParcel;

    @Column(nullable = false, name = "big_parcel")
    private boolean bigParcel;

    @Column(nullable = false, precision = 2)
    private double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "travel")
    private Set<TravelStops> travelStops;
}
