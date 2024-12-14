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

  getHealthStatus(): Observable<{ status: string}> {
    return this.http.get<{ status: string }>(`${this.baseUrl}/healthz`);
  }
  fetchData(): Observable<any> {
    return this.http.get<DataItem[]>(`${this.baseUrl}/fetchData`).pipe(
      map(data => data.sort((a, b) => {
        if (a.highPriority !== b.highPriority) {
          return a.highPriority - b.highPriority;
        }
        if (a.middlePriority !== b.middlePriority) {
          return a.middlePriority - b.middlePriority;
        }
        if (a.Challenge !== b.Challenge) {
          return a.Challenge ? -1 : 1;
        }
          return a.leastPriority - b.leastPriority;
        }))
    );
  }
}
