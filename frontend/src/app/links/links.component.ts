import { Component, OnInit } from '@angular/core';
import { LinksService } from '../links.service';
import { Domain, Link } from '../models/link.model';

@Component({
  selector: 'app-links',
  imports: [],
  templateUrl: './links.component.html',
  styleUrl: './links.component.css'
})
export class LinksComponent implements OnInit {
  title = 'links';
  domains : Domain[] = [];
  links: { [key: number]: Link[] } = {};
  selectedDomains: Set<number> = new Set();
  constructor(private linksService: LinksService) {}

  ngOnInit(): void {
    this.linksService.getDomains().subscribe((data: Domain[]) => {
      this.domains = data;
    });
  }
  getLinks(id: number): void {
    if (this.links[id]) {
      this.toggleDomain(id);
      return;
    }
    this.linksService.getLinks(id).subscribe((data: any) => {
      this.links[id] = data;
      this.toggleDomain(id);
    });

  }
  toggleDomain(id: number): void {
    if (this.selectedDomains.has(id)) {
      this.selectedDomains.delete(id);
    } else {
      this.selectedDomains.add(id);
    }
  }

}
