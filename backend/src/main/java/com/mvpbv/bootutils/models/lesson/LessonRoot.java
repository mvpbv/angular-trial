package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvpbv.bootutils.models.Root;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LessonRoot {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long id;
        @JsonProperty("Lesson") 
        public Lesson lesson;
        
        @JsonProperty("LessonDifficulty") 
        public int lessonDifficulty;

        @ManyToOne
        @JoinColumn(name = "root_id")
        @JsonBackReference
        private Root root;
}










