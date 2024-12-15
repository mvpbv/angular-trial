package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvpbv.bootutils.models.Root;

public interface RootRepository extends JpaRepository<Root, Long> {
    // Add custom query methods if needed
}