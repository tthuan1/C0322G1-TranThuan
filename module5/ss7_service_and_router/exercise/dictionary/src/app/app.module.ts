import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DictionayPageComponent } from './component/dictionay-page/dictionay-page.component';
import { DictionaryDetailComponent } from './component/dictionary-detail/dictionary-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    DictionayPageComponent,
    DictionaryDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
