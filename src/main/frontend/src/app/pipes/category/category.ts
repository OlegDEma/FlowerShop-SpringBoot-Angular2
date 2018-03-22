import {OnInit, Pipe, PipeTransform} from '@angular/core';
import {ProductShopPageComponent} from "../../product-shop-page/product-shop-page.component";
import {TaskService} from "../../services/task.service";
import {Category} from "../../model/Category";
import {forEach} from "@angular/router/src/utils/collection";
@Pipe({
    name: 'category',
    pure:false
})
export class CategoryPipe implements PipeTransform {

    transform(pagedItems: any[], typeOfCategory: string): any[] {
        if(!pagedItems) return [];
        if(!typeOfCategory) return pagedItems;

        if(typeOfCategory==='all'){
            return pagedItems;
        }else {
            return pagedItems.filter(it => {
                return it.category.name == typeOfCategory;
            });
        }

    }
}