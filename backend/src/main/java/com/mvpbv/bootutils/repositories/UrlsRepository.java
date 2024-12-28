package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.analytics.Urls;

@Repository
public interface UrlsRepository extends JpaRepository<Urls, Long> {
    
}
