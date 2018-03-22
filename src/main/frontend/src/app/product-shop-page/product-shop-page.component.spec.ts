import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductShopPageComponent } from './product-shop-page.component';

describe('ProductShopPageComponent', () => {
  let component: ProductShopPageComponent;
  let fixture: ComponentFixture<ProductShopPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductShopPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductShopPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
