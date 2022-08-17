import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {Contract} from '../../model/contract/contract';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contractList: Contract[] = [
    {
      id: 1,
      facilityName: 'home',
      customerName: 'Trần Thuận',
      startDate: '18-09-2021',
      endDate: '22-12-2021',
      deposit: 100000,
      total: 3000000,
      attachFacility: 'Vip'
    },
    {
      id: 2,
      facilityName: 'villa',
      customerName: 'Trần Thanh Trí',
      startDate: '15-08-2022',
      endDate: '17-08-2022',
      deposit: 500000,
      total: 1000000,
      attachFacility: 'basic'
    },
    {
      id: 3,
      facilityName: 'room',
      customerName: 'Trần Văn Hoàn',
      startDate: '01-01-2021',
      endDate: '01-02-2021',
      deposit: 3000000,
      total: 5000000,
      attachFacility: 'Vip 2'
    },
    {
      id: 4,
      facilityName: 'Villa',
      customerName: 'Trần Boos Huyền',
      startDate: '13-03-2022',
      endDate: '05-05-2022',
      deposit: 1000000,
      total: 9000000,
      attachFacility: 'Vip 4'
    },
    {
      id: 5,
      facilityName: 'Home',
      customerName: 'Trần Thị Hùng',
      startDate: '17-09-2021',
      endDate: '29-09-2021',
      deposit: 100000,
      total: 3000000,
      attachFacility: 'Vip'
    },
    {
      id: 1,
      facilityName: 'home',
      customerName: 'thuận',
      startDate: '18-09-2021',
      endDate: '22-12-2021',
      deposit: 100000,
      total: 3000000,
      attachFacility: 'd'
    },

  ];

  constructor() {
  }

  ngOnInit(): void {
  }

}
