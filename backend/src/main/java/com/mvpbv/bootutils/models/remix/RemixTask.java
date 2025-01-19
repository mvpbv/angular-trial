package com.mvpbv.bootutils.models.remix;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class RemixTask {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int taskId;

  private String taskTitle;

  private String taskDescription;

  @ManyToOne
  private RemixLesson remixLesson;





}
