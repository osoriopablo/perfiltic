import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  getBeer() {
    // return this.http.get('https://api.openbrewerydb.org/breweries')
    return this.http.get('http://localhost:8081/category/category1')
  }
}