import { Injectable } from '@angular/core';
import { RankTitle } from './rank.enum';
import { Rank } from './models/rank.interface';
import { XpService } from './xp.service';

@Injectable({
  providedIn: 'root'
})

export class RankService {
  assignRank(level: number) {
    if (level < 10) {
      return { name: RankTitle.Unranked, level: 0, xp: 0 };  
    } else if (level < 20) {
      return { name: RankTitle.Apprentice, level: 10, xp: 6480 };
    } else if (level < 30) {
      return { name: RankTitle.Pupil, level: 20, xp: 21280 };
    } else if (level < 40) {
      return { name: RankTitle.Acolyte, level: 30, xp: 44080 };
    } else if (level < 50) {
      return { name: RankTitle.Disciple, level: 40, xp: 74880 };
    } else if (level < 60) {
      return { name: RankTitle.Scholar, level: 50, xp: 113680 };
    } else if (level < 70) {
      return { name: RankTitle.Sorcerer, level: 60, xp: 160480 };
    } else if (level < 80) {
      return { name: RankTitle.Sage, level: 70, xp: 215280 };
    } else if (level < 90) {
      return { name: RankTitle.Archsage, level: 80, xp: 278080  };
    } else if (level < 100) {
      return { name: RankTitle.Mage, level: 90, xp: 348880 };
    } else {
      return { name: RankTitle.Archmage, level: 100, xp: 427680 };
    }
  }
  getAllRanks(): Rank[] {
    return [
      { name: RankTitle.Unranked, level: 0, xp: 0 },
      { name: RankTitle.Apprentice, level: 10, xp: XpService.xpAtLevel(10) },
      { name: RankTitle.Pupil, level: 20, xp: XpService.xpAtLevel(20) },
      { name: RankTitle.Acolyte, level: 30, xp: XpService.xpAtLevel(30) },
      { name: RankTitle.Disciple, level: 40, xp: XpService.xpAtLevel(40) },
      { name: RankTitle.Scholar, level: 50, xp: XpService.xpAtLevel(50) },
      { name: RankTitle.Sorcerer, level: 60, xp: XpService.xpAtLevel(60) },
      { name: RankTitle.Sage, level: 70, xp: XpService.xpAtLevel(70) },
      { name: RankTitle.Archsage, level: 80, xp: XpService.xpAtLevel(80) },
      { name: RankTitle.Mage, level: 90, xp: XpService.xpAtLevel(90) },
      { name: RankTitle.Archmage, level: 100, xp: XpService.xpAtLevel(100) }
    ];
  }
}
