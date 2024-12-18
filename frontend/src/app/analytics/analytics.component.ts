import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AnalyticsService } from '../analytics.service';
import { CommonModule } from '@angular/common';
import { analyticsLesson } from '../models/analytics-lesson.model';

@Component({
  imports: [CommonModule, FormsModule],
  template: `
  <label for="courseSelect">Select a course:</label>
  <select id="courseSelect" [(ngModel)] = "selectedCourse" (change)="onCourseChange($event)">
    <option *ngFor="let item of courses" [value]="item">{{ item }}</option>
  </select>
  <div *ngFor="let item of lessons"> 
    <p> {{ item.Title }} </p>
    <p> {{ item.CourseName }}</p>
    <p> {{ item.ChapterName }}</p>
    <p> {{ item.Difficulty }}</p>
    <a href="https://boot.dev/lessons/{{item.UUID}}">Go To Lesson</a>
  </div>
`,
  styleUrl: './analytics.component.css'
})
export class AnalyticsComponent implements OnInit{
  
  lessons: analyticsLesson[] = [];
  courses: string[] = [];
  selectedCourse: string = '';

  constructor(private analyticsService: AnalyticsService) {}

  ngOnInit() {
    this.analyticsService.getAnalyticsLessons().subscribe((data: analyticsLesson[]) => {
      this.lessons = data;
    });
    this.analyticsService.getAnalyticsCourses().subscribe((data: string[]) => {
      this.courses = data;
    });
  }
  onCourseChange(event: Event) {
    const target = event.target as HTMLSelectElement;
    this.analyticsService.getAnalyticsByCourse(this.selectedCourse).subscribe((data: analyticsLesson[]) => {
      this.lessons = data;
    });
  }
}
