import { Injectable } from '@angular/core';
import { RankTitle } from './rank.enum';
import { Rank } from './models/rank.interface';

@Injectable({
  providedIn: 'root'
})

export class RankService {
  assignRank(level: number) {
    if (level < 10) {
      return { name: RankTitle.Unranked, level: 0, xp: 0, percent: 0 };  
    } else if (level < 20) {
      return { name: RankTitle.Apprentice, level: 10, xp: 6480, percent: this.getPercent(6480) };
    } else if (level < 30) {
      return { name: RankTitle.Pupil, level: 20, xp: 21280, percent: this.getPercent(21280) };
    } else if (level < 40) {
      return { name: RankTitle.Acolyte, level: 30, xp: 44080, percent: this.getPercent(44080) };
    } else if (level < 50) {
      return { name: RankTitle.Disciple, level: 40, xp: 74880, percent: this.getPercent(74880) };
    } else if (level < 60) {
      return { name: RankTitle.Scholar, level: 50, xp: 113680, percent: this.getPercent(113680) };
    } else if (level < 70) {
      return { name: RankTitle.Sorcerer, level: 60, xp: 160480, percent: this.getPercent(160480) };
    } else if (level < 80) {
      return { name: RankTitle.Sage, level: 70, xp: 215280, percent: this.getPercent(215280) };
    } else if (level < 90) {
      return { name: RankTitle.Archsage, level: 80, xp: 278080, percent: this.getPercent(278080) };
    } else if (level < 100) {
      return { name: RankTitle.Mage, level: 90, xp: 348880, percent: this.getPercent(348880) };
    } else {
      return { name: RankTitle.Archmage, level: 100, xp: 427680, percent: 100 };
    }
  }
  getAllRanks(): Rank[] {
    return [
      { name: RankTitle.Apprentice, level: 10, xp: this.xpAtLevel(10), percent: this.getPercent(this.xpAtLevel(10)) },
      { name: RankTitle.Pupil, level: 20, xp: this.xpAtLevel(20), percent: this.getPercent(this.xpAtLevel(20)) },
      { name: RankTitle.Acolyte, level: 30, xp: this.xpAtLevel(30), percent: this.getPercent(this.xpAtLevel(30)) },
      { name: RankTitle.Disciple, level: 40, xp: this.xpAtLevel(40), percent: this.getPercent(this.xpAtLevel(40)) },
      { name: RankTitle.Scholar, level: 50, xp: this.xpAtLevel(50), percent: this.getPercent(this.xpAtLevel(50)) },
      { name: RankTitle.Sorcerer, level: 60, xp: this.xpAtLevel(60), percent: this.getPercent(this.xpAtLevel(60)) },
      { name: RankTitle.Sage, level: 70, xp: this.xpAtLevel(70), percent: this.getPercent(this.xpAtLevel(70)) },
      { name: RankTitle.Archsage, level: 80, xp: this.xpAtLevel(80), percent: this.getPercent(this.xpAtLevel(80)) },
      { name: RankTitle.Mage, level: 90, xp: this.xpAtLevel(90), percent: this.getPercent(this.xpAtLevel(90)) },
      { name: RankTitle.Archmage, level: 100, xp: this.xpAtLevel(100), percent: this.getPercent(this.xpAtLevel(100)) }
    ];
  }
  xpForLevel(level: number) {
    if (level < 1) {
      return 0;
    }
    return 320 + (80 * level);
  }

  xpAtLevel(level: number) {
    let total = 0;
    for (let i = 1; i < level; i++) {
      total += this.xpForLevel(i);
    }
    return total;
  }
  xpToFinish() {
    return 427680;
  }
  getPercent(xp: number): number {
    return xp / 427680 * 100;
  }
}
