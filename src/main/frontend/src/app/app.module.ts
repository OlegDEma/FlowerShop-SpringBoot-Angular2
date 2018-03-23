///<reference path="services/storage.service.ts"/>
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app.component';
import {TaskService} from "./services/task.service";
import {HeaderComponent} from './header/header.component';
import {HomePageComponent} from './home-page/home-page.component';
import {ErrorPageComponent} from './error-page/error-page.component';
import {CartPageComponent} from './cart-page/cart-page.component';
import {ServicePageComponent} from './service-page/service-page.component';
import {ProductShopPageComponent} from './product-shop-page/product-shop-page.component';
import {AppRoutingModule} from "./app-routing.module";
import {PagerService} from "./services/PagerService";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {Ng2OrderModule} from "ng2-order-pipe";
import {NgxPaginationModule} from "ngx-pagination";
import {FilterPipe} from "./pipes/filter/filter";
import {CategoryPipe} from "./pipes/category/category";
import { StoreModule } from '@ngrx/store';
import {ShoppingCartService} from "./services/shoping-cart.service";
import {LocalStorageServie, StorageService} from "./services/storage.service";
import {AlertService, AuthenticationService, UserService} from "./services";
import {RegisterComponent} from "./registration/register.component";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {JwtInterceptor} from "./registration/jwt.interceptor";
import {LoginComponent} from "./login";
// import {AuthModule} from "./auth/auth.module";


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomePageComponent,
    ErrorPageComponent,
    CartPageComponent,
    ServicePageComponent,
    ProductShopPageComponent,
      FilterPipe,
      CategoryPipe,
      RegisterComponent,
      LoginComponent,



  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
      AppRoutingModule,
      Ng2SearchPipeModule,
      Ng2OrderModule,
      NgxPaginationModule,
      HttpClientModule,


      // AuthModule,
  ],
  providers: [TaskService,PagerService,{ provide: StorageService, useClass: LocalStorageServie },
      {
          deps: [StorageService, TaskService],
          provide: ShoppingCartService,
          useClass: ShoppingCartService
      },UserService,AlertService,AuthenticationService,
      {
          provide: HTTP_INTERCEPTORS,
          useClass: JwtInterceptor,
          multi: true
      },],
  bootstrap: [AppComponent]
})
export class AppModule { }
