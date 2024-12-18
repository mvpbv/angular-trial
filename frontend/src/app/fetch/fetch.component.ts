import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs/internal/Observable';
import { DataItem } from '../models/data-item.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fetch',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './fetch.component.html',
  styleUrl: './fetch.component.css'
})
export class FetchComponent implements OnInit {
  items: DataItem[] = [];
  stats$!: Observable<any>;
  
  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.apiService.fetchData().subscribe((data: DataItem[]) => {
      this.items = data;
    });
  }
  getDifficultyClass(difficulty: number): string {
    switch (difficulty) {
      case 3:
        return 'very-easy';
      case 4:
        return 'easy';
      case 5:
        return 'medium';
      case 6:
        return 'harder';
      case 7:
        return 'very-hard';
      case 8:
        return 'hardest';
      case 9: 
        return 'very-hard';
      case 10:
        return 'hardest';
      default:
        return '';
    }
  }
}
  