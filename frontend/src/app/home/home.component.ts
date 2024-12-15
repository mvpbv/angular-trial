import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LevelsComponent } from '../levels/levels.component';
import { CoursesComponent } from '../courses/courses.component';
import { RanksComponent } from '../ranks/ranks.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    LevelsComponent,
    CoursesComponent,
    RanksComponent
  ],

  template: `
  <app-levels></app-levels>
  <app-courses></app-courses>
  <app-ranks></app-ranks>
  `,
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  title = 'Home';
}
