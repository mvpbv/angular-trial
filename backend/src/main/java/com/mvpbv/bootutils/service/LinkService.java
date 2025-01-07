package com.mvpbv.bootutils.service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mvpbv.bootutils.models.links.CourseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mvpbv.bootutils.models.links.Domain;
import com.mvpbv.bootutils.models.links.Url;
import com.mvpbv.bootutils.repositories.DomainRepository;
import com.mvpbv.bootutils.repositories.UrlRepository;
import com.mvpbv.bootutils.repositories.CourseInfoRepository;

@Service
public class LinkService {

    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private UrlRepository urlRepository;
    @Autowired
    private CourseInfoRepository courseInfoRepository;

    public List<Domain> findDomains(int courseIndex) {
      return domainRepository.findDomainsByCourseIndex(courseIndex);
    }

    public List<Url> findLinks(int course_id) {
    Set<Url> urls = new HashSet<>(urlRepository.findUrlsByDomainId(course_id));
    return urls.stream().toList();
    }
    public List<Url> findLinks(int domainId, int courseId) {
        return urlRepository.findUrlsByDomainIdAndCourseId(domainId, courseId);
    }


    public List<CourseInfo> findCourses() {
        return courseInfoRepository.findAll();
    }

}
