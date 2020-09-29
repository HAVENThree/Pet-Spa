import { Service } from './../models/Service';
import { HttpClient } from '@angular/common/http';
import { ApiService } from './api.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  constructor(private apiService: ApiService, private http: HttpClient) { }

  getList():Observable<Service[]> {
    return this.http.get<Service[]>(this.apiService.URL.services);
  }
  get(id: number): Observable<Service>  {
    const url = `${this.apiService.URL.services}/${id}`;
    return this.http.get<Service>(url);
  }
  add(ser: Service): Observable<Service> {
    return this.http.post<Service>(`${this.apiService.URL.services}/serviceType/${ser.serviceType.id}`, ser);
  }
  update(ser: Service): Observable<Service> {
    const url = `${this.apiService.URL.services}/${ser.id}`;
    return this.http.put<Service>(url, ser);
  }
  delete(id: number): Observable<Service>  {
    return this.http.delete<Service>(`${this.apiService.URL.services}/${id}`);
  }
}