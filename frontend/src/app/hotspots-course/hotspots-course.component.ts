import { Component, OnInit } from '@angular/core';
import { AnalyticsService } from '../analytics.service';
import { HotSpot } from '../models/hotspot.model';
import { CommonModule, KeyValue } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AnalyticsStats } from '../models/analytics-stats.models';
import { HotspotFormComponent } from "../hotspot-form/hotspot-form.component";
import { StatsComponent } from "../stats/stats.component";

@Component({
  selector: 'app-hotspots',
  imports: [CommonModule, ReactiveFormsModule, HotspotFormComponent, StatsComponent],
  templateUrl: './hotspots-course.component.html',
  styleUrl: './hotspots-course.component.css'
})
export class HotspotsCourseComponent implements OnInit {
  title = 'hotspots-course';
  isSliderFocused = false;
  hotspots : Record<number, HotSpot[]> = {};
  
  hotspotForm = new FormGroup({
    window: new FormControl(3, [Validators.required, Validators.min(2), Validators.max(16)]),
  });
  window = 3;
  expandedHotspots: Set<number> = new Set();
  expandedGroups: Set<number> = new Set();
  constructor(private analyticsService: AnalyticsService) {}

  ngOnInit(): void {
    
    this.analyticsService.getHotSpotsCourse(3).subscribe((data: any) => {
      this.hotspots = data;
    });
    this.hotspotForm.get('window')?.valueChanges.subscribe(value => {
      this.onWindowChange(value!);
    });
  }

  onWindowChange(window: number): void {
    
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
