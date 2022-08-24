import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FacilityType} from '../../model/facility/facility-type';
import {RentType} from '../../model/facility/rent-type';

@Injectable({
  providedIn: 'root'
})
export class RentTypeService {

  private URL_API = 'http://localhost:3000/rentType';

  constructor(private http: HttpClient) {
  }

  getRentType(): Observable<RentType[]> {
    return this.http.get<RentType[]>(this.URL_API);
  }

}
