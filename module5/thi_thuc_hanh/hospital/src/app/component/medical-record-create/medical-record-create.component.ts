import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Patient} from '../../module/patient';
import {MedicalRecordService} from '../../service/medical-record.service';
import {PatientService} from '../../service/patient.service';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-medical-record-create',
  templateUrl: './medical-record-create.component.html',
  styleUrls: ['./medical-record-create.component.css']
})
export class MedicalRecordCreateComponent implements OnInit {

  formCreate: FormGroup;
  patientList: Patient[] = [];

  constructor(private medicalRecordService: MedicalRecordService,
              private patientService: PatientService,
              private router: Router,
              private toastrService: ToastrService) {
  }

  getPatient() {
    this.patientService.getAllAPI().subscribe(data => {
      this.patientList = data;
    });
  }

  ngOnInit(): void {
    this.getPatient();
    this.formCreate = new FormGroup({
      patient: new FormControl('', [Validators.required]),
      hospitalizedDay: new FormControl('', [Validators.required]),
      hospitalDischargeDate: new FormControl('', [Validators.required]),
      reason: new FormControl('', [Validators.required]),
      treatments: new FormControl('', [Validators.required]),
      doctor: new FormControl('', [Validators.required]),
    });
  }

  submit() {
    const medicalRecord = this.formCreate.value;
    return this.medicalRecordService.createAPI(medicalRecord).subscribe(() => {
        this.toastrService.success('Update thành công', 'Thông báo');
        this.router.navigateByUrl('/MedicalRecord/List');
      }, error => {
        console.log(error);
      }
    );
  }
}
