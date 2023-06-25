package com.traveller239.backend.travels;

import com.traveller239.backend.auth.user.User;
import com.traveller239.backend.travels.dto.TravelViewRequest;
import com.traveller239.backend.travels.dto.TravelsResponse;
import com.traveller239.backend.travels.dto.view.TravelView;
import com.traveller239.backend.travels.entities.Travel;
import com.traveller239.backend.travels.entities.TravelStops;
import com.traveller239.backend.travels.repositories.TravelStopsRepository;
import com.traveller239.backend.travels.repositories.TravelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelService {
    private final TravelsRepository travelsRepository;
    private final TravelStopsRepository stopsRepository;
    private final Clock clock;

    public TravelsResponse getPages(int page, int size) {
        int offset = page * size;

        return TravelsResponse
                .builder()
                .travels(
                        travelsRepository
                                .getTravelsAfter(
                                        LocalDate.now(clock),
                                        size,
                                        offset)
                                .stream()
                                .map(Travel::generateView)
                                .toList())
                .offset(offset)
                .build();
    }

    public TravelView createTravel(TravelViewRequest view) {
        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final Travel savedTravel = travelsRepository.save(view.generateTravel(user));
        final List<TravelStops> savedStops = stopsRepository.saveAll(view.getStops(savedTravel));
        savedTravel.setTravelStops(savedStops);
        return savedTravel.generateView();
    }

    public List<TravelView> findTravels(LocalDate arrivalDate, String fromCity, String toCity) {
        final List<Travel> travels;
        if (arrivalDate != null) {
            travels = travelsRepository.findTravels(LocalDate.now(clock), arrivalDate, fromCity, toCity);
        } else {
            travels = travelsRepository.findTravels(LocalDate.now(clock), fromCity, toCity);
        }

        return travels
                .stream()
                .map(Travel::generateView)
                .toList();
    }
}
