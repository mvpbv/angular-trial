package com.mvpbv.bootutils.models.reccomendations;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.mvpbv.bootutils.models.links.CourseInfo;


public class Era {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int eraId;

  private String eraName;

  private String eraDescription;

  @OneToMany
  private CourseInfo[] courseInfos;


}
