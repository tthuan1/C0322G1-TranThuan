import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FacilityType} from '../../model/facility/facility-type';

@Injectable({
  providedIn: 'root'
})
export class FacilityTypeService {
  private URL_API = 'http://localhost:3000/facilityType';

  constructor(private http: HttpClient) {
  }

  getFacilityType(): Observable<FacilityType[]> {
    return this.http.get<FacilityType[]>(this.URL_API);
  }

}
