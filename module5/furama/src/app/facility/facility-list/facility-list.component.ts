import {Component, OnInit} from '@angular/core';
import {Facility} from '../../model/facility/facility';
import {FacilityType} from '../../model/facility/facility-type';
import {RentType} from '../../model/facility/rent-type';
import {FacilityService} from '../../service/facility/facility.service';
import {Customer} from '../../model/customer/customer';
import {FacilityTypeService} from '../../service/facility/facility-type.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilityList: Facility[] = [];
  id: number;
  name: string;
  p = 2;

  constructor(private facilityService: FacilityService,
              private facilityTypeService: FacilityTypeService,
              private router: Router) {

  }

  getFacilityAPI() {
    this.facilityService.getAllFacilityApi().subscribe(data => {
      this.facilityList = data;
      console.log('lấy dữ liệu thành công', data);
    }, error => {
      console.log(error);
    }, () => {
    });
  }

  deletefacilityAPI() {
    this.facilityService.deleteFacilityAPI(this.id).subscribe(() => {
      this.getFacilityAPI();
      alert('Xoa thanh cong');
    });
  }

  // ------------API

  ngOnInit(): void {
    this.getFacilityAPI();
    // this.FacilityList = this.facilityService.getAll();
  }

  facilityDelete(facility: Facility) {
    this.id = facility.id;
    this.name = facility.name;
    console.log(facility);
  }

  delete() {
    this.facilityService.deleteById(this.id);
  }

}
