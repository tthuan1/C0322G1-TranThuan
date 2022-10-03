import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GreatBooksComponent } from './great-books.component';

describe('GreatBooksComponent', () => {
  let component: GreatBooksComponent;
  let fixture: ComponentFixture<GreatBooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GreatBooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GreatBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
