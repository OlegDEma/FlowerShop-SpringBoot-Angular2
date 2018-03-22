import {Component, OnInit,} from '@angular/core';
import {Manager} from "../../model/Manager";
import {TaskService} from "../../services/task.service";
import {Brand} from "../../model/Brand";

@Component({
  templateUrl:'./add-manager.component.html',
    styleUrls:['./add-manager.component.css']
})
export class AddManagerComponent implements OnInit{

   newManager:Manager = new Manager();
   managers : Manager[] = [];
   change:boolean = false;
   index:number = null;
    bestManager : Manager = null;

    ngOnInit() {
        this.taskService.getManagers()
            .subscribe(
                (managers:any[])=>{
                    this.managers = managers;
                }
            );
        this.taskService.onManagerAdded
            .subscribe(
                (manager:Manager)=>{
                    this.managers.push(manager);
                }
            );

        console.log(this.managers);

    }
    constructor(private taskService:TaskService){
    }

    toggle(manager:Manager){
        this.change =  !this.change;
        if(this.bestManager == null && manager != undefined){
            this.bestManager = new Manager();
            this.bestManager.id = manager.id;
            this.bestManager.name = manager.name;
            this.bestManager.surname = manager.surname;
            this.bestManager.phone = manager.phone;
            this.bestManager.patronymic = manager.patronymic;
            this.bestManager.city = manager.city;
            this.bestManager.mail = manager.mail;
            this.bestManager.storage  = manager.storage;
        }else{
            this.bestManager = null;
        }
    }

    onManagerAdd() {

        this.taskService.addManager(this.newManager)
            .subscribe(
                (newManager: Manager) => {
                    this.taskService.onManagerAdded.emit(newManager);
                   this.passManager();
                }
            );
    }

    changeManager(){
        let manager:Manager = this.bestManager;
        let indexArr:number = null;
        for(let managerArr of this.managers){
            if(managerArr.id == manager.id ){
                indexArr = this.managers.indexOf(managerArr);
            }
        }
        this.managers[indexArr] = manager;
        this.taskService.addManager(manager)
            .subscribe(
                (brand:Brand) =>{
                   this.bestManager = null;
                   this.index = null;
                   this.change = false;

                }
            );
    }

    deleteManager(id:number){
        let arrIndex =  null;
        for(let manager of this.managers){
            if(manager.id == id){
                arrIndex = this.managers.indexOf(manager);
            }
        }
        this.managers.splice(arrIndex,1);
        this.taskService.deleteManager(id)
            .subscribe(
                (response:Response)=>{
                    return response.json();
                }
            );

    }

    passManager(){
        this.newManager.id = null;
        this.newManager.name = "";
        this.newManager.surname = "";
        this.newManager.patronymic = "";
        this.newManager.phone = null;
        this.newManager.mail = "";
        this.newManager.storage = "";
        this.newManager.city = "";
    }


}


/*
Copyright 2017-2018 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/