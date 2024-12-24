import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Rank } from '../models/rank.interface';
import { RankTitle } from '../rank.enum';
import { RankService } from '../rank.service';
import { CommonModule } from '@angular/common';
import { RanksComponent } from '../ranks/ranks.component';

@Component({
  selector: 'app-progress',
  imports: [CommonModule, ReactiveFormsModule, RanksComponent],
  templateUrl: './progress.component.html',
  styleUrl: './progress.component.css'
})
export class ProgressComponent {
  lvl: number = 0;
  levelXp: number = 0;
  totalXp: number = 0;
  levelForm: FormGroup;
  rank : Rank = { name: RankTitle.Unranked, level: 0, xp: 0 };
  nextRank : Rank = { name: RankTitle.Unranked, level: 10, xp: 320 };
  Complete: number = 0;

  constructor(private fb: FormBuilder, private rankService: RankService) {
    this.levelForm = this.fb.group({
      level: ['']
    });
    this.Complete = this.rankService.xpToFinish();
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
    this.levelXp = this.rankService.xpForLevel(this.lvl);
    this.totalXp = this.rankService.xpAtLevel(this.lvl);
  }

  ngOnInit(): void {}
}
