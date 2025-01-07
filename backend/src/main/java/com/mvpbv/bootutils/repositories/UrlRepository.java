package com.mvpbv.bootutils.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.links.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
   @Query("SELECT u FROM Url u WHERE u.domain.id = ?1")
    List<Url> findUrlsByDomainId(int domainId);
   @Query("SELECT u FROM Url u WHERE u.domain.id = ?1 AND u.courseInfo.courseIndex = ?2")
    List<Url> findUrlsByDomainIdAndCourseId(int domainId, int courseId);
}
