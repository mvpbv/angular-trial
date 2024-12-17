package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "question")
@Getter @Setter @NoArgsConstructor
public class Question{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Question") 
    public String question;

    @JsonProperty("Answers") 
    @ElementCollection
    public List<String> answers;

    @JsonProperty("Answer") 
    public String answer;
    
    @JsonProperty("ContainsCompleteDir") 
    public boolean containsCompleteDir;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private LessonMultipleChoice lessonDataMultipleChoice;    
}
