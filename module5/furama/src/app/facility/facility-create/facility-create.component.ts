import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {
  formCreateFacility: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.pattern('^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$')]),
    area: new FormControl('', [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
    cost: new FormControl('', [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
    maxPeople: new FormControl('', [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
    rentType: new FormControl('', [Validators.required]),
    facilityType: new FormControl('', [Validators.required]),
    standardRoom: new FormControl(),
    descriptionOtherConvenience: new FormControl(),
    poolArea: new FormControl('', [Validators.pattern('^[1-9]+\\d*')]),
    numberOfFloors: new FormControl('', [Validators.pattern('^[1-9]+\\d*')]),
    facilityFree: new FormControl(),
  });
  constructor() {
  }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.formCreateFacility);
  }
}
