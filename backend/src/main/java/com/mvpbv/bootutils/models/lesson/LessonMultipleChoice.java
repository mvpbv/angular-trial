package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "lesson_multiple_choice")
@Getter @Setter @NoArgsConstructor
public class LessonMultipleChoice{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Readme")
    @Lob
    @Column(name = "Description", columnDefinition="LONGTEXT")
    private String readme;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @JsonProperty("Question") 
    private Question question;

    @OneToOne(mappedBy = "lessonMultipleChoice")
    private Lesson lesson;

}
