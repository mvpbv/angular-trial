import { Injectable } from '@angular/core';
import { RankTitle } from './rank.enum';
import { Rank } from './models/rank.interface';
import { XpService } from './xp.service';

@Injectable({
  providedIn: 'root'
})



export class RankService {
  assignRank(level: number) {
    let rank : RankTitle;
    
    if (level < 10) {
      rank = RankTitle.Unranked;
    } else if (level < 20) {
      rank = RankTitle.Apprentice;
    } else if (level < 30) {
      rank = RankTitle.Pupil;
    } else if (level < 40) {
      rank = RankTitle.Acolyte;
    } else if (level < 50) {
      rank = RankTitle.Disciple;
    } else if (level < 60) {
      rank = RankTitle.Scholar;
    } else if (level < 70) {
      rank = RankTitle.Sorcerer;
    } else if (level < 80) {
      rank = RankTitle.Sage;
    } else if (level < 90) {
      rank = RankTitle.Archsage;
    } else if (level < 100) {
      rank = RankTitle.Mage;
    } else {
      rank = RankTitle.Archmage
    }

    return {
      name: RankService,
      level: level,
      xp: XpService.xpAtLevel(level)
    }
  }

  static getNextRank(rank: RankTitle) {
    if (rank === RankTitle.Unranked) {
      rank = RankTitle.Apprentice;
    } else if (rank === RankTitle.Apprentice) {
      rank = RankTitle.Pupil;
    } else if (rank === RankTitle.Pupil) {
      rank = RankTitle.Acolyte;
    } else if (rank === RankTitle.Acolyte) {
      rank = RankTitle.Disciple;
    } else if (rank === RankTitle.Disciple) {
      rank = RankTitle.Scholar;
    } else if (rank === RankTitle.Scholar) {
      rank = RankTitle.Sorcerer;
    } else if (rank === RankTitle.Sorcerer) {
      rank = RankTitle.Sage;
    } else if (rank === RankTitle.Sage) {
      rank = RankTitle.Archsage;
    } else if (rank === RankTitle.Archsage) {
      rank = RankTitle.Mage;
    } else if (rank === RankTitle.Mage) {
      rank = RankTitle.Archmage;
    } else if (rank === RankTitle.Archmage) {
      rank = RankTitle.Archmage;
    } else {
      rank = RankTitle.Unranked;
    }
  }
  constructor() { }
}
