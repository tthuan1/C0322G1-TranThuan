import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  id: number;
  name: string;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(): void {
    this.products = this.productService.getAll();
  }

  productDelete(product: Product) {
    this.id = product.id;
    this.name = product.name;
  }

  delete(): void {
    this.productService.deleteById(this.id);
    // this.routes.navigateByUrl('/customer-list');
  }
}
