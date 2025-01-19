import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MageComponent } from './mage.component';

describe('LessonComponent', () => {
  let component: MageComponent;
  let fixture: ComponentFixture<MageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
