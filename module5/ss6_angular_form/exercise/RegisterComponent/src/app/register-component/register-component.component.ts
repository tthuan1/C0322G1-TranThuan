import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {
  formRegister: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    confirmPassword: new FormControl('', [Validators.required]),
    country: new FormControl('Lào', [Validators.required]),
    age: new FormControl('', [Validators.required, this.checkAge]),
    phone: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]),
  }, this.checkInput);

  checkInput(abstractControl: AbstractControl) {
    const password = abstractControl.value.password;
    const confirmPassword = abstractControl.value.confirmPassword;
    if (password !== confirmPassword) {
      return {checkConfirmPassword: true};
    }
    return null;
  }

  checkAge(abstractControl: AbstractControl) {
    const age = abstractControl.value;
    console.log(age);
    if (age < 18) {
      return {checkAge: true};
    }
    return null;
  }


  constructor() {
  }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.formRegister);
  }
}
