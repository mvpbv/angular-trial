import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotspotFormComponent } from './hotspot-form.component';

describe('HotspotFormComponent', () => {
  let component: HotspotFormComponent;
  let fixture: ComponentFixture<HotspotFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotspotFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotspotFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
