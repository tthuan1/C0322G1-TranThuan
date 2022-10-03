import {AfterContentChecked, AfterViewChecked, ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {TokenStorageService} from '../../service/security/token-storage.service';
import {CartService} from '../../service/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, AfterViewChecked, AfterContentChecked {
  isSignIn = false;
  username: string;
  productQuantityInCart = 0;
  roles: string[];

  constructor(private tokenStorageService: TokenStorageService,
              private route: Router,
              private changeDetectorRef: ChangeDetectorRef,
              private cartService: CartService) {
  }

  ngOnInit(): void {
    if (this.tokenStorageService.getToken()) {
      this.isSignIn = true;
      this.username = this.tokenStorageService.getUser().username;
      this.roles = this.tokenStorageService.getUser().roles;
      console.log(this.username);
    }
  }

  logout(e) {
    this.tokenStorageService.signOut();
    this.tokenStorageService.getUser();
    this.ngOnInit();
    e.preventDefault();
    this.route.navigateByUrl('/').then();
    window.location.reload();
  }

  ngAfterViewChecked(): void {
    this.ngOnInit();
  }

  ngAfterContentChecked(): void {
    this.productQuantityInCart = this.cartService.getCartLength();
    this.changeDetectorRef.detectChanges();
    this.ngOnInit();
  }
}
