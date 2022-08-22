import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Route, Router, Routes} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  productUpdate: Product;
  id: number;
  productForm: FormGroup;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private routes: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      // this.productUpdate = this.productService.findById(this.id);
      console.log(this.productUpdate);

      this.productForm = new FormGroup(
        {
          id: new FormControl(this.productUpdate.id),
          name: new FormControl(this.productUpdate.name),
          price: new FormControl(this.productUpdate.price),
          description: new FormControl(this.productUpdate.description),
        }
      );
    });
  }

  ngOnInit(): void {
  }

  submit() {
    const product = this.productForm.value;
    // this.productService.updateById(this.id, product);
    alert('thanh cong');
    console.log(product);
    this.routes.navigateByUrl('/product/list');
  }
}
