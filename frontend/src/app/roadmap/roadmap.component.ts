import { Component, OnInit } from '@angular/core';
import { RankService } from '../rank.service';
import { Rank } from '../models/rank.interface';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-roadmap',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './roadmap.component.html',
  styleUrl: './roadmap.component.css'
})
export class RoadmapComponent implements OnInit{
  title = 'roadmap';
  ranks: Rank[] = [];
  highestXP: number = 0;
  rankForm = new FormGroup({
    xp: new FormControl(''),
    guess: new FormControl(''),
  });

  constructor(private rankService: RankService) {
  }
  ngOnInit(): void {
    this.ranks = this.rankService.getAllRanks();
    this.highestXP = this.calculateHighestXP();
  }
  calculateHighestXP(): number {
    return this.ranks[this.ranks.length - 1].xp;
  }
  getRankPercent(xp: number): number {
    return xp / this.highestXP * 100;
  }
  onSubmit(): void {

  }
}
