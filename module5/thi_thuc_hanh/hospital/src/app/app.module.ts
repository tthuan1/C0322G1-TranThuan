import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MedicalRecordListComponent } from './component/medical-record-list/medical-record-list.component';
import { MedicalRecordCreateComponent } from './component/medical-record-create/medical-record-create.component';
import { MedicalRecordUpdateComponent } from './component/medical-record-update/medical-record-update.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '@angular/common/http';
import {ToastrModule} from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    MedicalRecordListComponent,
    MedicalRecordCreateComponent,
    MedicalRecordUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    NgxPaginationModule,
    HttpClientModule,
    ToastrModule.forRoot({timeOut: 2000}),
    ReactiveFormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
