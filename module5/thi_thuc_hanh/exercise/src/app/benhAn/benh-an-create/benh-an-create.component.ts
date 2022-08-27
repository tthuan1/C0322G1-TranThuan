import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BenhNhan} from '../../model/benhAn/benh-nhan';
import {BenhNhanServiceService} from '../../service/benhAn/benh-nhan-service.service';
import {Router} from '@angular/router';
import {BenhAnServiceService} from '../../service/benhAn/benh-an-service.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-benh-an-create',
  templateUrl: './benh-an-create.component.html',
  styleUrls: ['./benh-an-create.component.css']
})
export class BenhAnCreateComponent implements OnInit {
  formCreate: FormGroup;
  benhNhanList: BenhNhan[] = [];

  constructor(private benhAnService: BenhAnServiceService,
              private benhNhanService: BenhNhanServiceService,
              private router: Router,
              private toastrService: ToastrService) {
  }

  getBenhNhan() {
    this.benhNhanService.getBenhNhanType().subscribe(data => {
      this.benhNhanList = data;
      console.log(this.benhNhanList);
    });
  }

  ngOnInit(): void {
    this.getBenhNhan();
    this.formCreate = new FormGroup({
      benhNhan: new FormControl('', [Validators.required]),
      ngayNhapVien: new FormControl('', [Validators.required]),
      ngayRaVien: new FormControl('', [Validators.required]),
      lyDoNhapVien: new FormControl('', [Validators.required, Validators.pattern('\\d{9}')]),
      phuongPhapDieuTri: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]),
      bacSiDieuTri: new FormControl('', [Validators.required, Validators.pattern('^\\+84\\d{9,10}$')]),
    });
  }

  submit() {
    const benhAn = this.formCreate.value;
    return this.benhAnService.createBenhAn(benhAn).subscribe(() => {
        this.toastrService.success('Update thành công', 'Thông báo');
        this.router.navigateByUrl('/benhAn-list');
      }
    );

  }
}
