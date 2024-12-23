import { CommonModule } from '@angular/common';
import { AfterViewInit, Component, ElementRef, HostListener, QueryList, ViewChildren } from '@angular/core';


@Component({
  selector: 'app-demo',
  imports: [CommonModule],
  templateUrl: './demo.component.html',
  styleUrl: './demo.component.css'
})
export class DemoComponent implements AfterViewInit {
  title = 'demo';
  data = [6, 7, 8, 9, 7, 4, 5, 7, 5, 5, 7, 7, 5, 6, 4, 5, 7, 7, 6, 4, 7]
  activeIndex: number | null = null;
  underlineStyle = {};
  underlineSum: number = 0;
  numPoints: number = 3;
  isPlaying: boolean = false;
  @ViewChildren('dataItem', { read: ElementRef }) dataItems!: QueryList<ElementRef>;
  moveInterval: any;
  
  
  constructor(private elRef: ElementRef) {}

  ngAfterViewInit(): void {
    
    if (this.data.length >= this.numPoints) {
      this.moveLine(0);
    }
  }
  moveLine(index: number): void {
    this.activeIndex = index;
    const end = Math.min(index + this.numPoints, this.data.length);
    const selectedData = this.data.slice(index, end);
    this.underlineSum = selectedData.reduce((sum, val) => sum + val, 0);
    
    setTimeout(() => {
      const selectedItems = this.dataItems.toArray().slice(index, end);
      if (selectedItems.length > 0) {
        const firstItem = selectedItems[0].nativeElement;
        const lastItem = selectedItems[selectedItems.length - 1].nativeElement;
        const firstItemRect = firstItem.getBoundingClientRect();
        const lastItemRect = lastItem.getBoundingClientRect();
        const parentRect = this.elRef.nativeElement.getBoundingClientRect();

        const left = firstItemRect.left - parentRect.left;
        const width = lastItemRect.right - firstItemRect.left;

        this.underlineStyle = {
          'left.px': left,
          'width.px': width
        };
      }
    }, 0);
  }
  @HostListener('window:keydown', ['$event'])
  handleKeyDown(event: KeyboardEvent): void {
    if (this.activeIndex === null) {
      return;
    }
    if (event.key === 'ArrowRight' && this.activeIndex! < this.data.length - this.numPoints) {
      this.moveLine(this.activeIndex! + 1);
    } else if (event.key === 'ArrowLeft' && this.activeIndex! > 0) {
      this.moveLine(this.activeIndex! - 1);
    }
  }
  startAutoMove(): void {
    if (this.isPlaying) {
      this.stopAutoMove();
    } else {
      this.moveInterval = setInterval(() => {
        if (this.activeIndex! < this.data.length - this.numPoints) {
          this.moveLine(this.activeIndex! + 1);
        } else {
          clearInterval(this.moveInterval);
          this.moveInterval = null;
        }
      }, 1000);
      this.isPlaying = true;
    }
}
  stopAutoMove(): void {
    if (this.moveInterval) {
      clearInterval(this.moveInterval);
      this.moveInterval = 0; 
      this.isPlaying = false;
    }
  }
  incrementSize(): void {
    this.numPoints = Math.min(this.numPoints + 1, this.data.length);
    this.stopAutoMove();
  }
  decrementSize(): void {
    this.numPoints = Math.max(this.numPoints - 1, 1);
    this.stopAutoMove();
  }
  
}
