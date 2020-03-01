import { Component, OnInit, Input } from '@angular/core';
import { HttpService } from '../http.service';
@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {

  productInfo : Product;
  title : String;

  constructor(private _http: HttpService) { }

  ngOnInit(): void {
    let a = window.location.pathname;

    this._http.getProductDetail( a[a.length -1] ).subscribe((data : Product) => {
      this.productInfo = data;
      this.title = data.name;
      console.log("THE PRODUCT",this.productInfo);
    } );
    
  }

}

class Product {
  public id : Number;
  public weigth : Number;
  public price : Number;
  public name : String;
  public description : String;
  public productImages : String[];
}
