import { Component, OnInit } from '@angular/core';
import { LinksService } from '../links.service';
import {CourseInfo, Domain, Link} from '../models/link.model';

@Component({
  selector: 'app-links',
  imports: [],
  templateUrl: './links.component.html',
  styleUrl: './links.component.css'
})
export class LinksComponent implements OnInit {
  title = 'links';
  domains : Map<number, Domain[]> = new Map();
  courses : CourseInfo[] = [];
  links: { [key: number]: {[key : number]: Link[]} } = {};
  selectedDomains: Set<number> = new Set();
  selectedCourses: Set<number> = new Set();
  constructor(private linksService: LinksService) {}

  ngOnInit(): void {
    this.linksService.getCourse().subscribe((data: any) => {
      this.courses = data;
    });
  }
  getDomains(courseIndex : number): void {
    this.linksService.getDomains(courseIndex).subscribe((data: any) => {
      this.domains.set(courseIndex, data);
      this.toggleCourse(courseIndex);
    });
  }
  getLinks(domainId: number, courseId: number): void {
    if (this.links[domainId]) {
      this.toggleDomain(domainId);
      return;
    }
    this.linksService.getLinks(domainId, courseId).subscribe((data: any) => {
      this.links[courseId][domainId] = data;
      this.toggleDomain(domainId);
    });

  }
  toggleCourse(id: number) {
    if (this.selectedCourses.has(id)) {
      this.selectedCourses.delete(id);
    } else {
      this.selectedCourses.add(id);
      this.getDomains(id);
    }
}
  toggleDomain(id: number): void {
    if (this.selectedDomains.has(id)) {
      this.selectedDomains.delete(id);
    } else {
      this.selectedDomains.add(id);
    }
  }

}
