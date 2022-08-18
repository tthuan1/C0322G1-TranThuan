import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {
  formCreateContract: FormGroup = new FormGroup({
    startDate: new FormControl('', [Validators.required]),
    endDate: new FormControl('', [Validators.required]),
    deposit: new FormControl('', [Validators.required, Validators.pattern('^[1-9]+\\d*$')]),
    total: new FormControl('', [Validators.required]),
    attachFacility: new FormControl('', [Validators.required]),
  });
  constructor() { }

  ngOnInit(): void {
  }

  submit() {
    console.log(this.formCreateContract);
  }
}
