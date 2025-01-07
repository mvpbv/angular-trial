package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mvpbv.bootutils.models.links.CourseInfo;

public interface CourseInfoRepository extends JpaRepository<CourseInfo, Integer> {
  CourseInfo findByCourseIndex(int courseIndex);

}
