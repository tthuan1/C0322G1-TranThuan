import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DictionayPageComponent} from './component/dictionay-page/dictionay-page.component';
import {DictionaryDetailComponent} from './component/dictionary-detail/dictionary-detail.component';


const routes: Routes = [
  {
    path: 'dictionary', component: DictionayPageComponent,
    children: [{
      path: ':word',
      component: DictionaryDetailComponent
    }]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
