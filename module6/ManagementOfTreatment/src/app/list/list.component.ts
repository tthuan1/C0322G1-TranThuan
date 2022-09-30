import {Component, OnInit} from '@angular/core';
import {TreatmentService} from '../service/treatment.service';
import {Treatment} from '../module/treatment';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  treatmentList: Treatment[] = [];
  deleteList: number[] = [];
  keySearch: string;

  constructor(private treatmentService: TreatmentService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    if (this.keySearch === undefined) {
      this.keySearch = '';
    }
    console.log('---------' + this.keySearch);
    this.treatmentService.getAll(this.keySearch).subscribe((data?: any) => {
      if (data?.content.length < 1) {
        return;
      }
      this.treatmentList = data?.content;
      console.log(data);
    }, error => {
      console.log(error);
    }, () => {
      console.log('get all ok');
    });
  }

  delete() {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.deleteList.length; i++) {
      console.log('delete', this.deleteList[i]);
      this.treatmentService.deleteTreatment(this.deleteList[i]).subscribe(() => {
        this.getAll();
        alert('xoá ok');
      }, error => {
        console.log('error', error);
      });
    }
    console.log(this.deleteList);
    return undefined;
  }

  getListDelete(id: number) {
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.deleteList.length; i++) {
      if (this.deleteList[i] === id) {
        this.deleteList.splice(i, 1);
        console.log(this.deleteList);
        return;
      }
    }
    this.deleteList.push(id);
    console.log(this.deleteList);
  }
}
