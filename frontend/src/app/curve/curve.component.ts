import { AfterViewInit, Component, ElementRef, HostListener, OnInit, ViewChild } from '@angular/core';
import { CodeService } from '../code.service';

@Component({
  selector: 'app-curve',
  imports: [],
  templateUrl: './curve.component.html',
  styleUrl: './curve.component.css'
})
export class CurveComponent implements AfterViewInit {
  @ViewChild('barChart') barChart!: ElementRef<HTMLCanvasElement>;
  title = 'curve';
  data: number[] = [];
  colors: string[] = ['#7fff00', '#39ff14', '#155724'];
  private scrollPosition = 0;
  private targetScrollPosition = 0;
  private animationFrameId: number | null = null;
  private visibleWidth = window.innerWidth - 40;
  private readonly width = 32;
  private readonly scrollSpeed = 0.1;
  

  constructor(private codeService: CodeService) {}
  ngAfterViewInit(): void {
    this.scrollPosition = window.scrollY;

    this.codeService.getCurve().subscribe((data: any) => {
      this.data = data;
      this.drawBarChart(this.data, this.barChart.nativeElement);
    });
  }
  @HostListener('window:wheel', [])
  onScroll() {
    this.targetScrollPosition = window.scrollY;
    if (!this.animationFrameId) {
      this.animateScroll();
    }
  }
  animateScroll() {
    const diff = this.targetScrollPosition - this.scrollPosition;
    console.log(`Animating Scroll: scrollPosition=${this.scrollPosition}, targetScrollPosition=${this.targetScrollPosition}, diff=${diff}`)
    if (Math.abs(diff) < 0.6) {
      this.scrollPosition = this.targetScrollPosition;
      this.animationFrameId = null;
      console.log("animation completed.");
      this.drawBarChart(this.data, this.barChart.nativeElement);
    } else {
      this.scrollPosition += diff * this.scrollSpeed;
      this.drawBarChart(this.data, this.barChart.nativeElement);
      this.animationFrameId = requestAnimationFrame(() => this.animateScroll());
      console.log("Animating scroll...");
    }
  }

  drawBarChart(data: number[], container: HTMLCanvasElement) {
    const ctx = container.getContext('2d');
    if (!ctx) return;

    container.width = this.visibleWidth;
    container.height = window.innerHeight * 0.9;

    ctx.clearRect(0, 0, container.width, container.height);
    ctx.save();
    ctx.translate(-this.scrollPosition, 0);

    data.forEach((value, index) => {
      const x = index * (this.width + 1);
      const height = ((value - 3) / 7) * (container.height - 100);
      if (ctx !== null) {
        ctx.fillStyle = this.colors[index % this.colors.length];
        ctx?.fillRect(x, container.height - height, this.width, height);
      }
    });

    ctx.restore();
  }
  ngOnDestroy(): void {
    if (this.animationFrameId) {
      cancelAnimationFrame(this.animationFrameId);
    }
  }

}
