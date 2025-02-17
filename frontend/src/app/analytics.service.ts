import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { DataItem } from './models/data-item.model';
import { analyticsLesson, HotSpot } from './models/hotspot.model';
import { AnalyticsStats } from './models/analytics-stats.models';

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {
  private baseUrl = 'http://localhost:8080/api/v1/analytics';

  constructor(private http: HttpClient) { }
  
    getAnalyticsLessons(): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getAllLessonData`);
    }
    paginateAnalyticsLessons(limit: number, offset: number): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getAllLessonData?limit=${limit}&offset=${offset}`);
    }
    getAnalyticsLessonsBy(courseNames: Array<String>): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getAllLessonDataBy=${courseNames}`);
    }
    getAnalyticsCourses(): Observable<any> {
      return this.http.get<String[]>(`${this.baseUrl}/getCourseNames`);
    }
    getAnalyticsTypes(): Observable<any> {
      return this.http.get<String[]>(`${this.baseUrl}/getLessonTypes`);
    }
    getAnalyticsTracks(): Observable<any> {
      return this.http.get<String[]>(`${this.baseUrl}/getTrackNames`);
    }
    getAnalyticsByCourse(course: string): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getLessonsByCourse?courseName=${course}`);
    }
    getAnalyticsByTrack(track: string): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getLessonsByTrack?trackName=${track}`);
    }
    getAnalyticsByType(type: string): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getLessonsByType?lessonType=${type}`);
    }
    getArticleLessons(): Observable<any> {
      return this.http.get<analyticsLesson[]>(`${this.baseUrl}/getArticleLessons`);
    }
    getAverageCourseDifficulty(): Observable<any> {
      return this.http.get<number>(`${this.baseUrl}/getAverageCourseDifficulty`);
    }
    getCodingCourses(): Observable<any> {
      return this.http.get<String[]>(`${this.baseUrl}/getCodingCourses`);
    }
    getHotSpots(limit: number, window: number): Observable<any> {
      return this.http.get<HotSpot[]>(`${this.baseUrl}/getHotSpots?limit=${limit}&window=${window}`);
    }
    getHotSpotsStats(window: number): Observable<any> {
      return this.http.get<AnalyticsStats>(`${this.baseUrl}/getHotSpotsAvg?window=${window}`);
    }
    getHotSpotsGrouped(window: number): Observable<any> {
      return this.http.get<DataItem[]>(`${this.baseUrl}/getHotSpotsGrouped?window=${window}&primary=false`);
    }
    getPrimary(window: number, limit: number): Observable<any> {
      return this.http.get<HotSpot[]>(`${this.baseUrl}/getPrimary?window=${window}&limit=${limit}`);
    }
    getPrimaryStats(window: number): Observable<AnalyticsStats> {
    return this.http.get<AnalyticsStats>(`${this.baseUrl}/getPrimaryStats?window=${window}`);
    }
    getHotSpotsCourse(window: number): Observable<any> {
      return this.http.get<HotSpot[]>(`${this.baseUrl}/getHotSpotsCourse?window=${window}`);
    }
}
