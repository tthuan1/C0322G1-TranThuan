import {Component, OnInit} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {CustomerType} from '../../model/customer/customer-type';
import {CustomerService} from '../../service/customer/customer.service';
import {Router} from '@angular/router';
import {CustomerTypeService} from '../../service/customer/customer-type.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  customerTypeList: CustomerType[] = [];
  id: number;
  name: string;
  p = 1;
  nameSearch: string;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private routes: Router) {
  }

  ngOnInit(): void {
    // this.customerList = this.customerService.getAll();
    this.getAllCustomer();
  }

  getCustomerType() {
    this.customerTypeService.getCustomerType().subscribe(data => {
      console.log(data);
      this.customerTypeList = data;
    }, error => {
      console.log(error);
    });
  }

  getAllCustomer() {
    this.customerService.getAllCustomerAPI().subscribe(data => {
      this.getCustomerType();
      this.customerList = data;
      console.log('customerList', this.customerList);
    }, error => {
      console.log(error);
    }, () => {
      console.log('ok');
    });
  }

  customerDelete(customer: Customer) {
    this.id = customer.id;
    this.name = customer.name;
  }

  delete() {
    console.log('deleteCustomerAPI', this.id);
    this.customerService.deleteCustomerAPI(this.id).subscribe(() => {
      this.getAllCustomer();
    });
    // this.routes.navigateByUrl('/customer-list');
  }
  search() {
    return this.customerService.searchCustomer(this.nameSearch).subscribe(listSearch => {
      console.log(listSearch);
      console.log(this.nameSearch);
      this.customerList = listSearch;
      this.p = 1;
    });
  }

}
