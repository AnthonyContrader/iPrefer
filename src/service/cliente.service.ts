import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ClienteDTO } from 'src/dto/clientedto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class ClienteService extends AbstractService<ClienteDTO>{
  
    constructor(http: HttpClient) {
      super(http);
      this.type = 'cliente';
    }
}