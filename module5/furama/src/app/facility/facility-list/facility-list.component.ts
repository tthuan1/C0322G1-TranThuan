import {Component, OnInit} from '@angular/core';
import {Facility} from '../../model/facility/facility';
import {FacilityType} from '../../model/facility/facility-type';
import {RentType} from '../../model/facility/rent-type';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilityList: Facility[] = [];

  constructor() {
    this.facilityList.push(
      {
        id: 1,
        name: 'PHÒNG SUITE HƯỚNG BIỂN',
        area: 36,
        cost: 100000,
        maxPeople: 10,
        standardRoom: 'normal',
        descriptionOtherConvenience: 'Có hồ bơi',
        poolArea: 500,
        numberOfFloors: 2,
        facilityFree: 'gà 51kg',
        facilityType: {id: 1, name: 'Villa'},
        rentType: {id: 1, name: 'Theo năm'},
      },
      {
        id: 2,
        name: 'PHÒNG STUDIO SUITE HƯỚNG BIỂN',
        area: 85.8,
        cost: 100000,
        maxPeople: 10,
        standardRoom: 'normal',
        descriptionOtherConvenience: 'Có hồ bơi',
        poolArea: 500,
        numberOfFloors: 2,
        facilityFree: 'gà 51kg',
        facilityType: {id: 1, name: 'Villa'},
        rentType: {id: 1, name: 'Theo năm'},
      },
      {
        id: 3,
        name: 'PHÒNG DELUXE HƯỚNG BIỂN',
        area: 67,
        cost: 100000,
        maxPeople: 10,
        standardRoom: 'normal',
        descriptionOtherConvenience: 'Có hồ bơi',
        poolArea: 500,
        numberOfFloors: 2,
        facilityFree: 'gà 51kg',
        facilityType: {id: 1, name: 'Villa'},
        rentType: {id: 1, name: 'Theo năm'},
      },
      {
        id: 4,
        name: 'PHÒNG SUPERIOR HƯỚNG HỒ',
        area: 56.8,
        cost: 100000,
        maxPeople: 10,
        standardRoom: 'normal',
        descriptionOtherConvenience: 'Có hồ bơi',
        poolArea: 500,
        numberOfFloors: 2,
        facilityFree: 'gà 51kg',
        facilityType: {id: 1, name: 'Villa'},
        rentType: {id: 1, name: 'Theo năm'},
      },
      {
        id: 4,
        name: 'PHÒNG SUPERIOR HƯỚNG VƯỜN',
        area: 56.8,
        cost: 100000,
        maxPeople: 10,
        standardRoom: 'normal',
        descriptionOtherConvenience: 'Có hồ bơi',
        poolArea: 500,
        numberOfFloors: 2,
        facilityFree: 'gà 51kg',
        facilityType: {id: 1, name: 'Villa'},
        rentType: {id: 1, name: 'Theo năm'},
      },
    );
  }

  ngOnInit(): void {
  }

}
