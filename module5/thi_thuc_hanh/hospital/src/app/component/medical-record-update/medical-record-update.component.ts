import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {MedicalRecord} from '../../module/medical-record';
import {MedicalRecordService} from '../../service/medical-record.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {PatientService} from '../../service/patient.service';
import {Patient} from '../../module/patient';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-medical-record-update',
  templateUrl: './medical-record-update.component.html',
  styleUrls: ['./medical-record-update.component.css']
})
export class MedicalRecordUpdateComponent implements OnInit {

  medicalRecordForm: FormGroup;
  id: number;
  medicalRecordUpdate: MedicalRecord;
  patientUpdate: Patient;

  constructor(private medicalRecordService: MedicalRecordService,
              private activatedRoute: ActivatedRoute,
              private patientService: PatientService,
              private routes: Router,
              private toastrService: ToastrService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.medicalRecordService.findByIdAPI(this.id).subscribe(data => {
        this.medicalRecordUpdate = data;
        console.log('medicalRecordUpdate', this.medicalRecordUpdate);
        this.medicalRecordForm = new FormGroup(
          {
            id: new FormControl(data.id),
            codePatient: new FormControl(data.patient.id),
            namePatient: new FormControl(data.patient.name),
            hospitalizedDay: new FormControl(data.hospitalizedDay),
            hospitalDischargeDate: new FormControl(data.hospitalDischargeDate),
            reason: new FormControl(data.reason),
            treatments: new FormControl(data.treatments),
            doctor: new FormControl(data.doctor),
          }
        );
      });
    });

    this.medicalRecordForm = new FormGroup(
      {
        id: new FormControl(''),
        codePatient: new FormControl(''),
        namePatient: new FormControl(''),
        hospitalizedDay: new FormControl(''),
        hospitalDischargeDate: new FormControl(''),
        reason: new FormControl(''),
        treatments: new FormControl(''),
        doctor: new FormControl(''),
      }
    );
  }


  ngOnInit(): void {

  }

  submit() {
    const medicalRecordForm = this.medicalRecordForm.value;
    this.patientUpdate = {id: medicalRecordForm.codePatient, name: medicalRecordForm.namePatient};
    const medicalRecord = {
      id: medicalRecordForm.id,
      patient: this.patientUpdate,
      hospitalizedDay: medicalRecordForm.hospitalizedDay,
      hospitalDischargeDate: medicalRecordForm.hospitalDischargeDate,
      reason: medicalRecordForm.reason,
      treatments: medicalRecordForm.treatments,
      doctor: medicalRecordForm.doctor,
    };
    console.log(medicalRecord);
    this.medicalRecordService.updateAPI(this.id, medicalRecord).subscribe(() => {
      console.log();
      this.patientService.updatePatient(this.patientUpdate.id, this.patientUpdate).subscribe();
      this.toastrService.success('Update thành công', 'Thông báo');
      this.routes.navigateByUrl('/MedicalRecord/List');
    });
  }
}

