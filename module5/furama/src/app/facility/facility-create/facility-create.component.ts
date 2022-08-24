import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {FacilityService} from '../../service/facility/facility.service';
import {Router} from '@angular/router';
import {FacilityTypeService} from '../../service/facility/facility-type.service';
import {RentTypeService} from '../../service/facility/rent-type.service';
import {RentType} from '../../model/facility/rent-type';
import {FacilityType} from '../../model/facility/facility-type';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {
  formCreateFacility: FormGroup;
  rentTypeList: RentType[] = [];
  facilityTypeList: FacilityType[] = [];


  constructor(private facilityService: FacilityService,
              private facilityTypeService: FacilityTypeService,
              private rentTypeService: RentTypeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getRentType();
    this.getFacilityType();
  }

  getFacilityType() {
    this.facilityTypeService.getFacilityType().subscribe(data => {
      this.facilityTypeList = data;
      this.formCreateFacility = new FormGroup({
        // tslint:disable-next-line:max-line-length
        name: new FormControl('', [Validators.required, Validators.pattern('^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$')]),
        area: new FormControl('', [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
        cost: new FormControl('', [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
        maxPeople: new FormControl('', [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
        rentType: new FormControl('', [Validators.required]),
        facilityType: new FormControl('', [Validators.required]),
        standardRoom: new FormControl(''),
        descriptionOtherConvenience: new FormControl(''),
        poolArea: new FormControl('', [Validators.pattern('^[1-9]+\\d*')]),
        numberOfFloors: new FormControl('', [Validators.pattern('^[1-9]+\\d*')]),
        facilityFree: new FormControl(''),
        image: new FormControl('assets/image/facility/facility1.jpeg'),
      });
    });
  }

  getRentType() {
    this.rentTypeService.getRentType().subscribe(data => {
      this.rentTypeList = data;
    });
  }

  submit() {
    const facility = this.formCreateFacility.value;
    console.log(facility.facilityType);
    console.log('submit', facility);
    this.facilityService.createFacilityAPI(facility).subscribe(() => {
      this.formCreateFacility.reset();
      this.router.navigateByUrl('/facility-list');
    });
  }
}
