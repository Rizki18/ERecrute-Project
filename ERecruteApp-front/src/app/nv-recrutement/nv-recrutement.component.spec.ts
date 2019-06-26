import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NvRecrutementComponent } from './nv-recrutement.component';

describe('NvRecrutementComponent', () => {
  let component: NvRecrutementComponent;
  let fixture: ComponentFixture<NvRecrutementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NvRecrutementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NvRecrutementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
