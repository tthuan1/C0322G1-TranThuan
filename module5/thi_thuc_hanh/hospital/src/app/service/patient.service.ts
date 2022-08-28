import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Patient} from '../module/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  private URL_API = 'http://localhost:8080/patient';

  constructor(private http: HttpClient) {
  }

  getAllAPI(): Observable<Patient[]> {
    return this.http.get<Patient[]>(this.URL_API);
  }

  updatePatient(id: number, data: Patient): Observable<Patient> {
    console.log(data);
    return this.http.put<Patient>(this.URL_API + `/${id}`, data);
  }
}
