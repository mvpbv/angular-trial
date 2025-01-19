package com.mvpbv.bootutils.models.reccomendations;

import jakarta.persistence.*;

@Entity
public class Resource {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int resourceId;

  private String resourceTitle;

  private String resourceDescription;

  private String resourceUrl;

  @Embedded
  private String[] keywords;

  private int rank;

  @ManyToOne
  private Audience audience;

  private Era era;



}
