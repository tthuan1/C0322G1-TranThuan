import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Treatment} from '../module/treatment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TreatmentService {
  private URL_API = 'http://localhost:8080/api/treatment/v1/';

  constructor(private http: HttpClient) {
  }

  getAll(name: string): Observable<Treatment[]> {
    return this.http.get<Treatment[]>(`${this.URL_API}?keySearch=` + name);
  }

  deleteTreatment(id: number): Observable<Treatment> {
    // @ts-ignore
    return this.http.put<Treatment>(this.URL_API + `${id}`);
  }
}
