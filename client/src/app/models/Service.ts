import { ServiceType } from './ServiceType';

export interface Service {
    id: number;
    serCode: number;
    name: string;
    // image: string;
    price: number;
    serviceType: ServiceType;
}