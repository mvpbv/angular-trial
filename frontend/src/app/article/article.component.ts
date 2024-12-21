import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimaryComponent } from '../primary/primary.component';

@Component({
  selector: 'app-article',
  imports: [CommonModule, PrimaryComponent],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {
  title = 'article';

  constructor() {}

  
}
