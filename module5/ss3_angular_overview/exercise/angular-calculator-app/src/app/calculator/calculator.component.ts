import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1 = 0;
  number2 = 0;
  total;
  background = '';
  color = '';

  constructor() {
  }

  ngOnInit(): void {
  }

  calculate(even) {
    console.log(even);
    switch (even) {
      case '+':
        return this.total = this.number1 + this.number2;
      case '-':
        return this.total = this.number1 - this.number2;
      case 'x':
        return this.total = this.number1 * this.number2;
      case '/':
        if (this.number2 === 0) {
          return this.total = 'không thể chia cho 0';
        }
        return this.total = this.number1 / this.number2;
    }
  }


}
