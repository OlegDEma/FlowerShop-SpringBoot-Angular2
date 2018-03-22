import { Pipe, PipeTransform } from '@angular/core';
import {ProductShopPageComponent} from "../../product-shop-page/product-shop-page.component";
@Pipe({
    name: 'typeOfFilter',
    pure:false
})
export class FilterPipe implements PipeTransform {


    transform(pagedItems: any[], typeOfFilter: string): any[] {
        if(!pagedItems) return [];
        if(!typeOfFilter) return pagedItems;
       if(typeOfFilter==='<50'){
           return pagedItems.filter( it => {
               return it.price < 50;
           });
       }else if(typeOfFilter==='50-100'){
           return pagedItems.filter( it => {
               return it.price > 50 && it.price<100;
           });
       }else if(typeOfFilter==='100-150'){
           return pagedItems.filter( it => {
               return it.price > 100 && it.price<150;
           });
       }else if(typeOfFilter==='150-200'){
           return pagedItems.filter( it => {
               return it.price > 150 && it.price<200;
           });
       }else if(typeOfFilter==='200-250'){
           return pagedItems.filter( it => {
               return it.price > 200 && it.price<250;
           });
       }else if(typeOfFilter==='250-300'){
           return pagedItems.filter( it => {
               return it.price > 250 && it.price<300;
           });
       }else if(typeOfFilter==='300-350'){
           return pagedItems.filter( it => {
               return it.price > 300 && it.price<350;
           });
       }else if(typeOfFilter==='350-400'){
           return pagedItems.filter( it => {
               return it.price > 350 && it.price<400;
           });
       }else if(typeOfFilter==='400+'){
           return pagedItems.filter( it => {
               return it.price > 400;
           });
       }else if(typeOfFilter==='all'){
           return pagedItems;
       }

    }
}