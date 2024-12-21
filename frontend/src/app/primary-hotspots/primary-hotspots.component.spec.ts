import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimaryHotspotsComponent } from './primary-hotspots.component';

describe('PrimaryHotspotsComponent', () => {
  let component: PrimaryHotspotsComponent;
  let fixture: ComponentFixture<PrimaryHotspotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrimaryHotspotsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrimaryHotspotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
