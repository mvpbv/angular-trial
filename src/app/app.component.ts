import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RanksComponent } from "./ranks/ranks.component";
import { LevelsComponent } from "./levels/levels.component";
import { CoursesComponent } from "./courses/courses.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RanksComponent, LevelsComponent, CoursesComponent],
  template: `<title>boot-utils</title>
    <h1>Hello, Boot.devver!</h1>
    <app-levels></app-levels>
    <app-courses></app-courses>
    <app-ranks></app-ranks>

  `,
  styleUrl: './app.component.css'
})
export class AppComponent { 
  title = 'boot-utils';
}
