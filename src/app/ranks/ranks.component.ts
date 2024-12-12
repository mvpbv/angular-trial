import { Component } from '@angular/core';
import { RankService } from '../rank.service';
import { Rank } from '../models/rank.interface';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-ranks',
  imports: [CommonModule],
  template: `
  <button class="toggle-button" (click)="toggleRanks()">{{ showRanks ? 'Hide Ranks' : 'Show Ranks' }}</button>
  <div *ngIf="showRanks">
      <div *ngFor="let rank of ranks" class="rank-item">
        <h4>{{rank.name}}</h4>
        <p>Level: <span class="accent-text">{{rank.level}}</span> XP: <span class="accent-text">{{rank.xp}}</span></p>
      </div>
  </div>
  `,
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
}
