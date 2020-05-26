import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { OrdinazioneDTO } from 'src/dto/ordinazionedto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OrdinazioneService extends AbstractService<OrdinazioneDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'ordinazione';
  }
}
