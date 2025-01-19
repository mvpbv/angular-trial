import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-resources',
  imports: [CommonModule],
  templateUrl: './resources.component.html',
  styleUrl: './resources.component.css'
})
export class ResourcesComponent {
  isCollapsed : boolean[] = []

  toggleCollapse(index: number) {
    this.isCollapsed[index] = !this.isCollapsed[index]
  }
}
