import { Component, Input, OnInit, SimpleChange, SimpleChanges } from '@angular/core';
import { AnalyticsStats } from '../models/analytics-stats.models';
import { AnalyticsService } from '../analytics.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-stats',
  imports: [CommonModule],
  templateUrl: './stats.component.html',
  styleUrl: './stats.component.css'
})
export class StatsComponent implements OnInit {
    title = 'stats';
  @Input() window : number = 3;
  @Input() stats: AnalyticsStats = {
      average: 0,
      standardDeviation: 0,
      variance: 0,
      median: 0,
      max: 0,
      min: 0
    };

    constructor(private analyticsService:AnalyticsService) {}

    ngOnInit(): void {
      this.analyticsService.getHotSpotsStats(3).subscribe((data: AnalyticsStats) => {
        this.stats = data;
      });
    }
    ngOnChanges(changes: SimpleChanges): void {
      if (changes['window']) {
        this.onWindowChange(changes['window'].currentValue);
      }
    }
    onWindowChange(window: number): void {
      this.analyticsService.getHotSpotsStats(window).subscribe((data: AnalyticsStats) => {
        this.stats = data;
      });
    }


}