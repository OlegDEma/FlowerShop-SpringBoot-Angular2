import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AdminComponent }           from './admin.component';
import {AddBrandComponent} from './add-brand/add-brand.component';
import {AddManagerComponent} from './add-manager/add-manager.component';
import {AddCategoryComponent } from './add-category/add-category.component';
import {AddDeliveryComponent} from "./add-delivery/add-delivery.component";
import {AddModelComponent} from "./add-model/add-model.component";
import {AddDescriptionComponent} from "./add-description/add-description.component";
import {AddProductComponent} from "./add-product/add-product.component";


const adminRoutes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      {
        path: '',
        children: [
          { path: 'managers', component: AddManagerComponent },
          { path: 'category', component: AddCategoryComponent },
            { path: 'delivery', component: AddDeliveryComponent },
            { path: 'model', component: AddModelComponent },
            { path: 'description', component: AddDescriptionComponent },
            { path: 'product', component: AddProductComponent },
          { path: '', component: AddBrandComponent }
        ]
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(adminRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AdminRoutingModule {}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/