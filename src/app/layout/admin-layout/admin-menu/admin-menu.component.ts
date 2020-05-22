import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isPrenotazioneCollapsed = false;
  isRecensioneCollapsed = false;
  

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  prenotazionicollapse() {
    if (this.isPrenotazioneCollapsed === false) {
      this.isPrenotazioneCollapsed = true;
    } else { this.isPrenotazioneCollapsed = false; }
  }

  recensionicollapse() {
    if (this.isRecensioneCollapsed === false) {
      this.isRecensioneCollapsed = true;
    } else { this.isRecensioneCollapsed = false; }
  }
}
