import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { HomeComponent } from './component/home/home.component';
import { AuthorsComponent } from './component/authors/authors.component';
import { GreatBooksComponent } from './component/great-books/great-books.component';
import { ProductsComponent } from './component/products/products.component';
import { ProductDetailComponent } from './component/product-detail/product-detail.component';
import { ContactusComponent } from './component/contactus/contactus.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './component/login/login.component';
import {ToastrModule} from 'ngx-toastr';
import {ReactiveFormsModule} from '@angular/forms';
import {CarouselModule} from 'ngx-owl-carousel-o';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    AuthorsComponent,
    GreatBooksComponent,
    ProductsComponent,
    ProductDetailComponent,
    ContactusComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    ReactiveFormsModule,
    CarouselModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
