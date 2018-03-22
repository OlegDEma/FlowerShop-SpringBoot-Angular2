import { Component, OnInit } from '@angular/core';
import {TaskService} from "../services/task.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

 flowers = [];

  constructor(private taskService : TaskService) { }

  ngOnInit() {
      // this.taskService.getProducts()
      //     .subscribe((products: any[]) =>{
      //         console.log(products) });
  }

}
