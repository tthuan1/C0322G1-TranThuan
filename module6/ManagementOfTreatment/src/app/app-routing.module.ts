import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListComponent} from './list/list.component';
import {CreateComponent} from './create/create.component';


const routes: Routes = [
  {path: 'treatment/list', component: ListComponent},
  {path: '', component: ListComponent},
  {path: 'treatment/create', component: CreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
