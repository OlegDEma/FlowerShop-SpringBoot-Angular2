import {Component, OnDestroy, OnInit} from '@angular/core';
import {Product} from "../model/Product";
import {Observable} from "rxjs/Observable";
import {ShoppingCart} from "../model/shopping-cart.model";
import {Subscription} from "rxjs/Subscription";
import {TaskService} from "../services/task.service";
import {ShoppingCartService} from "../services/shoping-cart.service";
import {CartProduct} from "../model/cartProduct";
import {CartItem} from "../model/cart-item.model";

interface ICartItemWithProduct extends CartItem {
    product: Product;
    totalCost: number;
}

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
    export class CartPageComponent implements OnInit, OnDestroy {
    public cart: Observable<ShoppingCart>;
    public cartItems: ICartItemWithProduct[];
    public itemCount: number;
    private products: Product[];
    private cartSubscription: Subscription;

    public constructor(private taskService: TaskService,
                       private shoppingCartService: ShoppingCartService) {
    }

    public emptyCart(): void {
        this.shoppingCartService.empty();
    }

    public addProductToCart(product: any): void {
        this.shoppingCartService.addItem(product.product, 1);
    }

    public removeProductFromCart(product: any): void {
        this.shoppingCartService.addItem(product.product, -1);
    }

    public deleteProduct(product:any){
        this.shoppingCartService.deleteProductFromCart(product.product);
    }



    public ngOnInit(): void {
        this.cart = this.shoppingCartService.get();
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

    public ngOnDestroy(): void {
        if (this.cartSubscription) {
            this.cartSubscription.unsubscribe();
        }
    }
}
