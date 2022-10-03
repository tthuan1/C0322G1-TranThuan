import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {BookService} from '../../service/book.service';
import {CartService} from '../../service/cart.service';
import {ToastrService} from 'ngx-toastr';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {Router} from '@angular/router';
import {BookDto} from '../../model/BookDto';
import {OwlOptions} from 'ngx-owl-carousel-o';

declare let isotope: any;

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  bookList: BookDto[];
  currentPage: number;
  totalPages: number;
  sort = 'releaseDESC';
  name = '';
  isGuest: boolean;
  user;
  @ViewChild('search') searchInput: ElementRef;
  isLogIn = false;
  username: string;
  public bookIdValue: number;
  public bookNameValue: string;
  public str: string;


  constructor(private bookService: BookService,
              private cartService: CartService,
              private toastrService: ToastrService,
              private tokenStorageService: TokenStorageService,
              private router: Router) {
    scrollBy(0, 0);
  }

  ngOnInit(): void {
    this.getAllBook({page: 0, size: 10});
    // tslint:disable-next-line:no-unused-expression
    new isotope();
    if (this.tokenStorageService.getToken()) {
      this.isLogIn = true;
      this.username = this.tokenStorageService.getUser().username;
    }

    this.user = this.tokenStorageService.getUser();
    if (this.user == null) {
      this.isGuest = true;
    }
    if (this.user != null) {
      // tslint:disable-next-line:triple-equals
      if (this.user.roles[0] == 'ROLE_USER') {
        this.isGuest = true;
      } else {
        this.isGuest = false;
      }
    }
    console.log(this.bookList);
  }

  getAllBook(request) {
    return this.bookService.getAll(request).subscribe(data => {
      this.bookList = data['content'];
      this.currentPage = data['number'];
      this.totalPages = data['totalPages'];
    }, () => {
      this.bookList = [];
    });
  }

  signOut(e) {

    this.tokenStorageService.signOut();
    this.router.navigateByUrl('/log/sign-in').then();

    this.ngOnInit();
    e.preventDefault();
  }

  customOptions: OwlOptions = {
    loop: false,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: true,
    // autoplay: true,
    // autoplayTimeout: 1000,
    navSpeed: 700,
    navText: ['<i class="fa fa-caret-left"/>', '<i class="fa fa-caret-right"/>'],
    responsive: {
      0: {
        items: 1
      },
      400: {
        items: 3
      },
      740: {
        items: 5
      },
      940: {
        items: 5
      }
    },
    nav: true
  };


  sortBooks(sort: HTMLSelectElement) {
    this.sort = sort.value;
    this.getAllBook({page: 0, size: 10, name: this.name, sort: this.sort});

  }

  previousPage() {
    const request = {};
    if ((this.currentPage) > 0) {
      request['page'] = this.currentPage - 1;
      request['size'] = 10;
      request['name'] = this.name;
      request['sort'] = this.sort;
      this.getAllBook(request);
    }
  }

  nextPage() {
    const request = {};
    if ((this.currentPage + 1) < this.totalPages) {
      request['page'] = this.currentPage + 1;
      request['size'] = 10;
      request['name'] = this.name;
      request['sort'] = this.sort;
      this.getAllBook(request);
    }
  }

  searchingBook(search: HTMLInputElement | HTMLSelectElement) {
    this.name = search.value;
    this.getAllBook({page: 0, size: 10, name: this.name, sort: this.sort});
  }

  addToCart(item: BookDto, $event) {
    if (item.quantity > 0) {
      this.cartService.addToCart(item, 1);
      this.showMessageSuccess(item.name);
    } else {
      this.showMessageError(item.name);
    }
    $event.preventDefault();
  }

  showMessageSuccess(itemName: string) {
    this.toastrService.success('Đã thêm thành công ' + itemName + ' vào giỏ hàng', 'Thông báo', {
      timeOut: 2000,
      progressBar: true,
    });
  }

  showMessageError(medicineName: string) {
    this.toastrService.warning('Thuốc ' + medicineName + ' đã hết hàng', 'Thông báo', {
      timeOut: 2000,
      progressBar: true,
    });
  }

  resetSearch() {
    this.searchInput.nativeElement.value = '';
    this.getAllBook({page: 0, size: 10});
  }

  getInforBookDelete(name: string, id: number) {
    this.bookIdValue = id;
    this.bookNameValue = name;
  }

  deleteBookByid(bookIdValue: number) {
    this.bookService.delete(bookIdValue).subscribe(() => {
      this.str = '';
      this.ngOnInit(),
        this.toastrService.success('Xoá thành công!', 'Thông báo', {
          timeOut: 3000,
          progressBar: true
        });
    }, () =>
      this.toastrService.warning('Không thể tìm thấy sách cần xoá !', 'Thông báo', {
        timeOut: 3000,
        progressBar: true
      }));
  }

}
