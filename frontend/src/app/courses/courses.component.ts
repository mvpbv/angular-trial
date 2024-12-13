import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TracksService} from '../tracks.service';

@Component({
  selector: 'app-courses',
  imports: [CommonModule, FormsModule],
  templateUrl: './courses.component.html',
  styleUrl: './courses.component.css'
})
export class CoursesComponent {
  tracks: any[] = [];

  constructor(private tracksService: TracksService) {
    this.tracks = this.tracksService.getStandard();
  }
  ngOnInit(): void {
    this.tracks = this.tracksService.getStandard();
  }
  
  toggleCoursesVisibility(track: any): void {
    track.coursesVisible = !track.coursesVisible;
  }
  loadStandard(): void {
    this.tracks = this.tracksService.getStandard();
  }
  loadMild(): void {
    this.tracks = this.tracksService.getMildEnhancements();
  }
}
