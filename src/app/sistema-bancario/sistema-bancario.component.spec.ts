import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SistemaBancarioComponent } from './sistema-bancario.component';

describe('SistemaBancarioComponent', () => {
  let component: SistemaBancarioComponent;
  let fixture: ComponentFixture<SistemaBancarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SistemaBancarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SistemaBancarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
