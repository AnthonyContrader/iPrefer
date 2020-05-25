import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isAccountCollapsed = false;
  isBevandaCollapsed = false;
  isPiattoCollapsed = false;
  isClienteCollapsed = false;
  isPrenotazioneCollapsed = false;
  isOrdinazioneCollapsed = false;
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

  piatticollapse() {
    if (this.isPiattoCollapsed === false) {
      this.isPiattoCollapsed = true;
    } else { this.isPiattoCollapsed = false; }
  }

  bevandecollapse() {
    if (this.isBevandaCollapsed === false) {
      this.isBevandaCollapsed = true;
    } else { this.isBevandaCollapsed = false; }
  }

  clienticollapse() {
    if (this.isClienteCollapsed === false) {
      this.isClienteCollapsed = true;
    } else { this.isClienteCollapsed = false; }
  }

  prenotazionicollapse() {
    if (this.isPrenotazioneCollapsed === false) {
      this.isPrenotazioneCollapsed = true;
    } else { this.isPrenotazioneCollapsed = false; }
  }

  ordinazionicollapse() {
    if (this.isOrdinazioneCollapsed === false) {
      this.isOrdinazioneCollapsed = true;
    } else { this.isOrdinazioneCollapsed = false; }
  }

  recensionicollapse() {
    if (this.isRecensioneCollapsed === false) {
      this.isRecensioneCollapsed = true;
    } else { this.isRecensioneCollapsed = false; }
  }
}
