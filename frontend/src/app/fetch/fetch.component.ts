import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs/internal/Observable';


@Component({
  selector: 'app-fetch',
  standalone: true,
  imports: [CommonModule],
  template: `
  <div>
    <h2>{{ (courseData | async)?.status }}</h2>
  `,
  styleUrl: './fetch.component.css'
})
export class FetchComponent implements OnInit{
  courseData!: Observable<{ status: string}>;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.courseData = this.apiService.fetchData();
    console.log(this.courseData);
  }
}
