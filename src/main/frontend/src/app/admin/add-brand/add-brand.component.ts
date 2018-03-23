import { Component, OnInit }    from '@angular/core';
import { ActivatedRoute }       from '@angular/router';
import { Observable }           from 'rxjs/Observable';

// import { SelectivePreloadingStrategy } from '../../selective-preloading-strategy';

import 'rxjs/add/operator/map';
import {Brand} from "../../model/Brand";
import {TaskService} from "../../services/task.service";
import {Manager} from "../../model/Manager";

@Component({
  templateUrl:`./add-brand.component.html`,
    styleUrls: ['./add-brand.component.css']
})
export class AddBrandComponent implements OnInit {
  sessionId: Observable<string>;
  token: Observable<string>;
  modules: string[];

  addBrandValue : string = null;
  newName:string = null;
  index:number = null;
  enableChange:boolean = false;

  brands :Brand[]=[];

  constructor(
      private taskService:TaskService,
    private route: ActivatedRoute,
  ) {
  }

  ngOnInit() {
    // this.sessionId = this.route
    //   .queryParamMap
    //   .map(params => params.get('session_id') || 'None');
    //
    // this.token = this.route
    //   .fragment
    //   .map(fragment => fragment || 'None');

     this.taskService.getBrands()
         .subscribe(
             (brands:any[])=>{
                 this.brands = brands;
                }
         );
     this.taskService.onBrandAdded.subscribe(
         (brand:Brand) => this.brands.push(brand)
     );

  }

  example(){
        this.taskService.example().subscribe(
            (er:string)=>{
                console.log(er);
            }
        );
  }

  toggle(id:number){
      this.index = id;
      this.enableChange = !this.enableChange;
  }

    onBrandAdd(event) {

    let brand: Brand = new Brand(event.target.value);
    console.log(brand);
    this.taskService.addBrand(brand)
        .subscribe(
            (newBrand: Brand) => {
                this.addBrandValue = ' ';
                this.addBrandValue = null;
                this.taskService.onBrandAdded.emit(newBrand);
            }
        );
}

    deleteBrand(id:number){
      let oldBrand : Brand;
      for(let brand of this.brands){
          if(brand.id == id){
              oldBrand = brand;
          }
      }
      let index :number =  this.brands.indexOf(oldBrand);
      this.brands.splice(index,1);
      this.taskService.deleteBrand(id).
          subscribe(
          (brand:Brand)=>{

          }
      );
    }

    changeBrand(){
      let brand:Brand = new Brand(this.newName);
      brand.id = this.index;
      let indexArr:number = null;
      for(let brandArr of this.brands){
          if(brandArr.id == brand.id ){
              indexArr = this.brands.indexOf(brandArr);
          }
      }
      this.brands[indexArr] = brand;
      this.taskService.changeBrand(brand)
          .subscribe(
              (brand:Brand) =>{
                   this.newName = "";
                   this.newName =  null;
                   this.enableChange = false;
              }
          );
    }



}



/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/