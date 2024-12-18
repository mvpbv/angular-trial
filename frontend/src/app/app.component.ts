import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    ReactiveFormsModule,
  ],
  template: `
    <title>boot-utils</title>
    <header class="header">
      <h1 class="site-title"> Welcome boot.devvers </h1>
      <nav class="navbar">
        <ul class="nav-list">
          <li class="nav-item"><a routerLink="/">Home</a></li>
          <li class="nav-item"><a routerLink="/fetch">Fetch</a></li>
          <li class="nav-item"><a routerLink="/analytics">Analytics</a></li>
          <li class="nav-item"><a routerLink="/progress">Progress</a></li>
        </ul>
      </nav>
    </header>
    <router-outlet></router-outlet>
  `,

  styleUrl: './app.component.css'
})
export class AppComponent { 
  title = 'boot-utils';
}
