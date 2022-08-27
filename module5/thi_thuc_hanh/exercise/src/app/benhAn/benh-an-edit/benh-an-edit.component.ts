import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {BenhAn} from '../../model/benhAn/benh-an';
import {BenhNhan} from '../../model/benhAn/benh-nhan';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {BenhAnServiceService} from '../../service/benhAn/benh-an-service.service';
import {BenhNhanServiceService} from '../../service/benhAn/benh-nhan-service.service';

@Component({
  selector: 'app-benh-an-edit',
  templateUrl: './benh-an-edit.component.html',
  styleUrls: ['./benh-an-edit.component.css']
})
export class BenhAnEditComponent implements OnInit {
  benhAnForm: FormGroup;
  id: number;
  benhAnUpdate: BenhAn;
  benhNhanUpdate: BenhNhan;

  constructor(private benhAnService: BenhAnServiceService,
              private activatedRoute: ActivatedRoute,
              private benhNhanService: BenhNhanServiceService,
              private routes: Router,
              private toastrService: ToastrService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.benhAnService.findByIdApi(this.id).subscribe(data => {
        this.benhAnUpdate = data;
        console.log('benhAnUpdate', this.benhAnUpdate);
        this.benhAnForm = new FormGroup(
          {
            id: new FormControl(data.id),
            maBenhNhan: new FormControl(data.benhNhan.id),
            tenBenhNhan: new FormControl(data.benhNhan.name),
            ngayNhapVien: new FormControl(data.ngayNhapVien),
            ngayRaVien: new FormControl(data.ngayRaVien),
            lyDoNhapVien: new FormControl(data.lyDoNhapVien),
            phuongPhapDieuTri: new FormControl(data.phuongPhapDieuTri),
            bacSiDieuTri: new FormControl(data.bacSiDieuTri),
          }
        );
      });
    });

    this.benhAnForm = new FormGroup(
      {
        id: new FormControl(''),
        maBenhNhan: new FormControl(''),
        tenBenhNhan: new FormControl(''),
        ngayNhapVien: new FormControl(''),
        ngayRaVien: new FormControl(''),
        lyDoNhapVien: new FormControl(''),
        phuongPhapDieuTri: new FormControl(''),
        bacSiDieuTri: new FormControl(''),
      }
    );
  }

  ngOnInit(): void {

  }

  submit() {
    const benhAnForm = this.benhAnForm.value;
    this.benhNhanUpdate = {id: benhAnForm.maBenhNhan, name: benhAnForm.tenBenhNhan};
    const benhAn = {
      id: benhAnForm.id,
      benhNhan: this.benhNhanUpdate,
      ngayNhapVien: benhAnForm.ngayNhapVien,
      ngayRaVien: benhAnForm.ngayRaVien,
      lyDoNhapVien: benhAnForm.lyDoNhapVien,
      phuongPhapDieuTri: benhAnForm.phuongPhapDieuTri,
      bacSiDieuTri: benhAnForm.bacSiDieuTri,
    };
    this.benhAnService.updateAPI(this.id, benhAn).subscribe(() => {
      this.benhNhanService.updateBenhNhan(this.benhNhanUpdate.id, this.benhNhanUpdate);
      this.toastrService.success('Update thành công', 'Thông báo');
      this.routes.navigateByUrl('/benhAn-list');
    });
  }
}
