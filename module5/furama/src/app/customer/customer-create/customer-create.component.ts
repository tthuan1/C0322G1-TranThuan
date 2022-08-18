import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  formCreateCustomer: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]+(\\s[a-zA-Zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]+)*$')]),
    birthday: new FormControl('', [Validators.required, Validators.pattern('^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$')]),
    gender: new FormControl('', [Validators.required]),
    idCard: new FormControl('', [Validators.required, Validators.pattern('\\d{9}')]),
    phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required]),
    type: new FormControl('', [Validators.required]),
  });


  constructor() {
  }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.formCreateCustomer);
  }
}
