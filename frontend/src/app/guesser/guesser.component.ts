import { Component } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { RankService } from '../rank.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-guesser',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './guesser.component.html',
  styleUrl: './guesser.component.css'
})
export class GuesserComponent {
  showForm: boolean = true;
  rankForm = new FormGroup({
    level: new FormControl(''),
    guess: new FormControl(''),
  });
  userPosition = {  level: 0, xp: 0, percent: 0 };
  guessPosition = 0;
  guessAccuracy = 0;
  highestXP: number = 0;

  constructor(private rankService: RankService) {
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
