import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PiattoDTO } from 'src/dto/piattodto';
import { HttpClient } from '@angular/common/http';
//import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre i metodi ereditati dall'Abstract.
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class PiattoService extends AbstractService<PiattoDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type ='piattos';
  }

//  login(loginDTO: LoginDTO): Observable<UserDTO> {
 //   return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  //}

}
