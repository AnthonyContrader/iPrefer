import { Injectable } from '@angular/core';
//import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService /*extends AbstractService<UserDTO>*/{

  path_entity: string = 'http://localhost:8080/api/users';


  constructor(protected http: HttpClient) {
  }

  login(loginDTO: LoginDTO): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/authenticate', loginDTO)
  }

 /* getAll(token: string): Observable<UserDTO[]> {

    return this.http.get<UserDTO[]>('http://localhost:8080/api/users',{
      headers: {
        Authorization : ('Bearer ' + token)
      }
    });
  }*/

  userLogged(username: string) {
    return this.http.get(`${this.path_entity}/` + username, {
      headers: {
        Authorization: localStorage.getItem('token')
      }
    });
  }



  getAll(): Observable<UserDTO[]> {
    return this.http.get<UserDTO[]>(`${this.path_entity}`);
  }

  get(id: number): Observable<UserDTO> {
    return this.http.get<UserDTO>(`${this.path_entity}/${id}`);
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(`${this.path_entity}/${id}`);
  }


  update(dto: UserDTO): Observable<UserDTO> {
    return this.http.put<UserDTO>(`${this.path_entity}`, dto);
  }

  insert(user: UserDTO): Observable<any> {
    return this.http.post(`${this.path_entity}`, user);
  }



  /*
  account(token:string): Observable<UserDTO>{
    return this.http.get<UserDTO>('http://localhost:8080/api/account',{

      headers: {
        Authorization : ('Bearer ' + token)
      }
    });
  }*/
}
