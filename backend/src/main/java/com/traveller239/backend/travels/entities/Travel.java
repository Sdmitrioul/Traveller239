package com.traveller239.backend.travels.entities;

import com.traveller239.backend.auth.user.User;
import com.traveller239.backend.travels.dto.view.TravelView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long travelId;

    @Column(nullable = false, length = 1024)
    private String description;

    private boolean documents;

    @Column(nullable = false, name = "small_package")
    private boolean smallParcel;

    @Column(nullable = false, name = "big_package")
    private boolean bigParcel;

    @Column(nullable = false, precision = 2)
    private double cost;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(mappedBy = "travel", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<TravelStops> travelStops;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public TravelView generateView() {
        return TravelView.build(this);
    }
}
