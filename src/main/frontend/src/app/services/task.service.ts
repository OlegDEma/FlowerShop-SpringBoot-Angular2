import "rxjs/Rx";
import {EventEmitter} from "@angular/core";
import {Brand} from "../model/Brand";
import {Manager} from "../model/Manager";
import {Category} from "../model/Category";
import {Delivery} from "../model/Delivery";
import {Model} from "../model/Model";
import {ProductDescription} from "../model/ProductDescription";
import {Product} from "../model/Product";
import {Injectable} from '@angular/core';
import {PaginationPage, PaginationPropertySort} from '../pagination';
import {Http, Response, URLSearchParams, RequestOptions, Headers} from '@angular/http';
import * as Rx from "rxjs/Rx";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';

@Injectable()
export class TaskService {


    onBrandAdded = new EventEmitter<Brand>();
    onManagerAdded = new EventEmitter<Manager>();
    onDeliveryAdded = new EventEmitter<Delivery>();
    onModelAdded = new EventEmitter<Model>();
    onDescriptionAdded = new EventEmitter<ProductDescription>();
    onProductAdded = new EventEmitter<Product>();
    private cart: Product[] = [];

    constructor(private http: Http) {
    }


    getDota(){
        return this.http.get('https://api.opendota.com/api/heroes')
        .map(
            (response: Response) => {
                return response.json();
            }
        );
    }

    addProductCart(product: Product) {

        this.cart.push(product);
        localStorage.cartItems = JSON.stringify(this.cart);
    }

    //GET

    findBrands(page: number, pageSize: number, sort: PaginationPropertySort): Rx.Observable<PaginationPage<Brand>> {
        let params = new URLSearchParams();
        params.set('size', `${pageSize}`);
        params.set('page', `${page}`);
        if (sort != null) {
            params.set('sort', `${sort.property},${sort.direction}`);
        }

        let options = new RequestOptions({
            search: params
        });
        return this.http.get(`/api/person`, options).map(this.extractData).publish().refCount();
    }

    private extractData(res: Response) {
        let body = res.json();
        return body || {};
    }

    getTasks() {
        return this.http.get('/api/tasks')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    getDelivery() {
        return this.http.get('/api/tasks/deliveryList')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    getProduct() {
        return this.http.get('/api/tasks/productList')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    getCategory() {
        return this.http.get('/api/tasks/categoryList')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }


    getBrands() {
        return this.http.get('/api/tasks/brandList')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    getManagers() {
        return this.http.get('/api/tasks/managerList')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    getModels() {
        return this.http.get('/api/tasks/modelList')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    getDescription() {
        return this.http.get('/api/tasks/descriptionList')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    /////////////////////////// Brand


    deleteBrand(id: number) {
        return this.http.get('/api/tasks/deleteBrand/' + id)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    addBrand(brand: Brand) {
        return this.http.post('/api/tasks/saveBrand', brand)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    example() {
        return this.http.get('/api/tasks/example')
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    changeBrand(brand: Brand) {
        return this.http.post('/api/tasks/changeBrand', brand)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }


    //////////////////////////////// Manager

    addManager(manager: Manager) {
        return this.http.post('/api/tasks/saveManager', manager)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    deleteManager(id: number) {
        return this.http.get('/api/tasks/deleteManager/' + id)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    changeManager(manager: Manager) {
        return this.http.post('/api/tasks/changeManager', manager)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }


    ///////////// Category

    addCategory(category: Category) {
        return this.http.post('/api/tasks/saveCategory', category)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    deleteCategory(id: number) {
        return this.http.get('/api/tasks/deleteCategory/' + id)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    changeCategory(category: Category) {
        return this.http.post('/api/tasks/changeCategory', category)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }


    /////////////// Delivery

    addDelivery(delivery: Delivery) {
        return this.http.post('/api/tasks/saveDelivery', delivery)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    deleteDelivery(id: number) {
        return this.http.get('/api/tasks/deleteDelivery/' + id)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    changeDelivery(delivery: Delivery) {
        return this.http.post('/api/tasks/changeDelivery', delivery)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    //////////////////////// Model

    addModel(model: Model) {
        return this.http.post('/api/tasks/saveModel', model)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    deleteModel(id: number) {
        return this.http.get('/api/tasks/deleteModel/' + id)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    changeModel(model: Model) {
        return this.http.post('/api/tasks/changeModel', model)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    //////////////////////// Description

    addDescription(description: ProductDescription) {
        return this.http.post('/api/tasks/saveDescription', description)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    deleteDescription(id: number) {
        return this.http.get('/api/tasks/deleteDescription/' + id)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    changeDescription(description: ProductDescription) {
        return this.http.post('/api/tasks/changeDescription', description)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }


    //////////////////////////// Product


    addProduct(product: Product) {
        return this.http.post('/api/tasks/saveProduct', product)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }

    deleteProduct(id: number) {
        return this.http.get('/api/tasks/deleteProduct/' + id)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }


    //////////////////////////////////////////////


    savePhoto(formData: FormData) {
        return this.http.post('/api/tasks/saveImageForProduct', formData)
            .map(
                (response: Response) => {
                    return response.json();
                }
            );
    }


}