import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecensioniComponent } from './recensioni.component';

describe('RecensioniComponent', () => {
  let component: RecensioniComponent;
  let fixture: ComponentFixture<RecensioniComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecensioniComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecensioniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
