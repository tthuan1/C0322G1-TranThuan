import {Component, OnInit} from '@angular/core';
import {MedicalRecord} from '../../module/medical-record';
import {Patient} from '../../module/patient';
import {MedicalRecordService} from '../../service/medical-record.service';
import {PatientService} from '../../service/patient.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-medical-record-list',
  templateUrl: './medical-record-list.component.html',
  styleUrls: ['./medical-record-list.component.css']
})
export class MedicalRecordListComponent implements OnInit {
  medicalRecordList: MedicalRecord[] = [];
  patientList: Patient[] = [];
  id: number;
  name: string;
  p = 1;
  nameSearch: string;

  constructor(private medicalRecordService: MedicalRecordService,
              private patientService: PatientService,
              private routes: Router,
              private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllMedicalRecord();
  }

  getAllMedicalRecord() {
    this.medicalRecordService.getAllAPI().subscribe(data => {
      this.getPatient();
      console.log('MedicalRecord', data);
      this.medicalRecordList = data;
    });
  }

  getPatient() {
    this.patientService.getAllAPI().subscribe(data => {
      this.patientList = data;
      console.log('Patient', data);
    });
  }

  medicalRecordDelete(medicalRecord: MedicalRecord) {
    this.id = medicalRecord.id;
    this.name = medicalRecord.patient.name;
  }

  delete() {
    console.log('delete', this.id);
    this.medicalRecordService.deleteAPI(this.id).subscribe(() => {
      this.getAllMedicalRecord();
      this.toastrService.success('Xoá bệnh án thành công', 'Thông báo');
    }, error => {
      console.log('error', error);
    });
  }

  search() {
    return this.medicalRecordService.search(this.nameSearch).subscribe(listSearch => {
      console.log(listSearch);
      console.log(this.nameSearch);
      this.medicalRecordList = listSearch;
      this.p = 1;
      this.nameSearch = '';
    });
  }
}
