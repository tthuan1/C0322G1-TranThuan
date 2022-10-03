import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {AuthorsComponent} from './component/authors/authors.component';
import {GreatBooksComponent} from './component/great-books/great-books.component';
import {ProductsComponent} from './component/products/products.component';
import {ProductDetailComponent} from './component/product-detail/product-detail.component';
import {ContactusComponent} from './component/contactus/contactus.component';
import {LoginComponent} from './component/login/login.component';


const routes: Routes = [
  {path : 'home', component : HomeComponent },
  {path : '', component : HomeComponent },
  {path : 'authors', component : AuthorsComponent },
  {path : 'great-books', component : GreatBooksComponent },
  {path : 'products', component : ProductsComponent },
  {path : 'product-detail/:id', component : ProductDetailComponent },
  {path : 'contactus', component : ContactusComponent },
  {path : 'login', component : LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
