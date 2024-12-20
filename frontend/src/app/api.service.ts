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
    console.log('fetching data');
    return this.http.get<DataItem[]>(`${this.baseUrl}/getChronologicalData`);
  }
}
