import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LinksService {
  private baseUrl = 'http://localhost:8080/api/v1/link';

  constructor(private http: HttpClient) { }

  getLinks(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getLinks`);
  }
  getDomains(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/domains`);
  }
}
