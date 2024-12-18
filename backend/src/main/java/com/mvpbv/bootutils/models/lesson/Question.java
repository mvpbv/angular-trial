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


@Entity
@Table(name = "question")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isContainsCompleteDir() {
        return containsCompleteDir;
    }

    public void setContainsCompleteDir(boolean containsCompleteDir) {
        this.containsCompleteDir = containsCompleteDir;
    }

    public LessonMultipleChoice getLessonDataMultipleChoice() {
        return lessonDataMultipleChoice;
    }

    public void setLessonDataMultipleChoice(LessonMultipleChoice lessonDataMultipleChoice) {
        this.lessonDataMultipleChoice = lessonDataMultipleChoice;
    }
}
