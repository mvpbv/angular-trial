package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvpbv.bootutils.models.links.Readme;

public interface ReadmeRepository extends JpaRepository<Readme, String>  {
    
}
