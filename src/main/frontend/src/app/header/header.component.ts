import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {ShoppingCart} from "../model/shopping-cart.model";
import {Observable} from "rxjs/Observable";
import {TaskService} from "../services/task.service";
import {ShoppingCartService} from "../services/shoping-cart.service";
import {Subscription} from "rxjs/Subscription";
import {Product} from "../model/Product";
import {CartItem} from "../model/cart-item.model";
import {User} from "../model/User";
import {AuthenticationService} from "../services";
import { Router } from '@angular/router';

interface ICartItemWithProduct extends CartItem {
    product: Product;
    totalCost: number;
}

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit,OnChanges {
    ngOnChanges(changes: SimpleChanges): void {

    }

    public cart: Observable<ShoppingCart>;
    public cartItems: ICartItemWithProduct[];
    public itemCount: number;
    private products: Product[];
    private cartSubscription: Subscription;
    currentUser:User ;
    username:string = '';
    auth:boolean = false;


    public constructor(private taskService: TaskService,private router: Router,
                       private shoppingCartService: ShoppingCartService,private authenticationService:AuthenticationService) {
    }

    public ngOnInit(): void {

        this.authenticationService.onLogIn
            .subscribe(data =>{
                this.auth = true;
            });

        this.cart = this.shoppingCartService.get();
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if(this.currentUser != null){
            this.username = this.currentUser.username;
            this.auth = true;
        }else{
            this.username = '';
            this.auth = false;
        }


        this.cartSubscription = this.cart.subscribe((cart) => {
            this.itemCount = cart.items.map((x) => x.quantity).reduce((p, n) => p + n, 0);
            this.taskService.getProduct().subscribe((products) => {
                this.products = products;
                this.cartItems = cart.items
                    .map((item) => {
                        const product = this.products.find((p) => p.id === Number(item.productId));
                        return {
                            ...item,
                            product,
                            totalCost: product.price * item.quantity };
                    });
            });
        });
    }

    getDota(){
        console.log("DONE")
        console.log(this.taskService.getDota());
    }

    logout() {
        this.authenticationService.logout();
        this.router.navigate(['/']);
        this.auth = false;

    }

    // logout() {
    //     this.authenticationService.logout()
    //         .subscribe(
    //             data => {
    //                 this.router.navigate(['/auth']);
    //             },
    //             error => {
    //
    //             });
    // }

}
