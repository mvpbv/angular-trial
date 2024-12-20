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
  showForm: boolean = true;
  title = 'roadmap';
  ranks: Rank[] = [];
  highestXP: number = 0;
  rankForm = new FormGroup({
    level: new FormControl(''),
    guess: new FormControl(''),
  });
  userPosition = {  level: 0, xp: 0, percent: 0 };
  guessPosition = 0;
  guessAccuracy = 0;

  constructor(private rankService: RankService) {
  }
  ngOnInit(): void {
    this.ranks = this.rankService.getAllRanks();
    this.highestXP = this.calculateHighestXP();
  }
  calculateHighestXP(): number {
    return this.ranks[this.ranks.length - 1].xp;
  }
  onSubmit(): void {
    const level = parseInt(this.rankForm.get('level')?.value ?? '0');
    const guess = parseInt(this.rankForm.get('guess')?.value ?? '0');
    this.calcResults(level, guess);
    this.showForm = false;
  }
  calcResults(xp: number, guess: number): void {
    const userXp = this.rankService.xpAtLevel(xp);
    const userPercent = userXp / this.highestXP * 100;
    this.userPosition = {
      level: xp,
      xp: userXp,
      percent: userPercent,
    };
    this.guessPosition = guess;
    this.guessAccuracy = Math.abs(guess - userPercent);
  }
}
