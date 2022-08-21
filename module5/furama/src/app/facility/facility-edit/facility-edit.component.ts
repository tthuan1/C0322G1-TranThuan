import {Component, OnInit} from '@angular/core';
import {FacilityService} from '../../service/facility.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Facility} from '../../model/facility/facility';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {

  id: number;
  facilityUpdate: Facility;
  facilityForm: FormGroup;

  constructor(private facilityService: FacilityService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.facilityUpdate = this.facilityService.findById(this.id);
      console.log(this.facilityUpdate);
      this.facilityForm = new FormGroup(
        {
          // tslint:disable-next-line:max-line-length
          name: new FormControl(this.facilityUpdate.name, [Validators.required, Validators.pattern('^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$')]),
          area: new FormControl(this.facilityUpdate.area, [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
          cost: new FormControl(this.facilityUpdate.cost, [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
          maxPeople: new FormControl(this.facilityUpdate.maxPeople, [Validators.required, Validators.pattern('^[1-9]+\\d*')]),
          rentType: new FormControl(this.facilityUpdate.rentType, [Validators.required]),
          facilityType: new FormControl(this.facilityUpdate.facilityType, [Validators.required]),
          standardRoom: new FormControl(this.facilityUpdate.standardRoom),
          descriptionOtherConvenience: new FormControl(this.facilityUpdate.descriptionOtherConvenience),
          poolArea: new FormControl(this.facilityUpdate.poolArea, [Validators.pattern('^[1-9]+\\d*')]),
          numberOfFloors: new FormControl(this.facilityUpdate.numberOfFloors, [Validators.pattern('^[1-9]+\\d*')]),
          facilityFree: new FormControl(this.facilityUpdate.facilityFree),
          image: new FormControl(this.facilityUpdate.image),
        }
      );
    });
  }

  ngOnInit(): void {
  }

  submit() {
    const facility = this.facilityForm.value;
    this.facilityService.updateById(this.id, facility);
    alert('thanh cong');
    this.router.navigateByUrl('/facility-list');
  }
}
