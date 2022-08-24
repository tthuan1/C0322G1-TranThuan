import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';
import {Router} from '@angular/router';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categoryList: Category[] = [];
  productForm: FormGroup;

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router) {
    this.categoryService.getCategory().subscribe(data => {
      this.categoryList = data;
      this.productForm = new FormGroup({
        name: new FormControl(),
        price: new FormControl(),
        description: new FormControl(),
        category: new FormControl(),
      });
    }, error => {
      console.log(error);
    });
  }

  ngOnInit(): void {
  }

  submit() {

    // this.todoService.addTodo({
    //   title: this.inputControl.value,
    // }).subscribe(data => {
    //   console.log(data);
    // });


    const product = this.productForm.value;
    console.log(product);
    this.productService.saveProduct(product).subscribe(data => {
      console.log(data);
    });
    this.productForm.reset();
    this.router.navigateByUrl('/product/list');
  }

}
