import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotspotsComponent } from './hotspots.component';

describe('HotspotsComponent', () => {
  let component: HotspotsComponent;
  let fixture: ComponentFixture<HotspotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotspotsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotspotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
