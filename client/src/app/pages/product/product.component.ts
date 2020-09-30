import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { ProductType } from 'src/app/models/product-type';
import { ProductTypeService } from 'src/app/services/product-type.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[] = []
  product: Product = { productType: { id: 0 } } as Product;
  productTypes: ProductType[] = []
  productType: ProductType = {} as ProductType;
  page: number = 1;
  itemsPerPage: number = 3;
  selectedFile: File = null
  imagePreview: String = "";
  constructor(private productService: ProductService, private productTypeService: ProductTypeService) { }

  private loadingData() {
    this.productService.getList().subscribe(res => {
      this.products = res;
    });

    this.productTypeService.getList().subscribe(res => {
      this.productTypes = res
      console.log(res);
    });
  }

  ngOnInit(): void {
    this.loadingData();
  }

}
