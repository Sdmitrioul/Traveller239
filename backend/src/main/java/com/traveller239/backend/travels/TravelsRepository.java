package com.traveller239.backend.travels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TravelsRepository extends JpaRepository<Travel, Long> {
    @Query(value = "select t from Travel t where t.user.id = :userId")
    List<Travel> findByUser(long userId);
}
