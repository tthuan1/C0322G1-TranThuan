import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Todo} from '../model/todo';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private readonly API_URL = 'http://localhost:3000';

  getTodos(count = 10): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.API_URL + '/todos').pipe(
      map(data => data.filter((todo, i) => i < count))
    );
  }

  delete(id: number): Observable<Todo> {
    return this.http.delete<Todo>(this.API_URL + `/todos/${id}`);
  }

  constructor(private http: HttpClient) {
  }

  addTodo(data: Todo): Observable<Todo> {
    return this.http.post<Todo>(this.API_URL + `/todos`, data);
  }


}
