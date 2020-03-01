import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  brews: Product[];
  categories: Products;
  title : String;

  constructor(private _http: HttpService,private router: Router) { }

  ngOnInit() {
    this._http.getBeer().subscribe((data : Products) => {
      this.categories = data;
      this.brews = data.products;
      this.title = data.name;
      console.log("THE CATS",this.categories);
    }
  );
  }

  onClickAction(category : Product){
    console.log("HELLO CLICK", category);
    this.router.navigate(['list',category.id])
    
  }

}

class Products {
  public products: Array<Product>;
  public name: String;
}

class Product {
  public id : Number;
  public weigth : Number;
  public price : Number;
  public name : String;
  public description : String;
}
