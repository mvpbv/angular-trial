package com.mvpbv.bootutils.models.reccomendations;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Audience {

  @OneToMany
  private Resource[] resources;

  private String audienceName;

  private String audienceDescription;



}
