import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class XpService {

  static xpForLevel(level: number) {
    if (level < 1) {
      return 0;
    }
    return 320 + (80 * level);
  }

  static xpAtLevel(level: number) {
    let total = 0;
    for (let i = 1; i < level; i++) {
      total += this.xpForLevel(i);
    }
    return total;
  }
  static xpToFinish() {
    return 427680;
  }
  constructor() { }
}
