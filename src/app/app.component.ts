import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RanksComponent } from "./ranks/ranks.component";
import { RankTitle } from './rank.enum';
import { RankService } from './rank.service';
import { XpService } from './xp.service';
import { Rank } from './models/rank.interface';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RanksComponent],
  template: `<h1>Hello, Boot.devver!</h1>
    <section>
      <form [formGroup] ="levelForm" (ngSubmit)="onSubmit()">
        <input type="number" formControlName="level" placeholder="Enter your level" #level />
        <button type="submit">Submit</button>
      </form>
    </section>
    <section *ngIf="lvl > 0">
      <p>You are level {{lvl}}</p>
      <p>You have {{ totalXp }} XP</p>
      <p>You need {{ levelXp }} more XP to reach level {{lvl + 1}}</p>
      <p>Your rank is {{rank.name}}</p>
      <p>Your next rank is {{nextRank.name}}</p>
      <p>You need {{nextRank.xp - totalXp}} XP to reach the next rank</p>
    </section>
    <app-ranks></app-ranks>
  `,
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  lvl: number = 0;
  levelXp: number = 0;
  totalXp: number = 0;
  levelForm: FormGroup;
  rank : Rank = { name: 'Unraked', level: 0, xp: 0 };
  nextRank : Rank = { name: 'Apprentice', level: 10, xp: 320 };

  constructor(private fb: FormBuilder) {
    this.levelForm = this.fb.group({
      level: ['']
    });
  }
  onSubmit() {
    const level = this.levelForm.get('level')?.value;
    const num = parseInt(level);

    this.calcResults(num);
  }
  calcResults(level: number) {
    this.lvl = level;
    this.levelXp = XpService.xpForLevel(this.lvl);
    this.totalXp = XpService.xpAtLevel(this.lvl);
    this.rank = RankService.assignRank(this.lvl);
    this.nextRank = RankService.getNextRank(this.rank);
  }  

  ngOnInit(): void {}

  
}
