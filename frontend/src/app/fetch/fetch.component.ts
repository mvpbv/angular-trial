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
  

  
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
      this.fetchData();
      this.courseData$.subscribe(data => {
        // handle the data here if needed
    });
  }
  toggleChallengeFilter() {
    this.showChallenges = !this.showChallenges;
    this.fetchData();
  }
  
  filterByDifficulty() {
    this.fetchData();
  }
  
  fetchData() {
    this.courseData$ = this.apiService.fetchData();
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