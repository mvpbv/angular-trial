import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimaryHotspotsComponent } from '../primary-hotspots/primary-hotspots.component';

@Component({
  selector: 'app-article',
  imports: [CommonModule, PrimaryHotspotsComponent],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {
  title = 'article';

  constructor() {}

  
}
