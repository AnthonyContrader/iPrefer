import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { RecensioneDTO } from 'src/dto/recensionedto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RecensioneService extends AbstractService<RecensioneDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'recensiones';
  }

}
