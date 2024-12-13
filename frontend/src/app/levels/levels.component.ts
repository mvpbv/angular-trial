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
      <p>You are level <span class="accent-text">{{lvl}}</span></p>
      <p>You have <span class="accent-text">{{ totalXp }}</span> XP</p>
      <p>You need <span class="accent-text">{{ levelXp }}</span> more XP to reach level <span class="accent-text">{{lvl + 1}}</span></p>
      <p>Your rank is <span class="accent-text">{{rank.name}}</span></p>
      <p>Your next rank is <span class="accent-text">{{nextRank.name}}</span></p>
      <p>You need <span class="accent-text">{{nextRank.xp - totalXp}}</span> XP to reach the next rank</p>
      <p>You are <span class="accent-text">{{ totalXp / Complete * 100 | number: '1.0-0' }}%</span> of the way to Archmage</p>
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
  Complete = XpService.xpToFinish();

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
