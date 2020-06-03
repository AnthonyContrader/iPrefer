import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { PiattoDTO } from 'src/dto/piattodto';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  user: UserDTO = new UserDTO;
  piatto:PiattoDTO=new PiattoDTO;
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.piatto=JSON.parse(localStorage.getItem('currentPiatto'));
  }

}
