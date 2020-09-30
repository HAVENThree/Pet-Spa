import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bill } from '../models/bill';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  constructor(private apiService: ApiService, private http: HttpClient) {}

  getList():Observable<[Bill]> {
    return this.http.get<[Bill]>(this.apiService.URL.bills);
  }
}
