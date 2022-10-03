import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/Category';
import {Discount} from '../model/Discount';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class DiscountService {

  constructor(private http:HttpClient) {
  }
  getAllDiscount(): Observable<Discount[]> {
    return this.http.get<Discount[]>(API_URL + '/discount');
  }
}
