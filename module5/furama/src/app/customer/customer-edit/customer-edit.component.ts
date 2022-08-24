import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../model/customer/customer';
import {CustomerType} from '../../model/customer/customer-type';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerForm: FormGroup;
  id: number;
  customerUpdate: Customer;
  customerType: CustomerType[] = [];


  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute,
              private routes: Router,
              private toastrService: ToastrService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.customerService.findByIdApi(this.id).subscribe(data => {
        this.customerUpdate = data;
        console.log('customerUpdate', this.customerUpdate);
        this.customerForm.patchValue(this.customerUpdate);
      });
    });

    this.customerForm = new FormGroup(
      {
        id: new FormControl(''),
        name: new FormControl(''),
        gender: new FormControl(''),
        birthday: new FormControl(''),
        idCard: new FormControl(''),
        phone: new FormControl(''),
        email: new FormControl(''),
        address: new FormControl(''),
        customerType: new FormControl(''),
      }
    );
  }

  compareCustomer(t1: Customer, t2: Customer) {
    if (t1.name === t2.name && t1.id === t2.id) {
      return true;
    } else {
      return false;
    }
    // return t1 && t2 ? t1.name === t2.name : t1 === t2;
  }

  ngOnInit(): void {
    this.customerType = this.customerService.getAllCustomerType();
  }

  submit() {
    const customer = this.customerForm.value;
    // this.customerService.updateById(this.id, customer);
    this.customerService.updateCustomerAPI(this.id, customer).subscribe(() => {
      // alert('thanh cong');
      this.toastrService.success('update thanh cong', 'thong bao');
      this.routes.navigateByUrl('/customer-list');
    });
  }
}
