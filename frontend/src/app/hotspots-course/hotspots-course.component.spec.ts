import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HotspotsCourseComponent } from './hotspots-course.component';

describe('HotspotsCourseComponent', () => {
  let component: HotspotsCourseComponent;
  let fixture: ComponentFixture<HotspotsCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HotspotsCourseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HotspotsCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
