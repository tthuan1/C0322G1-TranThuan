import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  formCreateCustomer: FormGroup = new FormGroup({
    id: new FormControl(''),
    // tslint:disable-next-line:max-line-length
    name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]+(\\s[a-zA-Zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]+)*$')]),
    birthday: new FormControl('', [Validators.required]),
    gender: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.pattern('\\d{9}')]),
    phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required]),
    customerType: new FormControl('', [Validators.required]),
  });


  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
  }

  submit() {
    const customer = this.formCreateCustomer.value;
    console.log(customer);
    this.customerService.saveCustomer(customer);
    this.formCreateCustomer.reset();
  }
}
