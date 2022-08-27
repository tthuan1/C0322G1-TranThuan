import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {MedicalRecordListComponent} from './component/medical-record-list/medical-record-list.component';
import {MedicalRecordCreateComponent} from './component/medical-record-create/medical-record-create.component';
import {MedicalRecordUpdateComponent} from './component/medical-record-update/medical-record-update.component';


const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', component: MedicalRecordListComponent},
  {path: 'MedicalRecord/List', component: MedicalRecordListComponent},
  {path: 'MedicalRecord/Create', component: MedicalRecordCreateComponent},
  {path: 'MedicalRecord/Edit/:id', component: MedicalRecordUpdateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
