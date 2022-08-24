import {Injectable} from '@angular/core';
import {Customer} from '../../model/customer/customer';
import {CustomerType} from '../../model/customer/customer-type';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  // ------------------------------------------------------
  constructor(private http: HttpClient) {
  }

  customerList: Customer[] = [
    {
      id: 1,
      name: 'Thuận',
      birthday: '18-09-1999',
      gender: 1,
      idCard: 436128312,
      phone: '0944192105',
      email: 'tthuan@gmail.com',
      address: 'Đà nẵng',
      customerType: {id: 1, name: 'Platinum'},
    },
    {
      id: 2,
      name: 'Sang',
      birthday: '03-09-1996',
      gender: 2,
      idCard: 537162398,
      phone: '0914221041',
      email: 'nhsang@gmail.com',
      address: 'Quảng Nam',
      customerType: {id: 2, name: 'Diamond'},
    },
    {
      id: 3,
      name: 'Hoàn',
      birthday: '13-01-1996',
      gender: 1,
      idCard: 576312312,
      phone: '0914741373',
      email: 'tvhoan@gmail.com',
      address: 'Đà nẵng',
      customerType: {id: 3, name: 'Gold'},
    },
    {
      id: 4,
      name: 'Bích Huyền',
      birthday: '13-03-1999',
      gender: 0,
      idCard: 531672312,
      phone: '0915897123',
      email: 'ntbhuyen@gmail.com',
      address: 'Hội an',
      customerType: {id: 4, name: 'Silver'},
    },
    {
      id: 5,
      name: 'Trần Thanh Trí',
      birthday: '04-11-1994',
      gender: 1,
      idCard: 123647844,
      phone: '0978123678',
      email: 'tttri@gmail.com',
      address: 'Quảng Trị',
      customerType: {id: 5, name: 'Member'},
    },
    {
      id: 6,
      name: 'Trần Thanh Sang',
      birthday: '04-11-1994',
      gender: 1,
      idCard: 123647844,
      phone: '0978123678',
      email: 'tttri@gmail.com',
      address: 'Quảng Trị',
      customerType: {id: 5, name: 'Member'},
    },
  ];

  customerType: CustomerType[] = [
    {id: 1, name: 'Platinum'},
    {id: 2, name: 'Diamond'},
    {id: 3, name: 'Gold'},
    {id: 4, name: 'Silver'},
    {id: 5, name: 'Member'},
  ];

  private URL_API = 'http://localhost:3000/customer';

  getAllCustomerAPI(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.URL_API);
  }

  addCustomerAPI(data: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.URL_API, data);
  }

  deleteCustomerAPI(id: number): Observable<Customer> {
    return this.http.delete<Customer>(this.URL_API + `/${id}`);
  }

  updateCustomerAPI(id: number, data: Customer): Observable<Customer> {
    return this.http.put<Customer>(this.URL_API + `/${id}`, data);
  }

  findByIdApi(id: number): Observable<Customer> {
    return this.http.get(this.URL_API + `/${id}`);
  }

  searchCustomer(name: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${this.URL_API}?q=` + name);
  }


  getAllCustomerType() {
    return this.customerType;
  }

  getAll() {
    return this.customerList;
  }

  saveCustomer(customer) {
    this.customerList.push(customer);
  }

  findById(id: number) {
    return this.customerList.find(temp => temp.id === id);
  }

  updateById(id: number, customer: Customer) {
    for (let i = 0; i < this.customerList.length; i++) {
      if (id === this.customerList[i].id) {
        this.customerList[i] = customer;
      }
    }
  }

  deleteCustomer(id: number) {
    const index = this.customerList.findIndex(customer =>
      customer.id === id
    );
    this.customerList.splice(index, 1);
    console.log(this.customerList);
  }

  deleteById(id: number) {
    const index = this.customerList.findIndex(customer =>
      customer.id === id
    );
    this.customerList.splice(index, 1);
    console.log(this.customerList);
  }


}

