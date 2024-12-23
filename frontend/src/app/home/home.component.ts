import { Component, ElementRef, ViewChild, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent implements AfterViewInit {
  private streakPositions: Array<{x: number, y: number}> = [];
  private readonly minDistance = 300;
  private colors = ['#f72585', '#b5179e', '#7209b7', '#560bad', '#480ca8', '#3a0ca3','#3f37c9', '#4361ee', '#4895ef', '#4cc9f0' ];
  @ViewChild('starCanvas') private canvas!: ElementRef<HTMLCanvasElement>;
  private ctx!: CanvasRenderingContext2D;

  ngAfterViewInit() {
    this.initCanvas();
    this.drawStarfield();
  }
  private getValidPosition() {
    let attempts = 0;
    let x, y;

    do {
      x = Math.random() * window.innerWidth;
      y = Math.random() * document.documentElement.scrollHeight;
      attempts++;
    } while (!this.isValidPosition(x, y) && attempts < 100);

    return {x, y};
  }

  private isValidPosition(x: number, y: number): boolean {
    return !this.streakPositions.some(pos => 
      Math.hypot(pos.x - x, pos.y - y) < this.minDistance
    );
  }
  private initCanvas() {
    const canvas = this.canvas.nativeElement;
    this.ctx = canvas.getContext('2d')!;
    canvas.width = window.innerWidth;
    canvas.height = document.documentElement.scrollHeight;
  }

  private shuffleColors() {
    const shuffled = [...this.colors];
    for (let i = shuffled.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [shuffled[i], shuffled[j]] = [shuffled[j], shuffled[i]];
    }
    return shuffled
  }

  private drawStarfield() {
    const streaks = 30;   
    for (let i = 0; i < streaks; i++) {
      const {x, y } = this.getValidPosition(); 
      this.streakPositions.push({x, y});
      const length = 200 + Math.random() * 50;
      const gradient = this.ctx.createLinearGradient(0, 0, length, 0);
      const colors = this.shuffleColors();
      
      gradient.addColorStop(0.5, colors[1]);
      gradient.addColorStop(1, colors[2]);
      gradient.addColorStop(0, colors[0]);
      this.ctx.save();
      this.ctx.translate(x, y);
      this.ctx.rotate(Math.PI / 3);
      
      this.ctx.beginPath();
      this.ctx.strokeStyle = gradient;
      this.ctx.lineWidth = 3;
      this.ctx.moveTo(0, 0);
      this.ctx.lineTo(length, 0);
      this.ctx.stroke();
      
      this.ctx.restore();
    }
  }
}