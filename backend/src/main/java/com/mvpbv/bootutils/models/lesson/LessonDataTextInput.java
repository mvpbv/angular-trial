package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lesson_data_text_input")
@Getter @Setter @NoArgsConstructor
public class LessonDataTextInput{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Readme") 
    public String readme;

    @JsonProperty("TextInputData") 
    @Embedded
    public TextInputData textInputData;
    
    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
