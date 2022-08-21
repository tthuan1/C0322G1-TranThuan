import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {CustomerType} from '../../model/customer/customer-type';
import {CustomerService} from '../../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  id: number;
  name: string;

  constructor(private customerService: CustomerService,
              private routes: Router) {
  }

  ngOnInit(): void {
    this.customerList = this.customerService.getAll();
  }

  customerDelete(customer: Customer) {
    this.id = customer.id;
    this.name = customer.name;
  }

  delete() {
    this.customerService.deleteById(this.id);
    // this.routes.navigateByUrl('/customer-list');
  }


}
