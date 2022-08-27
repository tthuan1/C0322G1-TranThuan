import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BenhAn} from '../../model/benhAn/benh-an';

@Injectable({
  providedIn: 'root'
})
export class BenhAnServiceService {
  private URL_API = 'http://localhost:3000/benhAn';

  constructor(private http: HttpClient) {
  }

  getAllAPI(): Observable<BenhAn[]> {
    return this.http.get<BenhAn[]>(this.URL_API);
  }

  deleteAPI(id: number): Observable<BenhAn> {
    return this.http.delete<BenhAn>(this.URL_API + `/${id}`);
  }

  updateAPI(id: number, data: BenhAn): Observable<BenhAn> {
    return this.http.put<BenhAn>(this.URL_API + `/${id}`, data);
  }

  findByIdApi(id: number): Observable<BenhAn> {
    return this.http.get(this.URL_API + `/${id}`);
  }

  createBenhAn(data: BenhAn): Observable<BenhAn> {
    return this.http.post(this.URL_API, data);
  }

  search(name: string): Observable<BenhAn[]> {
    return this.http.get<BenhAn[]>(`${this.URL_API}?q=` + name);
  }
}
