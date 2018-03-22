import { Component, OnInit } from '@angular/core';
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
export class HeaderComponent implements OnInit {

    public cart: Observable<ShoppingCart>;
    public cartItems: ICartItemWithProduct[];
    public itemCount: number;
    private products: Product[];
    private cartSubscription: Subscription;
    currentUser:User ;
    auth:boolean = false;


    public constructor(private taskService: TaskService,private router: Router,
                       private shoppingCartService: ShoppingCartService,private authenticationService:AuthenticationService) {
    }

    public ngOnInit(): void {
        this.cart = this.shoppingCartService.get();
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if(this.currentUser != null){
            this.auth = true;
        }else{
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

    logOut() {
        this.authenticationService.logOut()
            .subscribe(
                data => {
                    this.router.navigate(['/auth']);
                },
                error => {

                });
    }

}
