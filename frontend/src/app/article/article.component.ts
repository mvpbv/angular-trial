import { Component } from '@angular/core';
import { AnalyticsService } from '../analytics.service';
import { CommonModule } from '@angular/common';


import { HotSpot } from '../models/hot-spot.model';
import { HotspotsComponent } from "../hotspots/hotspots.component";

@Component({
  selector: 'app-article',
  imports: [CommonModule, HotspotsComponent],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {
  hotspots : HotSpot[] = [];
  title = 'article';

  constructor(private analyticsService: AnalyticsService) {}

  
}
