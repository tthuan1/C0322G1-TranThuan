import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MedicalRecord} from '../module/medical-record';

@Injectable({
  providedIn: 'root'
})
export class MedicalRecordService {

  private URL_API = 'http://localhost:8080/medicalRecord';

  constructor(private http: HttpClient) {
  }

  getAllAPI(): Observable<MedicalRecord[]> {
    return this.http.get<MedicalRecord[]>(this.URL_API);
  }

  deleteAPI(id: number): Observable<MedicalRecord> {
    return this.http.delete<MedicalRecord>(this.URL_API + `/${id}`);
  }

  updateAPI(id: number, data: MedicalRecord): Observable<MedicalRecord> {
    return this.http.put<MedicalRecord>(this.URL_API + `/${id}`, data);
  }

  findByIdAPI(id: number): Observable<MedicalRecord> {
    return this.http.get(this.URL_API + `/${id}`);
  }

  createAPI(data: MedicalRecord): Observable<MedicalRecord> {
    return this.http.post(this.URL_API, data);
  }

  search(name: string): Observable<MedicalRecord[]> {
    return this.http.get<MedicalRecord[]>(`${this.URL_API}?q=` + name);
  }
}
