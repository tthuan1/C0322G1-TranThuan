import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer/customer.service';
import {Router} from '@angular/router';
import {CustomerType} from '../../model/customer/customer-type';
import {CustomerTypeService} from '../../service/customer/customer-type.service';
import {Customer} from '../../model/customer/customer';
import {RentType} from '../../model/facility/rent-type';
import {FacilityType} from '../../model/facility/facility-type';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  formCreateCustomer: FormGroup;
  customer: Customer;
  customerTypeList: CustomerType[] = [];


  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getCustomerType();
    this.formCreateCustomer = new FormGroup({
      // tslint:disable-next-line:max-line-length
      name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]+(\\s[a-zA-Zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]+)*$')]),
      birthday: new FormControl('', [Validators.required]),
      gender: new FormControl(1, [Validators.required]),
      idCard: new FormControl('', [Validators.required, Validators.pattern('\\d{9}')]),
      phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('', [Validators.required]),
      customerType: new FormControl(1, [Validators.required]),
    });
    // this.customerType = this.customerService.getAllCustomerType();
  }

  getCustomerType() {
    this.customerTypeService.getCustomerType().subscribe(data => {
      console.log('getCustomerType', data);
      this.customerTypeList = data;
    }, error => {
      console.log(error);
    });
  }


  submit() {
    const customer = this.formCreateCustomer.value;
    console.log('submit', customer);
    this.customerService.addCustomerAPI(customer).subscribe(() => {
      this.formCreateCustomer.reset();
      this.router.navigateByUrl('/customer-list');
    });
    // this.customerService.saveCustomer(customer);
  }
}
