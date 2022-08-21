import {Component, OnInit} from '@angular/core';
import {Facility} from '../../model/facility/facility';
import {FacilityType} from '../../model/facility/facility-type';
import {RentType} from '../../model/facility/rent-type';
import {FacilityService} from '../../service/facility.service';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  FacilityList: Facility[] = [];

  constructor(private facilityService: FacilityService) {

  }

  ngOnInit(): void {
    this.FacilityList = this.facilityService.getAll();
  }

}
