import { Component, OnInit } from '@angular/core';
import {Product} from "../model/Product";
import {TaskService} from "../services/task.service";
import {PagerService} from "../services/PagerService";
import { Response } from '@angular/http';
import {promise} from "selenium-webdriver";
import {forEach} from "@angular/router/src/utils/collection";
import {Category} from "../model/Category";
import {ShoppingCartService} from "../services/shoping-cart.service";
import {Observable} from "rxjs/Observable";
import {Observer} from "rxjs/Observer";
@Component({
  selector: 'app-product-shop-page',
  templateUrl: './product-shop-page.component.html',
  styleUrls: ['./product-shop-page.component.css']
})
export class ProductShopPageComponent implements OnInit {

    products : Product[] = [];


    private allItems: any[];


    pager: any = {};

    pagedItems: any[];

    copyPagedItems: any[];

    itemsProduct:Product[];

    key: string = 'id';
    reverse: boolean = false;

    p: number = 1;

    typeOfFilter:string = 'all';
    typeOfCategory:string = 'all';

    categories:Category[] = [];


    constructor(private taskService:TaskService, private pagerService:PagerService,private shoppingCartService: ShoppingCartService) { }


  ngOnInit() {
      this.taskService.getProduct()
          .subscribe(
              (products:any[])=>{
                  this.allItems = products;
                  this.copyPagedItems = products;
                  this.itemsProduct = products;
                  console.log(this.allItems);
                  // this.setPage(1);
              }
          );

      this.taskService.getCategory()
          .subscribe(
              (categories:Category[])=>{
                  this.categories = categories;
              }
          );
      // this.copyPagedItems = this.pagedItems;

      // console.log(this.pager);
      // console.log(this.pagedItems);
      // console.log(this.copyPagedItems);
  }

  ///CART

    public addProductToCart(product: Product): void {
        this.shoppingCartService.addItem(product, 1);
    }

    public removeProductFromCart(product: Product): void {
        this.shoppingCartService.addItem(product, -1);
    }

    public productInCart(product: Product): boolean {
        return Observable.create((obs: Observer<boolean>) => {
            const sub = this.shoppingCartService
                .get()
                .subscribe((cart) => {
                    obs.next(cart.items.some((i) => i.productId === (product.id).toString()));
                    obs.complete();
                });
            sub.unsubscribe();
        });
    }


    ////

  changeTypeOfFilter(type:string){
      this.typeOfFilter = type;
  }
  changeTypeOfCategory(typeOfCategory:string){
      this.typeOfCategory = typeOfCategory;
  }

  addInCart(product:Product){
        this.taskService.addProductCart(product);
  }

  top(){
      window.scrollTo({ left: 0, top: 700, behavior: 'smooth' });
  }

    sort(key){
        this.key = key;
        this.reverse = !this.reverse;
    }

  sortType(type:string){
        if(type==='name'){
            this.allItems = this.copyPagedItems.sort(this.sortByProductName);
            this.allItems = this.copyPagedItems.sort(this.sortByProductName);
        }else if(type==='priceDesc'){
            this.allItems = this.copyPagedItems.sort(this.sortByProductPriceDesc);
            this.allItems = this.copyPagedItems.sort(this.sortByProductPriceDesc);
        }else if(type==='priceEsc'){
            this.allItems = this.copyPagedItems.sort(this.sortByProductPriceEsc);
            this.allItems = this.copyPagedItems.sort(this.sortByProductPriceEsc);
        }else if(type==='default'){
            this.allItems = this.itemsProduct;
        }

            this.setPage(1);
            this.setPage(1);
            this.setPage(1);
        console.log(this.pagedItems);
  }

    setPage(page: number) {
        if (page < 1 || page > this.pager.totalPages) {
            return;
        }

        // get pager object from service
        this.pager = this.pagerService.getPager(this.allItems.length, page);

        // get current page of items
        this.pagedItems = this.allItems.slice(this.pager.startIndex, this.pager.endIndex + 1);
    }

    sortByProductName(o1:Product,o2:Product){
        if(o1.name > o2.name){
            return 1;
        }else if(o1.name === o2.name){
            return 0;
        }else{
            return -1;
        }
    }

    sortByProductPriceDesc(o1:Product,o2:Product){
        if(o1.price > o2.price){
            return 1;
        }else if(o1.price === o2.price){
            return 0;
        }else{
            return -1;
        }
    }

    sortByProductPriceEsc(o1:Product,o2:Product){
        if(o1.price < o2.price){
            return 1;
        }else if(o1.price === o2.price){
            return 0;
        }else{
            return -1;
        }
    }

}
