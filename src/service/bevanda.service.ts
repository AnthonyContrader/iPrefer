import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { BevandaDTO } from 'src/dto/bevandadto';
import { HttpClient } from '@angular/common/http';
//import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BevandaService extends AbstractService<BevandaDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'bevandas';
  }
}


