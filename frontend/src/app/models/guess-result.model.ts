export interface GuessResult {
  level: number;
  guess: number;
  userPosition: {
    level: number,
    xp: number,
    percent: number
  };
  guessPosition: number;
  accuracy: number;
}