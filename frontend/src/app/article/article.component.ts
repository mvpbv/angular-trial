import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PrimaryComponent } from '../primary/primary.component';
import { DemoComponent } from '../demo/demo.component';

@Component({
  selector: 'app-article',
  imports: [CommonModule, DemoComponent],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {
  title = 'article';

  constructor() {}


}
