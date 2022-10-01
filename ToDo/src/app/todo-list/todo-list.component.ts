import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { todos } from 'modal/todo';
import {TodohttpService} from  'service/todohttp.service'

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
 
  todolist:any=[];
  status:String | undefined;

 constructor(private todoservice:TodohttpService,private router:Router) { }


  ngOnInit(): void {
    this.todoservice.getAllTodos().subscribe(data => this.todolist = data)
  }

  delete(todo:todos){
    // let objindx = this.todolist.findIndex((list: { id: number; })=>list.id === todo.id);
    // console.log(objindx)
    // this.todolist.splice(objindx,1)
    this.todoservice.deleteTodo(todo.id).subscribe(data=>{
      this.todoservice.getAllTodos();
      window.location.reload();
    })}

}
