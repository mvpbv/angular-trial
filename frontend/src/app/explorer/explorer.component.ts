import { Component, HostListener, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AnalyticsService } from '../analytics.service';
import { CommonModule } from '@angular/common';
import { analyticsLesson } from '../models/hotspot.model';

@Component({
  imports: [CommonModule, FormsModule],
  templateUrl: './explorer.component.html',
  styleUrl: './explorer.component.css'
})
export class ExplorerComponent implements OnInit{
  
  lessons: analyticsLesson[] = [];
  courses: string[] = [];
  tracks: string[] = [];
  types: string[] = [];
  difficulties: number[] = [3, 4, 5, 6, 7, 8, 9, 10];
  selectedCourse: string = '';
  selectedTrack: string = '';
  selectedType: string = '';
  selectedDifficultyMax: number = 10;
  selectedDifficultyMin: number = 3;
  isLoading: boolean = false;

  constructor(private analyticsService: AnalyticsService) {}

  ngOnInit() {
    this.analyticsService.paginateAnalyticsLessons(50,0).subscribe((data: analyticsLesson[]) => {
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
  @HostListener('window:scroll')
  onScroll() {
    if (window.innerHeight + window.scrollY >= document.body.offsetHeight - 1000 && !this.isLoading) {
      this.isLoading = true;
      this.analyticsService.paginateAnalyticsLessons(50, this.lessons.length)
      .subscribe((data: analyticsLesson[]) => {
        this.lessons = this.lessons.concat(data);
        this.isLoading = false;
      });
    } 
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
