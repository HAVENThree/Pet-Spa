import { ProductType } from './product-type';

export interface Product {
    id: number;
    proCode: string;
    name: string;
    imageData: FormData;
    image:String;
    price: number;
    productType: ProductType;
}
                                                                                                                                                                                                                                                                                                                                                                                                                