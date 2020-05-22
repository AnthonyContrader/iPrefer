import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PrenotazioneDTO } from 'src/dto/prenotazionedto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class PrenotazioneService extends AbstractService<PrenotazioneDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'prenotazione';
  }

  login(loginDTO: LoginDTO): Observable<PrenotazioneDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
  }

}
