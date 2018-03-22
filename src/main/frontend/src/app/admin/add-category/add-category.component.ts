import { Component } from '@angular/core';
import {TaskService} from "../../services/task.service";
import {Category} from "../../model/Category";
import {Brand} from "../../model/Brand";

@Component({
 templateUrl:'./add-category.component.html',
    styleUrls:['./add-category.component.css']
})
export class AddCategoryComponent {
  addCategoryValue:string = null;

  constructor(private taskService:TaskService){

  }

    onCategoryAdd(event) {

        let category: Category = new Category(event.target.value);
        this.taskService.addCategory(category)
            .subscribe(
                (newCategory: Category) => {
                    this.addCategoryValue = ' ';
                    this.addCategoryValue = null;
                }
            );
    }
}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/