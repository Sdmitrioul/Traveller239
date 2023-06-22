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
            select t.id, t.user_id, t.description, t.documents, t.small_package, t.big_package, t.cost
            from travels t inner join (
                select * 
                from travel_stops its
                where its.position = 0 and its.date > :time
            ) ts on t.id = ts.travel_id
            order by ts.date
            limit :limit
            offset :offset
            """, nativeQuery = true)
    List<Travel> getTravelAfter(LocalDate time, int limit, int offset);
}
