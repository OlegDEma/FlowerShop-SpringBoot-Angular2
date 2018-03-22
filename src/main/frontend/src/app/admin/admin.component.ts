import { Component } from '@angular/core';

@Component({
  template:  `
    <h3>ADMIN</h3>
    <nav>
      <a routerLink="./" routerLinkActive="active"
        [routerLinkActiveOptions]="{ exact: true }">Brands</a>
      <a routerLink="./managers" routerLinkActive="active">Managers</a>
      <a routerLink="./category" routerLinkActive="active">Category</a>
        <a routerLink="./delivery" routerLinkActive="active">Delivery</a>
        <a routerLink="./model" routerLinkActive="active">Model</a>
        <a routerLink="./description" routerLinkActive="active">Description</a>
        <a routerLink="./product" routerLinkActive="active">Product</a>
    </nav>
    <router-outlet></router-outlet>
  `
})
export class AdminComponent {

}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/