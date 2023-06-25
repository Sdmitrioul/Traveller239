package com.traveller239.backend.travels.repositories;

import com.traveller239.backend.travels.entities.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TravelsRepository extends JpaRepository<Travel, Long> {
    @Query(value = "select t from Travel t where t.user.id = :userId")
    List<Travel> findByUser(long userId);

    @Query(value = """
            select t.id, t.user_id, t.description, t.documents, t.small_package, t.big_package, t.cost, t.currency
            from travels t inner join (
                select *
                from travel_stops its
                where its.position = 0 and its.date > :time
            ) ts on t.id = ts.travel_id
            order by ts.date
            limit :limit
            offset :offset
            """, nativeQuery = true)
    List<Travel> getTravelsAfter(LocalDate time, int limit, int offset);

    @Query(value = """
            select *
            from travels t
            where t.id  in (
                select s1.travel_id
                from travel_stops s1
                    inner join travel_stops s2
                        on s1.travel_id = s2.travel_id
                            and s1.position < s2.position
                where s1.city = :fromCity
                        and s2.city = :toCity
                        and s1.date > :fromDate
                        and s2.date < :arrivalDate
            )
            """, nativeQuery = true)
    List<Travel> findTravels(LocalDate fromDate, LocalDate arrivalDate, String fromCity, String toCity);

    @Query(value = """
            select *
            from travels t
            where t.id  in (
                select s1.travel_id
                from travel_stops s1
                    inner join travel_stops s2
                        on s1.travel_id = s2.travel_id
                            and s1.position < s2.position
                where s1.city = :fromCity
                        and s2.city = :toCity
                        and s1.date > :fromDate
            )
            """, nativeQuery = true)
    List<Travel> findTravels(LocalDate fromDate, String fromCity, String toCity);
}
