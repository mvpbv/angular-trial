import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { WindowService } from '../window.service';
import { CommonModule } from '@angular/common';
import { debounceTime } from 'rxjs/internal/operators/debounceTime';
import { ImplicitReceiver } from '@angular/compiler';

@Component({
  selector: 'app-hotspot-form',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './hotspot-form.component.html',
  styleUrl: './hotspot-form.component.css'
})
export class HotspotFormComponent implements OnInit {
  title = 'hotspot-form';
  isSliderFocused = false;
  @Input() hotspotForm: FormGroup = new FormGroup({
    window: new FormControl(3, [Validators.required, Validators.min(2), Validators.max(16)]),
  });
  window = 3;
  constructor(private windowService: WindowService) {}
  ngOnInit(): void {
    this.hotspotForm.get('window')?.valueChanges.pipe(
      debounceTime(300)
    ).subscribe(value => {
      this.onWindowChange(value!);
    });
  }
  onSliderFocus() {
    this.isSliderFocused = true;
  }
  
  onSliderBlur() {
    this.isSliderFocused = false;
  }
  onWindowChange(window: number): void {
    this.windowService.setWindow(window);
  }


}
