import {Component, OnInit} from '@angular/core';
import {Todo} from 'src/app/model/todo';
import {FormControl} from '@angular/forms';
import {TodoService} from '../../service/todo.service';

// tslint:disable-next-line:variable-name
let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})


export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  inputControl = new FormControl();
  todoList: Todo[] = [];


  constructor(private todoService: TodoService) {
  }

  ngOnInit() {
    this.todoService.getTodos().subscribe(next => {
      console.log(next);
      this.todoList = next;
    }, error => {
      console.log(error);
    }, () => {
      console.log('complete');
    });
  }

  toggleTodo(i: number) {
    this.todoList[i].completed = !this.todoList[i].completed;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        title: '',
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

  addTodo() {
    this.todoService.addTodo({
      title: this.inputControl.value,
    }).subscribe(data => {
      console.log(data);
    });
    return undefined;
  }

  deleteTodo(id: number) {
    this.todoService.delete(id).subscribe(() => {

      // xu ly du lieu o local
      // const newValue = this.todoList.filter(item => item.id !== id);
      // this.todoList = newValue;

      // goi lai api get du lieu
      this.ngOnInit();
      console.log('success');
    }, error => {
      console.log(error);
    }, () => {
      console.log('complete');
    });
    return undefined;
  }

}
