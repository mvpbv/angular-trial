import { Component, OnInit } from '@angular/core';
import { AnalyticsService } from '../analytics.service';
import { HotSpot } from '../models/hotspot.model';
import { CommonModule, KeyValue } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AnalyticsStats } from '../models/analytics-stats.models';
import { HotspotFormComponent } from "../hotspot-form/hotspot-form.component";
import { WindowService } from '../window.service';
import { StatsComponent } from "../stats/stats.component";
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-hotspots',
  imports: [CommonModule, ReactiveFormsModule, RouterModule, HotspotFormComponent, StatsComponent],
  templateUrl: './hotspots.component.html',
  styleUrl: './hotspots.component.css'
})
export class HotspotsComponent implements OnInit {
  title = 'hotspots';
  
  hotspots : Record<number, HotSpot[]> = {};
  stats: AnalyticsStats = {
    average: 0,
    standardDeviation: 0,
    variance: 0,
    median: 0,
    max: 0,
    min: 0
  };
  expandedHotspots: Set<number> = new Set();
  expandedGroups: Set<number> = new Set();
  hotspotForm = new FormGroup({
    window: new FormControl(3, [Validators.required, Validators.min(2), Validators.max(16)]),
  });
  window = 3;

  constructor(private analyticsService: AnalyticsService, private windowService: WindowService) {}

  ngOnInit(): void {
    this.windowService.window$.subscribe(window => {
      this.onWindowChange(window);
    });
    this.analyticsService.getHotSpotsGrouped(3).subscribe((data: any) => {
      this.hotspots = data;
    });
    
  }

  onWindowChange(window: number): void {
    this.analyticsService.getHotSpotsGrouped(window).subscribe((data: Record<number, HotSpot[]>) => {
      this.hotspots = data;
    });
    this.window = window;
  }

  noSortComparator = (a: KeyValue<string, HotSpot[]>, b: KeyValue<string, HotSpot[]>) => {
    let abs = parseInt(a.key);
    let bbs = parseInt(b.key);
    return bbs - abs; 
  }

  toggleHotspot(index: number) {
    if (this.expandedHotspots.has(index)) {
      this.expandedHotspots.delete(index);
    } else {
      this.expandedHotspots.add(index);
    }
  }
  toggleGroup(index: number) {
    if (this.expandedGroups.has(index)) {
      this.expandedGroups.delete(index);
    } else {
      this.expandedGroups.add(index);
    }
  } 
  
  
}
