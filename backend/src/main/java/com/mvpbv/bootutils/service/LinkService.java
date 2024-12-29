package com.mvpbv.bootutils.service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mvpbv.bootutils.models.links.Domain;
import com.mvpbv.bootutils.models.links.Url;
import com.mvpbv.bootutils.repositories.DomainRepository;
import com.mvpbv.bootutils.repositories.UrlRepository;

@Service
public class LinkService {
   
    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private UrlRepository urlRepository;

    public List<Domain> findDomains() {
        return domainRepository.findAll(Sort.by(Sort.Direction.DESC, "count"));
    }

    public List<Url> findLinks(int id) {
    Set<Url> urls = urlRepository.findUrlsByDomainId(id).stream().collect(Collectors.toSet());
    return urls.stream().toList();

    }

}
