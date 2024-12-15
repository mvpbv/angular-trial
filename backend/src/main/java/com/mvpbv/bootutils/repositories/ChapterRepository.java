package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.Chapter;

@Repository
public interface  ChapterRepository extends JpaRepository<Chapter, Long> {
    // Add custom query methods if needed   
    
}
