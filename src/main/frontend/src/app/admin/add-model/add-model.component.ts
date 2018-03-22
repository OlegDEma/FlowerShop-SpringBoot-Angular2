import { Component, OnInit } from '@angular/core';
import {Model} from "../../model/Model";
import {TaskService} from "../../services/task.service";

@Component({
  selector: 'app-add-model',
  templateUrl: './add-model.component.html',
  styleUrls: ['./add-model.component.css']
})
export class AddModelComponent implements OnInit {

  newModel:Model = new Model();
  modelArr: Model[] = [];
  change:boolean = false;
  bestModel:Model  = null;

  constructor(private taskService:TaskService) { }

    ngOnInit() {
      this.taskService.getModels()
          .subscribe(
              (modelArr:any[])=>{
                this.modelArr = modelArr;
              }
          );

      this.taskService.onModelAdded
          .subscribe(
              (model:Model)=>{
                this.modelArr.push(model);
              }
          );
    }
    toggle(model:Model){
        this.change = !this.change;
        if(this.bestModel == null && model != undefined){
            this.bestModel =  new Model();
            this.bestModel.id = model.id;
            this.bestModel.name = model.name;
        }else{
            this.bestModel = null;
        }
    }

    addModel() {
        this.taskService.addModel(this.newModel)
            .subscribe(
                (newModel: Model) => {
                    this.taskService.onModelAdded.emit(newModel);
                    this.newModel.id = null;
                    this.newModel.name = '';
                }
            );
    }

    deleteModel(id:number){
        let index:number = null;
        for(let model of this.modelArr){
            if(model.id == id){
                index = this.modelArr.indexOf(model);
            }
        }
        this.modelArr.splice(index,1);
        this.taskService.deleteModel(id).subscribe(
            (response:Response)=>{
                return response.json();
            }
        );
    }
    changeModel(){
        let model:Model = this.bestModel;
        let index:number= null;
        for(let modelArr of this.modelArr){
            if(modelArr.id == model.id){
                index = this.modelArr.indexOf(modelArr);
            }
        }
        this.modelArr[index] = model;
        this.taskService.addModel(model)
            .subscribe(
                (model:Model)=>{
                    this.bestModel = null;
                    this.change  = false;
                }
            );
    }





}
