import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { RanksComponent } from "./ranks/ranks.component";
import { LevelsComponent } from "./levels/levels.component";
import { CoursesComponent } from "./courses/courses.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    ReactiveFormsModule,
  ],
  template: `
    <title>boot-utils</title>
    <h1>Hello, Boot.devver!</h1>
    <router-outlet></router-outlet>
  `,

  styleUrl: './app.component.css'
})
export class AppComponent { 
  title = 'boot-utils';
}
