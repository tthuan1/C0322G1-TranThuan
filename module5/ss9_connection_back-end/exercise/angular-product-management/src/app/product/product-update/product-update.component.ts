import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Route, Router, Routes} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productUpdate: Product;
  categoryList: Category[] = [];
  id: number;
  productForm: FormGroup;


  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private routes: Router) {
    this.categoryService.getCategory().subscribe(data => {
      this.categoryList = data;
    });

    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');


      this.productService.findById(this.id).subscribe(data => {
        this.productUpdate = data;
        console.log('abbbbbbb');
        console.log(this.productUpdate);
        this.productForm.patchValue(this.productUpdate);
      });
    });

    this.productForm = new FormGroup({
      id: new FormControl(''),
      name: new FormControl(''),
      price: new FormControl(''),
      description: new FormControl(''),
      category: new FormControl(''),
    });

  }

  category(t1: Category, t2: Category) {
    if (t1.name === t2.name && t1.id === t2.id) {
      return true;
    } else {
      return false;
    }
    // return t1 && t2 ? t1.name === t2.name : t1 === t2;
  }

  ngOnInit(): void {
  }

  submit() {
    const product = this.productForm.value;
    console.log('submit', product);
    this.productService.updateProduct(this.id, product).subscribe();
    alert('thanh cong');
    console.log(product);
    this.routes.navigateByUrl('/product/list');
  }
}
