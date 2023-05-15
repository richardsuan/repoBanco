import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TarjetacontrolComponent } from './tarjetacontrol.component';

describe('TarjetacontrolComponent', () => {
  let component: TarjetacontrolComponent;
  let fixture: ComponentFixture<TarjetacontrolComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TarjetacontrolComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TarjetacontrolComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
