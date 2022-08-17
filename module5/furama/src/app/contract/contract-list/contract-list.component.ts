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
      facility: {id: 1, name: 'Home'},
      customer: {id: 1, name: 'Trần Thuận'},
      startDate: '18-09-2021',
      endDate: '22-12-2021',
      deposit: 100000,
      total: 3000000,
      attachFacility: 'Vip'
    },
    {
      id: 2,
      facility: {id: 2, name: 'Villa'},
      customer: {id: 2, name: 'Trần Văn Hoàn'},
      startDate: '15-08-2022',
      endDate: '17-08-2022',
      deposit: 500000,
      total: 1000000,
      attachFacility: 'basic'
    },
    {
      id: 3,
      facility: {id: 3, name: 'Room'},
      customer: {id: 3, name: 'Trần Thanh Trí'},
      startDate: '01-01-2021',
      endDate: '01-02-2021',
      deposit: 3000000,
      total: 5000000,
      attachFacility: 'Vip 2'
    },
    {
      id: 4,
      facility: {id: 4, name: 'Villa and Home'},
      customer: {id: 4, name: 'Trần Văn Hải'},
      startDate: '13-03-2022',
      endDate: '05-05-2022',
      deposit: 1000000,
      total: 9000000,
      attachFacility: 'Vip 4'
    },
    {
      id: 5,
      facility: {id: 5, name: 'Home and Room'},
      customer: {id: 5, name: 'Trần Thị Diệp'},
      startDate: '17-09-2021',
      endDate: '29-09-2021',
      deposit: 100000,
      total: 3000000,
      attachFacility: 'Vip'
    },
    {
      id: 6,
      facility: {id: 6, name: 'Villa'},
      customer: {id: 6, name: 'Trần Ngọc Đảm'},
      startDate: '18-09-2021',
      endDate: '22-12-2021',
      deposit: 100000,
      total: 3000000,
      attachFacility: 'Vip 4'
    },

  ];

  constructor() {
  }

  ngOnInit(): void {
  }

}
