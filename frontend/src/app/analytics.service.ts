import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { DataItem } from './models/data-item.model';
import { analyticsLesson } from './models/analytics-lesson.model';

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {
  private baseUrl = 'http://localhost:8080/api/v1/analytics';

  constructor(private http: HttpClient) { }
  
    getAnalyticsLessons(): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getAllLessonData`);
    }
    getAnalyticsCourses(): Observable<any> {
      return this.http.get<DataItem[]>(`${this.baseUrl}/getCourseNames`);
    }
    getAnalyticsByCourse(course: string): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getLessonDataByCourse/${course}`);
    }
}
