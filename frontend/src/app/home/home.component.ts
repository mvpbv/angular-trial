import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProgressComponent } from '../progress/progress.component';
import { RanksComponent } from '../ranks/ranks.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    ProgressComponent,
    RanksComponent
  ],

  template: `
  <app-progress></app-progress>
  <app-ranks></app-ranks>
  `,
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  title = 'Home';
}
