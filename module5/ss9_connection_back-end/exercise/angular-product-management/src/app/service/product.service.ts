import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // products: Product[] = [{
  //   id: 1,
  //   name: 'IPhone 12',
  //   price: 2400000,
  //   description: 'New'
  // }, {
  //   id: 2,
  //   name: 'IPhone 11',
  //   price: 1560000,
  //   description: 'Like new'
  // }, {
  //   id: 3,
  //   name: 'IPhone X',
  //   price: 968000,
  //   description: '97%'
  // }, {
  //   id: 4,
  //   name: 'IPhone 8',
  //   price: 7540000,
  //   description: '98%'
  // }, {
  //   id: 5,
  //   name: 'IPhone 11 Pro',
  //   price: 1895000,
  //   description: 'Like new'
  // }];

  constructor(private http: HttpClient) {
  }

  private readonly API_URL = 'http://localhost:3000/product';

  getAllApi(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API_URL);
  }

  saveProduct(data: Product): Observable<Product> {
    return this.http.post<Product>(this.API_URL, data);
  }

  updateProduct(id: number, data: Product): Observable<Product> {
    return this.http.put(this.API_URL + `/${id}`, data);
  }

  delete(id: number): Observable<Product> {
    return this.http.delete(this.API_URL + `/${id}`);
  }


  // getAll() {
  //   return this.products;
  // }
  //
  // saveProduct(product) {
  //   this.products.push(product);
  // }
  //
  // findById(id: number) {
  //   return this.products.find(temp => temp.id === id);
  // }
  //
  // updateById(id: number, product: Product) {
  //   for (let i = 0; i < this.products.length; i++) {
  //     if (id === this.products[i].id) {
  //       this.products[i] = product;
  //     }
  //   }
  // }
  //
  // deleteById(id: number) {
  //   // this.products = this.products.filter(product => {
  //   //   return product.id !== id;
  //   // });
  //   const index = this.products.findIndex(product =>
  //     product.id === id
  //   );
  //   this.products.splice(index, 1);
  //   console.log(this.products);
  // }
  findById(id: number): Observable<Product> {
    return this.http.get<Product>(this.API_URL + `/${id}`);
  }
}
