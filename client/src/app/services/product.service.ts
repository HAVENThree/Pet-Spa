import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private apiService: ApiService, private http: HttpClient) {}

  getList():Observable<[Product]> {
    return this.http.get<[Product]>(this.apiService.URL.products);
  }
  delete(id: number): Observable<Product>  {
    return this.http.delete<Product>(`${this.apiService.URL.products}/${id}`);
  }
  get(id: number): Observable<Product>  {
    const url = `${this.apiService.URL.products}/${id}`;
    return this.http.get<Product>(url);
  }
  add(pro: Product): Observable<Product> {
    return this.http.post<Product>(`${this.apiService.URL.products}/productType/${pro.productType.id}`, pro);
  }
  update(pro: Product): Observable<Product> {
    const url = `${this.apiService.URL.products}/${pro.id}`;
    return this.http.put<Product>(url, pro);
  }
  uploadImage(data: FormData): Observable<String> {
    return this.http.post<String>(`${this.apiService.baseURL}uploadFile`, data);
  }
}