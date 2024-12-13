import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

interface User {
  id: string;
}

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'https://api.boot.dev/v1/users/public/'
  constructor(private http: HttpClient) { }

  getUser(id: string): Observable<User> {
    return this.http.get<User>(`${this.apiUrl}${id}`);
  }
}
