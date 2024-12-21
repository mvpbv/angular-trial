import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class CodeService {
  private baseUrl = 'http://localhost:8080/api/v1/code';

  constructor(private http: HttpClient) { }

  getCode(window: number, limit: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/getPrimary?window=${window}&limit=${limit}`);
  }

}
