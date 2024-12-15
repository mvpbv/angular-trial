import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators/map';
import { DataItem } from './models/data-item.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) { }
  getHealthStatus(): Observable<any> {
    return this.http.get(`${this.baseUrl}/healthz`);
  }
  fetchStats(): Observable<any> {
    return this.http.get(`${this.baseUrl}/fetchStats`);
  }
  fetchData(): Observable<any> {
    return this.http.get<DataItem[]>(`${this.baseUrl}/getData`).pipe(
      map(data => data.sort((a, b) => {
        if (a.HighestPriority !== b.HighestPriority) {
          return a.HighestPriority - b.HighestPriority;
        }
        if (a.HighPriority !== b.HighPriority) {
          return a.HighPriority - b.HighPriority;
        }
        if (a.MiddlePriority !== b.MiddlePriority) {
          return a.MiddlePriority - b.MiddlePriority;
        }
        if (a.Challenge !== b.Challenge) {
          return a.Challenge ? -1 : 1;
        }
          return a.LeastPriority - b.LeastPriority;
        }))
    );
  }
}
