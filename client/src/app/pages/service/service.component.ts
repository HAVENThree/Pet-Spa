import { ServiceTypeService } from './../../services/service-type.service';
import { ServicesService } from './../../services/services.service';
import { ServiceType } from './../../models/ServiceType';
import { Service } from './../../models/Service';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
  service = { serviceType: { id: 0 }} as Service;
  services: Service[] = [];
  serviceTypes: ServiceType[] = [];
  serviceType = { id: 0 } as ServiceType;
  constructor(private servicesService: ServicesService, private serviceTypeService: ServiceTypeService) { }

   loadingData() {
    this.servicesService.getList().subscribe(res => {
      this.services = res;
    });

    this.serviceTypeService.getList().subscribe(res => {
      this.serviceTypes = res;
    })
  }

  ngOnInit(): void {
    this.loadingData();
  }

}
