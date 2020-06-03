import { Component } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserDTO } from 'src/dto/userDTO';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ristoranteapp';

  

}