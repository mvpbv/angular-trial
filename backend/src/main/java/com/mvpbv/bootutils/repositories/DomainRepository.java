package com.mvpbv.bootutils.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.links.Domain;



@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {
    @Query(value = "SELECT * FROM domain WHERE domain = ?1", nativeQuery = true)
    Optional<Domain> findByDomain(String domain);
    @Query(value = "SELECT d FROM Domain d JOIN d.courseInfos ci WHERE ci.courseIndex = ?1")
    List<Domain> findDomainsByCourseIndex(int courseIndex);
}
