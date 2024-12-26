import { Component, OnInit } from '@angular/core';
import { RankService } from '../rank.service';
import { Rank } from '../models/rank.interface';
import { CommonModule } from '@angular/common';
import { GuesserComponent} from "../guesser/guesser.component";
import { GuessResult } from '../models/guess-result.model';

@Component({
  selector: 'app-roadmap',
  standalone: true,
  imports: [CommonModule, GuesserComponent],
  templateUrl: './roadmap.component.html',
  styleUrl: './roadmap.component.css'
})
export class RoadmapComponent implements OnInit {
  ranks: Rank[] = [];
  title = 'roadmap';
  highestXP: number = 0;
  userPosition = {  level: 0, xp: 0, percent: 0 };
  guessPosition = 0;
  guessAccuracy = 0;
  showForm: boolean = true;

  constructor(private rankService: RankService) {}

  ngOnInit(): void {
    this.ranks = this.rankService.getAllRanks();
    this.highestXP = this.calculateHighestXP();
  }
  calculateHighestXP(): number {
    return this.ranks[this.ranks.length - 1].xp;
  }
  formChange(show: boolean) {
    this.showForm = show;
  }
  onGuessSubmitted(result: GuessResult): void {
    this.userPosition = {
      level: result.userPosition.level,
      xp: result.userPosition.xp,
      percent: result.userPosition.percent,
    };

    this.guessPosition = result.guessPosition;
    this.guessAccuracy = result.accuracy;
    this.showForm = false;

    console.log('updated userPosition:', this.userPosition);
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
