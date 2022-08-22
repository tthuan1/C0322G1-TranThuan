import {Injectable} from '@angular/core';
import {Facility} from '../model/facility/facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  facilityList: Facility[] = [
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
      image: 'assets/image/facility/facility1.jpeg',
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
      image: 'assets/image/facility/facility2.jpeg',
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
      image: 'assets/image/facility/facility3.jpeg',
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
      image: 'assets/image/facility/facility4.jpeg',
    },
    {
      id: 5,
      name: 'PHÒNG DELUXE HƯỚNG VƯỜN',
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
      image: 'assets/image/facility/facility5.jpeg',
    },
    {
      id: 6,
      name: 'PHÒNG PRESIDENTIAL SUITE',
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
      image: 'assets/image/facility/facility6.jpeg',
    },
    {
      id: 7,
      name: 'BIỆT THỰ HƯỚNG BIỂN CÓ HỒ BƠI RIÊNG',
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
      image: 'assets/image/facility/facility7.jpeg',
    },
    {
      id: 8,
      name: 'BIỆT THỰ HƯỚNG VƯỜN CÓ HỒ BƠI RIÊNG',
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
      image: 'assets/image/facility/facility8.jpeg',
    },
    {
      id: 9,
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
      image: 'assets/image/facility/facility9.jpeg',
    },
  ];

  constructor() {
  }

  getAll() {
    return this.facilityList;
  }

  findById(id: number) {
    return this.facilityList.find(temp => temp.id === id);
  }

  updateById(id: number, facility: Facility) {
    for (let i = 0; i < this.facilityList.length; i++) {
      if (id === this.facilityList[i].id) {
        this.facilityList[i] = facility;
      }
    }
  }

  deleteById(id: number) {
    console.log(id);
    const index = this.facilityList.findIndex(facility =>
      facility.id === id
    );
    this.facilityList.splice(index, 1);
    console.log(this.facilityList);
  }
}
