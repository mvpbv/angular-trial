package com.mvpbv.bootutils.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.analytics.CodeChallenge;

@Repository
public interface CodeChallengeRepository extends JpaRepository<CodeChallenge, String> {
    
    @Query("SELECT a FROM CodeChallenge a WHERE a.trackName = 'CS Fundamentals' AND a.courseName IN ('Learn Python','Object Oriented Programming', 'Functional Programming')")
    List<CodeChallenge> findPrimaryLessons();


}