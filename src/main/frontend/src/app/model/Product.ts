import {Brand} from "./Brand";
import {Model} from "./Model";
import {Manager} from "./Manager";
import {Category} from "./Category";
import {ProductDescription} from "./ProductDescription";

export class Product{
    public id:number;

    public name:string;

    public image:string;

    public price:number;

    public guarantee:number;

    public brand:Brand;

    public model:Model;

    public manager:Manager;

    public category:Category;

    public sale:number;

    public description:ProductDescription;


    constructor() {
    }
}