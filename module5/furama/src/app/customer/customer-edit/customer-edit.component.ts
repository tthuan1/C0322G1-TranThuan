import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../model/customer/customer';
import {CustomerType} from '../../model/customer/customer-type';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerForm: FormGroup;
  id: number;
  customerUpdate: Customer;
  customerType: CustomerType[];

  constructor(private customerService: CustomerService,
              private activatedRoute: ActivatedRoute,
              private routes: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.customerUpdate = this.customerService.findById(this.id);
      console.log(this.customerUpdate);

      this.customerForm = new FormGroup(
        {
          id: new FormControl(this.customerUpdate.id),
          name: new FormControl(this.customerUpdate.name),
          gender: new FormControl(this.customerUpdate.gender, [Validators.required]),
          birthday: new FormControl(this.customerUpdate.birthday),
          idCard: new FormControl(this.customerUpdate.idCard),
          phone: new FormControl(this.customerUpdate.phone),
          email: new FormControl(this.customerUpdate.email),
          address: new FormControl(this.customerUpdate.address),
          customerType: new FormControl(this.customerUpdate.customerType.id),
        }
      );
    });
  }

  ngOnInit(): void {
    this.customerType = this.customerService.getAllCustomerType();
  }

  submit() {
    const customer = this.customerForm.value;
    this.customerService.updateById(this.id, customer);
    alert('thanh cong');
    console.log(customer);
    this.routes.navigateByUrl('/customer-list');
  }
}
