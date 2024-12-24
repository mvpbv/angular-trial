import { Component, ElementRef, ViewChild, AfterViewInit } from '@angular/core';
import { StarfieldComponent } from "../starfield/starfield.component";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  imports: [StarfieldComponent],
})
export class HomeComponent  {
  
}