import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-courses',
  imports: [FormsModule, CommonModule],
  template: `
  <h1>Tracks</h1>
  <h3>Select any tracks you have completed in full.</h3>
  <ul>
    <li *ngFor="let track of tracks">
      <label class="custom-checkbox">
        <input type ="checkbox" [(ngModel)]="track.completed" /> 
        <span class="checkmark"></span>
        {{ track.name }}
      </label>
    </li>
  <h1>Courses</h1>
  <ul>
    <li *ngFor="let course of courses">
      <label class="custom-checkbox">
        <input type ="checkbox" [(ngModel)]="course.completed" /> 
        <span class="checkmark"></span>
        {{ course.name }}
      </label>
    </li>
  </ul>
  ` ,
  styleUrl: './courses.component.css'
})
export class CoursesComponent {
  courses = [
     {name: 'Learn Python', completed: false, bonus : false },
     {name: 'Learn OOP', completed: false, bonus: false },
     {name: 'Learn FP', completed: false, bonus: false},
     {name: 'Algorithms', completed: false, bonus: false },
     {name: 'Data Structures', completed: false, bonus: false },
  ];
  tracks = [
    {name: 'CS Fundamentals', completed: false, bonus : false },
    {name: 'Backend Development', completed: false, bonus: false },
    {name: 'Extended Learning', completed: false, },
  ]
}
