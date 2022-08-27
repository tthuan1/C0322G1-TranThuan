import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {ToastrModule} from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BenhAnListComponent } from './benhAn/benh-an-list/benh-an-list.component';
import { BenhAnEditComponent } from './benhAn/benh-an-edit/benh-an-edit.component';
import { BenhAnCreateComponent } from './benhAn/benh-an-create/benh-an-create.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    BenhAnListComponent,
    BenhAnEditComponent,
    BenhAnCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({timeOut: 2000}),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
