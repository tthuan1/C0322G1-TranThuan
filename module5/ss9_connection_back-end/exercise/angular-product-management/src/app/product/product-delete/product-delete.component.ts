import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productDelete: Product;
  id: number;
  productForm: FormGroup;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private routes: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      // this.productDelete = this.productService.findById(this.id);
      console.log(this.productDelete);

      this.productForm = new FormGroup(
        {
          id: new FormControl(this.productDelete.id),
          name: new FormControl(this.productDelete.name),
          price: new FormControl(this.productDelete.price),
          description: new FormControl(this.productDelete.description),
        }
      );
    });
  }

  ngOnInit(): void {
  }

  submit() {
    // this.productService.deleteById(this.id);
    alert('thanh cong');
    this.routes.navigateByUrl('/product/list');
  }
}
