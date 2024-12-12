import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RanksComponent } from "./ranks/ranks.component";
import { LevelsComponent } from "./levels/levels.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RanksComponent, LevelsComponent],
  template: `<title>boot-utils</title>
    <h1>Hello, Boot.devver!</h1>
    <app-levels></app-levels>
    <app-ranks></app-ranks>
  `,
  styleUrl: './app.component.css'
})
export class AppComponent { 
  title = 'boot-utils';
}
