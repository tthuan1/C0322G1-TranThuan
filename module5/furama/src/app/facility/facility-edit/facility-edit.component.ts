import {Component, OnInit} from '@angular/core';
import {FacilityService} from '../../service/facility/facility.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Facility} from '../../model/facility/facility';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {FacilityTypeService} from '../../service/facility/facility-type.service';
import {RentTypeService} from '../../service/facility/rent-type.service';
import {FacilityType} from '../../model/facility/facility-type';
import {RentType} from '../../model/facility/rent-type';
import {Customer} from '../../model/customer/customer';

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {
  id: number;
  facilityUpdate: Facility;
  facilityForm: FormGroup;
  facilityTypeList: FacilityType[] = [];
  rentTypeList: RentType[] = [];

  constructor(private facilityService: FacilityService,
              private facilityTypeService: FacilityTypeService,
              private rentTypeService: RentTypeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.facilityService.findByIdAPI(this.id).subscribe(data => {
        this.facilityUpdate = data;
        this.facilityForm.patchValue(data);
        console.log('facilityUpdate', data);
      });
      console.log(this.facilityUpdate);
    });
    this.facilityForm = new FormGroup(
      {
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
        image: new FormControl(''),
      }
    );
  }

  ngOnInit(): void {
    this.getRentType();
    this.getFacility();
  }

  getRentType() {
    this.rentTypeService.getRentType().subscribe(data => {
      this.rentTypeList = data;
    });
  }

  getFacility() {
    this.facilityTypeService.getFacilityType().subscribe(data => {
      this.facilityTypeList = data;
    });
  }

  compareFacility(t1: Facility, t2: Facility) {
    // if (t1.name === t2.name && t1.id === t2.id) {
    //   return true;
    // } else {
    //   return false;
    // }
    return t1 && t2 ? t1.name === t2.name : t1 === t2;
  }

  submit() {
    const facility = this.facilityForm.value;
    this.facilityService.updateFacilityAPI(this.id, facility).subscribe(() => {
      alert('thanh cong');
      this.router.navigateByUrl('/facility-list');
    });
    // this.facilityService.updateById(this.id, facility);

  }
}
