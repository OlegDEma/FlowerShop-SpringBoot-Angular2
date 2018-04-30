import {EventEmitter, Injectable} from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import {Http, RequestOptions,Headers, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {User} from "../model/User";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class AuthenticationService {

    private authUrl = '/api/auth';
    static API_URL="http://localhost:8080";
    onLogIn = new EventEmitter<boolean>();

    constructor(private http: Http) { }

    public logIn(user: User){

        let headers = new Headers();
        headers.append('Accept', 'application/json')
        var base64Credential: string = btoa( user.username+ ':' + user.password);
        headers.append("Authorization", "Basic " + base64Credential);

        let options = new RequestOptions();
        options.headers=headers;

        return this.http.get(AuthenticationService.API_URL+"/account/login" ,   options)
            .map((response: Response) => {
                let user = response.json().principal;
                if (user) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            });
    }

    // logOut() {
    //     // remove user from local storage to log user out
    //     return this.http.get(AuthenticationService.API_URL+"/account/logout",{})
    //         .map((response: Response) => {
    //             localStorage.removeItem('currentUser');
    //         });
    //
    //
    //
    // }


    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}