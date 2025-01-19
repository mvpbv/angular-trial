import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecursionComponent } from './recursion.component';

describe('RecursionComponent', () => {
  let component: RecursionComponent;
  let fixture: ComponentFixture<RecursionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecursionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecursionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
