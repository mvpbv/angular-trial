import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WindowService {
  private windowSubject = new BehaviorSubject<number>(3);
  window$ = this.windowSubject.asObservable();

  setWindow(value: number) {
    this.windowSubject.next(value);
  }
}