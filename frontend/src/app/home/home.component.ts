import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProgressComponent } from '../progress/progress.component';
import { RanksComponent } from '../ranks/ranks.component';
import { RoadmapComponent } from "../roadmap/roadmap.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    RoadmapComponent
],

  template: `
    <app-roadmap></app-roadmap>
  `,
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  title = 'Home';
}
