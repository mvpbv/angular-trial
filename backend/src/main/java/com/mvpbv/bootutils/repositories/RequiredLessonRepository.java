package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.Alternatives;



@Repository
public interface RequiredLessonRepository extends JpaRepository<Alternatives, Long> {

}