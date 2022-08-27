import {Component, OnInit} from '@angular/core';
import {BenhAn} from '../../model/benhAn/benh-an';
import {BenhNhan} from '../../model/benhAn/benh-nhan';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {BenhAnServiceService} from '../../service/benhAn/benh-an-service.service';
import {BenhNhanServiceService} from '../../service/benhAn/benh-nhan-service.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-benh-an-list',
  templateUrl: './benh-an-list.component.html',
  styleUrls: ['./benh-an-list.component.css']
})
export class BenhAnListComponent implements OnInit {
  benhAnList: BenhAn[] = [];
  benhNhanList: BenhNhan[] = [];
  id: number;
  name: string;
  p = 1;
  nameSearch: string;

  constructor(private benhAnService: BenhAnServiceService,
              private benhNhanService: BenhNhanServiceService,
              private routes: Router,
              private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.getAllBenhAn();
  }

  getBenhNhan() {
    this.benhNhanService.getBenhNhanType().subscribe(data => {
      this.benhNhanList = data;
      });
  }

  getAllBenhAn() {
    this.benhAnService.getAllAPI().subscribe(data => {
      this.getBenhNhan();
      this.benhAnList = data;
    });
  }


  benhAnDelete(benhAn: BenhAn) {
    this.id = benhAn.id;
    this.name = benhAn.benhNhan.name;
  }

  delete() {
    console.log('delete', this.id);
    this.benhAnService.deleteAPI(this.id).subscribe(() => {
      this.getAllBenhAn();
      this.toastrService.success('Xoá bệnh án thành công', 'Thông báo');
    });
  }


  search() {
    return this.benhAnService.search(this.nameSearch).subscribe(listSearch => {
      console.log(listSearch);
      console.log(this.nameSearch);
      this.benhAnList = listSearch;
      this.p = 1;
      this.nameSearch = '';
    });
  }
}
