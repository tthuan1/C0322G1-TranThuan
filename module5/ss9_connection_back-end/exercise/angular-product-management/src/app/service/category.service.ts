import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Category} from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private readonly URL_API = 'http://localhost:3000/category';

  constructor(private http: HttpClient) {
  }

  getCategory(): Observable<Category[]> {
    return this.http.get<Category[]>(this.URL_API);
  }
}
