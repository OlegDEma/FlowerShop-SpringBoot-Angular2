import { Component, OnInit } from '@angular/core';
import {ProductDescription} from "../../model/ProductDescription";
import {TaskService} from "../../services/task.service";

@Component({
  selector: 'app-add-description',
  templateUrl: './add-description.component.html',
  styleUrls: ['./add-description.component.css']
})
export class AddDescriptionComponent implements OnInit {

    newProductDescription: ProductDescription = new ProductDescription();
    productDescriptionArr: ProductDescription[] = [];
    change:boolean = false;
    bestProductDescription:ProductDescription =  null;


    constructor(private taskService: TaskService) {
    }

    ngOnInit() {
        this.taskService.getDescription()
            .subscribe(
                (ProductDescriptionArr:any[])=>{
                    this.productDescriptionArr = ProductDescriptionArr;
                }
            );

        this.taskService.onDescriptionAdded.subscribe(
            (productDescription:ProductDescription)=>{
                this.productDescriptionArr.push(productDescription);
            }
        );
    }

    toggle(productDescription:ProductDescription){
        this.change = !this.change;
        if(this.bestProductDescription == null && ProductDescription != undefined){
            this.bestProductDescription =  new ProductDescription();
            this.bestProductDescription.id = productDescription.id;
            this.bestProductDescription.description = productDescription.description;
        }else{
            this.bestProductDescription = null;
        }
    }

    addProductDescription() {
        this.taskService.addDescription(this.newProductDescription)
            .subscribe(
                (newProductDescription: ProductDescription) => {
                    this.taskService.onDescriptionAdded.emit(newProductDescription);
                    this.newProductDescription.id = null;
                    this.newProductDescription.description = '';
                }
            );
    }

    deleteProductDescription(id:number){
        let index:number = null;
        for(let ProductDescription of this.productDescriptionArr){
            if(ProductDescription.id == id){
                index = this.productDescriptionArr.indexOf(ProductDescription);
            }
        }
        this.productDescriptionArr.splice(index,1);
        this.taskService.deleteDescription(id).subscribe(
            (response:Response)=>{
                return response.json();
            }
        );
    }
    changeProductDescription(){
        let ProductDescription:ProductDescription = this.bestProductDescription;
        let index:number= null;
        for(let ProductDescriptionArr of this.productDescriptionArr){
            if(ProductDescriptionArr.id == ProductDescription.id){
                index = this.productDescriptionArr.indexOf(ProductDescriptionArr);
            }
        }
        this.productDescriptionArr[index] = ProductDescription;
        this.taskService.addDescription(ProductDescription)
            .subscribe(
                (ProductDescription:ProductDescription)=>{
                    this.bestProductDescription = null;
                    this.change  = false;
                }
            );
    }


}
