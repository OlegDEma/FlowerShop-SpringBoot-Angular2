import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';



import {HomePageComponent} from "./home-page/home-page.component";
import {CartPageComponent} from "./cart-page/cart-page.component";
import {ServicePageComponent} from "./service-page/service-page.component";
import {ErrorPageComponent} from "./error-page/error-page.component";
import {ProductShopPageComponent} from "./product-shop-page/product-shop-page.component";
import {RegisterComponent} from "./registration/register.component";
import {LoginComponent} from "./login";


const appRoutes: Routes = [
  {
    path: 'admin',
    loadChildren: 'app/admin/admin.module#AdminModule',
  },
  {path:'', component: HomePageComponent },
    {path:'cart',component:CartPageComponent},
    {path:'404', component: ErrorPageComponent},
    {path:'service', component: ServicePageComponent},
    {path:'shop', component: ProductShopPageComponent},
    {path:'reg', component: RegisterComponent},
    {path:'auth', component: LoginComponent},
    // {path:'auth', component: AuthComponent},

];

@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: true,
        // preloadingStrategy: SelectivePreloadingStrategy,

      }
    )
  ],
  exports: [
    RouterModule
  ],
  providers: [
    // SelectivePreloadingStrategy
  ]
})
export class AppRoutingModule { }


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/