import { Component, OnInit } from '@angular/core';
import { LinksService } from '../links.service';

@Component({
  selector: 'app-links',
  imports: [],
  templateUrl: './links.component.html',
  styleUrl: './links.component.css'
})
export class LinksComponent implements OnInit {
  title = 'links';
  links = [];
  constructor(private linksService: LinksService) {}

  ngOnInit(): void {
    this.linksService.getDomains().subscribe((data: any) => {
      this.links = data;
    });
  }


}
