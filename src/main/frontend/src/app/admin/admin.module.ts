import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminComponent} from './admin.component';
import {AddBrandComponent} from './add-brand/add-brand.component';
import {AddManagerComponent} from './add-manager/add-manager.component';
import {AddCategoryComponent} from './add-category/add-category.component';

import {AdminRoutingModule} from './admin-routing.module';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {TaskService} from "../services/task.service";
import {AddDeliveryComponent} from './add-delivery/add-delivery.component';
import {AddModelComponent} from './add-model/add-model.component';
import {AddDescriptionComponent} from './add-description/add-description.component';
import {AddProductComponent} from './add-product/add-product.component';
import {PagerService} from "../services/PagerService";
import {Ng2SearchPipeModule} from "ng2-search-filter";
import {FilterPipe} from "../pipes/filter/filter";

@NgModule({
  imports: [
    CommonModule,
    AdminRoutingModule,
      FormsModule,
      HttpModule,
      ReactiveFormsModule,
      Ng2SearchPipeModule,
  ],
  declarations: [
    AdminComponent,
      AddBrandComponent,
      AddManagerComponent,
      AddCategoryComponent,
    AddDeliveryComponent,
    AddModelComponent,
    AddDescriptionComponent,
    AddProductComponent,





  ],
    providers: [TaskService,PagerService]
})
export class AdminModule {}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/