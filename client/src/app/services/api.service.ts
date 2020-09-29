import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor() { }
  baseURL = "http://localhost:7777/";
  URL = {
    customers : this.baseURL + "customers",
    products : this.baseURL + "products",
    services : this.baseURL + "service",
    productTypes : this.baseURL + "productTypes",
    serviceTypes : this.baseURL + "serviceTypes",
    bills: this.baseURL + "bills"
  }
}
