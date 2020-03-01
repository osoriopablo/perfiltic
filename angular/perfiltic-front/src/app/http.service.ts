import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  getBeer(pathName) {
    // return this.http.get('https://api.openbrewerydb.org/breweries')
    return this.http.get('http://localhost:8081/category/'+pathName)
  }

  getProductDetail(id : String){
    return this.http.get('http://localhost:8081/product/'+id);
  }

  convertCop(amount: any){
    return this.http.get(
      "http://api.currencylayer.com/convert"+
    "?access_key=4e6b3ca2320483f1fb96f76634af2706"+
    "&from=USD"+
    "&to=EUR"+
    "&amount="+amount+
    "&format=1");
  }
}