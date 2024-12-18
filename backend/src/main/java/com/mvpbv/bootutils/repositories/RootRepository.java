package com.mvpbv.bootutils.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.Root;

@Repository
public interface RootRepository extends JpaRepository<Root, Long> {
   @Query(value = "SELECT uuid FROM chapter_optional_lessons", nativeQuery = true) 
   List<String> getOptUuids();
   @Query(value = "SELECT uuid FROM chapter_required_lessons", nativeQuery = true)
   List<String> getReqUuids();
}