import {BenhNhan} from './benh-nhan';

export interface BenhAn {
  id?: number;
  benhNhan?: BenhNhan;
  ngayNhapVien?: string;
  ngayRaVien?: string;
  lyDoNhapVien?: string;
  phuongPhapDieuTri?: string;
  bacSiDieuTri?: string;
}
