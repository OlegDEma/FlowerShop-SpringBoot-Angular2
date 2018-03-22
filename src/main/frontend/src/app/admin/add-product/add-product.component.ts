import { Component, OnInit } from '@angular/core';
import {TaskService} from "../../services/task.service";
import {Product} from "../../model/Product";
import {Brand} from "../../model/Brand";
import {Category} from "../../model/Category";
import {Model} from "../../model/Model";
import {Manager} from "../../model/Manager";
import {ProductDescription} from "../../model/ProductDescription";
import {RequestOptions} from "@angular/http";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css'],
})
export class AddProductComponent implements OnInit {
  brands:Brand[] = [];
  categorys:Category[] = [];
  models:Model[]= [];
  managers:Manager[]= [];
  descriptions:ProductDescription[]= [];
    newFile:File;
    form: FormGroup;
    formData:FormData = null;

    newProduct:Product = new Product();
    products : Product[] = [];
    change:boolean = false;
    index:number = null;
    bestProduct : Product = null;
    newBrand:Brand = null;
    loading:boolean = false;
  constructor(private taskService:TaskService) { }

  ngOnInit() {
      this.taskService.getCategory()
          .subscribe(
              (categorys:any[])=>{
                  this.categorys = categorys;
              }
          );

    this.taskService.getBrands()
        .subscribe(
            (brandss:any[])=>{
                this.brands = brandss;
            }
        );
    this.taskService.getDescription()
        .subscribe(
            (desc:any[])=>{
                this.descriptions = desc;
            }
        );
    this.taskService.getModels()
        .subscribe(
            (model:any[])=>{
                this.models = model;
            }
        );
    this.taskService.getManagers()
        .subscribe(
            (managers:any[])=>{
                this.managers = managers;
            }
        );
    this.taskService.getProduct()
        .subscribe(
            (products:any[])=>{
                this.products = products;
                console.log(products);
            }
        );

    this.taskService.onProductAdded
        .subscribe(
            (product:Product)=>{
                this.products.push(product);
            }
        );

    setTimeout(() => {
          this.loading = true;
      }, 500);

  }

    updateBrand(brand:Brand){
      this.newProduct.brand = brand;

    }


    updated($event){
        const files = $event.target.files || $event.srcElement.files;
        const file = files[0];
        this.newFile = file;
    }

    onProductAdd() {

        const formData = new FormData();
        formData.append('file', this.newFile);
        this.newProduct.image = '../../../assets/images/products/'+ this.newFile.name;

        this.taskService.addProduct(this.newProduct)
            .subscribe(
                (newProduct: Product) => {
                    this.taskService.onProductAdded.emit(newProduct);
                }
            );
        this.taskService.savePhoto(formData)
            .subscribe(
                (response:Response)=>{
                    return response;
                }
            );
    }

    toggle(product:Product){
        this.change =  !this.change;
        if(this.bestProduct == null && product != undefined){
            this.bestProduct = new Product();
            this.bestProduct.id = product.id;
            this.bestProduct.name = product.name;
            this.bestProduct.price = product.price;
            this.bestProduct.guarantee = product.guarantee;
            this.bestProduct.image = product.image;

        }else{
            this.bestProduct = null;
        }
    }



    changeProduct(){
        let product:Product = this.bestProduct;
        let indexArr:number = null;
        for(let productArr of this.products){
            if(productArr.id == product.id ){
                indexArr = this.products.indexOf(productArr);
            }
        }
        this.products[indexArr] = product;
        this.taskService.addProduct(product)
            .subscribe(
                (product:Product) =>{
                    this.bestProduct = null;
                    this.index = null;
                    this.change = false;

                }
            );
    }

    deleteProduct(id:number){
        let arrIndex =  null;
        for(let product of this.products){
            if(product.id == id){
                arrIndex = this.products.indexOf(product);
            }
        }
        this.products.splice(arrIndex,1);
        this.taskService.deleteProduct(id)
            .subscribe(
                (response:Response)=>{
                    return response.json();
                }
            );

    }

}
