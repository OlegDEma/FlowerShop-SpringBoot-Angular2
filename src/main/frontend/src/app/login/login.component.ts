import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AuthenticationService} from "../services";
import {User} from "../model/User";


@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    // model: any = {};
    loading = false;
    error = '';
    model: User=new User();

    constructor(
        private router: Router,
        private authenticationService: AuthenticationService) { }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();
    }

    login(){
        this.authenticationService.logIn(this.model)
            .subscribe(data=>{
                    this.authenticationService.onLogIn.emit(true);
                    this.router.navigate(['header']);
                    this.router.navigate(['/']);
                },err=>{
                    this.error="error :  Username or password is incorrect";
                }
            )
    }
}
