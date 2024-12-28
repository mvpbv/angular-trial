package com.mvpbv.bootutils.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.analytics.Domain;



@Repository
public interface DomainRepository extends JpaRepository<Domain, Long> {
    @Query(value = "SELECT * FROM domain WHERE domain = ?1", nativeQuery = true)
    Optional<Domain> findByDomain(String domain);
}