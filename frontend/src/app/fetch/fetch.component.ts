import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs/internal/Observable';
import { DataItem } from '../models/data-item.model';
import { map } from 'rxjs';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fetch',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './fetch.component.html',
  styleUrl: './fetch.component.css'
})
export class FetchComponent implements OnInit{
  courseData$!: Observable<DataItem[]>;
  showChallenges: boolean = true;
  difficultyRangeMin: number = 3;
  difficultyRangeMax: number = 10;
  showDetails: boolean = true;
  dataCount: number = 0;
  totalDifficulty: number = 0;
  difficultyCounts: {[key: number]: number} = {};

  courses: string[] = ['Learn Python', 'Learn OOP', 'Learn FP', 'Algorithms', 'Data Structures', 'Memory Management', 'Learn Go', 'Learn HTTP Go', 'Learn Javascipt', 'Learn HTTP TypeScript'];
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
      this.fetchData();
      this.courseData$.subscribe(data => {
        this.dataCount = data.length;
        this.totalDifficulty = data.reduce((acc, item) => acc + item.Diff, 0);
        this.difficultyCounts = data.reduce((counts, item) => {
          counts[item.Diff] = (counts[item.Diff] || 0) + 1;
          return counts;
        }, {} as {[key: number]: number});
    });
  }
  toggleChallengeFilter() {
    this.showChallenges = !this.showChallenges;
    this.fetchData();
  }
  sortByDifficulty() {
    this.courseData$ = this.courseData$.pipe(
    map(data => data.sort((a, b) => b.Diff - a.Diff))
    );  
  }
  filterByDifficulty() {
    this.fetchData();
  }

  getDifficultyEntries(): [number,number][] {
    return Object.entries(this.difficultyCounts).map(([key, value]) => [parseInt(key), value]);
  }
  fetchData() {
    this.courseData$ = this.apiService.fetchData().pipe(
    map(data => data.filter((item : any) => 
      (!item.Challenge || this.showChallenges) && 
    (item.Diff >= this.difficultyRangeMin && item.Diff <= this.difficultyRangeMax) &&
    (this.courses.includes(this.getCourseName(item.highPriority))))
  ));  
  }

  toggleDetails() {
    this.showDetails = !this.showDetails;
  }

  getDifficultyClass(difficulty: number): string {
    switch (difficulty) {
      case 3:
        return 'very easy';
      case 4:
        return 'easy';
      case 5:
        return 'medium';
      case 6:
        return 'medium-hard';
      case 7:
        return 'hard';
      case 8:
        return 'harder';
      case 9:
        return 'very hard';
      case 10:
        return 'hardest';
      default:
        return '';
    }
  }
  filterByCourse() {
    this.fetchData();  
  }
  getCourseName(course: number): string {
    switch (course) {
      case 1:
        return 'Learn Python';
      case 2:
        return 'Learn OOP';
      case 3:
        return 'Learn FP';
      case 4:
        return 'Algorithms';
      case 5:
        return 'Data Structures';
      case 6:
        return 'Memory Management';
      case 7:
        return 'Learn Go';
      case 8:
        return 'Learn HTTP Go';
      case 9:
        return 'Learn Javascipt';
      case 10: 
        return 'Learn HTTP TypeScript';
      default:
        return '';
    }
  }
  getCourseNumber(course: string): number {
    switch (course) {
      case 'Learn Python':
        return 1;
      case 'Learn OOP':
        return 2;
      case 'Learn FP':
        return 3;
      case 'Algorithms':
        return 4;
      case 'Data Structures':
        return 5;
      case 'Memory Management':
        return 6;
      case 'Learn Go':
        return 7;
      case 'Learn HTTP Go':
        return 8;
      case 'Learn Javascipt':
        return 9;
      case 'Learn HTTP TypeScript':
        return 10;
      default:
        return 0;
    }
  }
}
