import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { RankService } from '../rank.service';
import { CommonModule } from '@angular/common';
import { GuessResult } from '../models/guess-result.model';

@Component({
  selector: 'app-guesser',
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './guesser.component.html',
  styleUrl: './guesser.component.css'
})
export class GuesserComponent{
  @Input() initialLevel?: number;
  @Input() initialGuess?: number;
  @Output() formVisibility = new EventEmitter<boolean>();
  @Output() guessSubmitted = new EventEmitter<GuessResult>();

  showForm: boolean = true;
  guessAccuracy: number = 0;
  highestXP: number = 436000;

  rankForm = new FormGroup({
    level: new FormControl(''),
    guess: new FormControl(''),
  });



  constructor(private rankService: RankService) {
  }

  onSubmit(): void {
    const level = parseInt(this.rankForm.get('level')?.value ?? '0');
    const guess = parseInt(this.rankForm.get('guess')?.value ?? '0');

    const userXp = this.rankService.xpAtLevel(level);
    const userPercent = userXp / this.highestXP * 100;
    const result: GuessResult = {
      level,
      guess,
      userPosition: {
        level,
        xp: userXp,
        percent: userPercent
      },
      guessPosition: guess,
      accuracy: Math.abs(guess - userPercent)
   };
   this.guessAccuracy = result.accuracy;
   this.guessSubmitted.emit(result);
   this.formVisibility.emit(false);
   this.showForm = false;
  }
  toggleForm(): void {
    this.showForm = true;
    this.formVisibility.emit(true);
  }

}
