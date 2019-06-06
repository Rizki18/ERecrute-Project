import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MotClesComponent } from './mot-cles.component';

describe('MotClesComponent', () => {
  let component: MotClesComponent;
  let fixture: ComponentFixture<MotClesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MotClesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MotClesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
