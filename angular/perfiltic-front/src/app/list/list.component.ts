import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  brews: Product[];
  categories: Products;

  constructor(private _http: HttpService) { }

  ngOnInit() {
    this._http.getBeer().subscribe((data : Products) => {
      this.categories = data;
      this.brews = data.products;
      console.log("THE CATS",this.categories);
    }
  );
  }

}

class Products {
  public products: Array<Product>;
}

class Product {
  public id : Number;
  public weigth : Number;
  public price : Number;
  public name : String;
  public description : String;
}
