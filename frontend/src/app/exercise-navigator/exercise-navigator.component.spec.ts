import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseNavigatorComponent } from './exercise-navigator.component';

describe('ExerciseNavigatorComponent', () => {
  let component: ExerciseNavigatorComponent;
  let fixture: ComponentFixture<ExerciseNavigatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExerciseNavigatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExerciseNavigatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
