import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AnalyticsService } from '../analytics.service';
import { CommonModule } from '@angular/common';
import { analyticsLesson } from '../models/hotspot.model';

@Component({
  imports: [CommonModule, FormsModule],
  template: `
  <label for="courseSelect">Select a course:</label>
  <select id="courseSelect" [(ngModel)] = "selectedCourse" (change)="onCourseChange($event)">
    @for (course of courses; track courses) {
    <option [value]="course">{{ course }}</option>
    }
  </select>
  
  <label for="trackSelect">Select a track:</label>
  <select id="trackSelect" [(ngModel)] = "selectedTrack" (change)="onTrackChange($event)">
    @for (track of tracks; track track) {
    <option [value]="track">{{ track }}</option>
    }
  </select>
  <label for="typeSelect">Select a type:</label>
  <select id="typeSelect" [(ngModel)] = "selectedType" (change)="onTypeChange($event)">
    @for (type of types; track types) {
      <option [value]="type">{{ types }}</option>
    }
  </select>
  @for (item of lessons; track lessons) {
  <div class="lesson"> 
    <p> {{ item.Title }} </p>
    <p> {{ item.CourseName }}</p>
    <p> {{ item.ChapterName }}</p>
    <p> {{ item.Difficulty }}</p>
    <p> {{ item.Radix }}</p>
    <a href="https://boot.dev/lessons/{{item.UUID}}">Go To Lesson</a>
  </div>
  }
`,
  styleUrl: './analytics.component.css'
})
export class AnalyticsComponent implements OnInit{
  
  lessons: analyticsLesson[] = [];
  courses: string[] = [];
  tracks: string[] = [];
  types: string[] = [];
  selectedCourse: string = '';
  selectedTrack: string = '';
  selectedType: string = '';

  constructor(private analyticsService: AnalyticsService) {}

  ngOnInit() {
    this.analyticsService.getAnalyticsLessons().subscribe((data: analyticsLesson[]) => {
      this.lessons = data;
    });
    this.analyticsService.getAnalyticsCourses().subscribe((data: string[]) => {
      this.courses = data;
    });
    this.analyticsService.getAnalyticsTracks().subscribe((data: string[]) => {
      this.tracks = data;
    });
    this.analyticsService.getAnalyticsTypes().subscribe((data: string[]) => {
      this.types = data;
    });
  } 
  onCourseChange(event: Event) {
    const target = event.target as HTMLSelectElement;
    this.analyticsService.getAnalyticsByCourse(this.selectedCourse).subscribe((data: analyticsLesson[]) => {
      this.lessons = data;
    });
  }
  onTrackChange(event: Event) {
    const target = event.target as HTMLSelectElement;
    this.analyticsService.getAnalyticsByTrack(this.selectedTrack).subscribe((data: analyticsLesson[]) => {
      this.lessons = data;
    });
  }
  onTypeChange(event: Event) {
    const target = event.target as HTMLSelectElement;
    this.analyticsService.getAnalyticsByType(this.selectedType).subscribe((data: analyticsLesson[]) => {
      this.lessons = data;
    });
  }
}
