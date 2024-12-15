package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.Alternatives;



@Repository
public interface OptionalLessonsRepository extends JpaRepository<Alternatives, Long> {
    // Add custom query methods if needed
}