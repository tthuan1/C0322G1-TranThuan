import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Author} from '../model/Author';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  constructor(private http: HttpClient) {
  }
  getAllAuthor(): Observable<Author[]> {
    return this.http.get<Author[]>(API_URL + '/author');
  }

}
