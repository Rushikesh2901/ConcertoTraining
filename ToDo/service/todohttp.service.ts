import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { todos } from 'modal/todo';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TodohttpService {
  url: string = 'http://localhost:3000/todos';
  constructor(private http: HttpClient) {}

  getAllTodos(): Observable<todos[]> {
    return this.http.get<todos[]>(this.url);
  }

  addTodo(todo:todos):Observable<todos>
  {
    return this.http.post<todos>(this.url, todo);
  }

  deleteTodo(id:number):Observable<number>{
    return this.http.delete<number>(this.url+'/'+id)


  }
}
