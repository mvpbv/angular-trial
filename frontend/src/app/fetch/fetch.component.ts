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
  stats$!: Observable<any>;
  showChallenges: boolean = true;
  difficultyRangeMin: number = 3;
  difficultyRangeMax: number = 10;
  languages: string[] = ['Python', 'SQL', 'Go', 'Typescript', 'Javascript'];
  showDetails: boolean = true;
  

  courses: string[] = ['Learn Python', 'Learn OOP', 'Learn FP', 'Learn Algorithms', 'Learn Data Structures',
    'C Memory Management', 'Learn Go', 'Go HTTP Clients', 'Learn JavaScript', 'TS HTTP Clients', 'Go Web Servers', 'Learn SQL',
    'TS Web Servers', 'Go Cryptography', 'Adv Algorithms' ];
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
      this.fetchData();
      this.stats$!.subscribe(data => {
        this.stats$ = data;
      });

      this.courseData$.subscribe(data => {
        this.courseData$ = data;
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
    (this.courses.includes(item.CourseFriendly) || this.courses.length === 0)))
  );  
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
}