import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BenhNhan} from '../../model/benhAn/benh-nhan';
import {BenhAn} from '../../model/benhAn/benh-an';

@Injectable({
  providedIn: 'root'
})
export class BenhNhanServiceService {
  private URL_API = 'http://localhost:3000/benhNhan';

  constructor(private http: HttpClient) {
  }

  getBenhNhanType(): Observable<BenhNhan[]> {
    return this.http.get<BenhNhan[]>(this.URL_API);
  }

  updateBenhNhan(id: number, data: BenhNhan): Observable<BenhNhan> {
    return this.http.put<BenhNhan>(this.URL_API + `/${id}`, data);
  }

}
