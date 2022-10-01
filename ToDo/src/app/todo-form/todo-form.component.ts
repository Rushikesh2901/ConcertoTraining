import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { todos } from 'modal/todo';
import {TodohttpService} from  'service/todohttp.service'
@Component({
  selector: 'app-todo-form',
  templateUrl: './todo-form.component.html',
  styleUrls: ['./todo-form.component.css']
})
export class TodoFormComponent implements OnInit {
  todolist: todos[] | undefined;
  constructor(private todoservice:TodohttpService,private router:Router) { }

  ngOnInit(): void {
    
  }

  savetodo(todo:todos){
    console.log(`todo === ${todo.todo}`)
    this.todoservice.addTodo(todo).subscribe(data=>
      {
      window.location.reload();
      });
      this.router.navigate(['/list']);

  }

}
