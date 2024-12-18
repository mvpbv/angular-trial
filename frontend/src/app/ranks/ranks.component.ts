import { Component } from '@angular/core';
import { RankService } from '../rank.service';
import { Rank } from '../models/rank.interface';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-ranks',
  imports: [CommonModule],
  templateUrl: './ranks.component.html',
  styleUrl: './ranks.component.css'
})
export class RanksComponent {
  title = 'ranks';
  ranks: Rank[] = [];
  showRanks: boolean = true;

  constructor(private rankService: RankService) {
    this.ranks = this.rankService.getAllRanks();
  }
  toggleRanks(): void {
    this.showRanks = !this.showRanks;
  }
  getRankPercent(xp: number): number {
    return xp / this.ranks[this.ranks.length - 1].xp;
  }

}
