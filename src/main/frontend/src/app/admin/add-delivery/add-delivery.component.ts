import { Component, OnInit } from '@angular/core';
import {Delivery} from "../../model/Delivery";
import {TaskService} from "../../services/task.service";

@Component({
  selector: 'app-add-delivery',
  templateUrl: './add-delivery.component.html',
  styleUrls: ['./add-delivery.component.css']
})
export class AddDeliveryComponent implements OnInit {

    newDelivery: Delivery = new Delivery();
    deliveryArr: Delivery[] = [];
    change:boolean = false;
    bestDelivery:Delivery =  null;



    constructor(private taskService: TaskService) {
    }

    ngOnInit() {
        this.taskService.getDelivery()
            .subscribe(
                (deliveryArr:any[])=>{
                    this.deliveryArr = deliveryArr;
                }
            );

        this.taskService.onDeliveryAdded.subscribe(
            (delivery:Delivery)=>{
                this.deliveryArr.push(delivery);
            }
        );
    }

    toggle(delivery:Delivery){
        this.change = !this.change;
        if(this.bestDelivery == null && delivery != undefined){
            this.bestDelivery =  new Delivery();
            this.bestDelivery.id = delivery.id;
            this.bestDelivery.wayOfDelivery = delivery.wayOfDelivery;
            this.bestDelivery.firmOfDelivery = delivery.firmOfDelivery;
        }else{
            this.bestDelivery = null;
        }
    }

    addDelivery() {
        this.taskService.addDelivery(this.newDelivery)
            .subscribe(
                (newDelivery: Delivery) => {
                    this.taskService.onDeliveryAdded.emit(newDelivery);
                    this.newDelivery.id = null;
                    this.newDelivery.firmOfDelivery = '';
                    this.newDelivery.wayOfDelivery = '';
                }
            );
    }

    deleteDelivery(id:number){
        let index:number = null;
        for(let delivery of this.deliveryArr){
            if(delivery.id == id){
                index = this.deliveryArr.indexOf(delivery);
            }
        }
        this.deliveryArr.splice(index,1);
        this.taskService.deleteDelivery(id).subscribe(
            (response:Response)=>{
                return response.json();
            }
        );
    }
    changeDelivery(){
        let delivery:Delivery = this.bestDelivery;
        let index:number= null;
        for(let deliveryArr of this.deliveryArr){
            if(deliveryArr.id == delivery.id){
                index = this.deliveryArr.indexOf(deliveryArr);
            }
        }
        this.deliveryArr[index] = delivery;
        this.taskService.addDelivery(delivery)
            .subscribe(
                (delivery:Delivery)=>{
                    this.bestDelivery = null;
                    this.change  = false;
                }
            );
    }



}
