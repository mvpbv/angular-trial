import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Rank } from '../models/rank.interface';
import { RankTitle } from '../rank.enum';
import { RankService } from '../rank.service';
import { XpService } from '../xp.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-levels',
  imports: [CommonModule, ReactiveFormsModule],
  template: `
  <section>
      <form [formGroup] ="levelForm" (ngSubmit)="onSubmit()" class="form-container">
        <input type="number"
        class="input-field" 
        formControlName="level" 
        placeholder="Enter your level" #level />
        <button type="submit" class="submit-button">Submit</button>
      </form>
    </section>
    <section *ngIf="lvl > 0" class="output-container">
      <p>You are level {{lvl}}</p>
      <p>You have {{ totalXp }} XP</p>
      <p>You need {{ levelXp }} more XP to reach level {{lvl + 1}}</p>
      <p>Your rank is {{rank.name}}</p>
      <p>Your next rank is {{nextRank.name}}</p>
      <p>You need {{nextRank.xp - totalXp}} XP to reach the next rank</p>
    </section>
    <br>
  `,
  styleUrl: './levels.component.css'
})
export class LevelsComponent {
  lvl: number = 0;
  levelXp: number = 0;
  totalXp: number = 0;
  levelForm: FormGroup;
  rank : Rank = { name: RankTitle.Unranked, level: 0, xp: 0 };
  nextRank : Rank = { name: RankTitle.Unranked, level: 10, xp: 320 };

  constructor(private fb: FormBuilder, private rankService: RankService) {
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
    this.rank = this.rankService.assignRank(this.lvl);
    this.nextRank = this.rankService.assignRank(this.lvl + 10);
    this.levelXp = XpService.xpForLevel(this.lvl);
    this.totalXp = XpService.xpAtLevel(this.lvl);
  }  

  ngOnInit(): void {}
}
