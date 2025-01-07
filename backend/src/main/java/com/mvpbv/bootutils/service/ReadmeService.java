package com.mvpbv.bootutils.service;

import com.mvpbv.bootutils.dto.ReadmeDTO;
import com.mvpbv.bootutils.models.links.*;
import com.mvpbv.bootutils.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class ReadmeService {

  @Autowired
  private TrackInfoRepository trackInfoRepository;
  @Autowired
  private CourseInfoRepository courseInfoRepository;
  @Autowired
  private LessonRepository lessonRepository;
  @Autowired
  private ReadmeRepository readmeRepository;
  @Autowired
  private ReadmeHelper readmeHelper;
  @Autowired
  private DomainRepository domainRepository;
  @Autowired
  private UrlRepository urlRepository;

  public void seedCourseInfo() {
    List<TrackInfo> tracks = readmeHelper.buildTrackInfo();
    List<CourseInfo> courses = readmeHelper.buildCourseInfo();

    trackInfoRepository.saveAll(tracks);
    courseInfoRepository.saveAll(courses);
  }
  public CourseInfo getCourseInfo(String courseSlug) {
    var courseIndex = readmeHelper.buildInfoSlug(courseSlug);
    return courseInfoRepository.findByCourseIndex(courseIndex);
  }
  public void seedReadme() {
    List<Supplier<List<ReadmeDTO>>> methods = List.of(
      lessonRepository::getDescriptionCLI,
      lessonRepository::getDescriptionGithub,
      lessonRepository::getDescriptionHttpTests,
      lessonRepository::getDescriptionMultipleChoice,
      lessonRepository::getDescriptionOutput,
      lessonRepository::getDescriptionTests,
      lessonRepository::getDescriptionSQL,
      lessonRepository::getDescriptionTextInput,
      lessonRepository::getDescriptionManual
    );
    List<Readme> readmes = new ArrayList<>();
    methods.forEach(method -> {
      method.get().forEach(readmeDTO -> {
        var courseSlug = readmeDTO.getCourseSlug();
        var courseInfo = getCourseInfo(courseSlug);
        var temp = new Readme(readmeDTO, courseInfo);
        temp.setUrls(readmeHelper.parseUrls(temp));
        readmes.add(temp);
      });
    });
    readmeRepository.saveAll(readmes);
  }
  public void seedDomains() {
    List<Url> urls = new ArrayList<>();
    List<Domain> newDomains = new ArrayList<>();
    Map<String, Domain> domainCache = new HashMap<>();
    Map<String, Integer> domainCounts = new HashMap<>();
    Map<String, Set<CourseInfo>> domainCourses = new HashMap<>();

    urlRepository.findAll().forEach(url -> {
      var temp = readmeHelper.parseDomain(url.getUrl());
      var domain = domainCache.computeIfAbsent(temp, key -> {
        var newDomain = new Domain(temp);
        newDomains.add(newDomain);
        return newDomain;
      });
      url.setDomain(domain);
      urls.add(url);
      domainCounts.put(temp, domainCounts.getOrDefault(temp, 0) + 1);
      domainCourses.computeIfAbsent(temp, key -> new HashSet<>()).add(url.getCourseInfo());
    });
    newDomains.forEach(domain -> {
      domain.setCount(domainCounts.get(domain.getDomain()));
      domain.setCourseInfos(domainCourses.get(domain.getDomain()));
    });
    domainRepository.saveAll(newDomains);
    urlRepository.saveAll(urls);
  }



}
