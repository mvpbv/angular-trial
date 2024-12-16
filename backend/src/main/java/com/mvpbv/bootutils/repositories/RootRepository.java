package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.course.CourseRoot;

@Repository
public interface RootRepository extends JpaRepository<CourseRoot, Long> {
    // Add custom query methods if needed
}