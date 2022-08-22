import {Component, OnInit} from '@angular/core';

import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';
import {CategoryService} from "../../service/category.service";
import {Category} from "../../model/category";


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  category: Category[] = [];
  id: number;
  name: string;

  constructor(private productService: ProductService,
              private categoryService: CategoryService
  ) {
  }

  ngOnInit(): void {
    this.productService.getAllApi().subscribe(data => {
      console.log(data);
      this.products = data;
    }, error => {
      console.log(error);
    }, () => {
      console.log('complete');
    });
    this.categoryService.getCategory().subscribe(data => {
      console.log(data);
      this.category = data;
    });
    // this.getAll();
  }

  // getAll(): void {
  //   this.products = this.productService.getAll();
  // }

  productDelete(product: Product) {
    this.id = product.id;
    this.name = product.name;
  }

  // delete(): void {
  //   this.productService.deleteById(this.id);
  //   // this.routes.navigateByUrl('/customer-list');
  // }
}
