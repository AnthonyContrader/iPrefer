import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;
  token:string;
  user: UserDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
  }

  login(f: NgForm): void {

   // this.service.login(this.loginDTO).subscribe((token: any) => localStorage.setItem('token',JSON.stringify(token)));
     
  //quando faccio subscribe salvo token e faccio altra chiamata

    this.loginDTO = new LoginDTO(f.value.username, f.value.password);



    this.service.login(this.loginDTO).subscribe((token: any) => {

      if (token != null) {
        localStorage.setItem('token',  'Bearer ' +token.id_token );
       
      

        this.service.userLogged(this.loginDTO.username).subscribe((user: UserDTO) => {
           if (user != null) {  
                    localStorage.setItem('currentUser', JSON.stringify(user));   
           
                    
                   this.router.navigate(['/admin-dashboard']);    
                    } 
              else {   
                       this.router.navigate(['/login']);   
                }  
        });
      }
    }
    );
  


    /*this.service.login(this.loginDTO).subscribe(
      (token: any) => {this.token = token.id_token, 
        this.service.account(this.token).subscribe(
          (response: UserDTO) => this.user = response)});
    */
    if (this.user != null){
for(var ruolo of this.user.authorities){
  if (ruolo == "ROLE_ADMIN"){
    this.router.navigate(['/admin-dashboard']);
    break;
  
  }
}

    }


    /*this.service.login(this.loginDTO).subscribe((user) => {

      if (user != null) {
        localStorage.setItem('currentUser', JSON.stringify(user));

        switch (user.usertype.toString()) {
          case 'ADMIN': {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case 'USER': {
            this.router.navigate(['/user-dashboard']);
            break;
          }
          default:
            this.router.navigate(['/login']);
        }
      }
    });*/

    


  }
}
