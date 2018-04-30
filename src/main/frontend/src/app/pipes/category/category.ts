import {OnInit, Pipe, PipeTransform} from '@angular/core';

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