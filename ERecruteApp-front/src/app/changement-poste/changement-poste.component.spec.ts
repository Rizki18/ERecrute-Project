import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangementPosteComponent } from './changement-poste.component';

describe('ChangementPosteComponent', () => {
  let component: ChangementPosteComponent;
  let fixture: ComponentFixture<ChangementPosteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangementPosteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangementPosteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
