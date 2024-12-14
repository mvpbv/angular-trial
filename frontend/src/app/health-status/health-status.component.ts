import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-health-status',
  standalone: true,
  imports: [CommonModule],
  template: `
  <div>
    <h2>{{ (healthStatus$ | async)?.status }}</h2>
  </div>
  `,
  styleUrl: './health-status.component.css'
})
export class HealthStatusComponent implements OnInit {
  healthStatus$!: Observable<{ status: string}>;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.healthStatus$ = this.apiService.getHealthStatus();
    console.log(this.healthStatus$);
  }
}
